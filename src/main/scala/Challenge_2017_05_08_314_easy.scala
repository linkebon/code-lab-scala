import scala.concurrent.duration._
import scala.io.StdIn

/**
  * Given a list of integers separated by a single space on standard input, print out the largest and smallest values that can be obtained by concatenating the integers together on their own line. This is from Five programming problems every Software Engineer should be able to solve in less than 1 hour, problem 4. Leading 0s are not allowed (e.g. 01234 is not a valid entry).
  * https://www.reddit.com/r/dailyprogrammer/comments/69y21t/20170508_challenge_314_easy_concatenated_integers/
  */
object Challenge_2017_05_08_314_easy extends App {
  // 79 82 34 83 69
  // res: smallest: 3469798283 largest: 8382796934
  print("Enter numbers: ")
  val input = StdIn.readLine()

  val t1 = System.nanoTime()
  val splitted = input.split(" ").toList
  val possibleNumbers = splitted
    .permutations
    .map { p =>
      BigInt(p.fold("")(_ + _))
    }
    .toList

  val min = possibleNumbers.min
  val max = possibleNumbers.max
  val t2 = System.nanoTime()
  val duration1 = Duration.fromNanos(t2 - t1)
  println(s"Smallest: $min Largest: $max. Time consumed: ${duration1.toMillis} ms")

  // -- Version 2 without permutations
  val smallest: (String, String) => Boolean = (a, b) => a < b
  val largest: (String, String) => Boolean = (a, b) => a > b

  def findNumber(numbers: String, sorting: (String, String) => Boolean): BigInt = {
    BigInt(
      numbers
        .split(" ")
        .toList
        .sortWith(sorting)
        .mkString)
  }

  val t3 = System.nanoTime()
  private val smallestNumber = s"${findNumber(input, smallest)}"
  private val largestNumber = s"${findNumber(input, largest)}"
  val t4 = System.nanoTime()
  val duration2 = Duration.fromNanos(t4 - t3)
  println(s"Smallest: $smallestNumber, Largest: $largestNumber Time consumed: ${duration2.toMillis} ms")
}
