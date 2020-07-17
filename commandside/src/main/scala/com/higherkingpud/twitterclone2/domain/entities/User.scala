package com.higherkingpud.twitterclone2.domain.entities

import java.util.UUID
import java.time.Instant

case class User(id: String, name: String, phoneNumber: String, createdAt: Instant)
