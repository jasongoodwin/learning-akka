name := """akkademy-db"""

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.6",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "junit"             % "junit"           % "4.11"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test"
)
