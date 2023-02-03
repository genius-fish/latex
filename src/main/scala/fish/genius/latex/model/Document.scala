package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Document {
  def apply(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment(
      name = "document"
    )(body)
  }

}
