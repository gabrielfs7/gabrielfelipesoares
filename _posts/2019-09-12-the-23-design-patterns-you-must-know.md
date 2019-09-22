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

### When to use Facade?

- If you need a class to represent an interface between a subsystem and a client class.
- To simplify the interaction between client and subsystems.

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

## Adapter

The output of a system might not comply with the expected input of another system. It requires an **adapter** to transform this output to an accepted input to the other system.

Involved parts to use the Adapter pattern:

- **Client**: Class of your your system that wants to use a third-party library or external system.
- **Adaptee**: It is the class in the third-party library or external library you want to use.
- **Adapter**: It will adapt (or translate) the Adaptee to the Client and vice-versa.
  - The Adapter must implements an **Target Interface** that the Adaptee understands.

Example in Java:

``` java
// This is the "Target interface"
public interface IWsRequester
{
    public Response request(Order order);
}

// This is the "Adapter"
public class WsAdapter implements IWsRequester
{
    //WebService is a third-party library class which we cannot change...
    private WebService adaptee;

    //...constructor

    public Response request(Order order)
    {
        String json = this.orderToJson(order);

        return this.adaptee.request(json);
    }

    private String orderToJson(Order order)
    {
        //... Adapts / translates Order object to JSON string
    }
}

// This is the "Client"
public class WsClient
{
    private IWsRequest requester;

    //...constructor

    public void dispatchOrder(String orderNumber)
    {
        Order order = this.orderRepository.getOrder(orderNumber);

        Response response = this.requester.request(order);

        if (response.code === 200) {
            System.out.println('Success!');
        } else {
            System.out.println('Error!');
        }
    }
}

public class Main
{
    public static void main(String args[])
    {
        WebService adaptee = new WebService("http://external-system-url");
        WsAdapter adapter = new WsAdapter(adaptee);

        WsClient client = new WsClient(adapter);

        //Note that the client does not need to be aware of the "adapteeo" interface thanks to the adapter...
        client.dispatchOrder(args[0]);
    }
}
```

## Composite

Objectives:

- To **compose nested structures** of objects.
- To **work uniformly** (with Polymorphism) with the classes of these objects.

Main components of the composite pattern:

- **Component Interface**: All the objects that implements this interface can be another components or a **Leaf**.
- **Component**: An implementation of the **Component Interface** that have aggregate other **Components** or **Leaves**.
- **Leaf**: An implementation of the **Component Interface** that "cannot" aggregate other **Components** or **Leaves**

{% include post-figure.html image="composite-pattern.png" caption="UML class diagram composition pattern" %}

Example in Java

``` java
import java.util.ArrayList;

/* [Program.java] */
public class Program {
	public static void main(String args[]) {
	
	Playlist studyPlaylist = new Playlist("Study");		
    Playlist rockPlaylist = new Playlist("Rock");
    
	Song rockSong1 = new Song("Nothing else matters");
    Song rockSong2 = new Song("Sultans of swing");
    
	rockPlaylist.add(rockSong1);
    rockPlaylist.add(rockSong2);
    
    Song studySong1 = new Song("Design Patterns");
    Song studySong2 = new Song("Software Architecture");

    studyPlaylist.setPlaybackSpeed(0.25f);
    studyPlaylist.add(studySong1);
    studyPlaylist.add(studySong2);
	studyPlaylist.add(rockPlaylist);
	studyPlaylist.play();
}

public interface IComponent 
{
    public void play();
    public void setPlaybackSpeed(float speed);
    public String getName();
}

// Component class
public class Playlist implements IComponent 
{
	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList();

    public Playlist(String playlistName) 
    {
		this.playlistName = playlistName;
    }
    
    public void play()
    {
        playlist.get(0).play();
    }

    public void setPlaybackSpeed(float speed)
    {
        for (IComponent song : playlist) {
            song.setPlaybackSpeed(speed);
        }
    }

    public String getName()
    {
        return playlistName;
    }

    public void add(IComponent component)
    {
        playlist.add(component);
    }

    public void remove(IComponent component)
    {
        playlist.remove(component);
    }
}

// Leaf class
public class Song implements IComponent 
{
	public String songName;
	public float speed = 1;

    public Song(String songName) 
    {
		this.songName = songName;
    }
    
    public void play()
    {
        System.out.println("Playing music ...");
    }

    public void setPlaybackSpeed(float speed)
    {
        this.speed = speed;
    }

    public String getSongName()
    {
        return songName;
    }
}
```

## Proxy 

Why to use a proxy?

- To act as a **Virtual** Proxy: If the resource is too big (i.e and image file) or we do not need all the resource we can access part of this resource through a Virtual Proxy.
- To act as a **Protection** Proxy: Useful to control access to the real subject class.
- To act as a **Remote** Proxy: When the proxy class is instantiated locally, but the subject classes are located remotely (I.e Google files stored locally in the Browser, but actual files are in the server).

{% include post-figure.html image="proxy-pattern.png" caption="UML proxy pattern" %}

``` php
<?php

// The Subject interface
interface StockInterface
{
    public function processOrder(Order $order): void
}

// The class that will be Proxied. It does not check stock quantity...
class DistributionCenter implements StockInterface
{
    /** @var Stock[] **/
    private $stocks;

    public function processOrder(Order $order): void
    {
        foreach ($order->getItems() as $item) {
            $stock = $this->getStock($item->getProduct());
            $stock->decrease($item->getQuantity());
        }
    }

    public function getStock(Product $product): Stock
    {
        foreach ($this->stocks as $stock) {
            if ($stock->belongsTo($product)) {
                return $stock;
            }
        }
    }
}

// The proxy checks all distribution centers for a stock, otherwise raise an exception
class DistributionCenterProxy implements StockInterface
{
    /** @var DistributionCenter **/
    private $distributionCenters;

    public function processOrder(Order $order): void
    {
        foreach ($this->distributionCenters as $distributionCenter) {
            $hasStock = true;

            foreach ($order->getItems() as $item) {
                $stock = $distributionCenter->getStock($item->getProduct());

                if (!$stock->hasStock($item->getQuantity())) {
                    $hasStock = false;

                    break;
                }
            }

            if ($hasStock) {
                $distributionCenter->processOrder($order);

                return;
            }
        }

        throw new Exception('Insufficient stock');
    }
}
```

## Decorator

Sometimes we need to add some extra feature or behavior for a class, but we do not want to change the original class in order to preserve its individual purpose. The Decorator pattern uses aggregation to combine behaviors to a class at runtime!

Goals:

- Aggregates other types of components forming an "stack" of components on top of each other.
- Serves as an **Abstract superclass** for concrete decorator classes where each one of them will increment behavior.
- Allow add at runtime any number of behaviors using **aggregation instead of inheritance**.
- The aggregation is always a **one-to-one relationship** with the object below in the stack.

{% include post-figure.html image="decorator-pattern.png" caption="UML decorator pattern" %}

``` java
// The component interface
public interface IWebPage
{
    public void display();
}

// The concrete component
public class BasicWebPage implements IWebPage
{
    public void display()
    {
        // Output page content...
    }
}

// The abstract Decorator
public abstract class WebPageDecorator implements IWebPage
{
    protected IWebPage webPage;

    public WebPageDecorator(IWebPage webPage)
    {
        this.webPage = webPage;
    }

    public void display()
    {
        this.webPage.display();
    }
}

// A concrete decorator. It does not aggregate any other IWebPage component
public class AuthenticationWebPage extends WebPageDecorator
{
    //constructor...

    public void display()
    {
        super.display();
        this.authenticateUser();
    }

    private void authenticateUser()
    {
        //Display authentication form
    }
}

// A concrete decorator. It does not aggregate any other IWebPage component
public class AuthorizationWebPage extends WebPageDecorator
{
    //constructor...

    public void display()
    {
        super.display();
        this.authorizeUser();
    }

    private void authorizeUser()
    {
        //Display authorized user content
    }
}

public class Main
{
    public static void main(String args)
    {
        // Here is we can check the decorator adding behavior in stack
        IWebPage basicPage = new BasicWebPage();
        IWebPage authorizationPage = new AuthorizationWebPage(basicPage);
        IWebPage authenticationPage = new AuthenticationWebPage(authorizationPage);
        
        authenticationPage.display();
    }
}
```

# Behavioral Patterns

Define how **independent** object work towards a common goal.

## Template Method

When you want to establish the **steps or behavior** of some algorithm and allow **customization** only for part of it, we call it **Template Method**.

- The template method defines the behavior in a **Abstract** superclass.
- The superclass has an **abstract method**, that must be implemented by subclasses.

{% include post-figure.html image="template-method-pattern.png" caption="UML template method pattern" %}

Example in PHP:

``` php
<?php

abstract class Pizza
{
    public function prepare(): void
    {
        $this->addCover();
        $this->addSauce();
        $this->bake();
    }

    private function bake(): void
    {
        // Common Baking logic
    }

    public abstract function addCover(): void;
    public abstract function addSauce(): void;    
}

class PizzaMozzarella extends Pizza
{
    public function addCover(): void
    {
        // Add mozzarella cheese
    }

    public function addSauce()
    {
        // add olives and oregano
    }
}

class PizzaCarbonara extends Pizza
{
    public function addCover(): void
    {
        // Add parmesan, mozzarella, eggs and bacon
    }

    public function addSauce()
    {
        // add oregano
    }    
}
```

## Chain of Responsibility

When we crate a chain of objects working together to handle requests, we call it a **Chain of Responsibility**.

Generally they are a series of **Handlers** objects, each one specialized on handle some part of the requests.

While the request **is not satisfied** by a handler, they will forward the request to the next handler in the chain.

{% include post-figure.html image="chain-off-responsibility-pattern.png" caption="UML Chain of responsibility pattern" %}

``` php
<?php

abstract class RequestHandler
{
    /**
     * @var Handler
     */
    protected $nextHandler;

    public function setNextHandler(Handler $nextHandler): self
    {
        $this->nextHandler = $nextHandler;

        return $this;
    }

    public abstract function handle(Request $request): Response;
}

class UserAuthorizerHandler extends RequestHandler
{
    public function handle(Request $request): Response
    {
        if (!$request->getAttribute('authorized')) {
            // Sends user to authorization...
            return new Response();
        }

        return $next->handle($request, $response);
    }
}

class UrlRedirectHandler extends RequestHandler
{
    public function handle(Request $request): Response
    {
        if ($request->getUrl() === 'redirect') {
            // Validate url and create redirect response...
            return new Response();
        }

        return $next->handle($request, $response);
    }
}

class XssValidationHandler extends RequestHandler
{
    public function handle(Request $request): Response
    {
        if ($request->getQueryParam('search')) {
            // If the parameter values corresponds to a XSS attack, block user...
            return new Response();
        }

        return $next->handle($request, $response);
    }
}

// Last handler, if everything went fine...
class LoadViewHandler extends RequestHandler
{
    public function handle(Request $request): Response
    {
        // Loads HTML page by request...
        return new Response();
    }
}

// ...request handling on index.php

$handler1 = new UserAuthorizerHandler();
$handler2 = new UrlRedirectHandler();
$handler3 = new XssValidationHandler();
$handler4 = new LoadViewHandler();

$handler1->setNextHandler($handler2)
    ->setNextHandler($handler3)
    ->setNextHandler($handler4);

return $handler1->handle($request);
```

## State pattern

The state pattern is used when you want to **change the behavior off an object depending on its current state** at run-time.

Lets see the example in Java. Instead of have lots of conditions inside the **ATM** class, we **distribute the responsibilities to each possible "state"** of the ATM machine.

``` java
class Atm
{
    private float balance;
    private AtmState currentState;
    private NoFundsState noFundsState;
    private HasFundsState hasFundsState;
    private IdleState idleState;

    public Atm()
    {
        idleState = new IdleState(this);
        noFundsState = new NoFundsState(this);
        hasFundsState = new HasFundsState(this);
        currentState = idleState;
    }

    public void withdraw(float amount)
    {
        currentState.withdraw(amount);
    }

    public void deposit(float amount)
    {
        currentState.deposit(amount);
    }

    public float getBalance()
    {
        return balance;
    }

    public void addMoney(float money)
    {
        this.balance += money;
    }

    public void removeMoney(float money)
    {
        this.balance -= money;
    }

    public void setCurrentState(AtmState currentState)
    {
        this.currentState = currentState;
    }

    public HasFundsState getHasFundsState()
    {
        return this.hasFundsState;
    }

    public NoFundsState getNoFundsState()
    {
        return this.noFundsState;
    }

    public IdleState getIdleState()
    {
        return this.idleState;
    }
}

abstract class AtmState
{
    protected Atm atm;

    public AtmState(Atm atm)
    {
        this.atm = atm;
    }

    public abstract void withdraw(float amount);
    public abstract void deposit(float amount);
}

class NoFundsState extends AtmState
{
    public void withdraw(float amount)
    {
        throw new NoFundsException("No funds");
    }

    public void deposit(float amount)
    {
        super.atm.addMoney(amount);
        super.atm.setState(super.atm.getHasFundsState());
    }
}

class HasFundsState extends AtmState
{
    public void withdraw(float amount)
    {
        if (super.atm.getBalance() < amount) {
            throw new NoFundsException("No funds");
        }

        super.atm.removeMoney(amount);

        if (super.atm.getBalance() <= 0) {
            super.atm.setState(super.atm.getNoFundsState());
        }
    }

    public void deposit(float amount)
    {
        super.atm.addMoney(amount);
    }
}

class IdleState extends AtmState
{
    public void withdraw(float amount)
    {
        if (super.atm.getBalance() < amount) {
            throw new NoFundsException("No funds");
        }
            
        super.atm.removeMoney(amount);

        if (super.atm.getBalance() <= 0) {
            super.atm.setState(super.atm.getNoFundsState());
        } else {
            super.atm.setState(super.atm.getHasFundsState());
        }
    }

    public void deposit(float amount)
    {
        super.atm.addMoney(amount);
        super.atm.setState(super.atm.getHasFundsState());
    }
}
```

## Command

The command **encapsulates a request in an object** its own. So this command must be forward to a **Worker** which knows how to execute this command.

```
(Sender) -Creates-> (Command) -Calls_Method-> (Receiver);
```

Objects involved in the Command pattern.

- **Sender**: The object that needs some request to be done.
- **Command**: The encapsulated request in a way that the Receiver knows how process it.
- **Receiver**: The object that knows how to execute an specific Command.
- **Invoker**: The object that invokes Command object to complete whatever tasks it does.
- **Command Manager**: A object to keep track of the commands to be executed.

### Undo/Redo or Memento using Command pattern

Sometimes you need to keep track of all the state changes of an object, so you can easily move back and forth to a program state. A real world example is the **undo/redo of text editors**. So every time you do a change in the editor you put a command at the top of a stack.

This pattern can be used in conjunction with the **Command pattern**

{% include post-figure.html image="command-memento-pattern.png" caption="UML Command and Memento pattern" %}

Se the example in PHP **integrating Memento with Command** pattern:

``` php
<?php 
interface Receiver
{
    public function execute(array $data);
}

class EraseTextReceiver implements Receiver
{
    public function execute(array $data): void
    {
        //Erase from file: $data['file'], strlen($data['text']), $data['position'];
    }
}

class WriteTextReceiver implements Receiver
{
    public function execute(array $data): void
    { 
        //Write in the file: $data['file'], $data['text'], $data['position'];
    }
}

class SaveFileReceiver implements Receiver
{
    public function execute(array $data): void
    {
        //Save file contents from $data['file']
    }
}

abstract class Command
{
    abstract public function do(): void;
    abstract public function undo(): void;
    abstract public function isReversible(): bool;
}

class WriteCommand extends Command
{
    private $writeReceiver;
    private $eraseFileReceiver;
    private $data;

    public function __construct(
        WriteFileReceiver $writeReceiver, 
        EraseFileReceiver $eraseFileReceiver,
        array $data
    ) {
        $this->writeReceiver = $writeReceiver;
        $this->eraseReceiver = $eraseFileReceiver;
        $this->data = $data;
    }

    public function do(): void
    {
        $this->writeReceiver->execute($this->data);
    }
    
    public function undo(): void
    {
        $this->eraseReceiver->execute($this->data);
    }

    public function isReversible(): bool
    {
        return true;
    }
}

class SaveCommand extends Command
{
    private $data;

    public function __construct(array $data) 
    {
        $this->data = $data;
    }

    public function do(array $data): void
    {
        // Save file: $this->data['file'];
    }
    public function undo(array $data): void
    {
         // cannot undo save
    }

    public function isReversible(): bool
    {
        return false;
    }
}

/**
 * Manage command execution, queue, etc
 * 
 * Here we are using "Memento pattern" where we have two queues "history" and "undoHistory".
 */
class CommandManager
{
    private $history = []; //Queue for doing commands
    private $undoHistory = []; //Queue for undoing commands

    public function doCommand(Command $command)
    {
        $this->history[] = $command;

        $command->do();
    }

    public function undoCommand()
    {
        $last = count($this->history) - 1;

        if (!isset($this->history[$last])) {
            return;
        }

        $lastCommand = $this->history[$last];

        unset($this->history[$last]);

        $this->undoHistory[] = $lastCommand;

        if ($lastCommand->isReversible()) {
            $lastCommand->undo();
        }
    }

    public function redoCommand()
    {
        $last = count($this->undoHistory) - 1;

        if (!isset($this->undoHistory[$last])) {
            return;
        }

        $lastCommand = $this->undoHistory[$last];

        unset($this->undoHistory[$last]);

        $this->history[] = $lastCommand;

        $lastCommand->do();
    }
}

// Interacts with command manager and commands
class Invoker
{
    /**
     * @var CommandManager
     */
    private $commandManager;

    public function invoke()
    {
        $file = new File();
        $writeTextReceiver = new WriteTextReceiver();
        $eraseTextReceiver = new EraseTextReceiver();
        $saveReceiver = new SaveFileReceiver();

        $command1 = new WriteCommand(
            $writeTextReceiver, 
            $eraseTextReceiver, 
            [
                'file' => $file,
                'text' => 'Hello Word', 
                'position' => 0,
            ]
            
        );
        $command2 = new WriteCommand(
            $writeTextReceiver, 
            $eraseTextReceiver, 
            [
                'file' => $file,
                'text' => 'Another text', 
                'position' => 9,
            ]
        );
        $command3 = new SaveCommand(
            [
                'file' => $file,
            ]
        );

        /**
         * Here we can check memento working with Command pattern
         */
        $this->commandManager->doCommand($command1);
        $this->commandManager->doCommand($command2);
        $this->commandManager->doCommand($command3);

        $this->commandManager->undoCommand(); // Cannot undo save
        $this->commandManager->undoCommand(); // Will remove "Another text" from file

        $this->commandManager->redoCommand(); // Will add again "Another text" to file

        $this->commandManager->undoCommand(); // Will remove "Another text" from file
        $this->commandManager->undoCommand(); // Will remove "Hello World" from file
    }
}
```

## Mediator

When we need some objects to interact each other based on some events, sometimes create an direct relation could be difficult to maintain. As these objects can grow in different directions, we do not want them to being coupled.

Imagine that you have a **Smart House** where you object can take different actions based on some events or other objects states. For instance, when your house temperature is too cold, the Air Conditioning should increase temperature. Or when you enter at home after a day of work, a coffee should be prepared. If it is Sunday morning 9AM, turn on the TV with the News.

It would be really difficult to maintain those objects aware about each other states. There comes handy the **Mediator** to do the job.

{% include post-figure.html image="mediator-pattern.png" caption="UML Mediator pattern" %}

In this pattern we call these objects that talk to the Mediator, **Colleagues**. The Colleagues can notify the Mediator through the **Observer Pattern**. So, for instance when some relevant event happens with the **Thermostat**, like "Temperature changed", the Mediator is notified.

{% include post-figure.html image="mediator-class-diagram.png" caption="Mediator UML class diagram" %}

``` php
<?php
abstract class Mediator implements SplObserver {}

abstract class Colleague implements SplSubject
{
    public function attach(SplObserver $observer)
    {
        // Attach Mediator
    }

    public function detach(SplObserver $observer)
    {
        // Detach Mediator
    }

    public function notify()
    {
        //Call Mediator::update
    }
}

class HouseMediator extends Mediator
{  
    public function update(SplSubject $publisher)
    {
        // Check the subject. If is Temperature update by thermostat, change the air conditioning
    }
}

class Thermostat extends Colleague
{
    public function updateCurrentTemperature(float $temperature): void
    {
        // Notify mediator
        $this->notify();
    }
}

class AirConditioning extends Colleague
{
    public function changeTemperature(float $temperature): void
    {
        // Change air conditioning temperature accordingly
    }
}
```

## Observer

When we need to keep objects "observing" changes on other objects (subjects) we use the **Observer** pattern. This pattern contains main classes:

- **Observer**: The objects that wants to be notified when something occurs with the Subject.
- **Subject**: The object containing one or more observers related and responsible to notify than when something occurs.

{% include post-figure.html image="observer-class-diagram.png" caption="Observer UML class diagram" %}

Example in Java:

``` java
public interface Subject 
{
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}

public interface Observer 
{
	public void update(Subject subject);
}

public class Shipping implements Subject 
{
    private ArrayList<Observer> observers;
    private String productId;
    private String status;

    public void changeShippingStatus(String productId, String status)
    {
        this.productId = productId;
        this.status = status;

        this.notifyObservers();
    }

    public String getProductId()
    {
        return this.productId;
    }

    public String getStatus()
    {
        return this.status;
    }
    
    public void addObserver(Observer observer)
    {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);    
        }
    }
    
    public void removeObserver(Observer observer)
    {
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }
    
    public void notifyObservers()
    {
        for (Observer observer : this.observers) {
            observer.update(this);
        }
    }
}

public class Customer implements Observer
{
    private String name;
    
    public Customer(String name)
    {
        this.name = name;
    }
    
    public void update(Subject subject)
    {
        if (status.equals("live")) {
            System.out.println("Product " + subject.getProductId() + " shipping status is now " + subject.getStatus() + "!");
        }
    }
}
```