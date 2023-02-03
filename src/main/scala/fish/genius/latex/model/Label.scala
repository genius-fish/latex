package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Label {
  def apply(name: String)(implicit
      documentBuilder: DocumentBuilder
  ): Unit = Command(
    "label",
    Nil,
    List(name)
  )

}
