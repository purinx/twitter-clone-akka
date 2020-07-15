package com.higherkingpud.twitterclone2.controllers

import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport

object Protocol extends SprayJsonSupport with DefaultJsonProtocol {
  case class PostUser(id: String, name: String, phoneNumber: String)
  case class PostTweet(userId: String, text: String)
  case class PostFollow(followerId: String, followeeId: String)
  case class Tweet(userId: String, text: String, createdAt: String)
  
  implicit lazy val userFormat = jsonFormat3(PostUser)
  implicit lazy val tweetFormat = jsonFormat2(PostTweet)
  implicit lazy val followFormat = jsonFormat2(PostFollow)
}

