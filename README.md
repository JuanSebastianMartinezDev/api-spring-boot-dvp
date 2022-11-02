# api-spring-boot-dvp
Api creada en Spring Boot - prueba JAVA

Spring Boot 2.7.1
JAVA 7
MAVEN

#BASE DE DATOS - CREDENCIALES
host: db4free.net
port: 3306
name_database: database_spring
db_username: user_bd_spring
password: user_bd_spring

#REQUISITOS PARA EJECUTAR EN LOCAL
apache-maven-3.8.6
java jdk: 7

verificar que tengan configuradas las variables de entorno "%JAVA_HOME%" y "%MAVEN_HOME%"

luego en la raiz del proyecto ejecutar:

$ mvnw spring-boot:run

despues abrir puerto http://localhost:8080

#ENDPOINTS API

// get all tickets      -    GET http://localhost:8080/ticket                              
// get ticket by id     -    GET http://localhost:8080/ticket/:id                         
// delete ticket by id  -    DELETE http://localhost:8080/ticket/:id                        
// update ticket        -    POST http://localhost:8080/ticket/:id    bodyRequest:   {id: int, name: "", state: "", username:"",created_at: "" , updated_at: "" }
// save ticket          -    POST http://localhost:8080/ticket        bodyRequest:   {name: "", state: "", username:"",created_at: "" , updated_at: "" }                      


