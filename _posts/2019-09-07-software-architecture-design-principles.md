---
title: Software Architecture Design Principles
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

There are 4 important *Design Principles* to guide architects when modeling software. They are the **CoSICi** principles. I have invented this word to help me out memorize them! So far it is working and I would like to share it!

<!-- more -->

<small>
*WIP:* This article is a working in progress. There could be some errors. I will also add some images to help the understanding :)
</small>

## 1. (Co) Coupling & Cohesion

Besides the different names, Coupling and Cohesion are intimately related, cause 
both concern about *software complexity*.

Before explain each one, lets first define what is considered a *module* within this scope.

*Module* can be a:

- Software Component.
- A Class
- A Method of a Class
- A Function

### Coupling

Coupling represents the level of complexity involving multiple modules.

### Cohesion

Cohesion represents the level of complexity inside a single module.

### And how to evaluate complexity?

To evaluate complexity we consider 3 important aspects: Degree, Easy, Flexibility:

#### Degree

The Degree relates to the number of connections between modules. Are they tightly coupled
to other modules?

#### Easy

The Easy relates to how obvious are these connections. Do they follow a standard with meaningful names and purpose?

#### Flexibility

Can the module be used by others without refactoring? Does it have a generic interface that can be easily used by other modules without collateral effect?


## 2. (S) Separation of Concerns

A component, service, class or method should have a single, clear and meaningful purpose. 

Here comes handy the usage of SOLID principles, specially the (S) Single Responsibility.

Tips:

- Relay on interfaces instead of concrete classes. When creating interfaces, you can better define the classes responsibility.
- Use properties and methods access modifiers to restrict access.
- Expose only necessary information on the APIs.
- Avoid to appropriate data from other *Domains* to your application. Respect the *Softwares Boundaries*

## 3. (I) Information Hiding

A module should only expose necessary information for other components. This means that a module
should only know what he needs to know to fill his purpose and also only expose information that is necessary for other modules purposes.

Be aware to use *encapsulation* and guard methods (i.e setter / constructors / getters) to receive and expose information in the correct ways.

## 4. (CI) Conceptual Integrity

I like to say the Conceptual Integrity is as good as the the alignment of business knowledge, technical expertise and process compliance that the individuals have.

Tips:

- Follow a code standard.
- Training and adjust knowledge levels of the individuals to be as similar as possible.
- Do Code Reviews to reinforce the standards are being applied.
- Have a well defined, accepted and execute SDLC (Software Development Life Cycle). Does not matter if you use Scrum, Kanban, water fall or whatever. If it is accepted and used by the individuals, this is what matters.



