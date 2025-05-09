# Workshop API – RESTful Back-end

API RESTful desenvolvida com Spring Boot e MongoDB para gerenciar usuários, publicações e comentários, com funcionalidades de busca e tratamento global de exceções.

## • Funcionalidades
• Operações CRUD de usuários (Criar, Ler, Atualizar, Excluir)  
• Operações CRUD de publicações com comentários incorporados  
• Busca por título e busca textual completa  
• Tratamento global de exceções para recursos não encontrados

## • Tecnologias Utilizadas
• Java 17+  
• Spring Boot  
• Spring Data MongoDB  
• MongoDB  
• Lombok  
• Maven

## • Como Executar
1. Clone o repositório e acesse a pasta:
   ```bash
   git clone https://github.com/joaoVitorLeal/spring-mongo-workshop-api.git
   # Em seguida:
   cd spring-mongo-workshop-api/workshop-api
    ```
2. Configure a conexão com o MongoDB em `src/main/resources/application.properties` (padrão: `mongodb://127.0.0.1:27017/workshop_mongo`).
3. Execute o projeto com Maven:
    ```bash
    mvn spring-boot:run
    ```
4. A API estará disponível em `http://localhost:8080`.

### • Endpoints Principais

#### Users
- `GET /users` Retorna todos os usuários.

- `GET /users/{id}` Retorna um usuário específico pelo ID.

- `POST /users` Cria um novo usuário.

- `PUT /users/{id}` Atualiza os dados de um usuário existente.

- `DELETE /users/{id}` Remove um usuário pelo ID.

- `GET /users/{id}/posts` Retorna todos os posts associados a um usuário.

#### Posts
- `GET /posts/{id}` Retorna um post específico pelo ID.

- `GET /posts/title-search?text={texto}` Busca posts por título com correspondência parcial.

- `GET /posts/full-search?text={texto}&minDate={yyyy-MM-dd}&maxDate={yyyy-MM-dd}` Realiza busca avançada com filtros textuais e de data inicial e final.
