package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Item {
  def apply(
      value: String,
      title: Option[String] = None
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    documentBuilder + s"\\item${title.map(t => s"[$t]").getOrElse("")} ${Texified(value).output}"
  }

}
