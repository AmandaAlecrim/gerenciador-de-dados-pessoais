# Gerenciador de Dados Pessoais (API REST)

Projeto de **API REST** desenvolvido como **teste técnico**, com foco em **CRUD de Pessoas e Endereços**, utilizando **Java 17**, **Spring Boot 3**, **Spring Data JPA** e **H2 (em memória)**.

### Resumo curricular do projeto
- **Objetivo**: entregar uma API REST enxuta para cadastro e manutenção de pessoas e seus endereços, incluindo consulta do **endereço principal** por pessoa.
- **Entregas (features)**:
  - CRUD completo de `Pessoa`
  - CRUD completo de `Endereco`
  - Relacionamento **1:N** (`Pessoa` → `Endereco`)
  - Endpoint para **obter o endereço principal** de uma pessoa
  - Banco **H2 em memória** com **console habilitado**
- **Competências demonstradas (o que este projeto evidencia no currículo)**:
  - API REST com Spring MVC (controllers, verbos HTTP e rotas)
  - Persistência com JPA/Hibernate (mapeamento de entidades e relacionamento 1:N)
  - Spring Data repositories (`JpaRepository`) e operações de CRUD
  - Serialização JSON com prevenção de ciclo (`@JsonIgnore`)
  - Configuração de banco e tooling (H2 console, SQL log, Actuator)

### Stack e requisitos
- **Linguagem**: Java 17
- **Framework**: Spring Boot 3.0.2
- **Persistência**: Spring Data JPA + Hibernate
- **Banco**: H2 (runtime, em memória)
- **Build**: Maven
- **Módulo**: `gerenciadordepessoas/`

### Arquitetura (estrutura do código)
O projeto está organizado em um modelo simples por responsabilidade:
- **`entities/`**: entidades JPA (`Pessoa`, `Endereco`)
- **`repositories/`**: interfaces Spring Data (`PessoaRepository`, `EnderecoRepository`)
- **`resources/`**: controllers REST (`PessoaResource`, `EnderecoResource`)

### Modelos (domínio)
- **Pessoa**
  - `id: Long`
  - `name: String`
  - `nascimento: String`
  - `enderecos: List<Endereco>`
- **Endereco**
  - `id: Long`
  - `logradouro: String`
  - `cep: int`
  - `numero: int`
  - `cidade: String`
  - `principal: boolean`
  - `pessoa: Pessoa` (many-to-one)

### Endpoints
Base URL local (padrão do Spring Boot): `http://localhost:8080`

#### Pessoas
- **GET** `/pessoas`  
  Lista todas as pessoas.
- **GET** `/pessoas/{id}`  
  Busca pessoa por id.
- **POST** `/pessoas`  
  Cria pessoa.
- **PUT** `/pessoas`  
  Atualiza pessoa (quando `id > 0`).
- **DELETE** `/pessoas/{id}`  
  Remove pessoa.
- **GET** `/pessoas/{id}/principal`  
  Retorna o **endereço principal** da pessoa (o primeiro marcado com `principal=true`).

#### Endereços
- **GET** `/enderecos`  
  Lista todos os endereços.
- **GET** `/enderecos/{id}`  
  Busca endereço por id.
- **POST** `/enderecos`  
  Cria endereço.
- **PUT** `/enderecos`  
  Atualiza endereço (quando `id > 0`).
- **DELETE** `/enderecos/{id}`  
  Remove endereço.

### Qualidade e suporte operacional
- **Testes**: projeto contém teste de contexto do Spring (`@SpringBootTest`) garantindo que a aplicação sobe com o wiring básico.
- **Observabilidade**: dependência do **Spring Boot Actuator** incluída no projeto (facilita evolução para health/metrics em ambiente).
- **Banco de dados**: H2 em memória (adequado para teste técnico e execução local sem infraestrutura externa).

### Observações
- **Persistência em memória**: ao reiniciar a aplicação, os dados são perdidos (H2 `mem`).
- **Camada de serviço/validações**: o código atual foca no fluxo direto controller → repository; pode ser evoluído com DTOs, validações (`jakarta.validation`) e tratamento de erros (ex.: `@ControllerAdvice`) conforme necessidade.
