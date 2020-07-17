package com.higherkingpud.twitterclone2.query

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.higherkingpud.twitterclone2.query.domain.entities.Follow
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object Protocols extends SprayJsonSupport with DefaultJsonProtocol {
  case class UserResponseBody(id: String, name: String, phoneNumber: String, createdAt: String)
  case class TweetResponseBody(id: String, userId: String, userName: String, createdAt: String)

  implicit lazy val userFormat: RootJsonFormat[UserResponseBody] = jsonFormat4(UserResponseBody)
  implicit lazy val tweetFormat: RootJsonFormat[TweetResponseBody] = jsonFormat4(TweetResponseBody)
  implicit lazy val followFormat: RootJsonFormat[Follow] = jsonFormat2(Follow)
}
