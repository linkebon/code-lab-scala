import scala.collection.{immutable, mutable}

object Interviewcake_34 extends App {
  val dictionary = mutable.Map[String, Int]()
  val notWantedChars = Array(';', ':', '.', ',', '\'', '(', ')', '\'')
  var modifiedText = ""
  "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake. The bill came to five dollars."
    .foreach {
      case char if notWantedChars.contains(char) => modifiedText += " "
      case char => modifiedText += char
    }

  modifiedText
    .split(" ")
    .filterNot(word => word.length == 1 || " ".equalsIgnoreCase(word))
    .foreach { word =>
      if (dictionary.contains(word)) {
        dictionary(word) = dictionary(word) + 1
      } else {
        dictionary += word -> 1
      }
    }
  dictionary.foreach(println)
}
