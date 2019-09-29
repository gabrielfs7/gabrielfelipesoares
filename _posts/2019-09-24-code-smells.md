---
title: Code Smells & Anti-patterns
categories:
- Design-Principles
feature_image: "https://picsum.photos/2560/600?image=872"
---

Here a brief list of some code smells and what to do to get ride from them.

<!-- more -->

# Comments

If you have to write a comment to explain what the code is doing, probably you used a poor design, code is doing too much or you are not sure what it is doing.

**How to get ride of comments?**

Avoid comments and prefer separations of concerns, smaller and specialized classes with self-explainable names. A class and method's purpose should be clear just by reading its name. Avoid creating to generic classes like "CustomerService" that does everything. Instead use specialized classes like: __UpdateCustomerService, SendCustomerInvoiceService,__ etc. By reading the name is really easy to know what is the class purpose.

# Long methods

The name is self-explainable. A long method most probably is doing more than what should and it is hard to understand. But what could be considered long? There is no magic number, i will depend on the language you are using and what is being done.

**How to avoid long methods**

- Use separation of concerns.
- Split the code in sub-methods with meaningful names.
- Split class in multiple classes.

# Long parameters list

If you have a really long list of parameters, probably your method either is doing more than it should or the class is fat. It can cause some complications, cause every time you need to change or add behavior on this class you need to add a new parameter, that sometimes will ignore previous parameters or even add a lot of optional parameters.

It is a pain to maintain such class or method, cause it bring high coupling and low cohesion.

**How to avoid long parameters list?**

- Create new objects encapsulating the parameters. For example, in a program about geo location, a class with parameters "x, y, z" could become an object called "Point3D" and "latitude, longitude" might become a "Coordinates" object.
- Segregate methods in more specialized methods / classes. Sometimes you have a long list of parameters, cause your class / method has multiple concerns.

According to __Robert Martin__ in the book [Clean Code](https://www.amazon.co.uk/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882) methods should be __monad, dyad or triad__. This means. Have maximum three parameters on the worst cases.

# Data classes

Data classes can be considered a code smell, when they are over abused and logic concerned to those classes are treated in separate classes when could be done in the same class.

A data class is basically a class the contain only getters and setters (sometimes). Of course, Values objects or data objects can be useful to normalization, but there are some cases they are not used only for this.

**How to avoid data classes?**

Check if these classes should not be doing another kind of operation besides encapsulation, for example, calculating or checking something, etc that could being done by another classes.

# Data clumps

Sometimes we start copying data from one class to another just for the sake of "save time" and end up generating a series of duplications. These parameters should become their own classes. For example. Imagine that you copy the database credentials in many services to create a new connection object. 

**How to avoid data clamps**

Probably these credentials should become a self-contained object (Parameter Object) holding the necessary data a Connection needs. Or even make the Connection be instantiated one a single place like a DI container avoiding the duplication.

# Divergent change

When you have to change a class in multiple ways for multiple reasons, then you have a __Divergent change__. This is because you have a __Large class__ code smell where the class is doing to much for too many purposes. A poor separation of concerns Design is generally the main cause.

**How to avoid a divergent change**

- Use proper separation of concerns.
- Split large class into specialized classes.

# Shotgun Surgery

When to support a new requirement to your system you have to do a change to a lot of places instead of a centralized location. This is called __Shotgun Surgery__ and probably was caused by poor design choices and violation of Design principles.

**How to avoid it?**

- Respect Design principles.
- Use SOLID principles.
- Centralize object creations and business rules validations.

# Feature Envy

When a method in one class constantly talks to a method of another class and vice-versa, and this method is only used for this purpose, probably they should be together in the same class. Of course, it is not always the case. Sometimes these methods are to complex and their responsibilities should be separated in other class.

**How to avoid Feature Envy?**

- Consider moving the common method to class it concerns.

# Inappropriate intimacy

When two classes depending to much each other in a two-way communication, they were probably split by mistake or should be talking each other in a non-coupled way.

**How to remove Inappropriate intimacy** 

- Try to unify the classes into once.
- Extract methods both classes use in another class.
- Try to use a non-coupled approach like __Observer__ pattern.

# Message chains

When your class method depends on a chain of methods to get its job done, than you have a __message chain__ problem. It causes **rigidity** and complexity on your design. Example:

``` java

public class A
{
    public void do()
    {
        this.b.getC().getD().do(); // Demeter's law violation
    }
}
```

**How to avoid message chains?**

- Respect the Law of Demeter.

# Primitive obsession

It happens when you rely too much on primitive or built-in types, like: __Int, Float, String__, etc. For sure these types will be used, but we should try to retain its usage to low levels of our implementation.

**How to avoid Primitive obsession**

- Create your own objects to represent primitive values with particular purpose. Example: 
  - The "postal code", could be handled as a "String" all over your system, but you can easily encapsulate and validate it inside a a class "PostalCode".
- Avoid passing collection of primitives that represents important subjects in your system. Prefer to implement a collection class.


# Switch statements

Switch statements (and if / else) are code smells when they try to replace Polymorphism. Example:

``` php
<?php

class Processor
{
    public function process(Order $oder, string $paymentType)
    {
        switch $paymentType
        {
            'creditCard':
                $this->cardProcessor->process($order);
                break;
            'payPal':
                $this->payPalProcessor->process($order);
                break;
            default:
                $this->defaultPalProcessor->process($order);
                break;
        }
    }
}
```

**How to avoid it?**

Instead, use Polymorphism:

``` php
<?php
interface IOrderProcessor
{
    public function process(Order $order): void;
    public function supportsPaymentType(string $type): bool;
}

class PaypalProcessor implements IOrderProcessor
{
    public function process(Order $order): void { /* ... */}
    public function supportsPaymentType(string $type): bool
    {
        return 'paypal';
    }
}

class CreditCardProcessor implements IOrderProcessor
{
    public function process(Order $order): void { /* ... */}
    public function supportsPaymentType(string $type): bool
    {
        return 'creditCard';
    }
}

class DefaultProcessor implements IOrderProcessor
{
    public function process(Order $order): void { /* ... */}
    public function supportsPaymentType(string $type): bool
    {
        return true;
    }
}

/**
 * As you can see we can add as many Order Processors we without increase the method complexity.
 */
class Processor
{
    /**
     * @var IOrderProcessor[]
     */
    private $orderProcessors;

    public function process(Order $oder, string $paymentType)
    {
        foreach ($this->orderProcessors as $orderProcessor) {
            if ($orderProcessor->supportsPaymentType($paymentType)) {
                $orderProcessor->process($order)
            }
        }
    }
}
```

# Speculative Generality

This code smell happens when code is created, but it is not used (or not needed) because we think that "We might need this come day". The "code", could be a feature, superclass or even and interface that is not necessary.

Imagine for instance that you create an interface that is used by a single class, just because "someone" might need to generalize this in the future. It is against Agile Development and Just In Time (JIT) delivery. You do not want to waste time writing code that is not needed.

**How to avoid Speculative generality?**

- Keep the code simple.
- Make code flexible, but avoid over-engineering. Find a balance.
- Do not create code based on assumptions that feature will evolve. Requirements are dropped and priority drops every time, so do not waste time.


# Refused bequest

Might happen you create a super class very useful for many cases, so **subclass might inherit something it does not need**.

**How to avoid?**

- Does it make sense to extend this class? Maybe not.
- Try to extract the unused behavior from super class.
- Maybe defined this behaviors in the subclasses only.