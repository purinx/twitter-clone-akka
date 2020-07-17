package com.higherkingpud.twitterclone2.query

import com.higherkingpud.twitterclone2.query.domain.model.{
  User,
  Tweet,
  Follow
}
import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport

object Protocol extends SprayJsonSupport with DefaultJsonProtocol {
  
  implicit lazy val userFormat = jsonFormat3(User)
  implicit lazy val tweetFormat = jsonFormat2(Tweet)
  implicit lazy val followFormat = jsonFormat2(Follow)
}
