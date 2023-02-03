package fish.genius.latex

import org.scalatest.flatspec.AnyFlatSpec

class TexifiedSpec extends AnyFlatSpec {
  it should "convert text to LaTeX source code" in {
    val texified = Texified("Abcdëf&~<>€")
    println(texified)
    assert(
      texified.output == "Abcd\\\"ef\\&\\textasciitilde \\textless \\textgreater \\texteuro "
    )
  }
}
