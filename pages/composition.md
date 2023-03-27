# Composition

- "Function Composition" is applying one function to the results of another

$$
\begin{aligned}
\operatorname {g} \colon \mathbb {Q} &\to \mathbb {N} \\
\operatorname {f} \colon \mathbb {N} &\to \mathbb {Z} \\
\operatorname {h} = \operatorname {f} \circ \operatorname {g} \colon \mathbb {Q} &\to \mathbb {Z} \\
\operatorname {h(x)} = f(g(x))
\newline
\end{aligned}
$$

- In Scala

```scala
val g: Double => Int = (x: Double) => x.toInt
val f: Int => String = (x: Int) => s"$x times"
val h: Double => String = g andThen f
val i: Double => String = f compose g
h(2.3) == i(2.3) == f(g(2.3))
```

<!--
There are many ways to read the notation f ∘ g. The most common are “g composed with g” and “g then f“.
-->