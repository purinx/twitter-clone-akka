package com.higherkingpud.twitterclone2.query.infra.mysql

import java.time.LocalDateTime

import com.higherkingpud.twitterclone2.query.domain.entities.Follow
import scalikejdbc._

case class TweetRecord(id: String, userId: String, text: String, createdAt: LocalDateTime)

case class UserRecord(id: String, name: String, phoneNumber: String, createdAt: LocalDateTime)

object TweetSchema extends SQLSyntaxSupport[TweetRecord] {
  override def tableName: String = "tweets"

  def apply(t: ResultName[TweetRecord])(rs: WrappedResultSet): TweetRecord = {
    TweetRecord(
      rs.string(t.id),
      rs.string(t.userId),
      rs.string(t.text),
      rs.localDateTime(t.createdAt)
    )
  }
}

object UserSchema extends SQLSyntaxSupport[UserRecord] {
  override def tableName: String = "users"

  def apply(u: ResultName[UserRecord])(rs: WrappedResultSet): UserRecord = {
    UserRecord(
      id = rs.string(u.id),
      name = rs.string(u.name),
      phoneNumber = rs.string(u.phoneNumber),
      createdAt = rs.localDateTime(u.createdAt)
    )
  }
}

object FollowSchema extends SQLSyntaxSupport[Follow] {
  override def tableName: String = "follows"

  def apply(f: ResultName[Follow])(rs: WrappedResultSet): Follow = {
    Follow(
      rs.string(f.followerId),
      rs.string(f.followeeId)
    )
  }
}
