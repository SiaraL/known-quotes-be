## About

It is a simple rest api to gather known quotes of famous people.


## Installation

To pull project to your computer you have to have installed jdk (v.11), maven and git at your computer. Then choose location of your workspace (e.g. C:\workspace) and clone project by typing at console: 

`git clone https://github.com/SiaraL/known-quotes-be.git
`

Then open project by your ide as maven run or get into project location in console (e.g. C:\workspace\known-quotes-be) and build maven project: 

`mvn package`

And then run your application by: 

`java -jar .\target\decerto-backend-1.0.0.jar`

## API
This api containst only 4 endpoints to manage quotes. 

You can see all enpoints at `swagger documentation` at the link:

`http://localhost:8080/swagger-ui.html`

If you can't, there is a list of endpoints:

GET `localhost:8080/api/v1/quote`


POST `localhost:8080/api/v1/quote`
with `RequestBody`:

`{value:string,
author: {firstName:string, lastName:string}}`


PATH `localhost:8080/api/v1/quote/{queryId}`
with `queryId` which is id of query and `RequestBody`:

`{value:string,
author: {firstName:string, lastName:string}}`


DELETE `localhost:8080/api/v1/quote/{queryId}`
with `queryId` which is id of query

There are examples of usage by Windows Power Shell:
```
GET:
Invoke-RestMethod -Method 'Get' -Uri 'http://localhost:8080/api/v1/quote' -ContentType 'application/json'

POST:
Invoke-RestMethod -Method 'Post' -Uri 'http://localhost:8080/api/v1/quote' -ContentType 'application/json' -Body '{
"value":"Life is brutal and full of zasadzkas", "author":{"firstName":"Paulo", "lastName":"Coelho"}}'

PATCH:
Invoke-RestMethod -Method 'Patch' -Uri 'http://localhost:8080/api/v1/quote/1' -ContentType 'application/json' -Body '{
"value":"Life is just brutal ", "author":{"firstName":"Paulo", "lastName":"Coelho"}}'

DELETE:
Invoke-RestMethod -Method 'Delete' -Uri 'http://localhost:8080/api/v1/quote/1' -ContentType 'application/json'```