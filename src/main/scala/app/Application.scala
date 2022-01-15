package app

import org.slf4j.LoggerFactory

import java.io.IOException
import scala.io.Source
import scala.util.Using

object Application extends App {
  val answerBuffer = AnswerBufferImpl()

  val service: QuestionService = new QuestionServiceImpl(
    answerBuffer
  )

  println("Hello, user!")
  println("I have a few questions for you:")

  var questions: Array[String] = service.getQuestions
  val bufferStreamReader = Source.fromInputStream(System.in)

  println(questions(0))

  try handleRead(1)
  catch
  case e: IOException => println("error" + e)

  try handleRead(2)
  catch
    case e: IOException => println("error" + e)

  try handleRead(3)
  catch
    case e: IOException => println("error" + e)

  bufferStreamReader.reader().close()
  answerBuffer.getPreviousAnswers

  def handleRead(questionNumber: Int): Unit = {
    for (line <- bufferStreamReader.getLines){
      println(line)
      service.saveAnswer(line, questionNumber)
        return
    }
  }

  val answers = answerBuffer.getPreviousAnswers
  answers.foreach( v =>
    println(v)
  )


}
