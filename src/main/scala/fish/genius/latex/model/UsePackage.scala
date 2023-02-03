package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object UsePackage {
  def apply(name: String, parameters: Option[String] = None)(implicit
      documentBuilder: DocumentBuilder
  ) = Command(
    if (documentBuilder.forTheme) "RequirePackage" else "usepackage",
    optionalParameters = parameters.toList,
    requiredParameters = List(name)
  )
}
