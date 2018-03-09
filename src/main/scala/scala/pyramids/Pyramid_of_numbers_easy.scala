package scala.pyramids

import scala.io.StdIn


/**
   Rows in pyramid: 9
         1
        2 2
       3 3 3
      4 4 4 4
     5 5 5 5 5
    6 6 6 6 6 6
   7 7 7 7 7 7 7
  8 8 8 8 8 8 8 8
 9 9 9 9 9 9 9 9 9

  Psuedo code
  Loop from pyramids rows(n) down to 1
  Print spaces from 1 to n
  Print currentRow value 1 to currentRow times followed by a space for each print
  */
object Pyramid_of_numbers_easy extends App {
  print("Rows in pyramid: ")
  val pyramidRows = StdIn.readInt()
  var currentRow = 1


  for (n <- pyramidRows to 1 by -1) {
    draw(" ", 1 to n)
    draw(currentRow + " ", 1 to currentRow)
    println()
    currentRow += 1
  }

  def draw(characters: String, range: Range): Unit = {
    range.foreach(n => print(characters))
  }
}