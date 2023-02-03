package fish.genius.latex.model.tables

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.{Environment, Verbatim}

trait TableCell {
  def output: String

  override def toString: String = output
}
case class MultiCell(
    colspan: Int = 1,
    alignment: Option[ColumnAlignment] = None
)(
    body: String
) extends TableCell {
  val output: String = colspan match {
    case 1 =>
      body
    case _ =>
      val alignmentString =
        if (alignment.nonEmpty) s"{${alignment.get.value}}" else ""
      s"\\multicolumn{$colspan}$alignmentString{$body}"
  }
}

case class Cell(output: String) extends TableCell

case class EmptyCell() extends TableCell {
  override val output: String = ""
}

case class PhantomCell(spacer: String) extends TableCell {
  override val output: String = s"\\phantom{$spacer}"
}

case class MathCell(formula: String) extends TableCell {
  val output: String = s"$$$formula$$"
}

case class MultiMathCell(
    colspan: Int = 1,
    alignment: Option[ColumnAlignment] = None
)(
    formula: String
) extends TableCell {
  val output: String = colspan match {
    case 1 =>
      s"$$$formula$$"
    case _ =>
      val alignmentString =
        if (alignment.nonEmpty) s"{${alignment.get.value}}" else ""
      s"\\multicolumn{$colspan}$alignmentString{$$$formula$$}"
  }
}
