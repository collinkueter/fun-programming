# Immutability

- once created, it cannot change

---
---

# Why Immutability?

```scala
// f is a total and deterministic function
def f(l: List[Int]): Int = ???

val x = List(1, 2, 3)
val z = f(x)
val x = ???
```

<!-- 
Maybe you can keep track of this in your head.
 -->

---
---

# Why Immutability?

Now let us say we call a very _complicated_ function on `x`

```scala
// these functions are all total and deterministic functions
val x = List(1, 2, 3)
val y = f(a(x) + b(x) * c(x) - 42 * (d(x) - e(x)) + floor(g(x * 3) * max(2 * 4)))
val x = ???
```

<!-- 
There is no way you can keep track of all this in your head.
 -->

---
---

# How do we get anything done?

Give me a copy, but change this one thing

```scala
case class Car(make: String, model: String)

val hondaRidgeline = Car(make = "Honda", model = "Ridgeline")

val hondaPilot = hondaRidgeline.copy(model = "Pilot")
```

In Scala we have higher-order functions like `map` and `filter` which help us

```scala
val names = List("jane", "jon", "mary", "joe")
val result = names.filter(_.startsWith("j"))
  .map(_.capitalize)
// result = List("JANE", "JON", "JOE")
```

<!--

We apply a function to an existing collection to create a new collection. 

persistent data structures - huge lists 

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
-->