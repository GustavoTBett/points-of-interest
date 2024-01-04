# Pontos de interesse

<!-- SOBRE O PROJETO -->
## SOBRE O PROJETO

Pontos de interesse de uma localização utilizando Java, Spring Boot e JPA, para aprendizado. 

Você manda na URL os pontos x e y fixos e o valor de distância máxima para encontrar os lugares mais próximos.

Deafio proposto em: https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md

```
  Exemplo: http://localhost:8080/20&10&10
  (x), (y) e (distância máxima)
  
  Retorno:
  [
    {
        "nome": "Lanchonete",
        "x": 27,
        "y": 12
    },
    {
        "nome": "Joalheria",
        "x": 15,
        "y": 12
    },
    {
        "nome": "Pub",
        "x": 12,
        "y": 8
    },
    {
        "nome": "Supermercado",
        "x": 23,
        "y": 6
    }
]
```

Tecnologias utilizadas:
* Java
* JPA
* Hibernate
* Lombok
* Postgresql
* Junit

<!-- GETTING STARTED -->
## Instalação

### Pré requisitos

* Insomnia/Postman/Google Chrome ( Para testar os endpoints ) 

* Alguma IDE que rode Java como Eclipse, Netbeans, Intellij... 

* Postgresql


### Instalação

1. Pegue o link do repositório https://github.com/GustavoTBett/points-of-interest.git
2. Clone o repo
   ```sh
   git clone https://github.com/GustavoTBett/points-of-interest.git
   ```
3. Abra o projeto em sua IDE de prefêrencia

4. Configure o arquivo application.properties alterando o usuario e senha (Utilize o seu usuário e senha do Postgresql), quando o projeto for executado ele se encarregará de criar a tabela e suas colunas no banco de dados

5. Na IDE execute o arquivo PointsOfInterestApplication

6. No insomnia teste os endpoins no localhost:8080

```
    Exemplo de JSON :
    {
        "nome": "churrascaria",
        "x": 28,
        "y": 2
    }
 ```

   ```JS
   POST / - para criar os pontos do mapa em banco
   
   GET /{x}&{y}&{dMax} - para procurar os lugares próximos em relação a um ponto fixo
   
   GET / - Retorna todos os pontos de interesse cadastrado
   ```
