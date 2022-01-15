package app

abstract class AnswerBuffer() {
  
  def saveAnswer(number: Int, answer: String): Unit
  
  def getPreviousAnswers: Array[String]
  
}
