# Client API Spec

## Create Clients

Endpoint : POST /api/projects/{idProjects}/clients

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

email, phone, address are nullable

```json
{
  "name": "PT Sigma",
  "email": "sigma@mail.com",
  "phone": "102390192",
  "address": "Indonesia"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "randomtring",
    "name": "PT Sigma",
    "email": "sigma@mail.com",
    "phone": "102390192",
    "address": "Indonesia"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Failed to create client"
}
```

## Update Client

Endpoint : PUT /api/projects/{idProjects}/clients/{idClients}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "name": "PT Sigma",
  "email": "sigma@mail.com",
  "phone": "102390192",
  "address": "Indonesia"
}
```

Response Body :

```json
{
  "data": {
    "id": "randomtring",
    "name": "PT Sigma",
    "email": "sigma@mail.com",
    "phone": "102390192",
    "address": "Indonesia"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Failed to update client"
}
```

## Get Client

Endpoint : GET /api/projects/{idProjects}/clients/{idClients}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body :

```json
{
  "data": {
    "id": "randomtring",
    "name": "PT Sigma",
    "email": "sigma@mail.com",
    "phone": "102390192",
    "address": "Indonesia"
  }
}
```

Response Body (Failed, 404) //unauthorized :

```json
{
  "errors": "Client is not found"
}
```

## Remove Client

Endpoint : DELETE /api/projects/{idProjects}/clients/{idClients}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body :

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Client is not found"
}
```

## List and Search Clients

Endpoint : GET /api/clients

Query Param :

- name : String, client name //optional
- phone : String //optional
- email : String //optional

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body :

```json
{
  "data": [
    {
      "id": "randomtring",
      "name": "PT Sigma",
      "email": "sigma@mail.com",
      "phone": "102390192",
      "address": "Indonesia"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
```
