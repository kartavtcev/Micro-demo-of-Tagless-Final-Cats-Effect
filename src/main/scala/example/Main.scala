package example

import cats.implicits._
import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    (new Game[IO]).program.attempt >>= {
      case Left(error: Throwable) =>  // TODO: log error
        ConsoleIO.putStrLn[IO](s"Error: ${error.toString}") *> IO(ExitCode.Error)
      case Right(exitCode) => IO(exitCode)
    }
}