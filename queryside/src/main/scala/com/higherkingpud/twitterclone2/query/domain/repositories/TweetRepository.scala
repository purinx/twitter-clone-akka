package com.higherkingpud.twitterclone2.query.domain.repositories

import com.higherkingpud.twitterclone2.query.domain.entities.Tweet
import scalikejdbc.streams.StreamReadySQL

trait TweetRepository {
  def streamTimeline(userId: String, offset: Int = 0): StreamReadySQL[Tweet]
}
