package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Math {
  def apply(
      value: String
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + s"$$$value$$"
  }

}
