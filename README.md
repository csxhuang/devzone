# Getting Started

### Analysis the requirement
When I started the task, the first thing to do is to understand the requirement. It can be summaried as the following points:
* Requirement by the front team: There are total 4 requiremnts (users actions).
* Data, Database, and data format that will be used:   
(1) Loaded two data file to MongoDB system;   
(2) Use NoSQL database MongoDB;   
(3) Data format is based on Json;
* Technology to be used in this task: REST and OpenAPI 3.0 standard is used in Java;

### Set the environment and created SpringBoot project
Start to work on the task:
#### 1) Got the format of the files DVDRentals-customers.json​ & DVDRentals-films.json
Took one document from the two file, and got the structures of them that put in the root fold DVDRentals/files.  
(1) customers-beautified.json  
(2) films-beautified.json  

#### 2) Install MongoDB on my MAC and loaded the two files
Tap the MongoDB Home-brew Tap:
```
$ brew tap mongodb/brew
```
Install MongoDB:
```
$ brew install mongodb-community@4.0
```

Run MongoDB:
```
$ brew services start mongodb-community@4.0
```

Check if the MongoDB is running:
```
$ ps aux | grep -v grep | grep mongod
```
Or:
```
$ more /usr/local/var/log/mongodb/mongo.log
```

Add the path to “mongo” terminal shell:
```
export PATH="$PATH:/usr/local/Cellar/mongodb-community@4.0/4.0.14/bin"
```

Connect and Use MongoDB:
```
$ mongo 
> show dbs
```

Create database DVDRentals:
```
> use DVDRentals
```

Check current selected database:
```
> db
```

Create Collection customers and films:
```
> db.createCollection("customers")
> db.createCollection("films")
> show collections
> exit
```

Load the data files into MongoDB:
```
$ mongoimport --db=DVDRentals --collection=customers --file=DVDRentals-customers.json
$ mongoimport --db=DVDRentals --collection=films --file=DVDRentals-films.json

$ mongo
> show dis
> use DVDRentals
> db
> show collections
> db.customers.find()
> db.films.find()
> db.customers.find({"First Name":"MARY", "Last Name":"SMITH"})
> db.films.find({"Description":{$regex:"A Emotional Character Study of a Dentist And a Crocodile who must Meet a Sumo Wrestler"}})
```

#### 3) Created Springboot project DVDRentals
To do it, I figured out the structure first, then finished step by step as follows:  
(1) Configured the pom.xml file first;  
(2) Created packages of the whole project;  
(3) Generated the entity;  
(4) Test the connection with database MongoDB;  
(5) Created the controller, Services;  
(6) Added the exception process;  
(7) Wrote the user guide documentation.

### Run the project
Run the project DVDRentals as follows:  
(1) Unzip the DVDRentals.zip;  
(2) Change the folder into the root folder DVDRentals;  
(3) Input the following command  
```
./mvnw spring-boot:run
```
(4) Import the following file that is saved in the folder DVDRentals/files into Postman  
```
jSonar.postman_collection.json
```
(5) Click the links in the Postman  
[1-Get a list of the customers](http://localhost:8080/api/allcustomers)  
[2-Get customer by phone](http://localhost:8080/api/customerphone/245477603573)  
[3-Get customer by name](http://localhost:8080/api/customername/MARSHA/DOUGLAS)  
[4-Get film rented list by name](http://localhost:8080/api/rentalbyname/MARSHA/DOUGLAS)  
[5-Get film rented list by phone](http://localhost:8080/api/rentalbyphone/245477603573)  
[6-Get a list of all the available films](http://localhost:8080/api/allfilms)  
[7-Get a list of customers by film name](http://localhost:8080/api/customersbyfilm/COLOR%20PHILADELPHIA)  
[8-Get film detail by film name](http://localhost:8080/api/filmdetailbyname/COLOR%20PHILADELPHIA)  
You can try also from the browser.

### Reference
My major references are as following:

* [Install MongoDB](https://docs.mongodb.com/v4.0/tutorial/install-mongodb-on-os-x/)
* [JSON Data Type](https://www.w3schools.com/js/js_json_datatypes.asp)
* [Spring Boot MongoDB Configuration](https://www.devglan.com/spring-boot/spring-boot-mongodb-configuration)
* [Spring Data MongoDB Queries](https://www.devglan.com/spring-boot/spring-data-mongodb-queries)

