
/**
  * L33tspeak - the act of speaking like a computer hacker (or hax0r) - was popularized in the late 1990s as a mechanism of abusing ASCII art and character mappings to confuse outsiders. It was a lot of fun. One popular comic strip in 2000 showed just how far the joke ran.
  * https://www.reddit.com/r/dailyprogrammer/comments/67dxts/20170424_challenge_312_easy_l33tspeak_translator/
  */
object Challenge_2017_04_24_312_easy extends App {
  val toLeetTranslation = Map(
    "A" -> "4",
    "B" -> "6",
    "E" -> "3",
    "I" -> "1",
    "L" -> "1",
    "M" -> "(V)",
    "N" -> """(\)""",
    "O" -> "0",
    "S" -> "5",
    "T" -> "7",
    "V" -> """\/""",
    "W" -> "`//")

  val fromLeetTranslation = toLeetTranslation.map {
    case (k, v) => (v, k)
  }

  def translator(toLeet: Boolean): Map[String, String] = if (toLeet) toLeetTranslation else fromLeetTranslation
  def translate(str: String, toLeet: Boolean): String = str.map(s => translator(toLeet).getOrElse(s.toUpper.toString, s.toString)).mkString

  println("storm -> " + translate("storm", true))
  println("31337" -> translate("31337", false))
  println("I am elite." -> translate("I am elite.", true))
  println("Eye need help!" -> translate("Eye need help!", true))

}
