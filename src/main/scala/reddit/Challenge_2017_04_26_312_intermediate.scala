package reddit

/**
  * Given an integer, find the next largest integer using ONLY the digits from the given integer.
  * https://www.reddit.com/r/dailyprogrammer/comments/67q3s6/20170426_challenge_312_intermediate_next_largest/
  */
object Challenge_2017_04_26_312_intermediate extends App {

  def calculatePermutationsAndSort(number: Int): List[Int] = {
    number
      .toString
      .permutations
      .map(_.toInt)
      .toList
      .distinct
      .sortWith((k, j) => j > k)
  }

  def findNextInteger(number: Int): Int = {
    val permutations = calculatePermutationsAndSort(number)
    permutations(permutations.indexOf(number) + 1)
  }

  val input_1 = 1234
  val input_2 = 1243
  val input_3 = 234765
  val input_4 = 19000

  println(input_1 + " -> " + findNextInteger(input_1))
  println(input_2 + " -> " + findNextInteger(input_2))
  println(input_3 + " -> " + findNextInteger(input_3))
  println(input_4 + " -> " + findNextInteger(input_4))
}
