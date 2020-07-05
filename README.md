# This is a Simple Virtual Store

It's a REST webservice that supports register of clients, products and orders.

The main framework used is JAX-RS, with MySQL database.

## How to use
This API have 3 entities, Client, Product and Order. Each one have the following operations: GET, POST and GET/{id}.

### Client
GET operation:
```
http://localhost:8080/virtualstore/rest/clients
```
Returns a list of all clients

GET/{id} operation:
```
http://localhost:8080/virtualstore/rest/clients/1
```
Returns the client with ID = 1

POST operation:
```
http://localhost:8080/virtualstore/rest/clients
```
With this payload in JSON format:
```
{"name": "robson", "password": "test"}
```
Creates a client named "robson" with "test" password

### Product
GET operation:
```
http://localhost:8080/virtualstore/rest/products
```
Returns a list of all products

GET/{id} operation:
```
http://localhost:8080/virtualstore/rest/products/1
```
Returns the product with ID = 1

POST operation:
```
http://localhost:8080/virtualstore/rest/products
```
With this payload in JSON format:
```
{"name": "Bed", "description": "A great bed", "price": 134.56}
```
Creates a product named "Bed"

### Order
GET operation:
```
http://localhost:8080/virtualstore/rest/orders
```
Returns a list of all orders

GET/{id} operation:
```
http://localhost:8080/virtualstore/rest/orders/1
```
Returns the order with ID = 1

POST operation:

For the POST operation, the user need to be authenticated.

Authentication request:
```
http://localhost:8080/virtualstore/rest/authentication
```
With this payload in JSON format:
```
{"name": "peter", "password": "test"}
```
Gives an authentication token for the user named "peter", if the password is correct

Now the POST request can be made with the authentication token in the HTTP Authorization header
```
http://localhost:8080/virtualstore/rest/orders
```
With this payload in JSON format:
```
{
    "client": {
        "id": 1
    },
    "date": "2020-07-05T00:00:00",
    "products": [
        {
            "id": 1
        },
        {
            "id": 2
        },
        {
            "id": 3
        }
    ]
}
```
Creates a order for the client with id = 1, containing the products with ids 1, 2 and 3.