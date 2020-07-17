package com.higherkingpud.twitterclone2.domain.entities

import java.util.UUID

case class TweetId(value: UUID) {
  override def toString: String = value.toString()
}

case class Tweet(id: TweetId, userId: String, text: String) 

object Tweet {
  def apply(userId: String, text: String): Tweet = {
    val newId = TweetId(UUID.randomUUID())
    Tweet(newId, userId, text)
  }
}
