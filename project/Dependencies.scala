import sbt._

object Dependencies {
  val akkaVersion = "2.6.7"
  val akkaHttpVersion = "10.1.12"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.1.2"
  lazy val jedis     = "redis.clients"  % "jedis"     % "3.3.0"
  lazy val macwire = Seq(
    "com.softwaremill.macwire" %% "macros"     % "2.3.6" % "provided",
    "com.softwaremill.macwire" %% "macrosakka" % "2.3.6" % "provided",
    "com.softwaremill.macwire" %% "util"       % "2.3.6",
    "com.softwaremill.macwire" %% "proxy"      % "2.3.6"
  )
  lazy val scalikejdbc = Seq(
    "mysql"         % "mysql-connector-java" % "8.0.17",
    "org.scalikejdbc" %% "scalikejdbc"       % "3.4.2"
  )
  lazy val pureconfig = "com.github.pureconfig" %% "pureconfig" % "0.12.3"
  lazy val akka = Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
  )
}
