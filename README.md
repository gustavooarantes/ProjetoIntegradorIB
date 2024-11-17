<div align="center">
  <h2>Estrutura inicial do projeto</h2>
  <p>A partir do site Spring Initializr, podemos gerar um modelo de projeto para ser aberto na IDE de escolha – que neste caso será o IntelliJ IDEA -, que irá conter a estrutura básica do projeto, as dependências instaladas e salvas no arquivo pom.xml, além das configurações iniciais para começar a desenvolver a aplicação.
    Seguem as principais características do projeto gerado para construção da API:</p>
  <ol>
    <li>Projeto Maven – O Apache Maven é uma ferramenta de automação de build e gerenciamento de projetos. Seu objetivo é simplificar o processo de construção do projeto através da padronização da estrutura do projeto, além de gerenciar as dependências de bibliotecas externas.</li>
    <li>Spring Web – permite a criação de APIs RESTful e aplicativos web MVC. Inclui o Spring MVC (framework para implementar a arquitetura Model-View-Controller), Embedded Tomcat (permite executar a aplicação como uma aplicação standalone) e Jackson (para serialização e desserialização de JSON).</li>
    <li>Spring Data JPA – facilita o acesso e manipulação de dados em um banco de dados relacional ao abstrair o código de acesso a dados, permitindo que o foco seja em torno das regras de negócio.</li>
    <li>MySQL Connector – é o driver que permite a aplicação Java se conectar a um banco de dados MySQL.</li>
    <li>Arquitetura monolítica – divisão em camadas, centralizando toda a lógica da aplicação em uma única API. As camadas são: models (representação das entidades do banco de dados), repositories (responsável pela comunicação com o banco de dados), 
      services (contém efetivamente as lógicas de negócio), controllers (define os endpoints da API REST) e DTOs (facilita a transferência de dados entre camadas).</li>
  </ol>
  <br>
  <hl></hl>
</div>
