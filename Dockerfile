# Empacotando a aplicação criando o build

# FROM maven:3.8.6-amazoncorretto-17 as build
FROM maven:3.9.9-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
# -DskipTests serve para pular a parte de teste na hora de buld
 RUN mvn clean package -DskipTests -X
 # RUN mvn dependency:resolve -X

#Rodando o build criado

# Versão minificada do openjdk
FROM openjdk:17-ea-10-jdk-slim

# Essa imagem do openjdk vai la para o workdir /app
WORKDIR /app

#O listnestapi serve para mudar o nome do jar quando buildar para não ficar snapshot
COPY --from=build ./app/target/*.jar ./jobwise.jar

# Execução da aplicação
ENTRYPOINT ["java -jar ./jobwise.jar"]