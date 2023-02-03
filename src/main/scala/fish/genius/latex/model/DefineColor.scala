package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object DefineColor {
  def apply(red: Int, green: Int, blue: Int)(name: String)(implicit
      documentBuilder: DocumentBuilder
  ): Unit = Command(
    "definecolor",
    requiredParameters = List(name, "RGB", s"$red,$green,$blue")
  )

}
