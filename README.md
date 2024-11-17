<div align="center">
  <h1>Estrutura inicial do projeto</h1>
  <p>A partir do site Spring Initializr, podemos gerar um modelo de projeto para ser aberto na IDE de escolha – que neste caso será o IntelliJ IDEA -, que irá conter a estrutura básica do projeto, as dependências instaladas e salvas no arquivo pom.xml, além das configurações iniciais para começar a desenvolver a aplicação.
    Seguem as principais características do projeto gerado para construção da API:</p>
  <ul>
    <li>Projeto Maven – O Apache Maven é uma ferramenta de automação de build e gerenciamento de projetos. Seu objetivo é simplificar o processo de construção do projeto através da padronização da estrutura do projeto, além de gerenciar as dependências de bibliotecas externas.</li>
    <li>Spring Web – permite a criação de APIs RESTful e aplicativos web MVC. Inclui o Spring MVC (framework para implementar a arquitetura Model-View-Controller), Embedded Tomcat (permite executar a aplicação como uma aplicação standalone) e Jackson (para serialização e desserialização de JSON).</li>
    <li>Spring Data JPA – facilita o acesso e manipulação de dados em um banco de dados relacional ao abstrair o código de acesso a dados, permitindo que o foco seja em torno das regras de negócio.</li>
    <li>MySQL Connector – é o driver que permite a aplicação Java se conectar a um banco de dados MySQL.</li>
    <li>Arquitetura monolítica – divisão em camadas, centralizando toda a lógica da aplicação em uma única API. As camadas são: models (representação das entidades do banco de dados), repositories (responsável pela comunicação com o banco de dados), 
      services (contém efetivamente as lógicas de negócio), controllers (define os endpoints da API REST) e DTOs (facilita a transferência de dados entre camadas).</li>
  </ul>
  <br>
  <hr>
</div>

<div align="center">
  <h1>Modelos do banco de dados</h1>
  <h3>Modelo Conceitual e Diagrama ER</h3>
  <p>Genero: idGenero (PK), nomeGenero</p>
  <p>Autores: idAutor (PK), nomeAutor, dataNascimentoAutor, nacionalidadeAutor</p>
  <p>Editoras: idEditora (PK), nomeEditora, paisEditora</p>
  <p>Usuarios: idUsuario (PK), nomeUsuario, emailUsuario, enderecoUsuario, dataCadastroUsuario, telefoneUsuario</p>
  <p>Livros: idLivro (PK), idGenero (FK - referencia Generos), idEditora (FK - referencia Editoras), idAutor (FK - referencia Autores), tituloLivro, dataPublicacaoLivro, quantidadeDisponivelLivro, statusReservaLivro, statusEmprestimoLivro</p>
  <p>Reservas: idReserva (PK), idUsuario (FK - referencia Usuarios), idLivro (FK - referencia Livros), statusReserva, dataReserva</p>
  <p>Emprestimos: idEmprestimo (PK), idUsuario (FK - referencia Usuarios), idLivro (FK - referencia Livros), dataEmprestimo, statusEmprestimo</p>
  <img src="https://github.com/gustavooarantes/ProjetoIntegradorIB/blob/master/Modelos%20-%20Projeto%20Integrador/Diagrama%20ER.png">
  <p>Errata: na entidade "Reservas", os atributos acima da entidade deveriam ser statusReserva e dataReserva.</p>
  <br>
  <h3>Modelo Lógico</h3>
  <img src="https://github.com/gustavooarantes/ProjetoIntegradorIB/blob/master/Modelos%20-%20Projeto%20Integrador/Modelo%20L%C3%B3gico.png">
  <br>
  <h3>Modelo Físico</h3>
  <img src="https://github.com/gustavooarantes/ProjetoIntegradorIB/blob/master/Modelos%20-%20Projeto%20Integrador/Primeira%20parte%20modelo%20f%C3%ADsico.png">
  <img src="https://github.com/gustavooarantes/ProjetoIntegradorIB/blob/master/Modelos%20-%20Projeto%20Integrador/Segunda%20parte%20modelo%20f%C3%ADsico.png">
  <img src="https://github.com/gustavooarantes/ProjetoIntegradorIB/blob/master/Modelos%20-%20Projeto%20Integrador/Terceira%20parte%20modelo%20f%C3%ADsico.png">
  <p>Erratas: na linha 34, após DATE não deveria estar presenta a palavra "Usuarios"; nas linhas 47 e 48, o tipo de dados foi deveria ser TINYINT (a query foi corrigida e o programa executado normalmente após, como é mostrado no vídeo)</p>
  <img src="https://github.com/gustavooarantes/ProjetoIntegradorIB/blob/master/Modelos%20-%20Projeto%20Integrador/Quarta%20parte%20modelo%20f%C3%ADsico.png">
  <br>
  <hr>
</div>

<div align="center">
  
</div>
