package com.higherkingpud.twitterclone2.query.infra.mysql

import java.time.ZoneOffset

import com.higherkingpud.twitterclone2.query.domain.entities.Tweet
import scalikejdbc._
import scalikejdbc.streams._

object TweetRepositoryOnMySQL extends {
  val t = TweetSchema.syntax("t")
  val u = UserSchema.syntax("u")

  private def toTweetEntity(rs: WrappedResultSet): Tweet = Tweet(
    id = rs.string(t.id),
    userId = rs.string(t.userId),
    userName = rs.string(u.userName),
    text = rs.string(t.text),
    createdAt = rs.localDateTime(t.createdAt).toInstant(ZoneOffset.UTC)
  )

  def streamTimelineWithOffset(followees: Seq[String], offset: Int = 0): StreamReadySQL[Tweet] = {
    withSQL {
      select.from(TweetSchema as t)
        .innerJoin(UserSchema as u)
        .where.in(t.userId, followees)
        .orderBy(t.createdAt)
        .desc
        .offset(offset)
        .limit(100)
    }.map(toTweetEntity).iterator()
  }
}
