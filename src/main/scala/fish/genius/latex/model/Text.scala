package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Text {
  def apply(
      value: String
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + Texified(value).output
  }

}
