package fish.genius.latex

import fish.genius.io.FileUtils
import fish.genius.latex.model.{
  DefineColor,
  Document,
  GraphicsPath,
  MakeTitle,
  Paragraph,
  Text,
  Verbatim
}
import fish.genius.latex.model.beamer.{
  BeamerTheme,
  CommonBeamerSettings,
  Frame,
  SlideDeck,
  SlideDeckPreamble
}
import fish.genius.latex.model.tikz.{
  Anchor,
  BelowOf,
  BoldFont,
  Circle,
  Draw,
  Fill,
  InnerSep,
  LineWidth,
  Midway,
  MinimumWidth,
  North,
  NorthWest,
  Rectangle,
  RightOf,
  Rotate,
  TextColor,
  TextWidth,
  Tikz,
  TikzPicture,
  TinyFont,
  West
}
import fish.genius.lorem.{SampleImages, SampleText}
import org.scalatest.flatspec.AnyFlatSpec

import java.io.File
import java.nio.file.Files

class SlideDeckSpec extends AnyFlatSpec {
  ignore should "generate a Beamer Slide Deck" in {
    val workDirectory = Files.createTempDirectory("dissertation").toFile
    List("color", "font", "inner", "outer", "").foreach(it =>
      FileUtils.copyResourceFromFileOrClassPathToFile(
        s"/beamer/beamer${it}themegeniusfish.sty",
        new File(workDirectory, s"beamer${it}themegeniusfish.sty"),
        this.getClass
      )
    )
    val imagesDirectory = new File(workDirectory, "images")
    imagesDirectory.mkdirs()
    val sampleIntegrationImage: String = SampleImages
      .image(680, 400, "jpg", filename = "integration1")
      .flatMap(integrationDiagram =>
        FileUtils.copy(
          integrationDiagram,
          new File(imagesDirectory, "integration1.jpg")
        )
      )
      .map(_.getName)
      .getOrElse("logo")
    List("logo", "tagline_black", "tagline_white", "title_background").foreach(
      it =>
        FileUtils.copyResourceFromFileOrClassPathToFile(
          s"/beamer/${it}.pdf",
          new File(imagesDirectory, s"${it}.pdf")
        )
    )
    val latexFile = new File(workDirectory, "document.tex")
    val latex = LaTeX(latexFile) { implicit documentBuilder =>
      SlideDeck {
        BeamerTheme("geniusfish")
        CommonBeamerSettings()
        SlideDeckPreamble(title = Some("Hello World"))
        GraphicsPath(List("./images/"))
        DefineColor(0, 0, 0)("testBlack")
        Document {
          MakeTitle()
          Frame("This is slide 1") {
            Text("Hello Genius")
          }
          Frame("This is slide 2") {
            TikzPicture.fullPage() {
              Tikz.line((0, 30), (100, 50), Some("hello"))(List(LineWidth(2)))(
                List(
                  Draw("innovensoBlue"),
                  Circle,
                  TinyFont,
                  Midway,
                  Anchor(North)
                )
              )
            }
          }
          Frame("Slide 3") {
            TikzPicture.fullPage() {
              Tikz.nodeAt(
                "hello",
                (100, 50),
                "helloworld",
                List(
                  Draw("innovensoBlue"),
                  Fill("innovensoBackground"),
                  Rectangle
                )
              )
              Tikz.nodeAt(
                "world",
                (50, 100),
                "worldhello",
                List(Draw("innovensoRed"), Fill("innovensoHighLight"), Circle)
              )
            }
          }
          Frame("Slide 4") {
            TikzPicture.fullPage() {
              Tikz.imageNodeAt(
                "logo",
                50,
                "thelogo",
                (0, 50),
                style = List(Anchor(West), Rotate(45))
              )
              Tikz.imageNodeAt("logo", 60, "thesecondlogo", (100, 60))
            }
          }
          Frame("Slide 5") {
            TikzPicture.fullPage() {
              Tikz.imageNodeAt(
                sampleIntegrationImage,
                68,
                "diagram",
                (0, 85),
                style = List(Anchor(NorthWest))
              )
              Tikz.node(
                content = SampleText.description,
                identifier = "description",
                style = List(
                  TextWidth(68),
                  MinimumWidth(68),
                  TinyFont,
                  InnerSep(0),
                  BelowOf("diagram.south", Some(5)),
                  Anchor(North)
                )
              )
              Tikz.node(
                content = "Criticality - Hazardous",
                identifier = "criticalityTitle",
                style = List(
                  Rectangle,
                  TextWidth(68),
                  TextColor("testBlack"),
                  MinimumWidth(68),
                  RightOf("diagram.north east", Some(4)),
                  Anchor(NorthWest),
                  InnerSep(0),
                  BoldFont(TinyFont)
                )
              )
              Tikz.node(
                content = SampleText.title,
                identifier = "criticalityDescription",
                style = List(
                  Rectangle,
                  TextWidth(68),
                  TextColor("testBlack"),
                  MinimumWidth(68),
                  BelowOf("criticalityTitle.south west"),
                  Anchor(NorthWest),
                  InnerSep(0),
                  TinyFont
                )
              )

              Tikz.node(
                content = "Volume",
                identifier = "volumeTitle",
                style = List(
                  Rectangle,
                  TextWidth(68),
                  TextColor("testBlack"),
                  MinimumWidth(68),
                  BelowOf("criticalityDescription.south west", Some(4)),
                  Anchor(NorthWest),
                  InnerSep(0),
                  BoldFont(TinyFont)
                )
              )
              Tikz.node(
                content = SampleText.title,
                identifier = "volumeDescripion",
                style = List(
                  Rectangle,
                  TextWidth(68),
                  TextColor("testBlack"),
                  MinimumWidth(68),
                  BelowOf("volumeTitle.south west"),
                  Anchor(NorthWest),
                  InnerSep(0),
                  TinyFont
                )
              )
            }
          }
        }
      }
    }
    val pdf = Renderer.pdf(latexFile)
    println(workDirectory.getAbsolutePath)
    assert(pdf.nonEmpty)

  }
}
