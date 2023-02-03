package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Environment {
  def apply(
      name: String,
      parameters: List[String] = Nil,
      optionalParameters: List[String] = Nil
  )(body: => Any)(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + s"\\begin{$name}${parameters.map(p => s"{$p}").mkString}${optionalParameters
        .map(p => s"[$p]")
        .mkString}"
    body
    documentBuilder + s"\\end{$name}"
  }
}
