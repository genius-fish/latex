package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Landscape {
  def apply(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment(
      name = "landscape"
    )(body)
  }

}
