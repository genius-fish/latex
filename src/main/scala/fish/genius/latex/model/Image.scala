package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

import java.io.File

object Image {
  def apply(
      filename: String
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Command(
      "includegraphics",
      optionalParameters = List("max width=\\textwidth"),
      requiredParameters = List(filename)
    )
  }

  def apply(
      imageFile: File
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder.addImage(imageFile)
    Command(
      "includegraphics",
      optionalParameters = List("max width=\\textwidth"),
      requiredParameters = List(imageFile.getName)
    )
  }

  def apply(
      imageFile: Option[File]
  )(implicit documentBuilder: DocumentBuilder): Unit =
    imageFile.foreach(apply(_))
}
