package com.higherkingpud.twitterclone2.query.infra.mysql

import scalikejdbc._
import scalikejdbc.streams._

object FollowRepositoryOnMySQL {
  val f = FollowSchema.syntax("f")

  def streamFollowee(userId: String): StreamReadySQL[String] = {
    withSQL {
      select.from(FollowSchema as f)
        .where.eq(f.followerId, userId)
    }.map(rs => rs.string(f.followeeId)).iterator()
  }
}
