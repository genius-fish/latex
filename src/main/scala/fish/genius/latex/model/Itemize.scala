package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Itemize {
  def apply(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment(
      name = "itemize"
    )(body)
  }

}
