---
theme: apple-basic
css: unocss
layout: intro-image-right
image: images/scala-spiral.png
title: Functional Programming
---

# Functional Programming
## in Scala

---
layout: image-right
image: images/img-127.jpg
src: ./pages/about-me.md
---

---
src: ./pages/work.md
---

---
src: ./pages/axoni.md
---

---
src: ./pages/goal.md
---

---
src: ./pages/history.md
---

---
src: ./pages/math-functions.md
---

---
---

# What is Functional Programming?

- Functional programming is really about composing expressions and reducing expressions

- In Functional Programming we keep composing functions until we've written our whole application

---
src: ./pages/expression.md
---

---
src: ./pages/composition.md
---

---
layout: fact
---

## The meaning of the composition of two expressions is the composition of the meanings of each of the expressions

<!--
How do we accomplish this in FP? 
We need to define some rules for our functions, so they compose well. 
--> 

---
src: ./pages/rules.md
---

---
---

# Total

- Every input has an output

```scala
def toInt(s: String): Int
// What about "foo"? 
```

<!--
Just like our mathematics definition for a function: assignment of an element of `Y` to each element of `X`
-->

---
---

# Deterministic

- The same input always give the same output

```scala
def toInt(s: String): Int = Random.nextInt

val x = toInt(1)
val y = toInt(1)
```

<!--
Just like mathematical functions
-->

---
---

# Pure - No Side Effects

- The only concern of the function is computing the result
- What is a side effect?
  - Modifying a variable
  - Modifying a data structure in place
  - Setting a field on an object
  - Throwing an exception or halting with an error
  - Printing to the console or reading user input
  - Reading from or writing to a file
  - Drawing on the screen
- Addition is a pure function you are probably familiar with `a + b`

---
---

# Principles

- Immutability
- Referential Transparency
- Local Reasoning
- Higher Order Function (Function as First-Class Values)
- Recursion
- Type-Driven Design
- Declarative vs Imperative 

---
src: ./pages/immutability.md
---
---
src: ./pages/referential-transparency.md
---
---
src: ./pages/local-reasoning.md
---
---
src: ./pages/functions-as-first-class-values.md
---
---
src: ./pages/recursion.md
---
---
src: ./pages/type-driven.md
---
---
src: ./pages/declarative.md
---

---
---

# Benefits
- Programs are easier to write
- Programs are easier to understand
- Typically Shorter Code 
- Parallelization is Trivial

---
src: ./pages/shorter.md
---

---
---

# Parallelization is trivial

Programs that run with parallelism is complex and notoriously difficult to reason about
- Communication among execution threads
- Shared mutable memory
- Race conditions
- Deadlocks 
- Aren't readily testable
- Don't Scale

---
---

# Types




---
layout: section
---

# Bonus

---
---
# How do we handle errors?

The non-functional way

```scala
def toInt(s: String): Int = {
  if (s.isNumeric) {
    Integer.parseInt(s)
  } else {
    throw Exception("unable to parse string to int")
  }
}

```
The functional way

```scala
// sealed abstract class Either[+A, +B]

object NonNumericError

def toInt(s: String): Either[NonNumericError, Int] =
  if (s.forall(Character.isDigit)) Integer.parseInt(s) else NonNumericError
```

---
---

# Algebraic Data Types (ADTs)

- Functional programming concept with a fancy name but a very simple meaning. 
- They are an idiomatic way of representing data using “ands” and “ors”. 
```scala
sealed trait Shape
final case class Rectangle(width: Double, height: Double) extends Shape
final case class Circle(radius: Double) extends Shape
```

---
---

# How do we handle side effects? 

An effect is a description of an action (or actions) that will be taken when evaluation happens. 

---
---

# Implementing a simple effect type

### Our goal is to represent effects while maintaining referentially transparency

```scala
def fahrenheitToCelsius(f: Double): Double = (f - 32) * 5.0 / 9.0
def converter: Unit = {
  println("Enter a temperature in degrees Fahrenheit: ")
  val d = readLine.toDouble
  println(fahrenheitToCelsius(d))
}
```
IO type
```scala
trait IO { def run: Unit }

val print = new IO { def run = println(msg) }
```

Using IO
```scala
def fahrenheitToCelsius(f: Double): Double = (f - 32) * 5.0 / 9.0
def converter: IO = {
  val prompt: IO =
    new IO {
      def run = println("Enter a temperature in degrees Fahrenheit: ")
    }
  // now what ???
}

```

```scala
sealed trait IO[A] {
  self =>
  def run: A

  def map[B](f: A => B): IO[B] = new IO[B] {
    def run = f(self.run)
  }

  def flatMap[B](f: A => IO[B]): IO[B] = new IO[B] {
    def run = f(self.run).run
  }
}

object IO extends Monad[IO] {
  def unit[A](a: => A): IO[A] = new IO[A] {
    def run = a
  }

  def flatMap[A, B](fa: IO[A])(f: A => IO[B]) = fa flatMap f

  def apply[A](a: => A): IO[A] = unit(a)
}


```