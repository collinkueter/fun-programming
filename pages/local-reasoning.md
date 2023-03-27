# Local Reasoning

- Allows us to understand module `A` and module `B` in isolation, `A` cannot change our understanding of `B`, and vice
  versa
- If we can’t make a substitution without altering the behaviour, then we are taking into account something else –
  some side effect – apart from the expression we are dealing with.

```scala
var x = 0

def foo(y: Int): Int = if (x < 0) y - x else y + x

f(1)
```

```scala
var x = 0
def foo(x: Int, y: Int): Int = if (x < 0) y - x else y + x
f(x, 1)
```
