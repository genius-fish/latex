package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object DocumentClass {
  def apply(name: String, options: List[String] = Nil)(implicit
      documentBuilder: DocumentBuilder
  ): Unit = Command(
    "documentclass",
    options,
    List(name)
  )

}
