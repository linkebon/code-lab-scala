package algorithms

import scala.collection.mutable.ListBuffer

object BucketSort extends App {

  // Solution 1
  val input = Array[Int](5, 2, 4, 4, 200, 1, 1, 200)
  val output = ListBuffer[Int]()
  // let buckets be an array of N sequences, each of which is initially empty
  val buckets = Array.ofDim[Int](input.max + 1)

  // increment buckets[e] by 1
  input.foreach(e => buckets(e) += 1)

  for (i <- buckets.indices) {
    for (n <- 0 until buckets(i)) {
      // insert i to O, n times
      output += i
    }
  }

  println(output.mkString(","))
}
