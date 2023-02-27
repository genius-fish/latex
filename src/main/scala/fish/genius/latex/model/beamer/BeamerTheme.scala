package fish.genius.latex.model.beamer

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.Command

object BeamerTheme {
  def apply(name: String)(implicit documentBuilder: DocumentBuilder): Unit = {
    Command("usetheme", requiredParameters = List(name))
  }
}
