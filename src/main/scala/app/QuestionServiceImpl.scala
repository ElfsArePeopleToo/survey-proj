package app

import app.QuestionServiceImpl.defineQuestions
import org.slf4j.LoggerFactory

class QuestionServiceImpl(var buffer: AnswerBuffer) extends QuestionService {
  
  override def saveAnswer(answer: String, questionNumber: Int): Unit = {
    buffer.saveAnswer(questionNumber, answer)
  }

  override def getQuestions: Array[String] = {
    defineQuestions()
  }
}

object QuestionServiceImpl {
  private def defineQuestions(): Array[String] = {
    val question1: String = "How do you feel today?"
    val question2: String = "What have you done since yesterday?"
    val question3: String = "What are you going to do today?"
    Array(question1, question2, question3)
  }

}


