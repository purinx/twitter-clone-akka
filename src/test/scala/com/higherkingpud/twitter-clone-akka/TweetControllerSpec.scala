package com.higherkingpud.twitterclone2.controllers

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.MediaTypes.`application/json`
import akka.http.scaladsl.server._
import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest

class TweetControllerSpec extends WordSpec with Matchers with ScalatestRouteTest with Routes {
  val userController: UserController = new UserController()
  val tweetController: TweetController = new TweetController()
  val followController: FollowController = new FollowController()

  "POST tweets return JSON sended." in {
    Post(
      "/tweets",
      HttpEntity(`application/json`, """{"text":"Just created","userId":"higherkingpud"}""")
    ) ~> routes ~> check {
      responseAs[String] should include(""""text":"Just created"""")
      responseAs[String] should include(""""userId":"higherkingpud"""")
    }
  }
}

