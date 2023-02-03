package fish.genius.latex.model.tables

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.Command

object TableFooter {
  def apply(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    body
    Command("endfoot")
  }

}
