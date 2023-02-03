package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object EmptyPageStyle {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "pagestyle",
    Nil,
    List("empty")
  )
}
