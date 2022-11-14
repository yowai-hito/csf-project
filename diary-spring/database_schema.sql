drop database if exists csf_project;

create database csf_project;

use csf_project;

create table users (
  account_id int IDENTITY(1,1) PRIMARY KEY,
  account_name varchar(64) UNIQUE,
  account_password varchar(64),
  account_role VARCHAR(8),
  account_handle varchar(64) UNIQUE
);

