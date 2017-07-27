drop table if exists user;

create table user (
  id integer identity primary key,
  username varchar(25) not null,
  password varchar(25) not null,
  fullName varchar(100) not null,
  email varchar(50) not null,
  status varchar(10) not null,
  addtime datetime not null,
  updatetime datetime not null
);

