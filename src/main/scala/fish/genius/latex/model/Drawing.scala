package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

object Drawing {
  def apply(caption: Option[String] = None)(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Environment("figure") {
      Command(
        name = "centering"
      )
      body
      if (caption.isDefined)
        Command(
          "caption",
          requiredParameters = caption.map(Texified(_).output).toList
        )
    }
  }

}
