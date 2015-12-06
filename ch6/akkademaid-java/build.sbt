name := "akkademy-db-scala"

organization := "com.akkademy-db"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.7",
  "com.typesafe.akka" %% "akka-cluster" % "2.3.7",
  "com.typesafe.akka" %% "akka-contrib" % "2.3.7",
  "com.syncthemall" % "boilerpipe" % "1.2.2",
  "com.jason-goodwin" % "better-monads" % "0.2.0",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "org.scalatest" %% "scalatest" % "2.1.6" % "test"
)

mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
  Seq("application.conf").contains(name)
}}

//
//name := "article-parse-server-java"
//
//organization := "com.akkademy-db"
//
//version := "0.0.1-SNAPSHOT"
//
//scalaVersion := "2.11.1"
//
//
//
//libraryDependencies ++= Seq(
//  "com.typesafe.akka" %% "akka-actor" % "2.3.7",
//  "com.typesafe.akka" %% "akka-cluster" % "2.3.7",
//  "com.typesafe.akka" %% "akka-contrib" % "2.3.7",
//  "com.syncthemall" % "boilerpipe" % "1.2.2",
//  "com.jason-goodwin" % "better-monads" % "0.2.0",
//  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
//  "junit"             % "junit"           % "4.11"  % "test",
//  "com.novocode"      % "junit-interface" % "0.10"  % "test"
//)
//
//mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
//  Seq("application.conf").contains(name)
//}}