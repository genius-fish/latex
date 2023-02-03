package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Command {
  def apply(
      name: String,
      optionalParameters: List[String] = Nil,
      requiredParameters: List[String] = Nil
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + s"\\$name${optionalParameters
        .map(p => s"[$p]")
        .mkString}${requiredParameters.map(p => s"{$p}").mkString}"
  }
}
