package fish.genius.latex.model.tables

import fish.genius.latex.model.{Caption, Environment}
import fish.genius.latex.{DocumentBuilder, Texified}

object Tabular {
  def apply(columnAlignments: ColumnAlignment*)(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment(
      name = "tabular",
      parameters = List(s"@{}${columnAlignments.map(_.value).mkString}@{}")
    ) {

      body
    }
  }

}
