# POST /tarefa

This endpoint is used to create a new task.

## Request Body

- `nome` (string, required): The name of the task.
    
- `dataEntrega` (string, required): The due date of the task in the format "YYYY-MM-DD".
    
- `responsavel` (string, required): The person responsible for the task.
    

## Response

The response will be in JSON format and will follow the schema:

``` json
{
    "type": "object",
    "properties": {
        "id": {
            "type": "string"
        },
        "nome": {
            "type": "string"
        },
        "dataEntrega": {
            "type": "string",
            "format": "date"
        },
        "responsavel": {
            "type": "string"
        }
    }
}

 ```
# Get Tarefa

This endpoint makes an HTTP GET request to retrieve tarefa data.

## Request

- There are no request parameters for this endpoint.
    

## Response

The response will include tarefa data in JSON format.


This endpoint retrieves the details of a specific task by its unique ID.

### Request

- Method: GET  
- URL: `http://localhost:8080/tarefa/{id}`

Replace `{id}` with the ID of the task you want to retrieve.  
For example, `http://localhost:8080/tarefa/1` will retrieve the task with ID 1.

### Response

The response will include the details of the task, such as its ID, title, description, status, and any other relevant information.

The task is retrieved from the database based on the provided ID.

This endpoint allows updating a task with the specified ID.

### Request

- Method: PUT  
- URL: `http://localhost:8080/tarefa/{id}`

Replace `{id}` with the ID of the task you want to update.  
For example: `http://localhost:8080/tarefa/1`

The request body must contain the following JSON payload:

```json
{
  "nome": "string",
  "dataEntrega": "string",
  "responsavel": "string"
}
```
nome: (string) The name of the task.
dataEntrega: (string) The due date of the task.
responsavel: (string) The person responsible for the task.


This endpoint sends an HTTP DELETE request to delete a specific task based on its ID.

### Request

- Method: DELETE  
- URL: `http://localhost:8080/tarefa/{id}`

Replace `{id}` with the ID of the task you want to delete.  
For example: `http://localhost:8080/tarefa/1`

The request body must include the following JSON payload:

```json
{
  "nome": "string",
  "dataEntrega": "string",
  "responsavel": "string"
}
```
nome (string): The name of the task to be deleted.
dataEntrega (string): The delivery date of the task to be deleted.
responsavel (string): The person responsible for the task to be deleted.
