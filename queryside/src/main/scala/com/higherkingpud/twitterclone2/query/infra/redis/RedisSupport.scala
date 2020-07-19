package com.higherkingpud.twitterclone2.query.infra.redis

import redis.clients.jedis.{Jedis, JedisPool}

trait RedisSupport {
  def pool: JedisPool

  final protected def withJedis[A](f: Jedis => A) = {
    val jedis = pool.getResource
    try {
      f(jedis)
    } finally {
      jedis.close()
    }
  }
}
