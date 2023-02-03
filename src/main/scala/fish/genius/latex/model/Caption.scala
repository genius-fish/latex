package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Caption {
  def apply(name: String)(shortName: Option[String] = None)(implicit
      documentBuilder: DocumentBuilder
  ): Unit = Command(
    "caption",
    shortName.map(Texified(_).output).toList,
    List(name).map(Texified(_).output)
  )

}
