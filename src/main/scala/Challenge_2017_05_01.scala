


/**
  * Given a sorted list of distinct integers, write a function that returns whether there are two integers in the list that add up to 0. For example, you would return true if both -14435 and 14435 are in the list, because -14435 + 14435 = 0. Also return true if 0 appears in the list.
  * https://www.reddit.com/r/dailyprogrammer/comments/68oda5/20170501_challenge_313_easy_subset_sum/?st=j2bsc6u1&sh=f90a1458
  */
object Challenge_2017_05_01 extends App {

  def myFunction(numbers: List[Int]): Boolean = {
    numbers.exists(i => numbers.contains(i * -1))
  }

  val true_1 = List(-97364, -71561, -69336, 19675, 71561, 97863)
  val true_2 = List(-1, 1)
  val true_3 = List(-53974, -39140, -36561, -23935, -15680, 0)

  val false_1 = List(-5, -3, -1, 2, 4, 6)
  val false_2 = List(1, 2, 3)
  val false_3 = List()

  println(false_1 + " -> " + myFunction(false_1))
  println(false_2 + " -> " + myFunction(false_2))
  println(false_3 + " -> " + myFunction(false_3))

  println(true_1 + " -> " + myFunction(true_1))
  println(true_2 + " -> " + myFunction(true_2))
  println(true_3 + " -> " + myFunction(true_3))
}
