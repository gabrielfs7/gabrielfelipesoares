---
title: Object Modeling Principles
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=87"
---

There are 4 important *Principles* when modeling objects! They are the **ADEG**. Yes, as always I have invented a word to memorize them! Lets talk about them.

<!-- more -->

</small>
*WIP:* This article is a working in progress. There could be some errors. I will also add some images to help the understanding :)
</small>

An brief history review, first:

# 1960's

During the 1960's there was the **Imperative Paradigm** where programs basically were composed of routines that interact with other small routines and shared the same **Global Variables**. The processment were really expensive and the focus were most about hardware capacity than in the solution itself. 

This was the age of Cobol, Fortran and such imperative programing languages.

# 1970's 

In this period of time we had a huge avance and now developers could use **local variables** without being worried about messup the system by trusting in shared global variables. 

Also the first scratch of what would become an "object" in the future was created, the **Abstract Type** or structs.

In this time, programs started beign splited in multiple files and C header file was introduced.

This was the age of Algol, C, Pascal and other programing languages that allowed developers to use Abstract Types and local variables.


# 1980's to now

Finally the concept of object was applyed to program languages and became possible split the problem and classes and methods and became easier to use business language in the code.

As examples of languages we can mention Java, C++, C# among many others object oriented languages.


## 1. Abstraction
 
The abstraction principle consists in "abstract" the general business needs into classes and methods without concert too much about details. 

At this point the idea is not mature yet and the goal is to translate the initial problem to a high level code base.

## 2. Decomposition

As we start diging we find more business needes we did not think before the problem becomes bigger and bigger.

Instead of get crazy, we start breaking down (or decomposing) the previous classes in more and specialized ones. We create abstractios, interfaces, new entities are discovered and so on. 

The goal here is to go deep in the details by decomposing the big problem in smaller and cotrolled solutons.

### Types of Decomposition relations

#### Association

- Relationship is optional
- Associated classes are completely independent.

#### Aggregatione

- Weak **has-a** relationship.
- One object does not need to have the other to exist.

#### Composition

- Strong **has-a** relationship
- Associated classes are **completely dependent**. Example, an object **Human** always has an object **Brain** associated, otherwise it cannot exist.


## 3. Encapsulation

When decomposing the classes we start creating new methods and attributes that concern only for those classes. It is time to use inheritance, abstraction and access modifiers to to restrict for them. 

We have some conventions for this like "getters" and "setter" methods, besides today they are controversial in some cases after the surge of Object Calisthenics.


## 4. Generalization

When a class inherits behavior or interface from a superior (super) class we call it **Generalization**. It can happen in two ways:

### By Abstraction 

An abstract class (cannot be instantiated) has some methods (behaviour) or propeties that can be shared with the **chield classes**.

### By Interface

An interface (or Contract) is created, so the classes that implement this interface can entirely manange the internal implementation of the interface's expected behaviour.

Then comes in place the **Polimorthism**.
