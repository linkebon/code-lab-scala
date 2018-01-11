package reddit

/**
  * Given a sorted list of distinct integers, write a function that returns whether there are two integers in the list that add up to 0. For example, you would return true if both -14435 and 14435 are in the list, because -14435 + 14435 = 0. Also return true if 0 appears in the list.
  * https://www.reddit.com/r/dailyprogrammer/comments/68oda5/20170501_challenge_313_easy_subset_sum/?st=j2bsc6u1&sh=f90a1458
  */
object Challenge_2017_05_01_1 extends App {

  def myFunction(numbers: List[Int]): Boolean = {
    numbers.exists(i => numbers.contains(i * -1))
  }

  val true_1 = List(-97364, -71561, -69336, 19675, 71561, 97863)
  val true_2 = List(-1, 1)
  val true_3 = List(-53974, -39140, -36561, -23935, -15680, 0)

  val false_1 = List(-5, -3, -1, 2, 4, 6)
  val false_2 = List(1, 2, 3)
  val false_3 = List()

  println("--- Basic ---")
  println(false_1 + " -> " + myFunction(false_1))
  println(false_2 + " -> " + myFunction(false_2))
  println(false_3 + " -> " + myFunction(false_3))

  println(true_1 + " -> " + myFunction(true_1))
  println(true_2 + " -> " + myFunction(true_2))
  println(true_3 + " -> " + myFunction(true_3))

  println("--- Bonus ---")
  def sumEqualsZero(subsets: List[List[Int]]): Boolean = {
    subsets.exists(_.sum == 0)
  }

  def createCombinations(numbers: List[Int]): List[List[Int]] = {
    numbers
      .toSet[Int]
      .subsets
      .map(_.toList)
      .toList
      .filter(_.nonEmpty)
  }

  private val test_1_false = List(-83314, -82838, -80120, -63468, -62478, -59378, -56958, -50061, -34791, -32264, -21928, -14988, 23767, 24417, 26403, 26511, 36399, 78055)
  private val test_2_false = List(-92953, -91613, -89733, -50673, -16067, -9172, 8852, 30883, 46690, 46968, 56772, 58703, 59150, 78476, 84413, 90106, 94777, 95148)
  private val test_3_false = List(-94624, -86776, -85833, -80822, -71902, -54562, -38638, -26483, -20207, -1290, 12414, 12627, 19509, 30894, 32505, 46825, 50321, 69294)
  private val test_4_false = List(-83964, -81834, -78386, -70497, -69357, -61867, -49127, -47916, -38361, -35772, -29803, -15343, 6918, 19662, 44614, 66049, 93789, 95405)
  private val test_5_false = List(-68808, -58968, -45958, -36013, -32810, -28726, -13488, 3986, 26342, 29245, 30686, 47966, 58352, 68610, 74533, 77939, 80520, 87195)

  private val test_1_true = List(-97162, -95761, -94672, -87254, -57207, -22163, -20207, -1753, 11646, 13652, 14572, 30580, 52502, 64282, 74896, 83730, 89889, 92200)
  private val test_2_true = List(-93976, -93807, -64604, -59939, -44394, -36454, -34635, -16483, 267, 3245, 8031, 10622, 44815, 46829, 61689, 65756, 69220, 70121)
  private val test_3_true = List(-92474, -61685, -55348, -42019, -35902, -7815, -5579, 4490, 14778, 19399, 34202, 46624, 55800, 57719, 60260, 71511, 75665, 82754)
  private val test_4_true = List(-85029, -84549, -82646, -80493, -73373, -57478, -56711, -42456, -38923, -29277, -3685, -3164, 26863, 29890, 37187, 46607, 69300, 84808)
  private val test_5_true = List(-87565, -71009, -49312, -47554, -27197, 905, 2839, 8657, 14622, 32217, 35567, 38470, 46885, 59236, 64704, 82944, 86902, 90487)
  private val test_6_true = List(0)
  private val test_7_true = List(-3, 1, 2)
  private val test_8_true = List(-98634, -86888, -48841, -40483, 2612, 9225, 17848, 71967, 84319, 88875)

  println(test_1_false + " -> " + sumEqualsZero(createCombinations(test_1_false)))
  println(test_2_false + " -> " + sumEqualsZero(createCombinations(test_2_false)))
  println(test_3_false + " -> " + sumEqualsZero(createCombinations(test_3_false)))
  println(test_4_false + " -> " + sumEqualsZero(createCombinations(test_4_false)))
  println(test_5_false + " -> " + sumEqualsZero(createCombinations(test_5_false)))

  println(test_1_true + " -> " + sumEqualsZero(createCombinations(test_1_true)))
  println(test_2_true + " -> " + sumEqualsZero(createCombinations(test_2_true)))
  println(test_3_true + " -> " + sumEqualsZero(createCombinations(test_3_true)))
  println(test_4_true + " -> " + sumEqualsZero(createCombinations(test_4_true)))
  println(test_5_true + " -> " + sumEqualsZero(createCombinations(test_5_true)))
  println(test_6_true + " -> " + sumEqualsZero(createCombinations(test_6_true)))
  println(test_7_true + " -> " + sumEqualsZero(createCombinations(test_7_true)))
  println(test_8_true + " -> " + sumEqualsZero(createCombinations(test_8_true)))


}
