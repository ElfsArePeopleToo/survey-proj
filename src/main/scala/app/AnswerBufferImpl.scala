package app

import org.slf4j.{Logger, LoggerFactory}

case class AnswerBufferImpl() extends AnswerBuffer {
  var answers: Array[String] = Array()
  var LOG: Logger = LoggerFactory.getLogger(QuestionServiceImpl.getClass)

  override def saveAnswer(number: Int, answer: String): Unit = {
    val index = number - 1
    try {
      answers.update(index, answer)
      LOG.info("Answer has saved")
    }
    catch
    case e: ArrayIndexOutOfBoundsException => answers = answers :+ answer
  }

  override def getPreviousAnswers: Array[String] = answers

}
