package app

trait QuestionService {
  def saveAnswer(answer: String, questionNumber: Int): Unit

  def getQuestions: Array[String]
}
