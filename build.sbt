ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

Global / serverConnectionType := ConnectionType.Tcp // experimental

val catsVersion = "2.10.0"

lazy val root = (project in file("."))
  .settings(
    name := "hmrc-assesment",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.15" % Test,
      "org.typelevel" %% "cats-core" % catsVersion
    )
  )
