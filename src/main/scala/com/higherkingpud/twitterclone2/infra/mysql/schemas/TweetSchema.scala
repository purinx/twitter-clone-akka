package com.higherkingpud.twitterclone2.infra.mysql

import scalikejdbc._
import java.time.LocalDateTime

case class TweetRecord(id: String, userId: String, text: String, createdAt: LocalDateTime) 

object TweetSchema extends SQLSyntaxSupport[TweetRecord] {
  override def tableName: String = "tweets"
  
  def apply(t: ResultName[TweetRecord])(rs: WrappedResultSet): TweetRecord = {
    TweetRecord(rs.string(t.id), rs.string(t.userId), rs.string(t.text), rs.localDateTime(t.createdAt))
  }
}
