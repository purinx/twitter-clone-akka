package com.higherkingpud.twitterclone2.query.domain.entities

import java.time.Instant

case class Tweet(
  id: String,
  userId: String,
  userName: String,
  text: String,
  createdAt: Instant,
)
