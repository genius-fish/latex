package fish.genius.latex.model.tables

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.Environment

object LongTable {
  def apply(columnAlignments: ColumnAlignment*)(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment(
      name = "longtable",
      parameters = List(s"${columnAlignments.map(_.value).mkString}")
    ) {

      body
    }
  }

}
