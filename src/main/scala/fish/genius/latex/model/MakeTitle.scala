package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object MakeTitle {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "maketitle"
  )
}
