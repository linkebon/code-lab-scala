package scala.pyramids

import scala.io.StdIn


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
