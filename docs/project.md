# Project API Spec

## Create Project

    - title
    - description
    - status
    - deadline
    - user_id (foreign)
    - client_id (foreign)

Endpoint : POST /api/projects

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "title": "Project Mbappe",
  "description": "Lorem Ipsum Project",
  "status": "Not started",
  "deadline": "2024/01/31"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "randomString",
    "title": "Project Mbappe",
    "description": "Lorem Ipsum Project",
    "status": "Not started",
    "deadline": "2024/01/31"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Failed to create project"
}
```

## Update Project

Endpoint : PUT /api/projects/{idProjects}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "title": "Project Mbappe",
  "description": "Lorem Ipsum Project",
  "status": "Not started",
  "deadline": "2024/01/31"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "randomString",
    "title": "Project Mbappe",
    "description": "Lorem Ipsum Project",
    "status": "Not started",
    "deadline": "2024/01/31"
  }
}
```

Response Body (Failed) :

```json
{
  "errors": "Failed to update project"
}
```

## Get Project

Endpoint : GET /api/projects/{idProjects}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body :

```json
{
  "data": {
    "id": "randomString",
    "title": "Project Mbappe",
    "description": "Lorem Ipsum Project",
    "status": "Not started",
    "deadline": "2024/01/31"
  }
}
```

Response Body (Failed, 404) //unauthorized :

```json
{
  "errors": "Project is not found"
}
```

## Remove Project

Endpoint : DELETE /api/projects/{idProjects}

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
  "errors": "Project is not found"
}
```

## Search

Endpoint : GET /api/clients

Query Param :

- title : String, client name //optional

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body :

```json
{
  "data": [
    {
      "id": "randomString",
      "title": "Project Mbappe",
      "description": "Lorem Ipsum Project",
      "status": "Not started",
      "deadline": "2024/01/31"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
```
