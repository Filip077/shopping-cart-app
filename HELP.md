
#Running the application
###Running locally (with jdk and maven installed)
`mvn clean install`

`mvn spring-boot:run`
###Running in a docker container (if docker runtime is installed)
`docker build -t springio/gs-spring-boot-docker .`

`docker run -p 8080:8080 springio/gs-spring-boot-docker`

#Tech notes
The project is using maven 3.5, spring-boot 2.7.5, h2 db 2.1,

#API:

##API endpoints

- **/api/products/getProducts** - API for getting all products

- **/api/shoppingCart/addProduct/{productSerialNumber}** `PUT` - For adding products in shopping cartt

- **/api/shoppingCart/getShoppingCart/{shoppingCartSerialNum}** `GET` - For getting all products from shopping cart with given serialnumber

- **/api/shoppingCart/{shoppingCartSerialNum}/totalPrice** `GET` - For getting total price of products in the cart

**Full API documentation** with swagger can also be found at http://localhost:8080/swagger-ui/index.html when the application is running

**The H2 database** can be accessed at http://localhost:8080/h2-console/ with username: admin password: admin
##Testing the api
API can be tested using the Postman or in browser

##Containerization:
Application is containeried using docker

##Validation:
Validation is done using hibernate validation mechanism

##Persistent storage:
The project is using in-memory H2 database

Data initialization is done using pure flyway

##Going forward:
- More extensive javadoc
- 100% unit test coverage
- Expanding the shopping cart API(deleting products from cart)
- Using a separate persisted DB (PostgreSQL) for data storage
