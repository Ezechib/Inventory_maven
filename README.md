# Inventory Management System

Created a Inventory Management System which is able to create, read, update and delete information which is inputed within the system. We created a MySQL database that synced with Java Eclipse which allowed the database to be retrieved from MySQL

## Getting Started
Firstly create a sql instance on google cloud. .Then pull the code to your eclipse using gitbash. Change the ip addresses of the MySQL database within java to there own databases ip

### Prerequisites

Eclipse
MySQL
Google Cloud Platform
GitBash
Java
Maven

```
Give examples
```

### Installing
1. Set up a google cloud instance

2. Pull the repository from GitHub using the following commands using GitBash: 
git init 
git pull https://github.com/Ezechib/Inventory_maven.git

3. Open repository into your IDE (Eclipse recommended)

4. Change all databases connections ip within the code to there own databases ip. This are located within there classes ims and all daoMysql

5. Run the application by pressing ctrl and f11 simultaneously. This will then prompt you to input your username and password to your own MySql database. The list of table names will then be presented and once a table is selected a series of commands will be displayed which allow for the table to be modified.
The create function allows for a new item to be saved into the database. The read function shows all the items present in the database. For example read will pull all the information from the database table and input it into the console. The update function allows a item already in the database to be changed and the delete function removes a item from the database


## Running the tests

Right click the test class in Java and run it in Junit.  This will return wether the code works or not by showing pass or not pass

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Blake Ezechi** - *Main body of work* - [Ezechib](https://github.com/Ezechib/Inventory_maven)

## License
This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details
 * Apache License, Version 2.0
   ([LICENSE-APACHE](LICENSE-APACHE) or http://www.apache.org/licenses/LICENSE-2.0)
 * MIT license
   ([LICENSE-MIT](LICENSE-MIT) or http://opensource.org/licenses/MIT)

## Acknowledgments

* Nathan Farnell
* Juamal 
* Tapiwa
