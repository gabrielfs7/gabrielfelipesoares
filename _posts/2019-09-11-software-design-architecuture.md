---
title: Important concepts about Software Design and Software architecture
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

What is Software Design and Architecture? How they relate and differ each other?

<!-- more -->

# Software Architecture

You can imagine the project of a house as example:

- How many rooms does it have and how they are connected: What is the house position and how many people it can support? These are higher level questions and show interactions of many "components" in a wide scope.

So during the architecture we need to know:

- The big picture of the problem we need to solve.
- What are the possible solutions.
- Define how the "overall" solution would look like.
- Necessary requirements for an stable and long living solution.
- Define the quality tradeoffs.

## What is quality trade-off?

A tradeoff happens when to make an improvement you must sacrifice some other quality, for example: Adding security layer even if it costs some performance, but application is safier.

# Software Design

For the very same project of the house, now we need to build the kitchen.

- Which pipes will we use? What will be the wall's colors and material. How many sinks and which sizes? etc. 

When we enter in "implementation" details of a "components" we are talking about the design. But what are the stages of the design?

## Stage 1: Conceptual Design

This part is closer to the software behaviour and funcional validation.

- Collect and validate customer requirements.
- Create conceptual mockups: Mockups will help you visualize your problem space in the earliest stages.
- Validate mockups with customers.
- Create the CRC (Class Responsibility Colaborator) cards: They will help you identify classes and components.
- Reveal "hidden" questions from customer.

## Technical Design

This part is closer to the software implementation.

- Turn the conceptual design into a more precise design. Go into details, for instance using UML.
- Define code structure and turn mockups into classes.

# What is CRC (Class Responsibility Colaborator)?

This technique helps you see the relations between classes or components.

- Class or Component: The class or components that interact with other class or components.
- Responsibilities: The responsibilities of this component.
- Colaborators: Components this component interacts with.

# What are the categories of objects we found in the design phase?

- Entity Objects: Real world entities that know threis rules and attributes. Example: Customer.
- Boundary objects: Objects responsible to collect / send information to other systems. Example: Gateway, ContactForm.
- Control objects: Objects that control other objects. Example: "Mediator".

