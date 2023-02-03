package fish.genius.latex

import fish.genius.config.Configurable
import fish.genius.io.{Command, FileUtils, Shell}
import fish.genius.logging.Loggable

import java.io.File
import java.nio.file.Files

object Renderer extends Loggable with Configurable {
  val latexmk = config.getString("genius.latex.command")
  def pdf(sourceFile: File): Option[File] = {
    info(s"rendering $sourceFile to PDF")
    val outputDirectory = Shell.run(
      Command(
        s"render-${sourceFile.getName}-to-pdf.log"
      ) + latexmk + "-pdf" + "-interaction=nonstopmode" + sourceFile.getName,
      sourceFile.getParentFile
    )
    outputDirectory
      .map(od => new File(od, sourceFile.getName.replaceAll(".tex", ".pdf")))
      .filter(_.canRead)
  }

  def pdf(latex: String, filename: String = "document"): Option[File] = {
    val workingDirectory = Files.createTempDirectory("latex").toFile
    val latexFile = new File(workingDirectory, s"$filename.tex")
    FileUtils.writeStringToFile(latex, latexFile)
    pdf(latexFile)
  }
}
