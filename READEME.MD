# API de Dados Parlamentares

Esta é uma API RESTful desenvolvida em Java com Spring Boot para gerenciar informações sobre deputados, proposições, votações, despesas e votos, baseada em um modelo de dados relacional.

O objetivo principal do sistema é registrar e consultar dados sobre a atividade parlamentar, garantindo a integridade e o relacionamento correto entre as diferentes entidades.

## Pré-requisitos

- Java 11 ou superior
- Maven 4.0.0+ ou Gradle 7.0+
- Um banco de dados SQL (como PostgreSQL, MySQL ou H2 para testes)

## Como Executar

1. Clone o repositório:
   ```bash
   git clone <url-do-seu-repositorio>
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd Deputados
   ```
3. Configure as credenciais do seu banco de dados no arquivo `src/main/resources/application.properties`.
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
A API estará disponível em `http://localhost:8080`.

---

## Documentação da API: Rotas de Criação (POST)

Esta seção detalha como utilizar cada rota `POST` para criar novos registros no sistema.

### 1. Criar Deputado e Votação

Deputados e Votações são entidades independentes e devem ser criadas primeiro, pois outras entidades dependerão de seus IDs.

#### a) Criar um Deputado

- **Endpoint:** `POST /api/deputados`
- **Descrição:** Registra um novo deputado no sistema.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "nomeCivil": "Maria Souza",
    "siglaPartido": "PDS",
    "siglaUf": "SP",
    "urlFoto": "[http://example.com/foto_maria.jpg](http://example.com/foto_maria.jpg)"
  }
  ```
- **Como Funciona:**
  1. O servidor recebe o JSON e o converte em um objeto `Deputado`.
  2. O `DeputadoService` salva o objeto no banco de dados.
  3. Uma nova `id` é gerada automaticamente pelo banco.
  4. A API retorna o objeto `Deputado` completo, incluindo a nova `id`, com o status `201 Created`.

#### b) Criar uma Votação

- **Endpoint:** `POST /api/votacoes`
- **Descrição:** Registra uma nova sessão de votação que ocorreu.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "data": "2025-10-20T14:30:00",
    "resumo": "Votação da Reforma Administrativa - Turno 1"
  }
  ```
- **Como Funciona:**
  1. O servidor recebe o JSON e o converte em um objeto `Votacao`.
  2. O `VotacaoService` salva o objeto no banco de dados.
  3. A API retorna o objeto `Votacao` completo, incluindo a nova `id`, com o status `201 Created`.

---

### 2. Criar Entidades Dependentes

Estas rotas exigem que os IDs das entidades relacionadas (como Deputado ou Votação) já existam no banco de dados.

#### a) Criar uma Proposição (associada a um autor)

- **Endpoint:** `POST /api/proposicao`
- **Descrição:** Registra uma nova proposição (ex: Projeto de Lei) e a associa a um deputado existente como seu autor.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "siglaTipo": "PL",
    "ementa": "Projeto de Lei que institui o programa de incentivo à leitura.",
    "statusDescricaoSituacao": "Aguardando Pauta na Comissão de Educação",
    "autor": {
      "id": 1 
    }
  }
  ```
- **Como Funciona:**
  1. O servidor recebe o JSON e extrai o ID do autor (`1`).
  2. **Validação:** O `ProposicaoController` utiliza o `DeputadoService` para verificar se um deputado com `id=1` existe no banco de dados.
  3. **Se o deputado não existir**, a API retorna um erro `400 Bad Request`, pois não é possível criar uma proposição sem um autor válido.
  4. **Se o deputado existir**, o objeto `Deputado` completo é associado à nova `Proposicao`.
  5. O `ProposicaoService` salva a proposição, que agora tem uma referência de chave estrangeira correta para o autor.
  6. A API retorna o objeto `Proposicao` criado com o status `201 Created`.

#### b) Criar uma Despesa (associada a um deputado)

- **Endpoint:** `POST /api/despesas`
- **Descrição:** Registra uma nova despesa e a associa a um deputado existente.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "dataDocumento": "2025-09-15",
    "tipoDespesa": "PASSAGEM AÉREA - Cia Aérea",
    "valorLiquido": 1250.75,
    "deputado": {
      "id": 1
    }
  }
  ```
- **Como Funciona:**
  1. O servidor recebe o JSON e extrai o ID do deputado (`1`).
  2. **Validação:** O `DespesaController` utiliza o `DeputadoService` para verificar se um deputado com `id=1` existe.
  3. **Se o deputado não existir**, a API retorna um erro `400 Bad Request`.
  4. **Se o deputado existir**, o objeto `Deputado` completo é associado à nova `Despesa`.
  5. O `DespesaService` salva a despesa no banco de dados.
  6. A API retorna o objeto `Despesa` criado com o status `201 Created`.

#### c) Criar um Voto (associado a um deputado e a uma votação)

- **Endpoint:** `POST /api/votos`
- **Descrição:** Registra o voto de um deputado específico em uma sessão de votação específica. Esta é a operação mais complexa, pois depende de duas entidades.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "voto": "Sim",
    "deputado": {
      "id": 1
    },
    "votacao": {
      "id": 101
    }
  }
  ```
- **Como Funciona:**
  1. O servidor recebe o JSON e extrai o ID do deputado (`1`) e o ID da votação (`101`).
  2. **Validação Dupla:** O `VotoController` realiza duas verificações:
     - Usa o `DeputadoService` para confirmar que o deputado com `id=1` existe.
     - Usa o `VotacaoService` para confirmar que a votação com `id=101` existe.
  3. **Se qualquer um dos dois não existir**, a API retorna um erro `400 Bad Request` para garantir a integridade dos dados.
  4. **Se ambos existirem**, os objetos `Deputado` e `Votacao` completos são associados ao novo `Voto`.
  5. O `VotoService` salva o voto, criando as duas referências de chave estrangeira.
  6. A API retorna o objeto `Voto` criado com o status `201 Created`.

---

## Tecnologias Utilizadas

* **Java 11**: Linguagem de programação.
* **Spring Boot**: Framework principal para criação da API REST.
* **Spring Data JPA**: Para persistência de dados de forma simplificada.
* **Hibernate**: Implementação da especificação JPA.
* **Maven**: Gerenciador de dependências e build do projeto.
* **H2 / PostgreSQL**: Banco de dados relacional.