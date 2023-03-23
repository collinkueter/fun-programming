---
theme: Seriph
# highlighter: shiki
css: unocss
layout: image-right
image: images/scala-spiral.png
---

# Functional Programming

in Scala

---
layout: image-right
image: images/img-127.jpg
---

# About Me

- (2016) Computer Science graduate of Cedarville
- (2016) Java - Principal Financial Group
- (2019) Scala - Dwolla
- (2021) Scala - Rally Health (UHG)
- (2022) Scala - Axoni


## How to stay in touch
collinkueter@gmail.com

<!--
- Introduce family
- Briefly talk about experience
-->

---
---
# Where I Work
<img src="/images/axoni-horiztonal-logo.png" class="h-50" />

<style>
img {
  background: white
}
</style>
<br>

- New York-based capital markets technology firm that specializes in distributed ledger infrastructure
- Provides secure, multiparty infrastructure to automate synchronization of information and processes across entire markets

<!--
- Discuss what I do at Axoni, Data Completeness "squad" 
-->

---
layout: section
---

# Goal


---
layout: section
---

Introduction to Functional Programming (FP)

---
layout: section
---

Show how Functional Programming is better

---

# History of Functional Programming
- (1930) Roots in academia, evolving from the lambda calculus (Alonzo Church in the 1930s), a formal system of computation based only on functions
- (late 1950's) The first high-level functional programming language, LISP, was developed for the IBM 700/7000 series of scientific computers by John McCarthy while at MIT.
- (1985) Miranda is a lazy, purely functional programming language designed by David Turner, but was proprietary software
- (1990) Haskell - A committe was formed to consolidate existing functional languages into a common one to serve as a basis for future research in functional-language design
- (2001/2004) Scala
- (2022) Scala - one of the top paying languages (median income $96,979 Stack Overflow Developer Survey)

<!--
Lisp was created for mathematical notation
-->

---
---

# Review: Mathematical Functions
<br>
A function from a set `X` to a set `Y` is an assignment of an element of `Y` to each element of `X`.
- The set X is called the domain of the function
- The set Y is called the codomain of the function.

Represented as:
$$
\begin{aligned}
\operatorname {f} (x)=x+1 \\
(x)\mapsto x+1 \\
\operatorname {f} \colon \mathbb {Z} &\to \mathbb {Z} \\
\newline
\operatorname {f}(5) = 5 + 1 = 6
\end{aligned}
$$

<!-- 
In programming functions can update a database, mutate some variables, do nothing, throw exceptions, etc.

Mathematical function always evaluate to the same thing given the same input

Mathematical functions are a thing, values that you can manipulate

We want to borrow this same concept which makes our functions act the same

so we create rules to make them act the same 

We call these Pure Functions or function which have no side effects

-->

---
---
# Why do we want to do this? 

- Make our programs easier to write
- Make our programs easier to understand

---
---

Consider an example:
```scala
x = [1,2,3]
y = f(x)
x = ???
```

<!-- 
When we have no side effects x never changes
 -->
---
---

Now let us say we call a very _complicated_ function on `x`

```scala
x = [1,2,3]
y = f(a(x) + b(x) * c(x) - 42 * (d(x) - e(x)) + floor(g(x * 3) * max(2*4)))
x = ???
```

<!--
x still does not change
-->
---
---
Let us consider another example where x is mutated

```scala
x = [1,2,3]
t = {
      x[1] = 5
      f(a(x) + b(x) * c(x))
    }
y = t + f(a(x) + b(x) * c(x) - 42 * (d(x) - e(x)) + floor(g(x * 3) * max(2*4)))
x = ???
```

<!-- 
We now have to look through all of the code again to ensure that it doesn't mutate our parameter

How do we fix this problem? Immutability, once you create something you cannot change it.

-->
---
layout: section
---

# Immutability

---
---
# How do we get anything done? 

Give me a copy, but change this one thing

In Scala we have higher-order functions like `map` and `filter` which help us

```scala
val names = List("jane", "jon", "mary", "joe")
val result = names.filter(_.startsWith("j"))
             .map(_.capitalize)
// result = List("JANE", "JON", "JOE")
```
<br>
In Java
```java
List<String> names = Arrays.asList({"jane", "jon", "mary", "joe"});
List<String> result = new ArrayList<>();
for(String name : names){
  if(name.charAt(0) == 'j') {
    result.add(name.toUppercase());
  }
}
```

<!-- 

We apply a function to an existing collection to create a new collection. 

persistent data structures - huge lists 

-->
---
---
# Review

1. Pure Function (or Functions with No Side Effects)
2. Immutability

<!-- 
Two more concepts
Two benefit of pure functions
 -->

---
---
# Local Reasoning

- Allows us to understand module `A` and module `B` in isolation, `A` cannot change our understanding of `B`, and vice versa

<!-- 
Allows us to understand code when t
 -->
---
---

# Referential Transparency

---
---

# Shorter Code
Functional style code is typically much shorter

---
---
# Parallelization is trivial

---
---

# Why Functional Programming?

- No side effects
- Immutability 
- Local Reasoning
- Referential Transparency
- Functional style code is typically much shorter
- Parallelization is trivial

---
layout: section
---
# Declarative vs Imperative

---
---
# Imperative
1. Start
2. Put on Shoes with size 10
3. Make room in your pocket for 4 keys
4. Put keys in the room for the keys in your pocket
5. Enter garage
6. Open garage
7. Enter Car
...
42. Put milk in the refrigerator

---
---
# Declarative
- Shoes are clothing worn on the feet
- Shoes are worn when leaving the house
- Key are used to start a car
- Cars are used to drive places
- A Garage is where a car is stored
- Milk is a drinkable liquid
- Milk is stored in the refrigerator 
- Milk is bought at a store
- A refrigerator is a box that keeps things cool
- A store is a place to buy things
- Buying something is to exchange money or a thing

Make sure we have milk in the refrigerator (when we need it - lazy).
---
---
# Types

---
---

# Scala Functions

```scala
def f(x: Integer): Integer = x + 1

val f: Integer => Integer = (x: Integer) => x + 1
```
<!-- 
Mechanics of a scala function
 -->
---
---
# Scala Functions

```scala
def f(x: Integer): Integer = x + 1

val f: Integer => Integer = (x: Integer) => x + 1
```

<Arrow x1="120" y1="220" x2="100" y2="125" />

---
---
# Scala Functions

```scala
def f(x: Integer): Integer = x + 1

val f: Integer => Integer = (x: Integer) => x + 1
```

<Arrow x1="120" y1="220" x2="112" y2="125" />

---
---
# Scala Functions

```scala
def f(x: Integer): Integer = x + 1

val f: Integer => Integer = (x: Integer) => x + 1
```

<Arrow x1="120" y1="220" x2="150" y2="125" />

---
---
# Scala Functions

```scala
def f(x: Integer): Integer = x + 1

val f: Integer => Integer = (x: Integer) => x + 1
```

<Arrow x1="120" y1="220" x2="215" y2="125" />

<!-- Great, but we can do this in Java or any other language! -->

---
---

# Code

Use code snippets and get the highlighting directly![^1]

```ts {all|2|1-6|9|all}
interface User {
  id: number
  firstName: string
  lastName: string
  role: string
}

function updateUser(id: number, update: User) {
  const user = getUser(id)
  const newUser = { ...user, ...update }
  saveUser(id, newUser)
}
```

<arrow v-click="3" x1="400" y1="420" x2="230" y2="330" color="#564" width="3" arrowSize="1" />

[^1]: [Learn More](https://sli.dev/guide/syntax.html#line-highlighting)

<style>
.footnotes-sep {
  @apply mt-20 opacity-10;
}
.footnotes {
  @apply text-sm opacity-75;
}
.footnote-backref {
  display: none;
}
</style>