package com.higherkingpud.twitterclone2.query.domain.repositories

import scalikejdbc.streams.StreamReadySQL

trait FollowRepository {
  def streamFollowee(userId: String): StreamReadySQL[String]
}
