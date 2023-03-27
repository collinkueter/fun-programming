# Functions as First-Class Values

- Higher order functions take other functions as parameters or return a function as a result.

<!--
This is possible because functions are first-class values in Scala.
-->

---
---

# Functions as First-Class Values

Functions take other functions as parameters

```scala

def helloFrom(name: String, prettify: String => String): String = s"Hello from ${prettify(name)}"

val result: String = helloFrom("Strange", name => s"Dr. $name")
```

---
---

# Functions as First-Class Values

Functions that return a function as a result

```scala
def helloFrom(prettify: String => String): String => String =
  (name: String) => s"Hello from ${prettify(name)}"

val addDrTitle: String => String = helloFrom(name => s"Dr. $name")

val result: String = addDrTitle("Watson")
```
---
---

# Functions as First-Class Values

Functions that return a function as a result

"Real World" Example

```scala
def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
  val schema = if (ssl) "https://" else "http://"
  (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
}

def getSSLURL = urlBuilder(ssl = true, "www.example.com")
val url = getSSLURL(endpoint = "users", query = "id=1") // "https://www.example.com/users?id=1"
```
