package fish.genius.latex

import fish.genius.io.FileUtils
import fish.genius.logging.Loggable

import java.io.File
import scala.util.{Failure, Success, Try}

object LaTeX extends Loggable {
  def apply(body: DocumentBuilder => Any): String = {
    val builder = new DocumentBuilder()
    body.apply(builder)
    builder.output
  }

  def apply(targetFile: File)(body: DocumentBuilder => Any): Option[File] =
    Try {
      val builder = new DocumentBuilder()
      body.apply(builder)
      FileUtils.writeStringToFile(builder.output, targetFile)
      targetFile
    } match {
      case Success(value) => Some(value)
      case Failure(cause) =>
        exception(cause)
        None
    }
}

object LatexTheme {
  def apply(body: DocumentBuilder => Any): String = {
    val builder = new DocumentBuilder(true)
    body.apply(builder)
    builder.output
  }
}
