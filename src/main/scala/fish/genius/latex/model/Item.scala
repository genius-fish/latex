package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Item {
  def apply(
      value: String
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + s"\\item ${Texified(value).output}"
  }

}
