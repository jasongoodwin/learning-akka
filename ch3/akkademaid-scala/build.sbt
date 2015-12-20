name := """akkademaid-scala"""

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-http-experimental_2.11" % "1.0-M4",
  "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "1.0-M4",
  "com.akkademy-db"   %% "akkademy-db-scala"     % "0.0.1-SNAPSHOT",
  "com.syncthemall" % "boilerpipe" % "1.2.2",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test"
)

