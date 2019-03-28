package example

import cats.effect.Sync

object ConsoleIO {
  def putStrLn[F[_]: Sync](value: String) = Sync[F].pure(println(value))
  def readLn[F[_]: Sync] = Sync[F].pure(scala.io.StdIn.readLine)
  def extractInts(input: String) = """(\d+)""".r.findAllIn(input).map(_.toInt).toList
}