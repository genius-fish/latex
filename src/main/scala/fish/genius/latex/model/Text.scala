package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Text {
  def apply(
      value: String,
      whitespaceAfter: Boolean = true
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + Texified(value).output
    if (whitespaceAfter) documentBuilder + ""
  }

}
