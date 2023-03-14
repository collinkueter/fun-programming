# Functional Programming in Scala

## About Me
![Family](./images/img-127.jpg)
- (2016) Computer Science graduate of Cedarville
- (2016) Java - Principal Financial Group
- (2019) Scala - Dwolla
- (2021) Scala - Rally Health (UHG)
- (2022) Scala - Axoni

## Where I Work
![Axoni](./images/axoni.jpeg)
- New York-based capital markets technology firm that specializes in distributed ledger infrastructure
- Provides secure, multiparty infrastructure to automate synchronization of information and processes across entire markets

## History of Functional Programming
- (1930) Roots in academia, evolving from the lambda calculus (Alonzo Church in the 1930s), a formal system of computation based only on functions
- (late 1950's) The first high-level functional programming language, LISP, was developed for the IBM 700/7000 series of scientific computers by John McCarthy while at MIT.
- (1985) Miranda is a lazy, purely functional programming language designed by David Turner, but was proprietary software
- (1990) Haskell - A committe was formed to consolidate existing functional languages into a common one to serve as a basis for future research in functional-language design
- (2001/2004) Scala
- (2022) Scala - one of the top paying languages (median income $96,979 Stack Overflow Developer Survey)

## Mathematical Functions
A function from a set `X` to a set `Y` is an assignment of an
element of `Y` to each element of `X`.
- The set X is called the domain of the function
- The set Y is called the codomain of the function.

```
f(x) = x + 1
```
#### Types
Domain: **Z**

Codomain: **Z**

## Scala Functions

```scala
def f(x: Integer): Integer = x + 1

val f: Integer => Int = (x: Integer) => x + 1
```
Great, but we can do this in Java or any other language!

## No Side Effects

Consider an example:
```
x = [1,2,3]
y = f(x)
x = ?
```
Now let us say that `f(x)` becomes very _complicated_
```
x = [1,2,3]
y = f(a(x) + b(x) * c(x) - 42 * (d(x) - e(x)))
x = ?
```

## Immutability 

```
x = [1,2,3]
c(x) = x[1] = 5 // [1,5,3]
y = f(x) = a(x) + b(x) * c(x) - 42 * (d(x) - e(x))
x = ?
```

### How can I ever change anything?

# Pure Functions

- A pure function is one that lacks side effects.

A function f with input type A and output type B is a computation that relates every value a of type A to exactly one value b of type B such that b is determined solely by the value of a. Any changing state of an internal or external process is irrelevant to computing the result f(a).

```scala
  f: A => B
```

For example this function will take every integer to a corresponding string

```scala
  def intToString(i: Int): String = i.toString
```

In other words, a function has no observable effect on the execution of the program other than to compute a result given its inputs; we say that it has no side effects. We sometimes qualify such functions as pure functions to make this more explicit, but this is somewhat redundant.

Unless stated otherwise, I'll use the word function to imply no side effects.

## Benefits of Functional Programming
- No Side Effects
- Immutability
- 






