package fish.genius.latex.model.tables

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.Command

object CMidRules {
  def apply(ranges: (Int, Int)*)(implicit
      documentBuilder: DocumentBuilder
  ): Unit = {
    val rules = ranges.map(r => s"\\cmidrule{${r._1}-${r._2}}")
    documentBuilder + rules.mkString(" ")
  }
}
