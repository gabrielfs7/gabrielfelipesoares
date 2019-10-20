---
title: Conway's law - How Organization Structure affects Software Architecture
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

Lets understand how the organization structure can affect the way the system is developed.

<!-- more -->

The **Conway's law** says:

_A system will tend to take a form that is congruous to the organization that produced it_.

Imagine that your organization has only one team that is responsible to develop a new component. It is easy to them to agree how it will be developed: message format, interfaces, code style, etc.

When happens that another team comes to develop a new component that will integrate with the first one. They also can easily agree on a message format and protocol without thinking about other cases, since for now only these two components are talking to each other. The developers teams are on the same floor, so the communication flows smoothly.

As the organization starts to grow, other teams are being created and new components are needed. They keep talking to each other and creating agreements separately. Sooner or later it is realized that the costs and risk to introduce new features are big due to tightly coupled components and lack of standards that were "not needed" at the beginning, but their absence became a huge problem now.

This is a really common situation and in my professional life I already saw it happening. The developers and engineers then try to create standards and conventions to "fix" the architecture, but it costs a lot to the company and takes much time (maybe years) to complete. Meanwhile new features need to be added you will se yourself changing the wheel with the car running. 

Of course it is possible and it is part of our work to improve, but have a more serious vision about standards and well designed, loosely coupled and interoperable system from the beginning can save your company (and you) a lot of money, time to market and hair from your head.

# Solutions

- Before start developing define **organization's standards** (architectural and code) and follow market conventions. This will improve also the **Conceptual Integrity** of the architecture. New colleagues learning curve will also be lower. Examples: 
  - RFCs.
  - Communications protocols.
  - Common Data / Message formats.
  - Code standards.

- **Involve other teams** or at least a main responsible before a new feature or components being developed to help validated the interoperability and reusability.

- Use **code reviews** to validate new components are following company standards and conventions.