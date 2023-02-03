package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object PageStyle {
  def apply(name: String)(implicit
      documentBuilder: DocumentBuilder
  ): Unit = Command(
    "pagestyle",
    Nil,
    List(name)
  )

}
