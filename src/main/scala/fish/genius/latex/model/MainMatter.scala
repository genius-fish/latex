package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object MainMatter {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "mainmatter"
  )
}
