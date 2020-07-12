package com.higherkingpud.twitterclone2.controllers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

trait Routes extends SprayJsonSupport {
  //TODO replace with DI
  val followController: FollowController
  val userController: UserController
  val tweetController: TweetController

  import Protocol._

  val routes = {
    path("users") {
      post {
        entity(as[PostUser]) { user =>
          userController.createUser(user)
        }
      }
    } ~
  path("tweets") {
    post {
      entity(as[PostTweet]) { tweet =>
        tweetController.createTweet(tweet)
      }
    }
  } ~
  path("follows") {
    post {
      entity(as[PostFollow]) { follow =>
        followController.createFollow(follow)
      }
    }
  }
  }
}

