package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Enumerate {
  def apply(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment(
      name = "enumerate"
    )(body)
  }

}
