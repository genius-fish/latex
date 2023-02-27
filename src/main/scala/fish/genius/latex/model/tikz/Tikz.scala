package fish.genius.latex.model.tikz

import fish.genius.latex.{DocumentBuilder, Texified, TextVariant}

object Tikz {
  type CoordinatesInMillimeter = (Int, Int)
  type PolarCoordinates = (Double, Double)
  def line(
      from: CoordinatesInMillimeter,
      to: CoordinatesInMillimeter,
      title: Option[String] = None
  )(lineStyle: List[TikzStyle] = Nil)(
      titleStyle: List[TikzStyle] = Nil
  )(implicit documentBuilder: DocumentBuilder): Unit =
    lineBetween(s"${from._1}mm,${from._2}mm", s"${to._1}mm,${to._2}mm", title)(
      lineStyle
    )(titleStyle)

  def lineBetween(from: String, to: String, title: Option[String] = None)(
      lineStyle: List[TikzStyle] = Nil
  )(
      titleStyle: List[TikzStyle] = Nil
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    val titleNode: String = title
      .map(t =>
        s"node [${titleStyle.map(_.value).mkString(",")}] {${Texified(t).output}}"
      )
      .getOrElse("")
    val lineConfigString: String =
      if (lineStyle.isEmpty) ""
      else s"[${lineStyle.map(_.value).mkString(",")}]"

    documentBuilder + s"\\draw$lineConfigString ($from) -- ($to) $titleNode;"
  }

  def nodeAt(
      content: String,
      at: CoordinatesInMillimeter,
      identifier: String,
      style: List[TikzStyle] = Nil,
      textVariants: List[TextVariant] = Nil,
      escapeContent: Boolean = true
  )(implicit documentBuilder: DocumentBuilder): Unit = node(
    content,
    Some(s"${at._1}mm,${at._2}mm"),
    identifier,
    style,
    textVariants,
    escapeContent
  )

  def nodeAtPolar(
      content: String,
      at: PolarCoordinates,
      identifier: String,
      style: List[TikzStyle] = Nil,
      textVariants: List[TextVariant] = Nil,
      escapeContent: Boolean = true
  )(implicit documentBuilder: DocumentBuilder): Unit = node(
    content,
    Some(s"at (${at._1}:${at._2})"),
    identifier,
    style,
    textVariants,
    escapeContent
  )

  def node(
      content: String,
      at: Option[String] = None,
      identifier: String,
      style: List[TikzStyle] = Nil,
      textVariants: List[TextVariant] = Nil,
      escapeContent: Boolean = true
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    val position: String = at.map(it => s"at ($it)").getOrElse("")
    val titleString: String =
      if (escapeContent) Texified.escapeAndApply(content, textVariants)
      else Texified.apply(textVariants, content)
    documentBuilder + s"\\node[${style.map(_.value).mkString(",")}] ${position} (${identifier}) {${titleString}};"
  }

  def imageNode(
      imageName: String,
      width: Int,
      identifier: String,
      at: Option[String] = None,
      style: List[TikzStyle] = Nil
  )(implicit documentBuilder: DocumentBuilder): Unit =
    node(
      content = s"\\includegraphics[width=${width}mm]{${imageName}}",
      at = at,
      style = style,
      identifier = identifier,
      escapeContent = false
    )

  def imageNodeAtPolar(
      imageName: String,
      width: Int,
      identifier: String,
      at: PolarCoordinates,
      style: List[TikzStyle] = Nil
  )(implicit documentBuilder: DocumentBuilder): Unit =
    nodeAtPolar(
      content = s"\\includegraphics[width=${width}mm]{${imageName}}",
      at = at,
      style = style,
      identifier = identifier,
      escapeContent = false
    )

  def imageNodeAt(
      imageName: String,
      width: Int,
      identifier: String,
      at: CoordinatesInMillimeter,
      style: List[TikzStyle] = Nil
  )(implicit documentBuilder: DocumentBuilder): Unit =
    nodeAt(
      content = s"\\includegraphics[width=${width}mm]{${imageName}}",
      at = at,
      style = style,
      identifier = identifier,
      escapeContent = false
    )

}
