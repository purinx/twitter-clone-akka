package com.higherkingpud.twitterclone2

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.higherkingpud.twitterclone2.controllers.Routes
import com.higherkingpud.twitterclone2.controllers.TweetController
import com.higherkingpud.twitterclone2.controllers.FollowController
import com.higherkingpud.twitterclone2.controllers.UserController

object Main extends App with Routes {
  val tweetController: TweetController = new TweetController()
  val followController: FollowController = new FollowController()
  val userController: UserController = new UserController()

  implicit lazy val system = ActorSystem("my-system")
  implicit lazy val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  val interface = "localhost"
  val port = 8080
  val logger = Logging(system, getClass)
  val binding = Http().bindAndHandle(routes, interface, port)

}

