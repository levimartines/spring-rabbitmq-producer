# Projeto RabbitMQ Producer

Projeto Producer utilizado para estudos de messageria utilizando RabbitMQ do
curso [RabbitMQ com SpringBoot e Docker](https://www.udemy.com/course/rabbitmq-com-springboot-e-docker/)
.

### Executando o projeto

1. Pelo terminal, acesse a pasta de instalação do RabbitMQ e depois a pasta sbin e execute o
   comando ``rabbitmqctl.bat start_app`` para iniciar o RabbitMQ.

2. Execute a aplicação (está configurada para a porta 8081). Para utilizar a API Rest, basta
   realizar um POST no endpoint /send com o JSON
   ````json
   {
      "text": "Uma nova mensagem para a fila!"
   }
   ````