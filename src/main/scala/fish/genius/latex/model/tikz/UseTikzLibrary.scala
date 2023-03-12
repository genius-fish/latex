package fish.genius.latex.model.tikz

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.Command

object UseTikzLibrary {
  def apply(name: String, parameters: Option[String] = None)(implicit
      documentBuilder: DocumentBuilder
  ) = Command(
    "usetikzlibrary",
    optionalParameters = parameters.toList,
    requiredParameters = List(name)
  )
}
