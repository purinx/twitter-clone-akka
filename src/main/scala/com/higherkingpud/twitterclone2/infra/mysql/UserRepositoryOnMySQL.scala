package com.higherkingpud.twitterclone2.infra.mysql

import com.higherkingpud.twitterclone2.domain.repositories.UserRepository
import com.higherkingpud.twitterclone2.domain.entities.User
import com.higherkingpud.twitterclone2.infra.mysql.schemas.UserSchema
import scalikejdbc._

import scala.concurrent.{Future, ExecutionContext}

class UserRepositoryOnMySQL(
  session: DBSession,
  executionContext: ExecutionContext
) extends UserRepository {
  import UserRepository._
  implicit val s = session
  implicit val ec = executionContext

  val columns = UserSchema.column
  val u = UserSchema.syntax("u")

  def findById(id: String): Future[Option[User]] = Future {
    DB.readOnly { implicit session =>
      withSQL {
        select
          .from(UserSchema as u)
          .where.eq(columns.id, id)
      }
    }
      .map(UserSchema(u.resultName))
      .single
      .apply()
      .map(_.toEntity).headOption
  }

  def create(user: UserCreating): Future[Unit] = Future {
    withSQL {
      insert.into(UserSchema).namedValues{
        columns.id -> user.id.toString
        columns.name -> user.name
        columns.phoneNumber -> user.phoneNumber
      }
    }.update.apply()
  }
}

