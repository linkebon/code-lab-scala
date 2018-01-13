package scala.patternmatching

object CustomerExtractors extends App {

  trait Customer

  class FreeUser(val firstName: String, val lastName: String) extends Customer

  class PremiumUser(val firstName: String, val lastName: String) extends Customer

  object FreeUser {
    def unapply(user: FreeUser): Option[(String, String)] = Some(user.firstName, user.lastName)
  }

  object PremiumUser {
    def unapply(user: PremiumUser): Option[(String, String)] = Some(user.firstName, user.lastName)
  }

  def matchUser(user: Customer): Unit = {
    user match {
      case FreeUser(firstName, lastName) => println(s"[Free] $firstName $lastName")
      case PremiumUser(firstName, lastName) => println(s"[Premium] $firstName $lastName")
      case _ => println("Not free or premium user")
    }
  }

  matchUser(new FreeUser("John", "Doe"))
  matchUser(new PremiumUser("Peter", "Johnson"))
  matchUser(new Customer {})

}