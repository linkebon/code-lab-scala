package scala.patternmatching

object SimplePatternMatchingCollections extends App {

  case class User(firstName: String, lastName: String, age: Int) {
    override def toString: String = s"$firstName $lastName $age"
  }

  matchUser(List(User("Petter", "Doe", 35)))
  matchUser(List(User("John", "Doe", 42), User("Blom", "Karlsson", 46), User("Pippi", "Strump", 11)))

  def matchUser(user: List[User]): Unit = {
    user match {
      case x :: Nil => println(s"Single element in list ${x.firstName} ${x.lastName}")
      case x :: xs => println(s"${x.firstName} ${x.lastName} ${x.age}, ${xs.mkString(", ")}")
      case Nil => println("Empty")
    }
  }
}