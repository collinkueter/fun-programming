# How do we handle side effects?

An effect is a description of an action (or actions) that will be taken when evaluation happens.

---
---

# Implementing a simple effect type

### Our goal is to represent effects while maintaining referential transparency

Simple program to read in a temperature in Fahrenheit and convert to Celsius.
```scala
def fahrenheitToCelsius(f: Double): Double = (f - 32) * 5.0 / 9.0

def converter: Unit = {
  println("Enter a temperature in degrees Fahrenheit: ")
  val d = readLine.toDouble
  println(fahrenheitToCelsius(d))
}
```
---
---
# A Simple IO Type

```scala
trait IO { def run: Unit }

val print = new IO { def run = println(msg) }
```

- IO simply describes an action that needs to take place, but does not actually execute it
- Only the interpreter of IO (its run method) actually has a side effect

Using IO
```scala
def fahrenheitToCelsius(f: Double): Double = (f - 32) * 5.0 / 9.0
def converter: IO = {
  val prompt: IO = new IO {
    def run = println("Enter a temperature in degrees Fahrenheit: ")
  }
  // now what ???
}

```
---
---

# Sequence IOs, allow input, and yield values
- Monad is a structure that combines functions and wraps their return values in a type (flatMap)

```scala
sealed trait IO[A] {
  self => def run: A

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

  def apply[A](a: => A): IO[A] = unit(a) // Lets us use function syntax
}
```
---
---

# Using sequenced IOs, input, and yielding values

```scala
def ReadLine: IO[String] = IO {
  readLine
}

def PrintLine(msg: String): IO[Unit] = IO {
  println(msg)
}

def converter: IO[Unit] = for {
  _ <- PrintLine("Enter a temperature in degrees Fahrenheit: ")
  d <- ReadLine.map(_.toDouble)
  _ <- PrintLine(fahrenheitToCelsius(d).toString)
} yield ()
```
---
layout: image
image: 'images/cats_effect_impure.png'
---
