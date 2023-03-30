
def sum(a: Int, b: Int): Int = a + b

val s1 = sum(2, 3)
val s2 = sum(2, 4)

val result = s1 + s2

val result2 = sum(2, 3) + sum(2, 4)

val g: Double => Int = (x: Double) => x.toInt
val f: Int => String = (x: Int) => s"$x times"
val h = g andThen f
val z = f compose g
h(2.3)
z(2.3)
f(g(2.3))

def bfs[T](s: Stream[T], f: T => Stream[T]): Stream[T] = {
  if (s.isEmpty) s
  else s.head #:: bfs(s.tail append f(s.head), f)
}