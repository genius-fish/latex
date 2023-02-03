package fish.genius.latex.model.tables

import fish.genius.latex.DocumentBuilder

object ArrayStretch {
  def apply(factor: Double)(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + f"\\renewcommand{\\arraystretch}{$factor%1.1f}"
  }
}
