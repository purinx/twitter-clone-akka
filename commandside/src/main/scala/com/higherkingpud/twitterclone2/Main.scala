package com.higherkingpud.twitterclone2

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.higherkingpud.twitterclone2.controllers.Routes
import com.higherkingpud.twitterclone2.modules.ApplicationModule

object Main extends App with ApplicationModule with Routes {
  implicit lazy val system = ActorSystem("my-system")
  implicit lazy val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  
  val logger = Logging(system, getClass)
  val binding = Http().bindAndHandle(
    routes, 
    httpConfig.interface, 
    httpConfig.port
  )
}
