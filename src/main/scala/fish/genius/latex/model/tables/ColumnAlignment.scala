package fish.genius.latex.model.tables

trait ColumnAlignment {
  def value: String

  override def toString: String = value
}

case object L extends ColumnAlignment {
  val value = "l"
}

case object R extends ColumnAlignment {
  val value = "r"
}

case object C extends ColumnAlignment {
  val value = "c"
}

case class P(width: Int) extends ColumnAlignment {
  val value = s"p{${width}mm}"
}
