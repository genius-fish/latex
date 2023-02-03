package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

import javax.swing.text.Document

object BackMatter {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "backmatter"
  )
}
