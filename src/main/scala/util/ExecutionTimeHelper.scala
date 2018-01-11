package util

trait ExecutionTimeHelper {
  def time(block: => Unit): Unit = {
    val t0 = System.currentTimeMillis()
    block
    val t1 = System.currentTimeMillis()
    println(s"Execution time: ${t1 - t0} milliseconds")
  }
}
