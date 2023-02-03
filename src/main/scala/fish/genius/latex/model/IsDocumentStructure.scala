package fish.genius.latex.model

import fish.genius.latex.{DocumentBuilder, Texified}

trait IsDocumentStructure {
  def commandName: String

  def apply(title: String, numbered: Boolean = true)(
      body: => Any
  )(implicit documentBuilder: DocumentBuilder): Unit = {
    Command(
      name = if (numbered) commandName else commandName + "*",
      requiredParameters = List(Texified(title).output)
    )
    body
  }

}
