package com.higherkingpud.twitterclone2.controllers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

class FollowController {
  import Protocol._

  def createFollow(follow: PostFollow) = complete(follow)
}

