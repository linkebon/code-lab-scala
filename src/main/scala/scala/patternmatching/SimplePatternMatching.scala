package scala.patternmatching

object SimplePatternMatching extends App {

  case class User(firstName: String, lastName: String, age: Int)
  matchUser(User("john", "doe", 42))
  matchUser(User("John", "doe", 35))
  matchUser(User("Ebb", "doe", 32))

  def matchUser(user: User): Unit = {
    user match {
      case User(firstName, lastName, age) if age > 40 => println(s"$firstName $lastName with age $age is old enough")
      case User(firstName@"John", _, _) => println(s"$firstName is the first name")
      case user@_ => println(s"${user.firstName} ${user.lastName} is ${user.age} years old which no conditions")
    }
  }
}