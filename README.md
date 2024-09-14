# TravTronics Assignment

## Description

This project is a Spring Boot application designed for managing products and users for TravTronics. It includes functionality for product management, user registration, cart operations, and order processing. The application uses an in-memory H2 database for data storage.

## Prerequisites

Ensure you have the following installed:

- **Java** (JDK 11 or higher)
- **Maven** (or Gradle, if preferred)
- **H2 Database** (H2 is an in-memory database used for development)

## Setup

### Cloning the Repository

Clone the repository using the following command:

```bash
git clone https://github.com/hemanthjinnala7/TravTronics-Assignment.git
cd TravTronics-Assignment
```

### Configuring the Environment

1. **Database Configuration**: The project uses an in-memory H2 database by default. The database configuration is provided in `application.properties` or `application.yml` (usually found in `src/main/resources`).

2. **Environment Variables**: If you need to configure environment-specific properties, create an `.env` file or configure them in your IDE.

### Installing Dependencies

Install project dependencies with Maven:

```bash
mvn install
```

Or with Gradle:

```bash
gradle build
```

## Running the Project

To run the project locally:

- **For Spring Boot applications**:

    ```bash
    mvn spring-boot:run
    ```

- **For other Java applications**:

    ```bash
    java -jar target/TravTronics-Assignment.jar
    ```

### Accessing the Application

- Open your web browser and navigate to `http://localhost:9090`.

## API Endpoints

### Product Controller

- **Get All Products**
  - **Endpoint**: `/api/getAllProducts`
  - **Method**: `GET`
  - **Description**: Retrieve all products in JSON format.

- **Get Product by ID**
  - **Endpoint**: `/api/getProductById/{id}`
  - **Method**: `GET`
  - **Description**: Retrieve a product by its ID in JSON format.

- **Add Product**
  - **Endpoint**: `/api/admin/addProduct`
  - **Method**: `POST`
  - **Request Body Example**:
    ```json
    {
      "name": "Samsung Galaxy Mobile",
      "price": 35000,
      "type": "smart-phone",
      "gender": "unisexual"
    }
    ```

- **Update Product**
  - **Endpoint**: `/api/admin/updateProduct/{id}`
  - **Method**: `POST`
  - **Request Body Example**:
    ```json
    {
      "name": "Samsung Galaxy Mobile",
      "price": 30000,
      "type": "smart-phone",
      "gender": "unisexual"
    }
    ```

- **Delete Product by ID**
  - **Endpoint**: `/api/admin/deleteProductById/{id}`
  - **Method**: `DELETE`
  - **Description**: Delete a product by its ID.

- **Delete All Products**
  - **Endpoint**: `/api/admin/deleteAllProducts`
  - **Method**: `DELETE`
  - **Description**: Delete all products.

### User Controller

- **Register User**
  - **Endpoint**: `/api/user/register`
  - **Method**: `POST`
  - **Request Body Example**:
    ```json
    {
      "username": "hemanth",
      "password": "1234"
    }
    ```

- **Add Item to Cart**
  - **Endpoint**: `/api/user/addItemToCartById/{userId}/{productId}`
  - **Method**: `POST`
  - **Description**: Add a product to the cart for a user.

- **Order Item**
  - **Endpoint**: `/api/user/Orderitem/{userId}/{productId}`
  - **Method**: `POST`
  - **Description**: Add a product to the order list for a user.

## Database

The application uses H2 as the in-memory database. Data will be lost when the application is stopped, as H2 is not persistent.

## Testing

To run tests:

- **For Maven**:

    ```bash
    mvn test
    ```

- **For Gradle**:

    ```bash
    gradle test
    ```

## Contributing

If you would like to contribute to this project:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to your branch.
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

- **Author**: Hemanth Jinnala
- **Email**: hemanthjinnala777@gmail.com
- **GitHub**: [hemanthjinnala7](https://github.com/hemanthjinnala7)

---

Feel free to adjust the content, especially around configuration and API details, to fit your actual project setup and requirements.










-------------------------------------------------------------------------------------------------------------------
in this project ->
there are 2 repositories
1.product
2.User
->both are implemented with jpa-repo which inherits every useful CRUD method that
  works efficiently with the database

there are 2 models
1.user
2.product

the models are the structures of how we wish to keep the data in your database



there are 2 controllers
1.product
2.user

product controllers contains->
    /api/getAllProducts -> to get all the products in our database in json format
    /api/getProductById/{id} -> to get the element in json frmt through id
    /api/admin/addProduct -> adding a new element to the databse through json format
    /api/admin/updateProduct/{id} -> to update the element by json format
    /api/admin/deleteProductById/{id} -> to delete the element by id

user contoller contains->
    /api/user/register -> to register the user in the db
    /api/user/addItemToCartById/{userId}/{productId} -> to add an item through id for a user by his id

the database is h2 database which is in-memory database where the data in the database
availble only when our machine is in ON-state,it will delete the entire data when it is in OFF state



END-POINTS->
    GET
    http://localhost:9090//api/getAllProducts  -> to get all products

    GET
    http://localhost:9090/api/getProductById/{id} -> to get product by id

    POST
    http://localhost:9090/api/admin/addProduct  -> to add an element
    ex-
    {
       "name":"samsung galaxy mobile",
       "price":35000,
       "type":"smart-phone"
       "gender":"unisexual"
    }

    POST
    http://localhost:9090/api/admin/updateProduct/{id} -> to update the element by json format
    ex-
    {
       "name":"samsung galaxy mobile",
       "price":30000,
       "type":"smart-phone"
       "gender":"unisexual"
    }

    DELETE
    http://localhost:9090/api/admin/deleteProductById/{id} -> to delete the element by id

    DELETE
    http://localhost:9090/api/admin/deleteAllProducts -> to delete all products in one shot

    POST
    http://localhost:9090/api/user/register -> to create a user
    ex->
    {
        "username":"hemanth",
        "password":"1234"
    }

    POST
     http://localhost:9090/api/user/addItemToCartById/{userId}/{productId}
     it will update the users cart by adding another object of product

     POST
     http://localhost:9090/api/user/Orderitem/{userId}/{productId}
     it will add the items to orders list of the respective user.



-------------------------------------------------------X-------------------------------------------------------------------
