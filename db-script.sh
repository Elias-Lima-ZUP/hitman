# Comando para iniciar mysql db
docker run -p 3306:3306 --name mysql -e MYSQL_USER=hitman -e MYSQL_PASSWORD=hitman -e MYSQL_DATABASE=hitman-db -e MYSQL_ROOT_PASSWORD=password mysql

# Comando para iniciar mysql db com volume
docker run -p 3306:3306 --name mysql -e MYSQL_USER=hitman -e MYSQL_PASSWORD=hitman -e MYSQL_DATABASE=hitman-db -e MYSQL_ROOT_PASSWORD=password --volume db-data-volume:/var/lib/mysql mysql

# Comandos para inspecionar um container
docker inspect mysql

docker stats mysql

docker top mysql

# Comandos para parar e remover um container
docker stop mysql

docker rm mysql