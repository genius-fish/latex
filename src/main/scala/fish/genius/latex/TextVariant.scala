package fish.genius.latex

import fish.genius.latex.Bold.latexCommandName

trait TextVariant {
  def latexCommandName: String
  def apply(text: String): String = s"\\$latexCommandName{$text}"

  override def toString: String = latexCommandName
}

object Bold extends TextVariant {
  val latexCommandName: String = "textbf"
}

object Uppercase extends TextVariant {
  val latexCommandName: String = "uppercase"
}
