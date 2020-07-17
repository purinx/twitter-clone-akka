package com.higherkingpud.twitterclone2.modules

// Do not delete next line.
import pureconfig.generic.auto._
import java.util.concurrent.Executors

import com.higherkingpud.twitterclone2.config.{HTTPConfig, MySQLConfig, RootConfig}
import com.higherkingpud.twitterclone2.controllers.{FollowController, TweetController, UserController}
import com.higherkingpud.twitterclone2.domain.repositories._
import com.higherkingpud.twitterclone2.infra.mysql.{FollowRepositoryOnMySQL, TweetRepositoryOnMySQL, UserRepositoryOnMySQL}
import com.softwaremill.macwire.wire
import com.typesafe.config.ConfigFactory
import pureconfig.ConfigSource
import scalikejdbc._

import scala.concurrent.ExecutionContext

trait ApplicationModule {
  lazy val config: RootConfig =
    ConfigSource.fromConfig(ConfigFactory.load()).loadOrThrow[RootConfig]
  lazy val mySQLConfig: MySQLConfig = config.mysql
  lazy val httpConfig: HTTPConfig = config.http

  lazy val session: DBSession = AutoSession

  val connectionPoolSettings: ConnectionPoolSettings = ConnectionPoolSettings(
    initialSize = 1,
    maxSize = mySQLConfig.maxconnections
  )

  ConnectionPool.singleton(
    s"jdbc:mysql://${mySQLConfig.host}:${mySQLConfig.port}/${mySQLConfig.dbname}", 
    mySQLConfig.username, 
    mySQLConfig.password, 
    connectionPoolSettings
  )

  lazy val databaseExecutorContext: ExecutionContext =
    ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(mySQLConfig.threads))

  // repositories
  lazy val followRepository: FollowRepository = wire[FollowRepositoryOnMySQL]
  lazy val userRepository: UserRepository = wire[UserRepositoryOnMySQL]
  lazy val tweetRepository: TweetRepository = wire[TweetRepositoryOnMySQL]

  // controllers
  lazy val followController: FollowController = wire[FollowController]
  lazy val tweetController: TweetController = wire[TweetController]
  lazy val userController: UserController = wire[UserController]
}

