package fish.genius.latex

import fish.genius.io.FileUtils
import org.scalatest.flatspec.AnyFlatSpec

import java.io.File
import java.nio.file.Files

class RendererSpec extends AnyFlatSpec {
  it should "render tex files to PDF" in {
    val workingDirectory = Files.createTempDirectory("latex").toFile
    val latexFile = new File(workingDirectory, "sample.tex")
    FileUtils.writeStringToFile(
      """\documentclass{article}
                                  |\begin{document}
                                  |    First document. This is a simple example, with no
                                  |    extra parameters or packages included.
                                  |\end{document}""".stripMargin,
      latexFile
    )
    val pdfFile = Renderer.pdf(latexFile)
    assert(pdfFile.nonEmpty)
    println(pdfFile.get.getAbsolutePath)
  }
}
