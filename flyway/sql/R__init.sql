CREATE DATABASE IF NOT EXISTS twitterclone2;

USE twitterclone2;

CREATE TABLE users(
  id varchar(36) PRIMARY KEY,
  name varchar(40),
  phone_number varchar(12),
  created_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tweets(
  id varchar(36) PRIMARY KEY,
  user_id varchar(40) NOT NULL,
  text varchar(255) NOT NULL,
  created_at timestamp DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY fk_user(user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE follows(
  follower_id varchar(36),
  followee_id varchar(36),
  created_at timestamp DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(follower_id, followee_id),
  FOREIGN KEY fk_follower(follower_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY fk_Followee(followee_id) REFERENCES users(id) ON DELETE CASCADE
);
