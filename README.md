# carmanual

start with docker-compose: \n
 docker-compose build \n
 docker-compose up \n

if you want start app without docker, change "db.default.url="jdbc:postgresql://pgdb:5432/" to "db.default.url="jdbc:postgresql://localhost:5432/" in conf/application.conf

standard app port: 9000 \n
port for adminer: 8080

/ - for main page with doc \n
/api - route for api
