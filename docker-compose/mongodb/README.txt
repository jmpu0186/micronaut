
1. docker exec -it ID_CONTAINER -u root
2. use micronaut
3. Digitar el comando siguiente comando para crear usuario admin para el database micronaut
db.createUser(
  {
    user: "admin",
    pwd: "admin",
    roles: [ { role: "readWrite", db: "micronaut" } ]
  }
)
4. docker exec -it ID_CONTAINER mongo -u admin --authenticationDatabase micronaut