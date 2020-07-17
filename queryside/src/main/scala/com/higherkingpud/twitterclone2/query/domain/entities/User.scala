package com.higherkingpud.twitterclone2.query.domain.entities

import java.time.Instant

case class User(
  id: String,
  name: String,
  phoneNumber: String,
  createdAt: Instant
)
