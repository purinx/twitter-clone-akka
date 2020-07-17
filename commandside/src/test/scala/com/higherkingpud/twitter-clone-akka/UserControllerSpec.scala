package com.higherkingpud.twitterclone2.controllers

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.MediaTypes.`application/json`
import akka.http.scaladsl.server._
import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest

class UserControllerSpec extends WordSpec with Matchers with ScalatestRouteTest with Routes {
  val userController: UserController = new UserController()
  val tweetController: TweetController = new TweetController()
  val followController: FollowController = new FollowController()

  "POST users return JSON sended." in {
    Post(
      "/users",
      HttpEntity(`application/json`, """{"name":"プリン","id":"higherkingpud","phoneNumber":"08000000000"}""")
    ) ~> routes ~> check {
      responseAs[String] should include(""""name":"プリン"""")
      responseAs[String] should include(""""id":"higherkingpud"""")
    }
  }
}

