name := """futures-examples"""

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"     % "2.3.9",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.7.0",
  "com.typesafe.akka" %% "akka-testkit"   % "2.3.9" % "test",
  "junit"             % "junit"           % "4.11"  % "test",
  "com.novocode"      % "junit-interface" % "0.11" % "test"
)
