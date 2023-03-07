package fish.genius.latex

import java.io.File

class DocumentBuilder(val forTheme: Boolean = false)(laTeX: LaTeX) {
  private var content: List[String] = Nil

  def +(line: String): Unit = content = line :: content

  def addImage(image: File): Unit = laTeX.withImage(image)
  def addOptionalImage(image: Option[File]): Unit =
    laTeX.withOptionalImage(image)

  def output: String = content.reverse.mkString("\n")
}
