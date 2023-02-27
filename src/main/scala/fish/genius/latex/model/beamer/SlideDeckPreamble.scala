package fish.genius.latex.model.beamer

import fish.genius.latex.{DocumentBuilder, Texified}
import fish.genius.latex.model.Command

import java.time.LocalDate

object SlideDeckPreamble {
  def apply(
      title: Option[String] = None,
      subtitle: Option[String] = None,
      author: Option[String] = None,
      institute: Option[String] = None,
      date: Option[LocalDate] = Some(LocalDate.now()),
      version: Option[String] = None
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    if (institute.isDefined)
      Command("institute", requiredParameters = institute.toList)
    if (date.isDefined)
      Command(
        "date",
        requiredParameters = List(
          s"${date.get.getYear}-${date.get.getMonth}-${date.get.getDayOfMonth}"
        )
      )
    if (version.isDefined)
      Command(
        "version",
        requiredParameters = version.map(Texified(_)).map(_.output).toList
      )
    if (title.isDefined)
      Command(
        "title",
        requiredParameters = title.toList.map(Texified(_)).map(_.output)
      )
    if (subtitle.isDefined)
      Command(
        "subtitle",
        requiredParameters = subtitle.toList.map(Texified(_)).map(_.output)
      )
    if (author.isDefined)
      Command(
        "author",
        requiredParameters = author.toList.map(Texified(_)).map(_.output)
      )
  }
}
