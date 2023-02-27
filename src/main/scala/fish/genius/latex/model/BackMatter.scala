package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object BackMatter {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "backmatter"
  )
}
