import scala.io.StdIn

/**
  * Given a list of integers separated by a single space on standard input, print out the largest and smallest values that can be obtained by concatenating the integers together on their own line. This is from Five programming problems every Software Engineer should be able to solve in less than 1 hour, problem 4. Leading 0s are not allowed (e.g. 01234 is not a valid entry).
  * https://www.reddit.com/r/dailyprogrammer/comments/69y21t/20170508_challenge_314_easy_concatenated_integers/
  */
object Challenge_2017_05_08_314_easy extends App {
  print("Enter numbers: ")
  val input = StdIn.readLine()
  val splitted = input.split(" ").toList
  val permutations = splitted
    .permutations
    .map(_.toList)
    .toList

  val sorted = permutations.map { p =>
    BigInt(p.fold("")(_ + _))
  }
  val min = sorted.min
  val max = sorted.max
  println(s"Smallest: $min Largest: $max")
}
