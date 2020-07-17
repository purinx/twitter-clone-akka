package com.higherkingpud.twitterclone2.config

case class RootConfig(
  http: HTTPConfig,
  mysql: MySQLConfig
)

case class AkkaConfig(
  loggers: List[String],
  loglevel: String
)

case class HTTPConfig(
  interface: String,
  port: Int
)

case class MySQLConfig(
  host: String,
  port: Int,
  dbname: String,
  username: String,
  password: String,
  threads: Int,
  maxconnections: Int,
  driver: String
)

