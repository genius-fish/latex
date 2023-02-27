package fish.genius.latex.model.beamer

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.DocumentClass

object SlideDeck {
  def apply(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    DocumentClass("beamer", List("handout", "aspectratio=169"))
    body
  }

}
