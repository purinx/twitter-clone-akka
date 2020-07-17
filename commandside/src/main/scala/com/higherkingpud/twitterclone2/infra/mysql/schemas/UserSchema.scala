package com.higherkingpud.twitterclone2.infra.mysql.schemas

import scalikejdbc._
import java.time.LocalDateTime
import com.higherkingpud.twitterclone2.domain.entities.User
import java.time.Instant
import java.time.ZoneOffset

case class UserRecord(id: String, name: String, phoneNumber: String, createdAt: LocalDateTime) {
  def toEntity: User = User(id, name, phoneNumber, createdAt.toInstant(ZoneOffset.UTC))
}

object UserSchema extends SQLSyntaxSupport[UserRecord] {
  override def tableName: String = "users"

  def apply(t: ResultName[UserRecord])(rs: WrappedResultSet): UserRecord = {
    UserRecord(rs.string(t.id), rs.string(t.name), rs.string(t.phoneNumber), rs.localDateTime(t.createdAt))
  }
}

