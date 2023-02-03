package fish.genius.latex.model.beamer

import fish.genius.latex.{DocumentBuilder, Texified}
import fish.genius.latex.model.Environment

object Frame {
  def apply(
      title: String,
      subtitle: Option[String] = None,
      condition: Boolean = true
  )(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    if (condition)
      Environment(
        "frame",
        parameters = List(title)
          .map(Texified(_).output) ++ subtitle.map(Texified(_).output).toList
      ) {
        body
      }
  }

}
