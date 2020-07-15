package com.higherkingpud.twitterclone2.controllers

import java.util.UUID
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import com.higherkingpud.twitterclone2.domain.repositories.TweetRepository
import com.higherkingpud.twitterclone2.domain.entities.TweetId

class TweetController(
  tweetRepository: TweetRepository
) {
  import Protocol._
  import TweetRepository._

  def createTweet(tweet: PostTweet) = {
    tweetRepository.create(TweetCreating(
      id = TweetId(UUID.randomUUID()),
      userId = tweet.userId,
      text = tweet.text
    ))
    complete(tweet)
  }
}

