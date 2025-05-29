# Gerenciador de Pagamentos de Mensalistas

## Requisitos

- Java 17
- Maven 3.x

## Como executar

	1. Abra o terminal na pasta do projeto
	2. Rode o seguinte comando:
		mvn spring-boot:run
		**OU**

		Compile e execute o `.jar`:
			mvn clean package
			java -jar target/gerenciador-pagamentos-0.0.1-SNAPSHOT.jar

## Endpoints disponíveis

	- `GET /mensalistas`
	- `POST /mensalistas`
	- `PUT /mensalistas/{id}`
	- `DELETE /mensalistas/{id}`

	- `GET /jogos`
	- `POST /jogos`

	- `GET /pagamentos`
	- `POST /pagamentos`

## Banco de dados

	- Usa H2 em memória
	- Acesse o console em: `http://localhost:8080/h2-console`
	- JDBC URL: `jdbc:h2:mem:db`

