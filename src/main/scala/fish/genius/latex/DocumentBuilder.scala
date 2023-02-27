package fish.genius.latex

class DocumentBuilder(val forTheme: Boolean = false) {
  private var content: List[String] = Nil

  def +(line: String): Unit = content = line :: content

  def output: String = content.reverse.mkString("\n")
}
