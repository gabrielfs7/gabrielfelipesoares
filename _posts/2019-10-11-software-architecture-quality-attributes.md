---
title: Software Architecture Quality Attributes
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

When we are talking about evaluate the quality of a Software Architecture, there are some questions that cannot be answered by Design Patterns and Principles or how the elements in the architecture interact each other.

<!-- more -->

Lets take as example the "Design Patterns", they cannot assure you software testability, usability, availability, user experience, performance, etc. The are mostly made to insure reusability, flexibility and maintainability.

So how to understand if a software will have the desired quality?

# Use the right architecture to the right environment

Lets suppose you were hired to plan a multiplayer game that will be accessed by 5 different continents from end-users.

You could choose for instance an **Event-Based** architecture, which is a good choice in this case, but combined this with a **Data Centric** architecture which will make your application be very slow and unusable for the end users. Even if you architecture has fulfilled the **functional requirements**, there might be hidden **non-functional requirements** like response time, etc that were ignored.

The non-functional requirements must be raised by the architects to the stakeholders, before defining the architecture, otherwise  they can lead to a complete fail. 

Remember that different stakeholders have different perspectives and expectations, so the role of the architect is to extract them into requirements and find the architecture with the best quality as possible to meet their needs.

# Quality Attributes

A tool to find the better quality architecture is by using quality attributes. They are measurable properties to evaluate performance, usability and design. Of course, as we have different stakeholders, the quality attributes will vary according to each perspective:

## Quality Attributes for Developers

- **Maintainability**: _How easy the system can undergo through changes_? Usage of Design patterns can help reducing costs to maintain the system.

- **Reusability**: How your systems _functions or parts can be used by another_. An high cohesive and loosely coupled architecture brings benefit here.

- **Flexibility**: Requirements changes and new functionalities are added unpredictably many times. So flexibility means how your system can _adapt to requirement changes_.

- **Modifiability**: A system with good modifiability can be _easily changed or have a new functionality incorporated or removed_.

- **Testability**: As new changes occur in the system, it must be tested to guaranty best quality for end-users. Test automation can provide better testability and enforces you to develop good quality systems, besides easily demonstrate errors with test execution.

- **Conceptual Integrity**: Naming conventions, usage of a common object modeling architecture and code structure (i.e. DDD) will help you to keep conceptual integrity. It will reduce learning curves within developers to different applications and new features.

## Quality Attributes for end users

- **Availability**: Does the amount of time the system is available harm the user experience? Redundancy, multi-region deploy, load balancing, monitoring, etc are ways to maintain a good availability.

- **Interoperability**: Nowadays systems do not exist in isolation. They depend on data provided by other systems. Well defined and standardized communications protocols and data formats will facilitate the system to exchange information with another.

- **Security**: The capacity of the system to safely store, process and transfer sensitive data. Authorization and authentication checks, cryptography, etc are some examples to keep a system safe.

- **Performance**: The system throughput, latency should be acceptable to not affect end user experience. Multi-region deployment, load balancing, usage of CDN and many others are techniques to increase performance.

- **Usability**: Defines how easy is the system to be used. Does it contain a friendly user interface and easy to navigate? This item is close to UI and UX areas.

# Conclusion

To reach the best architecture that meets the stakeholders expectation we must involve them to collect all the functional and non-functional requirements. Moreover, gather and classify the Software Architecture Quality Attributes according to their expectations. It is not recommended to invest much time with further architecture and design steps before have the quality attributes clear, since they can drastically influence the architecture style and technologies used.            