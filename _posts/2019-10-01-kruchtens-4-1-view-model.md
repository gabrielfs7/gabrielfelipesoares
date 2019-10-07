---
title: Kruchten's 4 + 1
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

The [Kruchten's 4 + 1](https://en.wikipedia.org/wiki/4%2B1_architectural_view_model) technique consists to represent how a system should be implemented by dividing it in **4 different views** that are discovered through some business **Scenarios** or "Stories".

<!-- more -->

{% include figure.html image="https://upload.wikimedia.org/wikipedia/commons/e/e6/4%2B1_Architectural_View_Model.svg" caption="Source: https://upload.wikimedia.org/wikipedia/commons/e/e6/4%2B1_Architectural_View_Model.svg" position="left" %}

## Logical View

This view's intent is to capture the software functionality provided to the end-users. Here we can abstract the actors and process of our system in classes.

The UML Diagrams used here are:

- Class Diagram
- State Diagram

## Process View

To show how process and subprocess interaction within the logical view. The efficiency and performance of the system comes in evidence here.

The UML Diagrams used here are:

- Activity Diagram
- Sequence Diagram

## Development view

This view focus on implementation details, such as hierarchical structure of the software and other constraints from programing the language and technologies used.

The UML Diagrams used here are:

- Component Diagram
- Package Diagram

## Physical View

Here we can map how system interact with physical devices. The deployment process generally is part of the Physical view.

The UML Diagrams used here are:

- Deployment Diagram
- Package Diagram
