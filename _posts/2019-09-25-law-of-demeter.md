---
title: Law of Demeter - Least Knowledge Principle
categories:
- Design-Principles
feature_image: "https://picsum.photos/2560/600?image=872"
---

A class should know as less as possible about other classes implementation. There is a law for it!

<!-- more -->

A class should only know about first implementation of its "immediate fried" classes. This is important to avoid coupling and make your system more flexible, reusable, maintainable and with low coupling.

# Example:

Let's check the allowed usages:

``` java
class A
{
    private C c;

    public void doB(B b)
    {
        b.do(); // Allowed!
    }

    public void doC()
    {
        this.c.do(); // Allowed!
    }

    public void doD()
    {
        D d = new D();

        d.do(); // Allowed!
    }
}
```

And these are not allowed:

``` java
class A
{
    private C c;

    public void doB(B b)
    {
        b.do().doAgain(); // NOT Allowed!
    }

    public void doC()
    {
        this.c.do().doAgain(); // NOT Allowed!
    }

    public void doD()
    {
        D d = new D();

        d.do().doAgain(); // NOT Allowed!
    }

    public void setC(C2 c)
    {
        this.c = c;

        this.c.do(); // NOT Allowed, cause C2 is a base class of C and A only knows C!
    }
}
```