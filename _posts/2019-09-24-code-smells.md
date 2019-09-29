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

Avoid comments and prefer separations of concerns, smaller and specialized classes with self-explainable names. A class and method's purpose should be clear just by reading its name. Avoid creating to generic classes like "CustomerService" that does everything. Instead use specialized classes like: __UpdateCustomerService, NotifyCustomerOderService,__ etc. By reading the name is really easy to know what is the class purpose.

# Long methods

The name is self-explainable. A long method most probably is doing more than what should and it is hard to understand. But what could be considered long? There is no magic number. Depending on the language you are using and what is being done.

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