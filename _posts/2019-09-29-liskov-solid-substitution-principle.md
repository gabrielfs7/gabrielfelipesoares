---
title: Liskov Substitution Principle - LSP
categories:
- Design-Principles
- SOLID
feature_image: "https://picsum.photos/2560/600?image=872"
---

Lets talk about Liskov Substitution Principle and how inheritance should be implemented. Yes, we are talking about the "L" from SOLID Design Principles.

<!-- more -->

Implementing inheritance in a wrong way could be a trap for you, even worse than maintaining only concrete classes. 

When different subclasses start changing the behavior of the program by being replaced by each other, then hidden behaviors are introduced and it will cause inconsistency and implying to add extra conditions to "workaround" these anomalies. From that point is all the way down.

The [Liskov substitution principle (LSP)](https://en.wikipedia.org/wiki/Liskov_substitution_principle) defines about subtyping relation by **(strong) behavioral subtyping**. It says:

`
 If S is a subtype of T, then objects of type T in a program may be replaced with objects of type S without altering any of the desirable properties of that program
`

The **4 major rules to comply to LSP** are:

# 1. Subclass cannot decide base class method invocation

A subclass MUST NOT add extra conditions to a base class method be called.

# 2. Base class state cannot differ

The **base class** state after a call from a subclass cannot be different if the call is done by another subclass. The results should be the same.

# 3. Invariants from base class must remain in subclasses

The invariant conditions should be immutable, so subclasses should not change them an cause side effects in the behavior of the program or base class.

# 4. Immutable characteristics from based class should not be changed

The base class sometimes have its own attributes that are or not encapsulated, if changing these attributes changes the base class state, so they are immutable. Avoid protected attributes as much as you can. Update these attributes can cause undesired side effects in the program or base class.

# Example

``` php
<?php
// Base class
abstract class ProductSearch
{
    /**
     * @throws InvalidArgumentException
     */
    private function validateCommand(SearchCommand $search) 
    { 
        //... 
    }

    abstract protected function executeSearch(SearchCommand $search): array;

    abstract protected function normalizeResult($item): ResultItem;

    public function search(SearchCommand $search): SearchSummary
    {
        $this->validateCommand($search);

        $results = $this->processResults($search);
        
        $summary = new SearchSummary();
        $summary->setTotal(count($results));
        $summary->setResult(
            array_map(
                function ($item): ResultItem
                {
                    return $this->normalizeResult($item);
                },
                $results
            )
        );

        return $summary;
    }
}

// Subclass, does not change behavior
class ElasticSearchProductSearch extends ProductSearch
{
    protected function executeSearch(SearchCommand $search): array
    {
        // return specific ElasticSearch results
    }

    protected function normalizeResult($item): ResultItem
    {
        // return normalized ElasticSearch result item
    }
}

// Subclass, does not change behavior
class MySQLProductSearch extends ProductSearch
{
    protected function executeSearch(SearchCommand $search): array
    {
        // return specific MySQL results
    }

    protected function normalizeResult($item): ResultItem
    {
        // return normalized MySQL result item
    }
}

// Subclass, does not change behavior
class RedisProductSearch extends ProductSearch
{
    protected function executeSearch(SearchCommand $search): array
    {
        // return specific Redis results
    }

    protected function normalizeResult($item): ResultItem
    {
        // return normalized Redis result item
    }
}

class SearchController
{
    /**
     * @var ProductSearch
     */
    private $productSearch;

    protected function search(Request $request): SearchSummary
    {
        $results = $this->productSearch->search(
            new SearchCommand(
                $request->getQueryParam('term')
            )
        );

        return $this->view->render($results);
    }
}

```


