ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "1.0.0"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "game",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.5",
      "org.typelevel" %% "cats-effect" % "1.2.0",
      "org.typelevel" %% "cats-core" % "1.6.0"
    ),
    scalacOptions ++= Seq(
      "-language:higherKinds",
      "-language:postfixOps"
    )
  )