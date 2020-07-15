package com.higherkingpud.twitterclone2.controllers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import com.higherkingpud.twitterclone2.domain.repositories.UserRepository

class UserController(
  userRepository: UserRepository
) {
  import Protocol._
  import UserRepository._

  def createUser(user: PostUser) = {
    userRepository.create(UserCreating(
      id = user.id,
      name = user.name,
      phoneNumber = user.phoneNumber,
    ))
    complete(user)
  }

}
