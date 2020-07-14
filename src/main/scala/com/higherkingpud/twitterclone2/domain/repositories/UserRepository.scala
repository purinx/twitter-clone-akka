package com.higherkingpud.twitterclone2.domain.repositories

import com.higherkingpud.twitterclone2.domain.entities.User
import scala.concurrent.Future

object UserRepository {
  case class UserCreating(id: String, name: String, phoneNumber: String)
}

trait UserRepository {
  import UserRepository._

  def findById(id: String): Future[Option[User]]
  
  def create(user: UserCreating): Unit

}
