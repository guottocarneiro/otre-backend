# Rodando os containers
Para rodar a aplicação localmente com Docker, primeiro faça o *package* do projeto e depois rode os seguimentos comandos (caso nao tenha Maven instalado, pode instalar aqui https://dicasdejava.com.br/como-instalar-o-maven-no-windows/):

- mvn clean package
- docker build -t otre-backend .
- docker-compose up -d