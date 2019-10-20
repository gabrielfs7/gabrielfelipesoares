---
title: Using ATAM to Analyze & Evaluate Architecture
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

Software development is becoming more complex over the years. Let's talk about how the **Architecture Trade-offs Analysis Method** can help to validate the architecture and and expose hidden risks to the Stakeholders.

<!-- more -->

When validating an _Architecture Design_ we want to fulfill the interests and concerns of all the Stakeholders. On way to do this is using _Quality Attributes Scenarios_ for every _Quality Attribute_. There are 2 types of scenarios:

### General Attribute Scenario

Are generic scenarios used to characterize any kind of system.

### Concrete Attribute Scenario

Are dedicated scenarios used to characterize an specific kind of system.

## Scenarios Components

{% include post-figure.html image="qa-scenarios.png" caption="Quality Attributes Scenarios" %}

### Stimulus Source 

It is any action that can create a stimulus. They could be _internal_ or external. An **Internal Stimulus** example is a CRON tab, that time to time triggers an action. An **External Stimulus** example could be an end-user button click or simply request a page load.
 
### Stimulus

The Stimulus source sends a _Stimulus_ which is any kind of condition that makes the system to respond. They can also be internal or external, so an invalid input provided by the end-user is a external stimulus whereas internal server error, like memory limit exceeds, is an internal stimulus.

### Artifact 

The artifact is the subsystem or component that handles the stimulus and generates the response. For instance it could be the end-user invalid input error handling or a failure recovery for an internal fault issue.

The stimulus should not communicate directly with the whole system, instead its response will become source of other stimulus and communicate with them as a chain.

### Environment

The environment is the mode or state of the system when receiving an stimulus. It could be for instance the state of the user (logged in / out), the amount of free memory in the server, the environment variables set, the server configuration, network configuration and so on.

### Response 

How the artifact behave after it receives a stimulus in certain environment will generate an specific response. It could be for instance, logging the error, sending an alert message, etc.

### Response Measure

It is a metric to quantify a quality attribute though the response. It must be quantitative and objective. Example: response time, recovery or repair time, etc.