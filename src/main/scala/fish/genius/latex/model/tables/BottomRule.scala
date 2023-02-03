package fish.genius.latex.model.tables

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.Command

object BottomRule {
  def apply()(implicit documentBuilder: DocumentBuilder): Unit = Command(
    "bottomrule"
  )
}
