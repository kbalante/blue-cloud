/* Data Definition Language */
create database bluecloud;

drop table bluecloud.user;
CREATE TABLE bluecloud.user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(500) NULL,
  email VARCHAR(100) NOT NULL,
  password_encrypted VARCHAR(100) NOT NULL,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (id)
);

drop table bluecloud.reminder;
CREATE TABLE bluecloud.reminder (
  id BIGINT NOT NULL AUTO_INCREMENT,
  type VARCHAR(50) NOT NULL,
  description TEXT NOT NULL,
  priority VARCHAR(100) NULL,
  status VARCHAR(100) NOT NULL,
  label VARCHAR(100) NULL,
  sequence SMALLINT NOT NULL,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (id)
);

CREATE TABLE bluecloud.project (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  project_key VARCHAR(5) NOT NULL,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (id)
);

CREATE TABLE bluecloud.task (
  id BIGINT NOT NULL AUTO_INCREMENT,
  project_id BIGINT NOT NULL,
  summary VARCHAR(1000) NOT NULL,
  description TEXT NULL,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (id)
);

CREATE TABLE bluecloud.comment (
  id BIGINT NOT NULL AUTO_INCREMENT,
  project_id BIGINT NOT NULL,
  description TEXT NOT NULL,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (id)
);