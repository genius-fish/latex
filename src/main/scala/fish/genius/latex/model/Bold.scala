package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Bold {
  def apply(
      value: String
  )(implicit documentBuilder: DocumentBuilder): Unit =
    Command("textbf", Nil, List(value))

}
