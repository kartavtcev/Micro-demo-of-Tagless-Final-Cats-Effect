package example

import cats.effect.{ExitCode, Sync}
import cats.syntax.flatMap._
import cats.syntax.functor._
import example.ConsoleIO._

class Game[F[_]: Sync] {

  /*
    def calculate(pieces: List[Piece]) (m: Int, n: Int): F[Stream[String]] =
    (Player.findFirst(m,n) _ andThen Player.getSecond andThen Sync[F].pure) (pieces)
  */

  def calculate(pieces: List[String]) (m: Int, n: Int): F[List[String]] =
    Sync[F].pure(List.empty)

  val program: F[ExitCode] = for {
    _ <- putStrLn("Enter the dimensions: M, N")
    listmn <- readLn.map(extractInts)
    (mRows, nCols) = (listmn(0), listmn(1))

    _ <- putStrLn("Enter # of First")
    f <- readLn.map(extractInts).map(_.head)

    _ <- putStrLn("Enter # of Second")
    s <- readLn.map(extractInts).map(_.head)

    _ <- putStrLn("Calculating...")
    _ <- putStrLn(System.nanoTime().toString)

    pieces = (List.fill(f)("") ::: List.fill(s)(""))

    results <- calculate(pieces)(mRows,nCols)

    _ <- putStrLn(System.nanoTime().toString)
    _ <- putStrLn("OUTPUT")
    _ <- putStrLn(s"# ${results.length}")

    //_ <- putStrlLn(s"${results.foreach(println)}")

  } yield ExitCode.Success
}