# RestAssuredSerenityCucumber Framework

This is a sample Rest API test solution for sample endpoints available in https://restful-booker.herokuapp.com/apidoc/index.html The published APIs represent a blog application where users can publish post and comment on them.

Tests are written using a combination of SerenityBDD, RestAssured, Cucumber, Junit & Maven.

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
    + java                          
      + env                         methods to get/set env related configs
      + models                      pojos of all endpoints
      + utilities                   utility methods and constants
  + test
    + java                          
      + endpoints                   endpoints of the services
      + runners                     test runner(senerity runner/trigger configurations)
      + stepdefinitions             Step definitions for the BDD feature
      + utils                       Common utility methods
    + resources
      + features                  Feature files
      + properties                AUT properties files
      + logback.xml               for rebug logs
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

If we make any push/pull/any change to code, will automatically trigger the builds in both circleci and gitlab, reports are shown here [https://4-338524524-gh.circle-artifacts.com/0/target/site/serenity/index.html] and some results screenshots are attached herewith as well
```
https://4-338524524-gh.circle-artifacts.com/0/target/site/serenity/3a150e0886d4f3778244668b3c48c7ec22ba1bb143c571df3bfc79d6bbf8413c.html
https://4-338524524-gh.circle-artifacts.com/0/target/site/serenity/b5422f8413aebb5473f0c7772d254e632456fb69d3d8f60ad7998fc178f0dc3f.html
```

### Finally Source code, Please refer

* Github (https://github.com/cvenkatreddy/restassured-serenity-cucumber) with circleci integration(Config.yml)
* GitLab (https://gitlab.com/cvenkatreddy/restassured-serenity-cucumber) with gitlab integration (.gitlab-ci.yml)
