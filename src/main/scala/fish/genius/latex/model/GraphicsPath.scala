package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object GraphicsPath {
  def apply(
      folders: List[String] = List("./images")
  )(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "graphicspath",
    requiredParameters = List(folders.map(f => s"{$f}").mkString(","))
  )
}
