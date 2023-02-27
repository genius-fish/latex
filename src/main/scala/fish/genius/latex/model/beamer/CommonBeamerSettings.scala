package fish.genius.latex.model.beamer

import fish.genius.latex.DocumentBuilder
import fish.genius.latex.model.{Command, UsePackage}

import java.time.LocalDate

object CommonBeamerSettings {
  private val today = LocalDate.now()
  private val documentVersion =
    s"${today.getYear}-${today.getMonthValue}-${today.getDayOfMonth}"

  def apply()(implicit documentBuilder: DocumentBuilder): Unit = {
    UsePackage("opensans", parameters = Some("default,oldstyle,scale=0.95"))
    UsePackage("tikz")
    UsePackage("setspace")
    UsePackage("graphicx")

    UsePackage("xcolor")
    UsePackage("xfp")
    UsePackage("xparse")
    UsePackage("inputenc", parameters = Some("utf8"))
    UsePackage("fontenc", parameters = Some("T1"))
    UsePackage("fontawesome5")
    UsePackage("babel", parameters = Some("dutch,french,english"))
    UsePackage("multicol")
    UsePackage("pgffor")
    UsePackage("tikzscale")
    UsePackage("tikzpeople")
    UsePackage("pgfplots")
    UsePackage("hyperref")
    UsePackage("pgfbaselayers")
    UsePackage("mathpazo")
    UsePackage("tcolorbox", parameters = Some("most"))
    UsePackage("wrapfig")
    UsePackage("pgfgantt")
    UsePackage("smartdiagram")
    UsePackage("longtable")
    UsePackage("forloop")
    UsePackage("booktabs")
    UsePackage("adjustbox", parameters = Some("Export"))

    Command(
      name = "usesmartdiagramlibrary",
      requiredParameters = List("additions")
    )
    Command(name = "usetikzlibrary", requiredParameters = List("calc"))
    Command(name = "usetikzlibrary", requiredParameters = List("positioning"))
    Command(
      name = "usetikzlibrary",
      requiredParameters = List("shapes,snakes,shapes.callouts")
    )
    Command(
      name = "usetikzlibrary",
      requiredParameters = List("decorations.pathreplacing")
    )
    Command(name = "usetikzlibrary", requiredParameters = List("fit"))
    Command(name = "usetikzlibrary", requiredParameters = List("backgrounds"))
    Command(name = "usetikzlibrary", requiredParameters = List("arrows.meta"))
    Command(name = "usetikzlibrary", requiredParameters = List("fadings"))
    Command(name = "usetikzlibrary", requiredParameters = List("mindmap,trees"))

    Command("pgfplotsset", requiredParameters = List("width=7cm,compat=1.8"))
    Command("setkeys", requiredParameters = List("Gin", "keepaspectratio"))

    documentBuilder + s"""\\newcommand{\\optarg}[1][]{%
                        |}
                        |
                        |\\DeclareUnicodeCharacter{200B}{{\\hskip 0pt}}
                        |
                        |\\def\\documentVersion{$documentVersion}
                        |\\newcommand{\\version}[1]{\\gdef\\documentVersion{#1}}
                        |""".stripMargin

  }

}
