CREATE DATABASE IF NOT EXISTS twitterclone2;

USE twitterclone2;

CREATE TABLE users(
  id varchar(36) PRIMARY KEY,
  name varchar(40),
  phoneNumber varchar(12),
  created_at timestamp DEFAULT CURRENT_TIMESTAMP,
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE tweets(
  id varchar(36) PRIMAY KEY,
  user_id varchar(40) NOT NULL,
  text varchar(255) NOT NULL,
  created_at timestamp DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY fk_user(user_id) REFERENCES users(id)
);

CREATE TABLE follows(
  followerId varchar(36),
  followeeId varchar(36),
  created_at timestamp DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY fk_follower(follower_id) REFERENCES users(id)
  FOREIGN KEY fk_Followee(followee_id) REFERENCES users(id)
);
