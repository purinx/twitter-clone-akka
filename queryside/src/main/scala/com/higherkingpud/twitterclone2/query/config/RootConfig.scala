package com.higherkingpud.twitterclone2.query.config

case class RootConfig(
    http: HTTPConfig,
    redis: RedisConfig,
    mysql: MySQLConfig
)

case class RedisConfig(
    host: String,
    port: Int
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
