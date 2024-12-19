# Empacotando a aplicação criando o build

# FROM maven:3.8.6-amazoncorretto-17 as build
#FROM maven:3.9.9-eclipse-temurin-17 as build


# WORKDIR /app
# COPY . .
# -DskipTests serve para pular a parte de teste na hora de buld
# RUN mvn clean package -DskipTests -X
# RUN mvn dependency:resolve -X

#Rodando o build criado

# Versão minificada do openjdk
# FROM openjdk:17-ea-10-jdk-slim

# Essa imagem do openjdk vai la para o workdir /app
# WORKDIR /app

#O listnestapi serve para mudar o nome do jar quando buildar para não ficar snapshot
# COPY --from=build ./app/target/*.jar ./jobwise.jar

# Execução da aplicação
# ENTRYPOINT ["java -jar ./jobwise.jar"]

#imagem maven 3.9.9 eclipse e JDK 22
FROM maven:3.9.9-eclipse-temurin-22-alpine AS build

# Copia todos os arquivos que esta no diretorio src para o diretorio src/
COPY ./src src/
COPY ./pom.xml pom.xml

# Essa linha compila o projeto roda os testes e gera o arquivo final.jar
RUN mvn clean verify -DskipTests

FROM eclipse-temurin:22-jre-alpine 

# Aponta para cima o build do projeto
COPY --from=build target/*.jar apprh.jar 

# Por padrão as aplicações spring roda na porta 8080
EXPOSE 8080

CMD ["java", "-jar", "apprh.jar"]