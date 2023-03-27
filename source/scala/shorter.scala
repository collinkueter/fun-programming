def validByAge(in: List[Person]): List[String] = in.filter(_.valid).sortBy(_.age).map(_.first)

case class Person(val first: String, val last: String, val age: Int) {
  def valid: Boolean = age > 18
}

validByAge(List(Person("John", "Valid", 32), Person("John", "Invalid", 17), Person("OtherJohn", "Valid", 19)))