# User API Spec

## Register User

Endpoint : POST /api/users

Request Body :

```json
{
  "username": "alvin",
  "password": "inipass",
  "name": "Alvin Fadli"
}
```

Response Body :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Username must not blank"
}
```

## Login User

Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username": "alvin",
  "password": "inipass"
}
```

Response Body :

```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 1237128437 // millisecond
  }
}
```

Response Body (Failed, 401) //unauthorized :

```json
{
  "errors": "Username or password wrong"
}
```

## Get User

Endpoint : GET /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body :

```json
{
  "data": {
    "username": "alvin",
    "name": "Alvin Fadli"
  }
}
```

Response Body (Failed, 401) //unauthorized :

```json
{
  "errors": "Unauthorized"
}
```

## Update User

Endpoint : PATCH /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "name": "Alvin Fadli", // optional
  "password": "inipass" // optional
}
```

Response Body :

```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 1237128437 // millisecond
  }
}
```

Response Body (Failed, 401) //unauthorized :

```json
{
  "errors": "Username or password wrong"
}
```

## Logout User

Endpoint : PATCH /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body :

```json
{
  "data": "OK"
}
```
