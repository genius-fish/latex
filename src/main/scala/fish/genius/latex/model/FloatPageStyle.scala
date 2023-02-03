package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object FloatPageStyle {
  def apply(name: String)(implicit
      documentBuilder: DocumentBuilder
  ): Unit = Command(
    "floatpagestyle",
    Nil,
    List(name)
  )

}
