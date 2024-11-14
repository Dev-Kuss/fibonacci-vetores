

```markdown
# Technical Test API

API REST desenvolvida em Java com Spring Boot para resolução de desafios técnicos.

## 🚀 Tecnologias

- Java 21
- Spring Boot 3
- PostgreSQL
- Docker
- Swagger/OpenAPI

## 📋 Pré-requisitos

- Docker e Docker Compose
- Java 21 (opcional, apenas para desenvolvimento local)
- Maven (opcional, apenas para desenvolvimento local)

## 🔧 Instalação e Execução

### Usando Docker (Recomendado)
```
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/technical-test.git
cd technical-test/java
```

2. Execute com Docker Compose:
```bash
docker compose up --build
```

A API estará disponível em `http://localhost:8080`

### Desenvolvimento Local

1. Configure o PostgreSQL:
```bash
docker compose up -d postgres
```

2. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

## 📚 Documentação da API

A documentação Swagger está disponível em:
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/api-docs

## 🛠️ Endpoints

### Fibonacci
- GET `/api/fibonacci/verificar/{numero}` - Verifica se um número pertence à sequência
- GET `/api/fibonacci/sequencia/{limite}` - Gera sequência até o limite

### Soma
- GET `/api/soma` - Calcula soma sequencial
- GET `/api/soma/detalhado` - Mostra processo detalhado

### Faturamento
- GET `/api/faturamento/estatisticas` - Retorna estatísticas de faturamento
- GET `/api/faturamento/dias-acima-media` - Lista dias acima da média

### Distribuição
- GET `/api/distribuicao` - Calcula percentual por estado

### Inversão
- POST `/api/inversao` - Inverte caracteres de um texto

## 🧪 Testes

Execute os testes com:
```bash
./mvnw test
```

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/technicalTest/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── db/migration/
│       └── application.properties
└── test/
```

## 🤝 Contribuindo

1. Fork o projeto
2. Crie sua branch de feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'feat: adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request