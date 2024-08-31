# API TESTING BOOTCAMP

A bootcamp project based on Cucumber BDD Framework with Rest Assured to implement fundementals of API Testing.  
The project designed in Page Object Model and Singleton pattern implemented to separate test data from test cases.

**Build Tool:** Maven  
**Test Framework:** Cucumber BBD (with Rest Assured and JUnit Assertions)

## Prerequisites

#### System Requirements
- Java 8+ JDK  
- Apache Maven (to be able to run tests by command line)

#### Recommended Plugins for IDE
- Cucumber for Java from JetBrains  
- Gherkin from JetBrains  
- Lombok (for POJO class)  

## Environment: 
`https://petstore.swagger.io/`

## Features, Contents

### User features
- CRUD operations implemented
- login functions with api key implemented

### Pet features
- file upload operation implemented  
- update operation with form-data implemented
- get pets by status scenario tested

### Schema validation
- the schema validation done a response body got from API.
- the repsonse validdated with the schema which has added to the project root directory

### Scenario Context Feature
- Due to structure of Cucumber Framework the content of one scenario can not stored to use in another scenario by known object craetion way.
- To hanlde this, to Context classes created in pages and test data from response stored there to use in different test scenarios




