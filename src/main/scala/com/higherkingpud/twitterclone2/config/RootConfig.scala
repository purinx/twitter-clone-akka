package com.higherkingpud.twitterclone2.config

case class RootConfig(
  http: HTTPConfig,
  mysql: MySQLConfig
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
  threads: Int
)

