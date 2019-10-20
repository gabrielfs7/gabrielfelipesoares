---
title: Product Lines and Product Families
categories:
- Software-Architecture
feature_image: "https://picsum.photos/2560/600?image=872"
---

Producing software has costs that can be reduced with code reusability. Lets talk about how the creation of "Product Lines" can help you achieve this.

<!-- more -->

According to the book [Software Product Lines in Action](https://www.goodreads.com/book/show/1434086.Software_Product_Lines_in_Action) by _Frank J. van der Linden_. To discover the product lines we must separate the features that stay the same, from the features that change by each product.

We can do this through the classification of three feature's groups:

- **Commonalities**: _Product line_ features that stay the same for all the products. For instance: The UI components, Hardware Drivers, etc.

- **Variations**: _Product line_ features that vary within products. iPad and iPhone camera software.

- **Product-Specifics**: Specific features _for one and only one_ product.

To apply the product lines classification on the architecture and Software Development lifecycle, it is common to create different teams and change the organization structure. 

There will be 2 different teams that can vary according to size of product, commonalities and variations.

- **Domain Team**: Responsible to maintain the commonalities and variations. They are constantly in contact with application teams when new features need to be released and define if the scope is product specific or not.

- **Application Team**: Responsible to develop new Product Specific features and integrate variations and commonalities into their products.

{% include post-figure.html image="product-lines-team-organization.png" caption="Product Lines Team Organization" %}

Of course, there are some trade-offs by using this approach. There will be needed for an _extra upfront investment_ to adapt your architecture and code base to support reusable code. The creation of **commonalities**, like libraries, definition of boundaries, communications standards and protocols within components among others must be planned and done in advance.

{% include post-figure.html image="product-lines-tradeoffs.png" caption="Product Lines" %}

It might does not fit for all sort of projects. If you have a small project that has a short life time and no plans to scale, may not worth to invest time on creating **commonalities**. But companies that want to build a consolidated product must think about this.

## Benefits of Product Lines

- **Reducing costs** to maintain and create new products. Since great part of the codebase is shared, more products will benefit from it.

- **More resources** can be spent on other qualities attributes of a product, such as testing, security, reliability, etc.

- **User experience**: As the products share UI libraries, the end-user will have low learning curve to use different products. This is an strategy used for Apple, where users from iPad, iPhone, iMac are already familiar with the software. It is really important to engage users on companies products.

- **Time-to-Market**: If the company decides to create a new product tomorrow, they can utilize existent software have a shorter delivery time, since most of the softwares components are already made.

## Conclusion

The creation of product lines is really important to reduce costs and give competitive advantage for the company. Even if it implies in a higher initial development cost, it will bring lots of benefits in short period. As a Software Architect you must identify the situations where it worth invest time by planning Product Lines, since it does not fit for all types of projects.