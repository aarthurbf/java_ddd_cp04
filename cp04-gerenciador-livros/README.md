CP04 - Gerenciador de Livros (Spring Boot)
--------------------------------------------------

Estrutura: pacote base `com.arthur.biblioteca`.

Requisitos:
- Java 17+
- Maven

Endpoints úteis:
- Aplicação: http://localhost:8080/
- H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:biblioteca)

Observações:
- O projeto usa H2 em memória e inclui um `script.sql` para popular alguns livros e usuários.
- As views usam Thymeleaf + Bootstrap via CDN.
