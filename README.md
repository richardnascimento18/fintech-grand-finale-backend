# 💻 Projeto Fintech - API de Gestão Financeira

Este repositório contém o **backend** do projeto desenvolvido para o curso de **Análise e Desenvolvimento de Sistemas na FIAP**.
O objetivo da aplicação é fornecer uma **API RESTful robusta e segura** para o gerenciamento financeiro pessoal, integrando-se ao frontend desenvolvido em Next.js.

---

## 🚀 Tecnologias Utilizadas

O backend foi desenvolvido com **Java + Spring Boot**, adotando boas práticas de arquitetura e segurança:

* **Java 17+** – Linguagem principal da aplicação
* **Spring Boot** – Framework para criação de aplicações Java modernas e modulares
* **Spring Data JPA** – Mapeamento e persistência de dados
* **Spring Security + JWT** – Autenticação e autorização seguras
* **Oracle Database** – Banco de dados relacional utilizado
* **Maven** – Gerenciador de dependências e build

---

## 🧠 Sobre o Projeto

A API é responsável por toda a **lógica de negócios e persistência de dados** do sistema de gestão financeira, oferecendo endpoints REST para:

* **Autenticação de usuários** (registro e login via JWT)
* **Gerenciamento de transações** (entradas e saídas)
* **Categorização de despesas e receitas**
* **Consulta de saldo e estatísticas financeiras**

Ao utilizar Arquitetura Hexagonal, o projeto foi projetado para ser **modular, escalável e segura**, garantindo comunicação fluida com o frontend em Next.js.

---

## 📂 Estrutura do Repositório

```
/src
 ├── main/
 │   ├── java/br/com/fiap/cashiq_backend/        # Código-fonte principal
 │   │   ├── controller/               # Controladores REST
 │   │   ├── dto/                      # Objetos de transferência de dados
 │   │   ├── model/                    # Entidades JPA
 │   │   ├── repository/               # Interfaces de persistência
 │   │   ├── service/                  # Regras de negócio
 │   │   └── security/                 # Configurações de autenticação JWT
 │   └── resources/
 │       ├── application.properties    # Configurações da aplicação
 │       └── schema.sql / data.sql     # Scripts de inicialização do banco
 └── test/                             # Testes unitários e de integração
```

---

## ⚙️ Como Executar Localmente

1. **Clone o repositório**

   ```bash
   git clone https://github.com/seu-usuario/fintech-backend.git
   ```

2. **Configure o banco de dados Oracle**

   Crie um schema no Oracle e atualize as credenciais no arquivo:

   ```
   src/main/resources/application.properties
   ```

   Exemplo:

   ```properties
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
   spring.datasource.username=fintech_user
   spring.datasource.password=senha123
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   jwt.secret=chave_secreta_segura
   ```

3. **Execute o projeto**

   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em:
   [http://localhost:8080](http://localhost:8080)

---

## 🔗 Integração com o Frontend

A API fornece os endpoints consumidos pelo frontend em **Next.js**, responsável pela interface do usuário.
Toda comunicação é feita via **JSON** e protegida por **tokens JWT** para autenticação segura.

---

## 👥 Autores

Projeto desenvolvido para o curso de **Análise e Desenvolvimento de Sistemas – FIAP**, com foco em **arquitetura de software**, **boas práticas backend** e **integração full-stack**.

---

## 📄 Licença

Este projeto é de uso acadêmico e pode ser utilizado como referência para estudos e aprimoramento técnico.

---

**FIAP | Análise e Desenvolvimento de Sistemas**
Desenvolvido com ☕ e hexagonal architecture.