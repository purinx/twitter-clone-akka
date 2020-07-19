package com.higherkingpud.twitterclone2.query.domain.aggregates

import akka.Done
import akka.stream.Materializer
import akka.stream.scaladsl._
import com.higherkingpud.twitterclone2.query.domain.entities.Tweet
import com.higherkingpud.twitterclone2.query.domain.repositories.TweetRepository
import com.higherkingpud.twitterclone2.query.infra.json.TwitterJsonSupport
import com.higherkingpud.twitterclone2.query.infra.redis.RedisSupport
import redis.clients.jedis.JedisPool
import scalikejdbc.DB
import scalikejdbc.streams._

import scala.concurrent._

class TimelineAggregate(
    ec: ExecutionContext,
    tweetRepository: TweetRepository,
    _pool: JedisPool,
    _materializer: Materializer
) extends RedisSupport {
  import TwitterJsonSupport._

  lazy val pool: JedisPool                 = _pool
  implicit val publishEC: ExecutionContext = ec
  implicit val materializer: Materializer  = _materializer

  def pushTweetToRedisCache(userId: String)(tweet: Tweet): Unit =
    withJedis[Unit] {
      _.rpush(userId, tweetFormat.write(tweet).prettyPrint)
    }

  /**
   * タイムラインをキャッシュする
   * @param userId
   * @return
   */
  def dumpTweetToRedisCache(userId: String): Future[Done] = {
    val publisher: DatabasePublisher[Tweet] = DB readOnlyStream {
      tweetRepository.streamTimeline(userId)
    }
    Source.fromPublisher(publisher).runForeach(pushTweetToRedisCache(userId))
  }


}
