# Referential Transparency

Referential transparency means that we can safely, without changing the behaviour of a program, replace an expression
with its value and vice versa. It is deterministic.

```scala
def getMoney(money: BigDecimal): BigDecimal = {
  val withInterest = money * 1.1
  println(s"Here's your money: $withInterest")
  withInterest
}

val a = getMoney(10)
val twice = a + a
// Is not the same as:
val twice = getMoney(10) + getMoney(10)
```
