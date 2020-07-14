package com.higherkingpud.twitterclone2.domain.repositories

import com.higherkingpud.twitterclone2.domain.entities.User

trait UserRepository {

  def findById(id: String): Option[User]
  
  def create(user: User): Unit

  def update(user: User): Unit
}
