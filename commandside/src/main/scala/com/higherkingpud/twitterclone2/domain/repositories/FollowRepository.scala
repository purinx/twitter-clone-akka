package com.higherkingpud.twitterclone2.domain.repositories

import com.higherkingpud.twitterclone2.domain.entities.Follow

import scala.concurrent.Future

trait FollowRepository {

  def create(follow: Follow): Future[Unit]

  def drop(follow: Follow): Future[Unit]
}
