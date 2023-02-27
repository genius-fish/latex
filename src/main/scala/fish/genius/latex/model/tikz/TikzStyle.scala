package fish.genius.latex.model.tikz

import fish.genius.latex.model.{
  ExtremelyLarge,
  Footnote,
  Huge,
  Large,
  LatexFont,
  Normal,
  Script,
  Small,
  Tiny,
  VeryHuge,
  VeryLarge
}

trait TikzStyle {
  def value: String
}

case class TikzStyleRef(value: String) extends TikzStyle

case object Rectangle extends TikzStyle {
  val value: String = "rectangle"
}

case object Circle extends TikzStyle {
  val value: String = "circle"
}

case object RoundedCorners extends TikzStyle {
  val value: String = "rounded corners"
}

case class Fill(color: String) extends TikzStyle {
  val value: String = s"fill=$color"
}

case class Opacity(level: Double) extends TikzStyle {
  val value: String = s"opacity=$level"
}

case class Draw(color: String) extends TikzStyle {
  val value: String = s"draw=$color"
}

case class TextColor(color: String) extends TikzStyle {
  val value: String = s"text=$color"
}

case object DecorateWithBrace extends TikzStyle {
  val value: String = s"decorate, decoration={brace}"
}

case object TextCentered extends TikzStyle {
  val value: String = "text centered"
}

case class MinimumHeight(mm: Double) extends TikzStyle {
  val value: String = s"minimum height=${mm}mm"
}

case class MinimumWidth(mm: Double) extends TikzStyle {
  val value: String = s"minimum width=${mm}mm"
}

case class TextWidth(mm: Double) extends TikzStyle {
  val value: String = s"text width=${mm}mm"
}

case class TextHeight(mm: Double) extends TikzStyle {
  val value: String = s"text height=${mm}mm"
}

case class TextDepth(mm: Double) extends TikzStyle {
  val value: String = s"text depth=${mm}mm"
}

case class LineWidth(mm: Double) extends TikzStyle {
  val value: String = s"line width=${mm}mm"
}

case class InnerSep(mm: Double) extends TikzStyle {
  val value: String = s"inner sep=${mm}mm"
}

case class InnerXSep(mm: Double) extends TikzStyle {
  val value: String = s"inner xsep=${mm}mm"
}

case class InnerYSep(mm: Double) extends TikzStyle {
  val value: String = s"inner ysep=${mm}mm"
}

case class OuterSep(mm: Double) extends TikzStyle {
  val value: String = s"outer sep=${mm}mm"
}

case class OuterXSep(mm: Double) extends TikzStyle {
  val value: String = s"outer xsep=${mm}mm"
}

case class OuterYSep(mm: Double) extends TikzStyle {
  val value: String = s"outer ysep=${mm}mm"
}

case class XShift(mm: Double) extends TikzStyle {
  val value: String = s"xshift=${mm}mm"
}

case class YShift(mm: Double) extends TikzStyle {
  val value: String = s"yshift=${mm}mm"
}

case class Fit(identifiers: List[String]) extends TikzStyle {
  val value: String = s"fit=${identifiers.map("(" + _ + ")").mkString(" ")}"
}

trait RelativePosition extends TikzStyle {
  def direction: String
  def distance: Option[Double]
  def of: String

  def value: String =
    s"${direction}=${distance.map(it => s"${it}mm ").getOrElse("")}of ${of}"
}
case class AboveOf(of: String, distance: Option[Double] = None)
    extends RelativePosition {
  val direction = "above"
}

case class BelowOf(of: String, distance: Option[Double] = None)
    extends RelativePosition {
  val direction = "below"
}

case class LeftOf(of: String, distance: Option[Double] = None)
    extends RelativePosition {
  val direction = "left"
}

case class RightOf(of: String, distance: Option[Double] = None)
    extends RelativePosition {
  val direction = "right"
}

trait Font extends TikzStyle {
  def latexFont: LatexFont
  def value: String = s"font=${latexFont.name}"
}

case class BoldFont(font: Font) extends TikzStyle {
  val value: String = font.value + "\\bfseries"
}

case object TinyFont extends Font {
  val latexFont: LatexFont = Tiny
}

case object ScriptFont extends Font {
  val latexFont: LatexFont = Script
}

case object FootnoteFont extends Font {
  val latexFont: LatexFont = Footnote
}

case object SmallFont extends Font {
  val latexFont: LatexFont = Small
}

case object NormalFont extends Font {
  val latexFont: LatexFont = Normal
}

case object LargeFont extends Font {
  val latexFont: LatexFont = Large
}

case object VeryLargeFont extends Font {
  val latexFont: LatexFont = VeryLarge
}

case object ExtremelyLargeFont extends Font {
  val latexFont: LatexFont = ExtremelyLarge
}

case object HugeFont extends Font {
  val latexFont: LatexFont = Huge
}

case object VeryHugeFont extends Font {
  val latexFont: LatexFont = VeryHuge
}

case class Rotate(degrees: Int) extends TikzStyle {
  val value: String = s"rotate=${degrees}"
}

case object Midway extends TikzStyle {
  val value: String = "midway"
}

case class Anchor(direction: CompassDirection) extends TikzStyle {
  val value: String = s"anchor=${direction.value}"
}

sealed trait CompassDirection {
  def value: String
}

case object North extends CompassDirection {
  val value = "north"
}

case object South extends CompassDirection {
  val value = "south"
}

case object East extends CompassDirection {
  val value = "east"
}

case object West extends CompassDirection {
  val value = "west"
}

case object NorthEast extends CompassDirection {
  val value = "north east"
}

case object NorthWest extends CompassDirection {
  val value = "north west"
}

case object SouthEast extends CompassDirection {
  val value = "south east"
}

case object SouthWest extends CompassDirection {
  val value = "south west"
}
