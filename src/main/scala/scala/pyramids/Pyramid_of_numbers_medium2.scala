package scala.pyramids

import scala.io.StdIn

/**
   Rows in pyramid: 9
                  1
                1 2 1
              1 2 3 2 1
            1 2 3 4 3 2 1
          1 2 3 4 5 4 3 2 1
        1 2 3 4 5 6 5 4 3 2 1
      1 2 3 4 5 6 7 6 5 4 3 2 1
    1 2 3 4 5 6 7 8 7 6 5 4 3 2 1
  1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1

  */
object Pyramid_of_numbers_medium2 extends App {
  print("Rows in pyramid: ")
  val pyramidRows = StdIn.readInt()
  var currentRow = 1

  for (n <- pyramidRows to 1 by -1) {
    (1 to n * 2).foreach(_ => print(" "))
    (1 until currentRow).foreach(iteration => print(iteration + " "))
    (currentRow to 1 by -1).foreach(iteration => print(iteration + " "))
    println()
    currentRow += 1
  }

}
