# RestAssuredSerenityCucumber Framework

A simple maven project demonstrating automated API tests using RestAssured and Serenity BDD.
## Technology Stack

- Java
- Serenity BDD
- Maven
- RestAssured

## Prerequisites

* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Dev Kit
* [Maven](https://maven.apache.org/download.cgi) - Dependency Manager

## Application Under Test

We are using Restful-Booker APIs as the Application Under Test.

* URL : https://restful-booker.herokuapp.com/

## The project directory structure
The project follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
    + java                        contains pojos of each json placeholder endpoint
  + test
    + java                        Test runners, step definitions and supporting code
    + resources
      + features                  Feature files
         Booking.feature
```


Following instructions will help you running the project. First, clone this project locally on your machine from the master branch.

### Installation and Test Execution

Open the project in any IDE Eclipse/IntelliJ. Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

```sh
$ mvn clean install
```

### Execute Tests

Run the following command in Terminal to execute tests.

```sh
$ mvn clean verify
```

### Test Report

You can find the Serenity reports in the following directory of the Project.

```sh
\target\site\serenity\
```

In the serenity directory, open 'index.html' file to view the report.
