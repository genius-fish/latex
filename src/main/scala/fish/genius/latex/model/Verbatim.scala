package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Verbatim {
  def apply(
      value: String
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + value
  }

}
