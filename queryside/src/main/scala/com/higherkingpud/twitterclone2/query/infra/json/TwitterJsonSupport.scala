package com.higherkingpud.twitterclone2.query.infra.json

import java.time.Instant

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.higherkingpud.twitterclone2.query.domain.entities.Tweet
import spray.json._

object TwitterJsonSupport extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val instantJsonFormat: JsonFormat[Instant] = new JF[Instant] {
    override def write(inst: Instant): JsValue = JsNumber(inst.toEpochMilli)
    override def read(value: JsValue): Instant =
      value match {
        case JsNumber(em) => Instant.ofEpochMilli(em.toLong)
        case x            => throw new IllegalArgumentException(s"Expected EpochMilli as JsNumber. But got ${x.getClass}")
      }
  }

  implicit val tweetFormat: RootJsonFormat[Tweet] = jsonFormat5(Tweet)

}
