package com.higherkingpud.twitterclone2.domain.repositories

import com.higherkingpud.twitterclone2.domain.entities.TweetId

import scala.concurrent.Future

object TweetRepository {
  case class TweetCreating(id: TweetId, userId: String, text: String)
}

trait TweetRepository {
  import TweetRepository._
  def create(tweet: TweetCreating): Future[Unit]

  def drop(id: TweetId): Future[Unit]
}
