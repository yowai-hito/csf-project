drop database if exists csf_project;

create database csf_project;

use csf_project;

create table users (
  account_id int IDENTITY(1,1) PRIMARY KEY,
  account_name varchar(64) UNIQUE,
  account_password varchar(64),
  account_role VARCHAR(8),
  account_handle varchar(64) UNIQUE,

);

create table chatrooms {
  chatroom_id binary(16) PRIMARY KEY,
  chatroom_name varchar(64), 
}

create table chatroom_users (
  chatroom_id binary(16),
  account_id int NOT NULL,

  CONSTRAINT fk_account_id
    FOREIGN KEY (account_id) REFERENCES users(account_id),
  CONSTRAINT fk_chatroom_id
    FOREIGN KEY (chatroom_id) REFERENCES chatrooms(chatroom_id)
)