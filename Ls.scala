//> using lib "com.lihaoyi::os-lib::0.8.1"
//> using publish.organization "io.github.alexarchambault"
//> using publish.version "0.1.0-SNAPSHOT"

object Ls {
  def main(args: Array[String]): Unit = {
    val paths =
      if (args.isEmpty) Seq(os.pwd)
      else args.toSeq.map(os.Path(_, os.pwd))
    for (path <- paths) {
      for (f <- os.list(path) if !f.last.startsWith("."))
        println(f.last)
    }
  }
}
