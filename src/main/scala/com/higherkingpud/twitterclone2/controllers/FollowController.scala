package com.higherkingpud.twitterclone2.controllers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import com.higherkingpud.twitterclone2.domain.repositories.FollowRepository
import com.higherkingpud.twitterclone2.domain.entities.Follow

class FollowController(
  followRepository: FollowRepository  
) {
  import Protocol._

  def createFollow(follow: PostFollow) = {
    followRepository.create(Follow(follow.followerId, follow.followeeId))
    complete(follow)
  }
}

