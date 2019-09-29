---
title: Open / Closed Principle - OCP
categories:
- Design-Principles
- SOLID
feature_image: "https://picsum.photos/2560/600?image=872"
---

The Open/Close Principle says that a class must be open for extension, but closed to change. Let's take a look on it.

<!-- more -->

If classes are tested, stable and the system is proven to be working with those, probably you do not want (need) to change then to add more features. So the classes will be open for extension, but closed to changes. 

To overcome this you can use polymorphism to add new features by inheritance or implementing same interfaces.
