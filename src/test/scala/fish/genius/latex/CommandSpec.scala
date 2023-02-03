package fish.genius.latex

import fish.genius.latex.model.beamer.Frame
import fish.genius.latex.model.{
  BackMatter,
  Chapter,
  DefineColor,
  Document,
  DocumentClass,
  Drawing,
  Image,
  Part,
  Section,
  SubSection,
  SubSubSection,
  Text,
  UsePackage
}
import org.scalatest.flatspec.AnyFlatSpec

class CommandSpec extends AnyFlatSpec {
  ignore should "print a LaTeX document from the DSL" in {
    val latex = LaTeX { implicit body =>
      DocumentClass("article", List("a4"))
      UsePackage("tikz")
      Document {
        Section("Section 1.1.1") {
          Text("This is section one!")
          SubSection("SubSection 1.1.1.1") {
            Text("And this is a subsection")
            Text("With multiple lines possibly")
          }
        }
        Text("With a text")
      }
    }
    val pdf = Renderer.pdf(latex, "commandspec")
    assert(pdf.nonEmpty)
    println(pdf.get.getAbsolutePath)
  }
}
