DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  id       INT(10) PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(200),
  password VARCHAR(200),
  nickname VARCHAR(200)
);