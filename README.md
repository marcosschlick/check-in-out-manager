# Check In Out Manager

## Sobre o projeto
Sistema para registro e gestão de check-in/check-out de pessoas usando CPF ou cédula uruguaia como identificador.  
Desenvolvido com Java Spring seguindo arquitetura em camadas.

## Tecnologias principais
- **Spring Boot**
- **Spring Security** (autenticação e criptografia BCrypt)
- **Spring Data JPA** (persistência de dados)
- **MariaDB** (banco de dados principal)
- **Flyway** (controle de migrações do banco)
- **Lombok** (redução de boilerplate code)
- **Springdoc OpenAPI** (documentação de APIs - Swagger)
- **H2 Database** (banco em memória para testes)
- **Maven** (gerenciamento de dependências)

## Como executar
1. Configure variáveis de ambiente no `.env` (exemplo no .env.example)
2. Suba o banco de dados:
```bash
podman compose up -d
```
3. Execute a aplicação:
```bash
mvn clean spring-boot:run
```

## Documentação da API
Acessível via Swagger UI após subir a aplicação:  
`http://localhost:8080/swagger-ui.html`
