package fish.genius.latex.model.beamer

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.{Command, UsePackage}

object CommonBeamerSettings {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = {
    UsePackage("opensans", parameters = Some("default,oldstyle,scale=0.95"))
    Command("pgfplotsset", requiredParameters = List("width=7cm,compat=1.8"))
    Command("setkeys", requiredParameters = List("Gin", "keepaspectratio"))
  }

}
