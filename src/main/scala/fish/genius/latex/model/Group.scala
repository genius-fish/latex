package fish.genius.latex.model

import fish.genius.latex.DocumentBuilder

object Group {
  def apply(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Command("begingroup")
    body
    Command("endgroup")
  }

}
