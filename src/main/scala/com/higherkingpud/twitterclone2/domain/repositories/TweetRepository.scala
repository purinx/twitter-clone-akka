package com.higherkingpud.twitterclone2.domain.repositories

import com.higherkingpud.twitterclone2.domain.entities.TweetId
import com.higherkingpud.twitterclone2.domain.repositories.TweetRepository.TweetCreating

object TweetRepository {
  case class TweetCreating(id: TweetId, userId: String, text: String)
}

trait TweetRepository {
  def create(tweet: TweetCreating): Unit

  def delete(id: TweetId): Unit
}
