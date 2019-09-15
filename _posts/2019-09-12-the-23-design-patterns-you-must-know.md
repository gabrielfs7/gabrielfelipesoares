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
class Singleton
{
    private $instance;

    private function __construct(){}

    public static function getInstance(): Singleton 
    {
        if (null === $this->instance) {
            $this->instance = new self();
        }

        return $this->instance;
    }
}
```

# Structural Patterns

These patterns describe how objects are connected to each other:

- How they relate with generalization: Composition, Association, Aggregation, Inheritance or Interface 
- How classes and subclasses interact trough inheritance.

# Behavioral Patterns

Define how **independent** object work towards a common goal.

