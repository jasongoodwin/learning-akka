name := """akkademaid-java"""

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.9",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.3.0",
  "com.typesafe.akka" % "akka-http-experimental_2.11" % "1.0-M4",
  "com.typesafe.akka" % "akka-http-core-experimental_2.11" % "1.0-M4",
  "com.jason-goodwin" % "better-monads" % "0.2.0",
  "com.syncthemall" % "boilerpipe" % "1.2.2",
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test"
)
