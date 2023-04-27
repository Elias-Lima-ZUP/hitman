# Comando para iniciar mysql db
docker run -e MYSQL_USER=hitman -e MYSQL_PASSWORD=hitman -e MYSQL_DATABASE=hitman-db -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 mysql

# Comando para iniciar mysql db com volume
docker run -p 3306:3306 -e MYSQL_USER=hitman -e MYSQL_PASSWORD=hitman -e MYSQL_DATABASE=hitman-db -e MYSQL_ROOT_PASSWORD=password --volume db-data-volume:/app mysql