package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Centering {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "centering"
  )
}
