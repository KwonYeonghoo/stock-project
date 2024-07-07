CREATE DATABASE IF NOT EXISTS nasdaq_db; -- nasdaq_db 생성

USE nasdaq_db;

CREATE USER IF NOT EXISTS 'hoo'@'%' IDENTIFIED BY 'hoo1234'; -- 사용자 생성
GRANT ALL PRIVILEGES ON nasdaq_db.* TO 'hoo'@'%'; -- hoo사용자에게 nasdaq_db에 대한 모든 권한을 부여
FLUSH PRIVILEGES; -- 권한 변경사항 적용