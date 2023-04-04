<h1>Conhecendo o Projeto Spring Data JPA na Prática </h1>
<p> Sejam bem-vindos ao projeto de LAB <strong>Conhecendo o Projeto Spring Data JPA na Prática</strong> oferecido gratuitamente pela plataforma de cursos online <a href="https://dio.me/"><strong> Digital Innovation One</strong></a>.<br>

<h2>🎯 Objetivo do Projeto</h2>
<p>Ao final deste projeto, o Dev irá conhecer os principais conceitos de mapeamento objeto relacional (ORM) usando o <strong>Spring Data JPA</strong>. Para isso, uma <strong>API RESTful</strong> será desenvolvida com ênfase na modelagem de suas entidades, no domínio de uma academia de ginástica.</p>

<h2>
🛑 Pré-requistos
</h2>

- [x] Fundamentos do Spring Boot

- [x] Noções de SQL

<h2> 🚦 Guia </h2>

<ol>
    <li> Apresentação do Projeto Base </li>
    <li> Configuração do banco de dados (SGBD <em>PostgreSQL</em>)</li>
    <li> Aplicando as <em>annotations</em></li>
    <li> Execução do fluxo back-end: <em>Controller - Service - Repository</em></li>
    <li> Validação - <em>Hibernate Validator</em> </li>
    <li> Consultas Avançadas - <em>Derived Query - Native Query</em></li>
</ol>

<h2>🛠 Tecnologias Utilizadas</h2>

<ul>
    <li>IDE IntelliJ</li>
    <li>Java 11</li>
    <li>Maven</li>
    <li><strong>Spring Web</strong></li>
    <li><strong>Spring Data JPA</strong></li>
    <li><strong>PostgreSQL Driver</strong></li>
    <li><strong>Hibernate Validator</strong></li>
    <li>Lombok</li>
    <li>Postman</li>
</ul>


<h2><a href="https://strn.com.br/artigos/2018/12/11/todas-as-anota%C3%A7%C3%B5es-do-jpa-anota%C3%A7%C3%B5es-de-mapeamento/">
Anotações de Mapeamento </a></h2>

<strong>@Entity</strong>
Usada para especificar que a classe anotada atualmente representa um tipo de entidade.

<strong>@Table</strong>
Usada para especificar a tabela principal da entidade atualmente anotada.

<strong>@Id</strong>
Especifica o identificador da entidade. Uma entidade deve sempre ter um atributo identificado.

<strong>@GeneratedValue</strong>
Especifica que o valor do identificador de entidade é gerado automaticamente.

<strong>@Column</strong>
Usada para especificar o mapeamento entre um atributo de entidade básico e a coluna da tabela de banco de dados.

<strong>@JoinColumn</strong>
Usada para especificar a coluna FOREIGN KEY. Indica que a entidade é a responsável pelo relacionamento.

<strong>@OneToMany</strong>
Usada para especificar um relacionamento de banco de dados um-para-muitos.

<strong>@OneToOne</strong>
Usada para especificar um relacionamento de banco de dados um-para-um.

<strong>@ManyToOne</strong>
Usada para especificar um relacionamento de banco de dados muitos-para-um.

<strong>cascade</strong>
Realizar operações em cascata só faz sentido em relacionamentos Pai - Filho.

<strong>mappedBy</strong>
Indica qual é o lado inverso ou não dominante da relação.

<h2>🔗 Links Úteis</h2>
<ul>
    <li><a href="https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.1&packaging=jar&jvmVersion=11&groupId=me.dio.academia&artifactId=academia-digital&name=academia-digital&description=Tutorial%20API%20RESTful%20modelando%20sistema%20de%20academia%20de%20gin%C3%A1stica&packageName=me.dio.academia.digital&dependencies=web,data-jpa,postgresql,validation,lombok">Spring Initializr</a></li>
    <li><a href="https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/common-application-properties.html">Common application properties</a></li>
    <li><a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories">Spring Data JPA - Reference Documentation</a></li>
    <li><a href="https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-gettingstarted">Validation Reference Implementation: Reference Guide</a></li>

</ul>

<h2>Pontos de extremidade da API</h2>

<h3>A API fornece os seguintes pontos de extremidade:</h3>

<ul>
    <li>GET /alunos: Obtenha todos os alunos.</li>
    <li>GET /alunos/{id}: Obter um aluno por id.</li>
    <li>POST /alunos: Crie um novo aluno.</li>
    <li>PUT /alunos/{id}: Atualize um aluno por id.</li>
    <li>DELETE /alunos/{id}: Excluir um aluno por id.</li>
    </br>
    <li>GET /avaliacoes: Obtenha todas as avaliações.</li>
    <li>GET /avalicoes/{id}: Obter uma avaliação por id.</li>
    <li>POST /avaliacoes: Crie um nova avalicao.</li>
    <li>PUT /avaliacoes/{id}: Atualize uma avaliacao por id.</li>
    <li>DELETE /avaliacoes/{id}: Excluir uma avaliacao por id.</li>
    </br>
    <li>GET /matriculas: Obtenha todas as matriculas.</li>
    <li>GET /matriculas/{id}: Obter uma matricula por id.</li>
    <li>POST /matriculas: Crie um nova matricula.</li>
    <li>DELETE /matriculas/{id}: Excluir uma matricula por id.</li>
    
</ul>
    
    
<h2>Testando a API</h2>
    
<h3>Você pode testar a API usando qualquer cliente REST, como Postman ou curl. Aqui estão alguns exemplos de solicitações:</h3>

Obtenha todos os produtos:
bash
Copy code
GET http://localhost:8080/products
Obter um produto por id:
bash
Copy code
GET http://localhost:8080/products/1
Crie um novo produto:
bash
Copy code
POST http://localhost:8080/products
Content-Type: application/json

{
    "name": "Product 1",
    "description": "This is product 1",
    "price": 10.0
}
Atualizar um produto por id:
bash
Copy code
PUT http://localhost:8080/products/1
Content-Type: application/json

{
    "name": "Product 1 Updated",
    "description": "This is product 1 updated",
    "price": 20.0
}
Excluir um produto por id:
bash
Copy code
DELETE http://localhost:8080/products/1



<h2> 🤝 Contribuindo </h2>

Este repositório foi criado para fins de estudo, então contribua com ele. Se te ajudei de alguma forma, ficarei feliz em
saber. E caso você conheça alguém que se identidique com o conteúdo, não deixe de compatilhar.

Se possível:

⭐️ Star o projeto

🐛 Encontrar e relatar issues

------------

Disponibilizado com ♥ por [cami-la](https://www.linkedin.com/in/cami-la/ "cami-la").




