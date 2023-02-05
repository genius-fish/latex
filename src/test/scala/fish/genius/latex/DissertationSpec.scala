package fish.genius.latex

import fish.genius.io.FileUtils
import fish.genius.latex.model.tables._
import fish.genius.latex.model._
import org.scalatest.flatspec.AnyFlatSpec

import java.io.File
import java.nio.file.Files

class DissertationSpec extends AnyFlatSpec {
  it should "generate a book in the University of Malta style" in {
    val workDirectory = Files.createTempDirectory("dissertation").toFile
    val style = FileUtils.copyResourceFromFileOrClassPathToFile(
      "/um.cls",
      new File(workDirectory, "um.cls"),
      this.getClass
    )
    val imagesDirectory = new File(workDirectory, "images")
    val logo = FileUtils.copyResourceFromFileOrClassPathToFile(
      "/genius_fish.eps",
      new File(imagesDirectory, "genius_fish.eps")
    )
    val latexFile = new File(workDirectory, "document.tex")
    val latex = LaTeX(latexFile) { implicit body =>
      DocumentClass("um", List("twoside"))
      UsePackage("nag", Some("l2tabu, orthodox"))
      UsePackage("blindtext")
      Command("title", requiredParameters = List("Genius Fish LaTeX Library"))
      Command(
        "tagline",
        requiredParameters =
          List("Because we want to generate PDFs of our articles")
      )
      Command("author", requiredParameters = List("Jurgen Lust"))
      Command("doctype", requiredParameters = List("dissertation"))
      Verbatim(
        "\\renewcommand{\\chapterheadstart}{\\vspace*{\\beforechapskip}}"
      )
      Verbatim("\\setlength\\beforechapskip{0mm}")
      Verbatim("\\graphicspath{{./images/}{./chap1/images/}{./chap2/images/}}")
      MakeIndex()
      Document {
        FrontMatter()
        MakeTitle()
        Verbatim(
          "\\tableofcontents*\\if@openright\\cleardoublepage\\else\\clearpage\\fi"
        )
        PageStyle("umpage")
        FloatPageStyle("umpage")
        MainMatter()

        Chapter("This is Genius Fish") {
          Section("Section 1.1.1") {
            Text("This is section one!")
            SubSection("SubSection 1.1.1.1") {
              Text("And this is a subsection")
              Text("With multiple lines possibly")
              Itemize {
                Item("Once Upon A Midnight Dreary")
                Item("While I pondered, weak and weary")
                Item("Over many a quaint and curious volume of forgotten lore")
              }
              Enumerate {
                Item(
                  "While I nodded, nearly napping, suddenly there came a tapping,"
                )
                Item(
                  "As of some one gently rapping, rapping at my chamber door."
                )
                Item(
                  "“’Tis some visitor,” I muttered, “tapping at my chamber door—"
                )
              }

              Table() {
                Caption("A beautiful and complex table")(
                  Some("Beautiful Complex")
                )
                Label("tab:sometable")
                Tabular(R, R, R, R, C, R, R, R) {
                  TopRule()
                  Row(
                    EmptyCell(),
                    MultiMathCell(3, Some(C))("w = 8"),
                    PhantomCell("abc"),
                    MultiMathCell(3, Some(C))("w = 16")
                  )
                  CMidRules((2, 4), (6, 8))
                  Row(
                    EmptyCell(),
                    MathCell("t=0"),
                    MathCell("t=1"),
                    MathCell("t=2"),
                    EmptyCell(),
                    MathCell("t=0"),
                    MathCell("t=1"),
                    MathCell("t=2")
                  )
                  MidRule()
                  Row(MathCell("dir=1"))
                  Row(
                    MathCell("c"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    EmptyCell(),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f")
                  )
                  Row(
                    MathCell("c"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    EmptyCell(),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f")
                  )
                  Row(
                    MathCell("c"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    EmptyCell(),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f")
                  )
                  Row(MathCell("dir=0"))
                  Row(
                    MathCell("c"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    EmptyCell(),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f")
                  )
                  Row(
                    MathCell("c"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    EmptyCell(),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f")
                  )
                  Row(
                    MathCell("c"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    EmptyCell(),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f"),
                    Cell(f"${java.lang.Math.random()}%2.4f")
                  )
                  BottomRule()
                }
              }
            }
          }
          Text("With a text")
          Landscape {

            Center {
              Group {
                LongTable(
                  L,
                  P(15),
                  P(15),
                  P(15),
                  P(15),
                  P(15),
                  P(15),
                  P(15),
                  P(15)
                ) {
                  Caption(
                    "Performance of Ligity in HTS mode against the Ligity-compatible DUD-E targets"
                  )(Some("DUD-E targets"))
                  Label("tab:full-dude-results")
                  Row()
                  TableFirstHeader {
                    TopRule()
                    Row(
                      Cell("Target"),
                      Cell("No. of Actives"),
                      Cell("No. of Decoys"),
                      Cell("ROC AUC Tanimoto"),
                      Cell("ROC AUC Tversky"),
                      Cell("BEDROC Tanimoto"),
                      Cell("BEDROC Tversky"),
                      Cell("EF Tanimoto"),
                      Cell("EF Tversky")
                    )
                    MidRule()
                  }
                  TableHeader {
                    MidRule()
                    Row(
                      Cell("Target"),
                      Cell("No. of Actives"),
                      Cell("No. of Decoys"),
                      Cell("ROC AUC Tanimoto"),
                      Cell("ROC AUC Tversky"),
                      Cell("BEDROC Tanimoto"),
                      Cell("BEDROC Tversky"),
                      Cell("EF Tanimoto"),
                      Cell("EF Tversky")
                    )
                    MidRule()
                  }
                  TableFooter {
                    MidRule()
                    Row(MultiCell(7, Some(R))("(continued...)"))
                  }
                  TableLastFooter {}
                  (1 to 100).foreach(i =>
                    Row(
                      Cell(s"A$i"),
                      Cell(f"${java.lang.Math.random()}%2.4f"),
                      Cell(f"${java.lang.Math.random()}%2.4f"),
                      Cell(f"${java.lang.Math.random()}%2.4f"),
                      Cell(f"${java.lang.Math.random()}%2.4f"),
                      Cell(f"${java.lang.Math.random()}%2.4f"),
                      Cell(f"${java.lang.Math.random()}%2.4f"),
                      Cell(f"${java.lang.Math.random()}%2.4f"),
                      Cell(f"${java.lang.Math.random()}%2.4f")
                    )
                  )
                  BottomRule()
                }
              }
            }

          }

        }

        PageStyle("umpageback")
        BackMatter()
        Text("The End")
      }
    }

    val pdf = Renderer.pdf(latexFile)
    println(workDirectory.getAbsolutePath)
    assert(pdf.nonEmpty)
  }
}
