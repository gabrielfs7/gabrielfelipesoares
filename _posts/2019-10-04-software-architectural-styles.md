---
title: Software Architectural Styles
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

A brief overview about the main software architectural styles and why and when we use them.

<!-- more -->

# Language-based Systems

The programing language you choose to build your software will define the way you will architect it due their limitations or advantages. 

For instance, a OOP (i.e. Java) will probably give you a better domain abstraction than a procedural language (i.e. C), but you cost you more performance and wont work for embedded software.

## Abstract Types and Object Oriented

Using a OOP paradigm we have better application of "Abstraction", "Encapsulation" and "Decomposition" principles. The code produced can better translate the business language and generally the learning curve is smaller. High-level programing languages generally are intuitive and have lots of third-party libraries that already solve common problems.

The cons is that it generally implies less performance and higher computational power is required. It is more difficult (and impossible sometimes) to create lightweight or embedded software with this paradigm.

**Usages:**

- Management and administrative systems.
- Web apps.
- Mobile apps.

## Main program and Subroutines

This paradigm consists in usage of procedural code based on routines and subroutines sharing globals variables and procedures. It advantage is a very lightweight and highly performative software that consumes less computational power and energy. The cons is that is really difficult to maintain and the learning curve is higher. Low-level programing languages are generally not intuitive at all do not translate well the business language.

**Usages:**

- Embedded software.
- Computational focused systems.

# Repository Based Systems
When it is needed to shared data within modules and components an often used solution is a **Data Centric** Software Architecture.

## Databases
At the core of a Data Centric architecture are __2 different types of components__:

**Central Data**: Stores and share data across all the components that connect to it.

**Data Accessors**: They are the components that connect to the Central Data component. These run queries, transactions to store and retrieve data from the Database.

{% include post-figure.html image="data-centric-software-architecture.png" caption="UML Data Centric Software Architecture" %}

The main benefits of a data centric architecture style, besides share data are:

- **Data Integrity**: Data will be store with proper normalization and will be accurate.
- **Data Persistence**: Data will keep alive to be used later.

# Layered Systems
TBD.
## Layered Systems
## Client Server n-tier


# Interpreter-based systems
TBD.
## Interpreters
## State Transition Systems


# DataFlow Systems 
TBD.
## Pipes
## Filters


# Implicit Invocation Systems
TBD.
## Event-Based
## Publish Subscribe

# Process Control Systems
TBD.
## Process Control

# 


