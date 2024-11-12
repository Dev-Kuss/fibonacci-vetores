# Usa uma imagem Maven com uma versão padrão do JDK
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo pom.xml e outras configurações para o contêiner
COPY pom.xml .

# Baixa as dependências para acelerar builds subsequentes
RUN mvn dependency:go-offline -B

# Copia o código-fonte para o contêiner
COPY src ./src

# Limpa e constrói a aplicação
RUN mvn clean package -DskipTests

# Usa uma imagem do OpenJDK 21 para o ambiente de execução
FROM eclipse-temurin:21-jdk-jammy

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o JAR construído da fase de build
COPY --from=build /app/target/technicalTest-0.0.1-SNAPSHOT.jar app.jar

# Copia o código-fonte para o contêiner
COPY src ./src

# Copia o arquivo pom.xml para o contêiner
COPY pom.xml .

# Adiciona o Maven para recompilação
COPY --from=build /usr/share/maven /usr/share/maven
RUN ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# Expõe a porta 8080 para acesso à aplicação
EXPOSE 8080

# Define o perfil de desenvolvimento
ENV SPRING_PROFILES_ACTIVE=dev

# Executa a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005'", "app.jar"]
