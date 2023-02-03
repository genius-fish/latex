package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

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

}
