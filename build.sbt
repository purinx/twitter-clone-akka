import Dependencies._

ThisBuild / scalaVersion := "2.13.2"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.higherkingpud"
ThisBuild / organizationName := "higherkingpud"

lazy val root = (project in file("."))
  .settings(
    name := "twitter-clone2",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= akka,
    libraryDependencies ++= macwire,
    libraryDependencies ++= scalikejdbc,
    libraryDependencies += jedis,
    libraryDependencies += pureconfig
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

