# ultimate hitman app

Simple CRUD to play with java and spring boot

## Build with:

* Spring boot
* Postgresql
* JPA/Hibernate

## App schema

| API NAME      |      HTTP Method      |  Path                 |  Status Code          |  Description           |
|---------------|-----------------------|-----------------------|-----------------------|------------------------|
| Get hitmans   |  GET                  | /api/v1/hitmans       |  200 (OK)             |  List all hitmans      |
| POST hitman   |  POST                 | /api/v1/hitmans       |  201 (Created)        |  New hitman is created |
| GET hitman    |  GET                  | /api/v1/hitmans/{id}  |  200 (OK)             |  One hitman is listed  |
| PUT hitman    |  PUT                  | /api/v1/hitmans/{id}  |  200 (OK)             |  One hitman is updated |
| DELETE hitman |  DELETE               | /api/v1/hitmans/{id}  |  204 (No Content)     |  Hitman is deleted     |

## Comes with:

* Dockerfile
* Docker compose

## How play?

```bash
docker-compose up -d --build
```

Inside util folder there's a POSTMAN export with examples.
