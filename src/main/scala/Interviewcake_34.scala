import util.ExecutionTimeHelper

import scala.collection.mutable

/**
  *--- Solutions has to be run separately and not in the same time for correct time values. ---
  *
  * https://www.interviewcake.com/question/python/word-cloud
  *
  * You want to build a word cloud, an infographic where the size of a word corresponds to how often it appears in the body of text.
  * *
  * To do this, you'll need data. Write code that takes a long string and builds its word cloud data in a dictionary ↴ , where the keys are words and the values are the number of times the words occurred.
  * *
  * Think about capitalized words. For example, look at these sentences:
  * 'After beating the eggs, Dana read the next step:'
  * 'Add milk and eggs, then add flour and sugar.'
  * What do we want to do with "After", "Dana", and "add"? In this example, your final dictionary should include one "Add" or "add" with a value of 22. Make reasonable (not necessarily perfect) decisions about cases like "After" and "Dana".
  * *
  * Assume the input will only contain words and standard punctuation.
  * *
  * You could make a reasonable argument to use regex in your solution. We won't, mainly because performance is difficult to measure and can get pretty bad.
  */
object Interviewcake_34 extends App with ExecutionTimeHelper {
  // Solution 1. Little bit faster
  time {
    val dictionary = mutable.Map[String, Int]()
    val notWantedChars = Array(';', ':', '.', ',', '\'', '(', ')', '\'', ' ')
    var text = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake. The bill came to five dollars."

    var tempBuffer = ""
    for (n <- 0 until text.length) {
      if (notWantedChars.contains(text(n))) {
        addOrUpdateDictionary(tempBuffer)
        tempBuffer = ""
      }
      else
        tempBuffer += text(n).toLower
    }
    dictionary.foreach(println)

    def addOrUpdateDictionary(word: String): Unit = {
      word match {
        case "" => // dont add empty as entry
        case str if dictionary.contains(str) => dictionary(str) = dictionary(str) + 1
        case str => dictionary += str -> 1
      }
    }
  }

  // Solution 2. Little bit slower.
  time {
    val dictionary = mutable.Map[String, Int]()
    val notWantedChars = Array(';', ':', '.', ',', '\'', '(', ')', '\'')
    var modifiedText = ""
    "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake. The bill came to five dollars."
      .foreach {
        case char if notWantedChars.contains(char) => modifiedText += " "
        case char => modifiedText += char.toLower
      }

    modifiedText
      .split(" ")
      .filterNot("".equalsIgnoreCase)
      .foreach { word =>
        if (dictionary.contains(word)) {
          dictionary(word) = dictionary(word) + 1
        } else {
          dictionary += word -> 1
        }
      }
    dictionary.foreach(println)
  }
}
