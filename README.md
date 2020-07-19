# twitter-clone-akka
Twitter clone as practice of CQRS with Akka.[WIP]

## Requirements

- sbt
- Docker

## Clone

```
git clone https://github.com/higherkingpud/twitter-clone-akka.git
cd twitter-clone-akka
```

## Set up local environment

```.sh
docker-compose up -d
```

## Run (now only commandside available)

```.sh
git clone https://github.com/higherkingpud/twitter-clone-akka.git
cd twitter-clone-akka
sbt
sbt:twitter-clone-akka> project commandside
sbt:commandside>run
[info] Compiling 6 Scala sources to /Users/kijimayuutairou/hobby/twitter-clone2/target/scala-2.13/classes ...
[warn] 1 deprecation (since 2.6.0); re-run with -deprecation for details
[warn] one warning found
[info] running com.higherkingpud.twitterclone2.Main 
```

## commandside endpoint

- POST /users 
- POST /tweets
- POST /follows

## queryside endpoint

- GET /users/:userId/timeline (WIP)
