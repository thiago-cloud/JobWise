# Aplicação JobWise

Status: Desenvolvedor ⚠️

JobWise é uma aplicação ERP de gerenciamento de recursos humanos (RH) desenvolvida em Spring Boot e Thymeleaf com Bootstrap 5. Com uma interface amigável, o JobWise oferece funcionalidades completas de CRUD para simplificar o gerenciamento de vagas, funcionários e dependentes. A aplicação permite o cadastro de novas vagas, a criação de perfis de funcionários e a inclusão de informações sobre seus dependentes, tudo em um ambiente seguro e fácil de navegar.

O JobWise inclui autenticação robusta com Spring Security, garantindo acesso restrito e seguro aos dados da empresa. Além disso, a aplicação permite a listagem e visualização de vagas e funcionários, fornecendo detalhes individuais de cada funcionário para facilitar o acompanhamento e a gestão de equipe.

## Tecnologias Utilizadas

- **Backend:**  <a href="https://spring.io/projects/spring-boot">Spring-Boot3</a> (Incluindo a dependência Spring-Security6.1 com JWT para fazer autenticação de usuário) e Banco de dados <a href="https://www.mysql.com/downloads/">Mysql</a>.
- **Frontend:** <a href="https://www.thymeleaf.org/documentation.html">Thymeleaf</a> (Motor de Template) e <a href="https://getbootstrap.com/">Bootstrap5</a>.

## Pré-requisitos

- **Eclipse IDE ou INTELLIJ:** Essas duas IDE são ótimas para rodar a aplicação Spring Boot, porém você pode ficar a vontade e escolher outras, referencie essas duas porque elas foram criadas especificamente para executar aplicações de java.
- **Java:** E necessário instalar o JRE do java que serve para executar aplicações de java, se você quiser desenvolver em cima deste código e necessário a instalação do JDK que é responsável pela execução do ambiente de desenvolvimento java.
- **MySQL:** É necessário ter um banco de dados instalado porque servirá para as operações de CRUD da aplicação não precisa ser o MySQL pode ser o seu banco de dados de sua preferência, porém se for outro banco de dados que não seja o MySQL será necessário entrar em application.properties e na classe DataConfiguration e alterar o dialeto ``MySQLDialect`` do banco para o dialeto do seu banco de dados.
  
## Estrutura do Repositório

 **MVC:** Esse projeto e baseado no padrão de arquitetura de software MVC(Model, View e Controller). 
- **src/java/com/appRH/appRH/models:** O pacote model armazena todas as entidades, como Candidato, Dependente, Funcionário e Vaga, que são mapeadas para tabelas no banco de dados.
- **src/java/com/appRH/appRH/controller:** O pacote controller centraliza os arquivos responsáveis por implementar a lógica de busca (buscaController) e os métodos de CRUD para funcionários (funcionarioController) e vagas (vagaController).
- **src/java/com/appRH/appRH/repository:** A camada de persistência de dados, utilizando o padrão do Spring, permite um acesso facilitado e eficiente ao banco de dados, com suporte a armazenamento em cache para melhorar o desempenho. Essa camada centraliza operações de leitura, escrita e armazenamento, facilitando a integração com diferentes fontes de dados.
- **src/java/com/appRH/appRH/WebConfig.java:** O WebConfig é responsável por configurar o Spring Security, definindo regras de autenticação e autorização para proteger a aplicação.
- **src/main/resources/templates:** Essa camada é responsável pelas views da aplicação, renderizadas com o motor de template Thymeleaf, permitindo a criação de páginas dinâmicas e interativas para o usuário final.
- **src/main/resources/static:** A camada static é responsável por armazenar bibliotecas de frontend, como Bootstrap, e outros recursos estáticos usados na interface da aplicação.
- **src/main/resources/application.properties:** O arquivo application.properties contém as configurações do banco de dados, sendo essencial para leitura e conexão ao banco durante o deploy, como no Heroku. Embora a classe DataConfiguration também configure o banco, o application.properties é mais legível e recomendável para deploys, pois facilita ajustes e integrações.
- **README.md:** Este arquivo.

## Como Executar

1. Clone o projeto ou faça um fork
2. No Eclipse, selecione File > Import > Maven > Existing Maven Projects, escolha o pom.xml e finalize; depois, clique com o botão direito em AppRh.Application.java, escolha Run As > Java Application e abra ``localhost:8080`` no navegador para acessar o projeto.
3. Configure a conexão com o banco de dados ajustando o DataConfiguration.java e o application.properties, inserindo seu usuário e senha em ``dataSource.setUsername`` e ``dataSource.setPassword``, e definindo o dialeto em ``adapter.setDatabasePlatform``.
4. Agora você verá uma tela de login para acessar o projeto; para acesso de usuário, use user: ``thiago`` e password: ``thiago``; para acesso de administrador, use user: ``root`` e password: ``root``.

