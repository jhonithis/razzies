# Descrição do projeto

> API RESTful para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

## Requisito do Sistema:
1. Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao iniciar a
aplicação.

## Requisito da API:
1. Obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido, seguindo a especificação de formato definida na
página 2;

## Requisitos não funcionais do sistema:
1. O web service RESTful deve ser implementado com base no nível 2 de maturidade
de Richardson;
2. Devem ser implementados somente testes de integração. Eles devem garantir que
os dados obtidos estão de acordo com os dados fornecidos na proposta;
3. O banco de dados deve estar em memória utilizando um SGBD embarcado (por
exemplo, H2). Nenhuma instalação externa deve ser necessária;
4. A aplicação deve conter um readme com instruções para rodar o projeto e os testes de integração.

## Tecnologias Utilizadas
- Java
- Spring Boot (Data JPA, Web, Test e Validation)
- H2 Database
- Open CSV

## Instruções do projeto

##### Pré requisitos de configuração
- Java 8
- Maven

##### Arquivo CSV
- Arquivo CSV deve ter as seguintes colunas (na mesma ordem descrita): year, title, studios, producers e winner;
- O arquivo deve ter o nome movielist.csv;
- O arquivo deve estar localizado em src/main/resources/csv/.

##### Inicializar o sistema
- Iniciar o sistema pelo Spring Boot da IDE de sua preferência ou executar o comando a baixo dentro do diretorio inicial do projeto:
```
mvn spring-boot:run
```
- Sistema está disponível pelo tomcat na url localhost:8080/

##### End point
- Foi disponibilizado o endpoint [/api/producer/min-max-interval-award](http://localhost:8080//api/producer/min-max-interval-award) onde o retorno é o resultado do item *Requisito da Api*

##### Acesso ao Banco de dados
- Banco de dados H2
- Para acessar o SGBD do H2
    - Rodar o sistema
    - Acessar o link do [SGBD H2](http://localhost:8080/h2-ui)
    - Informar url do banco: jdbc:h2:mem:razzies
    - Informar login: root
    - OBS: Senha é em branco
    
## Testes

- Realizado testes com base nos itens *Requisito do Sistema* e *Requisito da Api*
    - Consulta dos filmes inseridos do csv não podendo ser vazio
    - Geração do json do produtor com maior e menor intervalo entre dois prêmios consecutivos

### Para mais Informações:
> [Golden Raspberry Awards](https://www.razzies.com/index.html/)