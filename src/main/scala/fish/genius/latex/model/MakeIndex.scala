package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object MakeIndex {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "makeindex"
  )
}
