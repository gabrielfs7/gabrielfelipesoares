---
title: The 23 Design Patterns you must know
categories:
- Software-Architecture
- Design-patterns
feature_image: "https://picsum.photos/2560/600?image=872"
---

Based on a famous book I will try to simplify and give examples of the 
23 famous design patterns that can help your daily work as developer.

<!-- more -->

If you do not know the book I am talking about, it is [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612).
Even nowadays the Book is still handy and we realize how timeless is its content.

# Before we start

So what are **Design Patterns**? 

Yes, Design Patterns are everywhere we need to do a recurring action.

Besides construction, medicine, engineering, we have patterns also for teaching people, cooking (recipes), social interactions (greet, thanks, apologize), selling, designing packings and many many others areas.

Basically, for any repeating task, by experience, the specialists found approaches that work better on each situation and then it becomes a pattern.

Along the history developers have solved similar problems with different solutions. It turned out that to solve common problems, some solutions provided a better result and made the code more **ReFlexMain**, which is **Reusable, Flexible and Maintainable**, the holy trinity.

As an Architect, Software Engineer or Developer, Design patterns will give to you the **Foundation** to solve more complex design problems.

Lets explore them!

# Creational Patterns

Define patterns to be used when creating or cloning objects.

## Singleton

Singleton actually became an **anti-patterns**, because it brings many restrictions due the fact is is a single instance of an object, thus a global state in the whole application. It makes system more complex and hard to test.

For a matter of information, I will show the pattern here just for you to don not use it.

Goals of the pattern:

- Object must be globally accessible.
- There must **a single instance of an object** for the whole application.

Basically we make impossible to create an instance externally by making a **private constructor** and then we create a public static method to cache and retrieve the single global state of this class.

**Example in PHP**:

``` php
<?php
class MySingleton
{
    private $instance;

    private function __construct(){}

    public static function getInstance(): MySingleton 
    {
        if (null === $this->instance) {
            $this->instance = new self();
        }

        return $this->instance;
    }
}
```

## Factory Object

As in the real world, the purpose of this patterns is also to create objects.

Benefits:

- Centralize object creation.
- Avoid repeat code. DRY, since other parts of the system can use the factory.
- Make code easier to maintain.
- Decouple multiple responsibilities from classes.

**Example in Java**:

``` java
public class PackageFactory
{
    public IPackage create(PackageType type)
    {
        IPackage package;

        if (type.is('carrier')) {
            package = new CarrierPackage();
        } else if (type.is('post')) {
            package = new PostPackage();
        } else {
            package = new OrdinaryPackage();
        }

        return package;
    }
}

// Using the factory object
public class Shipping
{
    private PackageFactory packageFactory;

    public Shipping(PackageFactory packageFactory)
    {
        this.packageFactory = packageFactory;
    }

    public void dispatch(PackageType type, Item item)
    {
        IPackage package;

        package = this.packageFactory.create(type);
        package.addItem(item);
        package.close();
        //... other implementation...
    }
}
```

### Factory method

As the factory object, this pattern also creates object, but in a separate method of specialized classes instead.

We can do this making the previously client of the factory an abstract class, so the **subclasses will be specialized** and responsible to **decide which type of object to create**.

**Benefits:**

- Code for interface rather than implementation.
- Easier to extend the code.
- Does not inflate factories.

``` java
public abstract class Shipping
{
    public void dispatch(PackageType type, Item item)
    {
        IPackage package;

        package = this.createPackage(type);
        package.addItem(item);
        package.close();
        //... other implementation...
    }

    abstract IPackage createPackage(PackageType type);
}

public class CarrierShipping extends Shipping
{
    IPackage createPackage(PackageType type)
    {
        return new CarrierPackage();
    }
}

public class PostShipping extends Shipping
{
    IPackage createPackage(PackageType type)
    {
        return new PostPackage();
    }
}

public class OrdinaryShipping extends Shipping
{
    IPackage createPackage(PackageType type)
    {
        return new OrdinaryPackage();
    }
}
```

# Structural Patterns

These patterns describe how objects are connected to each other:

- How they relate with generalization: Composition, Association, Aggregation, Inheritance or Interface 
- How classes and subclasses interact trough inheritance.

## Facade

A client of a subsystem don't want (and don't need) to know the details of how it works internally. It just wants to request something in order to get something.

A Facade is:

- A **point of entry** to your subsystem(s).
- A **wrapper class** to allow the client to interact with subsystems.
- A pattern that **puts all the complexity of the subsystems behind a "facade"**

### Key principles to use a Facade

- **Encapsulation**: Inject the necessary subsystem classes into the Facade.
- **Information Hiding**: Do not expose subsystems to the client.
- **Separation of concerns**: The client does not need to be concerned about subsystems implementations details or business rules.

Example in PHP:

``` php
<?php
interface IAccount
{
    public function getBalance(): float;
    public function withdraw(float $amount): void;
    public function deposit(float $amount): void;
}

class InvestmentAccount implements IAccount {}

class SavingAccount implements IAccount {}

class CurrentAccount implements IAccount {}

class BankFacade
{
    public function accountBalance(string $accountNumber): float
    {
        $account = $this->accountRepository->find(accountNumber);

        return $account->getBalance();
    }

    public function accountWithdraw(string $accountNumber, float $amount): void
    {
        $account = $this->accountRepository->find(accountNumber);

        $account->withdraw($amount);
    }

    public function accountDeposit(string $accountNumber, float $amount): void
    {
        $account = $this->accountRepository->find(accountNumber);

        $account->deposit($amount);
    }

    public function createAccount(string $type, string $customerName): Account
    {
        if ($type == 'saving') {
            $account = new SavingAccount($customerName);
        } elseif ($type == 'investment') {
            $account = new InvestmentAccount($customerName);
        } elseif ($type == 'current') {
            $account = new CurrentAccount($customerName);
        }

        $this->accountRepository->save(accountNumber);

        return $account;
    }
}

/**
 * The client is not aware about internal behavior or implementation of subsystems. 
 * It just know about the exposed functionality.
 */
class ApplicationClient
{
    private $bankFacade;

    public function __construct(BankFacade $bankFacade)
    {
        $this->bankFacade = $bankFacade;
    }

    public function operation(string $operation, array $parameters)
    {
        if ($operation === 'new-account') {
            return $this->bankFacade->createAccount($parameters['accountType'], $parameters['customerName']);
        }

        if ($operation === 'deposit') {
            return $this->bankFacade->accountDeposit($parameters['accountNumber'], $parameters['amount']);
        }

        if ($operation === 'withdraw') {
            return $this->bankFacade->accountWithdraw($parameters['accountNumber'], $parameters['amount']);
        }

        if ($operation === 'balance') {
            return $this->bankFacade->accountBalance($parameters['accountType']);
        }
    }
}
```

### When to use Facade?

- If you need a class to represent an interface between a subsystem and a client class.
- To simplify the interaction between client and subsystems.


# Behavioral Patterns

Define how **independent** object work towards a common goal.

