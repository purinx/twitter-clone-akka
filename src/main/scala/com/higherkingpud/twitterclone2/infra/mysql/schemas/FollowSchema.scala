package com.higherkingpud.twitterclone2.infra.mysql.schemas

import scalikejdbc._
import java.time.LocalDateTime

case class FollowRecord(followerId: String, followeeId: String, createdAt: LocalDateTime)

object FollowSchema extends SQLSyntaxSupport[FollowRecord] {
  override def tableName = "follows"

  def apply(t: ResultName[FollowRecord])(rs: WrappedResultSet): FollowRecord = {
    FollowRecord(rs.string(t.followerId), rs.string(t.followeeId), rs.localDateTime(t.createdAt))
  }
}
