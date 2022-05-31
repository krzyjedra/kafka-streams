ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "kafka-streams"
  )

libraryDependencies += "org.apache.kafka" % "kafka-streams" % "3.1.0" % "provided"
libraryDependencies += "com.github.scopt" %% "scopt" % "4.0.1"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % "test"