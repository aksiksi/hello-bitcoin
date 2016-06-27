val dependencies = Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.7",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.7",
  "io.spray" %% "spray-json" % "1.3.2",
)

lazy val commonSettings = Seq(
  organization := "tn.btx",
  version := "0.1",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "hello-bitcoin",
    libraryDependencies ++= dependencies
  )

// Auto-import sbt-pack settings - finds main() automatically
packAutoSettings