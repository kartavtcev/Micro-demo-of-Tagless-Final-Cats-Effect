package example

import cats.effect.{ExitCode, Sync}
import cats.syntax.flatMap._
import cats.syntax.functor._
import example.ConsoleIO._

class Game[F[_]: Sync] {

  def calculate(pieces: List[String]) (m: Int, n: Int): F[List[String]] =
    Sync[F].pure(List.empty)

  val program: F[ExitCode] = for {
    _ <- putStrlLn("Enter the dimensions: M, N")
    listmn <- readLn.map(extractInts)
    (mRows, nCols) = (listmn(0), listmn(1))

    _ <- putStrlLn("Enter # of First")
    f <- readLn.map(extractInts).map(_.head)

    _ <- putStrlLn("Enter # of Second")
    s <- readLn.map(extractInts).map(_.head)

    _ <- putStrlLn("Calculating...")
    _ <- putStrlLn(System.nanoTime().toString)

    pieces = (List.fill(f)("") ::: List.fill(s)(""))

    results <- calculate(pieces)(mRows,nCols)

    _ <- putStrlLn(System.nanoTime().toString)
    _ <- putStrlLn("OUTPUT")
    _ <- putStrlLn(s"# ${results.length}")

    //_ <- putStrlLn(s"${results.foreach(println)}")

  } yield ExitCode.Success
}