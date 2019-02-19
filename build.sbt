//import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "game",
    libraryDependencies ++= Seq(
      //scalaTest % Test,
      "org.typelevel" %% "cats-effect" % "1.2.0",
      "org.typelevel" %% "cats-core" % "1.6.0"
    )
  )