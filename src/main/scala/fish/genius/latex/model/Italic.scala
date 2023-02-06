package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Italic {
  def apply(
      value: String
  )(implicit documentBuilder: DocumentBuilder): Unit =
    Command("textit", Nil, List(value))

}
