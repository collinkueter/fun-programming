# Expression

- An expression is a value, or anything that executes and ends up being a value.

```scala
val x = 5
val f = (i: Int) => i + 1
val y = f(x)
val z = if (y > 6) "passed" else "failed"
val p: Unit = println("Hello World!")
```

In FP and Scala everything is an expression, there are no statements.