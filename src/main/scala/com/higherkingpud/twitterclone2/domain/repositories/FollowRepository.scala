package com.higherkingpud.twitterclone2.domain.repositories

import com.higherkingpud.twitterclone2.domain.entities.Follow

trait FollowRepository {

  def create(follow: Follow): Unit

  def delete(follow: Follow): Unit
}
