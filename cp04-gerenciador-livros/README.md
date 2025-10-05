CP04 - Gerenciador de Livros (Spring Boot - Gradle)
--------------------------------------------------

Estrutura: pacote base `com.arthur.biblioteca`.

Requisitos:
- Java 17+
- Gradle (ou use o Gradle instalado no sistema)

Como rodar (usando Gradle instalado):
1. Vá para a pasta do projeto:
   cd cp04-gerenciador-livros
2. Rode:
   gradle bootRun

Alternativamente, importe o projeto em uma IDE (IntelliJ/STS/Eclipse) e rode a classe:
com.arthur.biblioteca.BibliotecaApplication

Endpoints úteis:
- Aplicação: http://localhost:8080/
- H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:biblioteca)

Observações:
- O projeto usa H2 em memória e inclui um `data.sql` para popular alguns livros e usuários.
- As views usam Thymeleaf + Bootstrap via CDN.
