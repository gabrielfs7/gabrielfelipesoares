---
title: Interface Segregation Principle - ISP
categories:
- Design-Principles
- SOLID
feature_image: "https://picsum.photos/2560/600?image=872"
---

A class should not be forced to do what it does not do. What? Yes, the way you built interfaces can cause this side effect.

<!-- more -->

The Interface Segregation Principle (ISP) says says that class should not be forced to depend on method it does not use.

To table this, segregate a interfaces in more and specialized ones.

# Example:

Imagine that you want to extract Bird behaviors for an interface.

``` java
interface Bird
{
    public void putEggs();
    public void peck();
    public void fly();
    public void land();
}
```

Seems good, right? But what about penguins, chickens or other birds that does not fly? To solve this we can segregate the Bird interfaces in more specialized ones:

``` java
interface Bird
{
    public void putEggs();
    public void peck();
}

interface Flying
{
    public void fly();
    public void land();
}

class Penguin implements Bird
{
    //...
}

class Chicken implements Bird
{
    //...
}

class Falcon implements Bird, Flying
{
    //...
}
```