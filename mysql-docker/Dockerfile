FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root1234

ADD ./init /docker-entrypoint-initdb.d/

EXPOSE 3306

CMD ["mysqld"]