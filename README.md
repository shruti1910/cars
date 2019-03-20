# README (Apple Assessment)

The project has been build as a maven project. 

### Steps to run test:
```mvn test``` 

### Answers to assessment questions
Package: assessment 
https://github.com/shruti1910/cars/blob/master/src/main/java/assessment/Assessment.java

##### Question1: Print all the blue Teslas received in the web service response. Also print the notes
`printAllTeslaWithNotes()`

##### Question2: Return all cars which have the lowest per day rental cost for both cases: a. Price only, b. Price after discounts
`lowestPerDayRentalOnPrice()`

`lowestPerDayRentalOnPriceAfterDiscount()`


##### Question3: Find the highest revenue generating car
`highestRevenueGeneratingCar()`


---

### List of libraries used:
- Unirest: http://unirest.io/java.html
  - for making HTTP calls for request / response
- Mockito: https://site.mockito.org/
  - for mocking out tests
- Jackson: https://github.com/FasterXML/jackson
  - for serializing / deserializing JSON request / response
  
 
 ### Directory Structure
 - src
  - java
    - `assessment`: contains methods for implementing Questions 1, 2 and 3
    - `deserializer`: custom package for deserializing response json for `Car`
    - `models`: class for modelling `Car` json
    - `service`: REST API handlers for GET / POST calls
 - test
  - data
  - java
    - `assessment`: test for all 3 assessment questions
    - `deserializer`: test for custom jackson deserializer
    - `models`: test for `AppleCar` class
    - `service`: test for REST API handlers
    
    
  
  
