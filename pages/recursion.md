# Recursion (Tail)

- The problem with loops is their conditions are usually based on mutable variables
- Because of stack overflow exceptions we use tail recursion

```scala
@tailrec
def sumUp(list: List[Int], sum: Long = 0L): Long =
  if (list.isEmpty) sum else sumUp(list.tail, sum + list.head)

val bigList = (1 to 1000000).toList

sumUp(bigList)
```

<!--
in Scala, it’s possible to annotate recursive functions with the @tailrec annotation. 
It will trigger the compiler to run an analysis of whether this function meets the specific criteria – 
if not the compilation will fail and the code will need to be adjusted. 
-->