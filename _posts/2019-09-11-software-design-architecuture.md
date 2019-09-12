---
title: A brief overview about Software Design and Software architecture
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

What is Software Design and Architecture? How they relate and differ each other?

<!-- more -->

To try to understand Software Design/Architecture, we can do an analogy using a project of a house, for example:

# Software Architecture

As an architect, you would have **high level** concerns, such as: 

- How many people does it needs to support?
- How many rooms does it have?
- How are they connected / acessible?
- What would be the best house position, angle, size?
- What is the region where the house is located? 
- What materials should I use?

These are higher level questions and show **interactions of many "components"** on a wide scope.

So during the architecture we need to know:

- The **big picture** of the problem we need to solve.
- What are the **possible solutions**.
- Define how the "overall" solution would look like.
- Raise the **Necessary requirements** for an stable and long living solution.
- Define the **quality tradeoffs**.

## What is a quality trade-off?

A tradeoff happens when to make an improvement you must sacrifice some other quality, for example: Adding security layer even if it costs some performance, makes the application safier.

## What are important skills for a Software Architect?

- **Tech Skills**: Having good years of experience programing with different languages, databases, frameworks, solving problems in different scales, etc are mandatory.
  - Design patterns.
  - Code standards.
  - Distributed processing.
  - Network.
  - Event Oriented and Object Oriented Programing.
  - ...Any other Technology close to your professional scope. Example: An architect for mobile apps, must know cloud computing, mobile programing (ie. Java), UI and so on.

- **Business knowledge**: An architect must be close to the business in order to clearly understand their needs and find the better approach to create a successful solution.

- **Organizational skills**: Handle multiple concerns: Security, Performance, Business requirements, technical limitations, deadlines, etc.

- **Soft skills**: It's true that we use computers to create our applications, but we actually work with people for people. It's important to maitain good relationship with colleagues from the team and other departments. Make the work environment pleasant and colaborative. Happy people produce more and do not get sick so often.

- **Know what is available**: Do not get stuck on your technologies and ideas. Always try to find out what is happening in the market, which technologies are available, what can you use? I mean, you do not need to know everything in details, but it comes handy when you have a problem to solve and planty of alternatives to nail it.

# Software Design

Still considering the house project as example, the "Design" involves a **low level** scope, which means, we can can **go on details for a given component**.

Considering we need to build the kitchen, now the questions are:

- How would the person interact with the kitchen?
- How many sinks and which sizes we would need?
- For plumbing, which pipes should we use, and in which disposition?
- What will be the best material for this type of kitchen?
- How would be better electrical wires connections to use, and how many plugs and sockets?

When we enter in **"implementation" details** of a **"component"** we are talking about the design. 

But what are the **Stages of the Software Design**?

## Stage 1: Conceptual Design

This part is closer to the software behaviour and funcional validation.

- **Concept validation**: Collect and validate customer requirements.
- **Conceptual mockups**: Create mockups to help you visualize your problems in the earlier stage.
- **Validate mockups**: Show, validate and adapt your mockups with the customers.
- **Create the CRC cards**: Class Responsibility Colaborator cards will help you identify classes and components in your system and how they interact each other.
- **Reveal "hidden" questions**: Durnig the previous steps, many questions might come to you. Bring them to the customer, before moving forward.

### What is CRC (Class Responsibility Colaborator)?

This technique helps you see the relations between classes or components.

- **Class or Component**: The class or components that interact with other class or components.
- **Responsibilities**: The responsibilities of this component.
- **Colaborators**: Components this component interacts with.

## Stage 2: Technical Design

This part is closer to the software **implementation**.

- **Go into details**: Turn the conceptual design into a more precise design, for example, start the UML class diagram.
- **Programing** Define code structure and turn mockups into classes and then an application.

### Categories of objects

During the technical design, many types of objects will be evidenced:

- **Entity Objects**: Real world entities that know threis rules and attributes. Example: Customer.
- **Boundary objects**: Objects responsible to collect / send information to other systems. Example: Gateway, ContactForm.
- **Control objects**: Objects that control other objects. Example: "Mediator".

