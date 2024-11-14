
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

## 🎯 Endpoints e Inputs

### Fibonacci Controller
- GET `/api/fibonacci/verificar/{numero}`
  - Input: número (path variable)
  - Output:
    ```json
    {
      "numero": 34,
      "pertence": true,
      "sequencia": [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
    }
    ```

- GET `/api/fibonacci/sequencia/{limite}`
  - Input: limite (path variable)
  - Output: `[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]`

### Soma Controller
- GET `/api/soma`
  - Input: nenhum
  - Output: `91` (número)

- GET `/api/soma/detalhado`
  - Input: nenhum
  - Output:
    ```text
    Iteração 1: K = 1, SOMA = 1
    Iteração 2: K = 2, SOMA = 3
    ...
    Iteração 13: K = 13, SOMA = 91
    ```

### Faturamento Controller
- GET `/api/faturamento/estatisticas`
  - Input: nenhum
  - Output:
    ```json
    {
      "menorValor": 373.7838,
      "maiorValor": 48924.2448,
      "mediaMensal": 20865.37,
      "diasAcimaMedia": 10
    }
    ```

- GET `/api/faturamento/dias-acima-media`
  - Input: nenhum
  - Output:
    ```json
    [
      {
        "dia": 1,
        "valor": 22174.1664
      },
      {
        "dia": 2,
        "valor": 24537.6698
      }
    ]
    ```

### Distribuição Controller
- GET `/api/distribuicao`
  - Input: nenhum
  - Output:
    ```json
    [
      {
        "estado": "SP",
        "valor": 67836.43,
        "percentual": 37.53
      },
      {
        "estado": "RJ",
        "valor": 36678.66,
        "percentual": 20.29
      }
    ]
    ```

### Inversão Controller
- POST `/api/inversao`
  - Input: texto (raw text)
    ```text
    Hello World
    ```
  - Output:
    ```json
    {
      "textoOriginal": "Hello World",
      "textoInvertido": "dlroW olleH"
    }
    ```

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
│   │       ├── TechnicalTestApplication.java
│   │       ├── controller/
│   │       │   ├── DistribuicaoController.java
│   │       │   ├── FaturamentoController.java
│   │       │   ├── FibonacciController.java
│   │       │   ├── InversaoController.java
│   │       │   └── SomaController.java
│   │       ├── dto/
│   │       │   ├── DistribuicaoDTO.java
│   │       │   ├── FaturamentoDTO.java
│   │       │   ├── FibonacciDTO.java
│   │       │   └── InversaoDTO.java
│   │       ├── exception/
│   │       │   └── FaturamentoNotFoundException.java
│   │       ├── model/
│   │       │   ├── Distribuicao.java
│   │       │   └── Faturamento.java
│   │       ├── repository/
│   │       │   ├── DistribuicaoRepository.java
│   │       │   └── FaturamentoRepository.java
│   │       ├── service/
│   │       │   ├── DistribuicaoService.java
│   │       │   ├── FaturamentoService.java
│   │       │   ├── FibonacciService.java
│   │       │   ├── InversaoService.java
│   │       │   └── SomaService.java
│   │       └── util/
│   │           └── FaturamentoMapper.java
│   └── resources/
│       ├── application.properties
│       └── db/
│           └── migration/
│               └── V1_insert_faturamento_e_distribuicao_data.sql
├── test/
│   └── java/
│       └── com/example/technicalTest/
│           └── TechnicalTestApplicationTests.java
├── Dockerfile
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## 🤝 Contribuindo

1. Fork o projeto
2. Crie sua branch de feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'feat: adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request