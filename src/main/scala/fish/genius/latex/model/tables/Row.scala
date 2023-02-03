package fish.genius.latex.model.tables

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.Environment

object Row {
  def apply(
      cells: TableCell*
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + s"${cells.map(_.output).mkString(" & ")} \\\\"
  }

}
