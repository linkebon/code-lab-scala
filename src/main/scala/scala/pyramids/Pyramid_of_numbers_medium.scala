package scala.pyramids

import scala.io.StdIn


/**
   Rows in pyramid: 9
         1
        1 2
       1 2 3
      1 2 3 4
     1 2 3 4 5
    1 2 3 4 5 6
   1 2 3 4 5 6 7
  1 2 3 4 5 6 7 8
 1 2 3 4 5 6 7 8 9
  */
object Pyramid_of_numbers_medium extends App {
  print("Rows in pyramid: ")
  val pyramidRows = StdIn.readInt()
  var currentRow = 1

  for (n <- pyramidRows to 1 by -1) {
    (1 to n).foreach(_ => print(" "))
    (1 to currentRow).foreach(iteration => print(iteration + " "))
    println()
    currentRow += 1
  }

}
