# Usa uma imagem Maven com uma versão padrão do JDK
FROM maven:3.9.5-eclipse-temurin-21 AS build

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo pom.xml e outras configurações para o contêiner
COPY pom.xml .

# Baixa as dependências para acelerar builds subsequentes
RUN mvn dependency:go-offline -B

# Copia o código-fonte para o contêiner
COPY src ./src

# Constrói a aplicação
RUN mvn package -DskipTests

# Usa uma imagem do OpenJDK 21 para o ambiente de execução
FROM eclipse-temurin:21-jdk

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o JAR construído da fase de build
COPY --from=build /app/target/technicalTest-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080 para acesso à aplicação
EXPOSE 8080

# Executa a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
