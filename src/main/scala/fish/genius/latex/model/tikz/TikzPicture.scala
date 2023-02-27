package fish.genius.latex.model.tikz

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.{Environment, Verbatim}

object TikzPicture {
  def apply(parameters: List[String] = List("node distance=1mm"))(body: => Any)(
      implicit documentBuilder: DocumentBuilder
  ): Unit = Environment("tikzpicture", optionalParameters = parameters)(body)

  def fullPage(
      parameters: List[String] = List("node distance=1mm")
  )(body: => Any)(implicit documentBuilder: DocumentBuilder): Unit =
    apply(parameters) {
      Verbatim(
        "\u005cuseasboundingbox (0,0) rectangle(\\the\\paperwidth,\\the\\paperheight);"
      )
      body
    }
}
