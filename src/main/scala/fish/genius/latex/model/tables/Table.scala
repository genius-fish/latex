package fish.genius.latex.model.tables

import fish.genius.latex.{DocumentBuilder, Texified}
import fish.genius.latex.model.{Caption, Centering, Environment}

object Table {
  def apply(numbered: Boolean = true)(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment(
      name = if (numbered) "table" else "table*"
    ) {
      Centering()
      ArrayStretch(1.3)
      body
    }
  }

}
