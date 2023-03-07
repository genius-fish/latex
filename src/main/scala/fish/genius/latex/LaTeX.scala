package fish.genius.latex

import fish.genius.io.FileUtils
import fish.genius.logging.Loggable

import java.io.File
import java.nio.file.Files
import scala.util.{Failure, Success, Try}

class LaTeX(val workingDirectory: File) extends Loggable {
  val imagesDirectory: File = new File(workingDirectory, "images")
  val mainSource: File = new File(workingDirectory, "main.tex")
  imagesDirectory.mkdirs()

  def withImage(image: File): LaTeX = {
    val result = FileUtils
      .copy(image, new File(imagesDirectory, image.getName))
    if (result.isEmpty) withPlaceholderImage(image.getName)
    this
  }

  def withImages(images: List[File]): LaTeX = {
    images.foreach(withImage)
    this
  }

  def withOptionalImage(image: Option[File]): LaTeX = withImages(image.toList)

  def withImageResource(path: String, filename: String): LaTeX = {
    val result = FileUtils.copyResourceFromFileOrClassPathToFile(
      path,
      new File(imagesDirectory, filename),
      this.getClass
    )
    if (result.isEmpty) withPlaceholderImage(filename)
    this
  }

  def withPlaceholderImage(filename: String): LaTeX =
    withImageResource("/placeholder.pdf", filename)

  def withImageResources(
      listOfPathsAndFilenames: List[(String, String)]
  ): LaTeX = {
    listOfPathsAndFilenames.foreach(pair => withImageResource(pair._1, pair._2))
    this
  }

  def withSource(sourceFile: File): LaTeX = {
    FileUtils.copy(sourceFile, new File(workingDirectory, sourceFile.getName))
    this
  }

  def withSources(sourceFiles: List[File]): LaTeX = {
    sourceFiles.foreach(withSource)
    this
  }

  def withResource(path: String, filename: String): LaTeX = {
    FileUtils.copyResourceFromFileOrClassPathToFile(
      path,
      new File(workingDirectory, filename),
      this.getClass
    )
    this
  }

  def withResources(listOfPathsAndFilenames: List[(String, String)]): LaTeX = {
    listOfPathsAndFilenames.foreach(pair => withResource(pair._1, pair._2))
    this
  }

  def withOptionalSource(sourceFile: Option[File]): LaTeX = withSources(
    sourceFile.toList
  )

  def withMainSource(body: DocumentBuilder => Any): LaTeX =
    writeToFile(mainSource)(body)

  def withSource(filename: String)(body: DocumentBuilder => Any): LaTeX =
    writeToFile(new File(workingDirectory, filename))(body)

  def withTheme(filename: String)(body: DocumentBuilder => Any): LaTeX =
    writeToFile(new File(workingDirectory, filename), forTheme = true)(body)

  def render: Option[File] = Renderer.pdf(mainSource)

  private def writeToFile(
      targetFile: File,
      forTheme: Boolean = false
  )(body: DocumentBuilder => Any): LaTeX = {
    val builder = new DocumentBuilder(forTheme = forTheme)(this)
    body.apply(builder)
    try {
      FileUtils.writeStringToFile(builder.output, targetFile)
    } catch {
      case e: Throwable => exception(e)
    }
    this
  }
}

object LaTeX {
  def apply(
      workingDirectory: File = Files.createTempDirectory("latex").toFile
  ): LaTeX = new LaTeX(workingDirectory)
}
