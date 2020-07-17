import Dependencies._

ThisBuild / scalaVersion := "2.13.2"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.higherkingpud"
ThisBuild / organizationName := "higherkingpud"

lazy val commandside = (project in file("commandside"))
  .settings(
    name := "commandside",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= akka,
    libraryDependencies ++= macwire,
    libraryDependencies ++= scalikejdbc,
    libraryDependencies += pureconfig,
    libraryDependencies += logback
  )

lazy val queryside = (project in file("queryside"))
  .settings(
    name := "queryside",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= akka,
    libraryDependencies ++= macwire,
    libraryDependencies ++= scalikejdbc,
    libraryDependencies += scalikejdbcStreams,
    libraryDependencies += jedis,
    libraryDependencies += pureconfig,
    libraryDependencies += logback
  )
