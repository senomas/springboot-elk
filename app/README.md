# Spring boot example with REST and spring data JPA


### Endpoints

| Method | Url | Decription |
| ------ | --- | ---------- |
| GET    |/info  | info / heartbeat - provided by boot |
| GET    |/health| application health - provided by boot |
| GET    |/api/v2/api-docs    | swagger json |
| GET    |/swagger-ui.html| swagger html |
| GET    |/api/v1/person/{id}| get person by id |
| GET    |/api/v1/persons    | get N persons with an offset|
| PUT    |/api/v1/person     | add / update person|
