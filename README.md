# README (Apple Assessment)

The project has been build as a maven project. 

### Steps to run test:
```mvn test``` 

### Answers to assessment questions
Package: assessment 
https://github.com/shruti1910/cars/blob/master/src/main/java/assessment/Assessment.java

##### Question1: Print all the blue Teslas received in the web service response. Also print the notes
- `printAllTeslaWithNotes()`

##### Question2: Return all cars which have the lowest per day rental cost for both cases: a. Price only, b. Price after discounts
- `lowestPerDayRentalOnPrice()`
- `lowestPerDayRentalOnPriceAfterDiscount()`


##### Question3: Find the highest revenue generating car
- `highestRevenueGeneratingCar()`


---

### List of libraries used:
- Unirest: http://unirest.io/java.html
  - for making HTTP calls for request / response
- Mockito: https://site.mockito.org/
  - for mocking out tests
- Jackson: https://github.com/FasterXML/jackson
  - for serializing / deserializing JSON request / response
  
 
 ### Directory Structure
 - `/src`
  - `/java`
    - `/assessment`: contains methods for implementing Questions 1, 2 and 3
      - [Assessment.java](https://github.com/shruti1910/cars/blob/master/src/main/java/assessment/Assessment.java)
      - [AssessmentWithAPICalls.java](https://github.com/shruti1910/cars/blob/master/src/main/java/assessment/AssessmentWithAPICalls.java)
    - `/deserializer`: custom package for deserializing response json for `Car`
      - [AppleCarDeserializer.java](https://github.com/shruti1910/cars/blob/master/src/main/java/deserializer/AppleCarDeserializer.java)
    - `/models`: class for modelling `Car` json
      - [AppleCar.java](https://github.com/shruti1910/cars/blob/master/src/main/java/models/AppleCar.java)
      - [Metadata.java](https://github.com/shruti1910/cars/blob/master/src/main/java/models/Metadata.java)
      - [Metrics.java](https://github.com/shruti1910/cars/blob/master/src/main/java/models/Metrics.java)
      - [PerDayRent.java](https://github.com/shruti1910/cars/blob/master/src/main/java/models/PerDayRent.java)
      - [RentalCount.java](https://github.com/shruti1910/cars/blob/master/src/main/java/models/RentalCount.java)
    - `/service`: REST API handlers for GET / POST calls
      - [RequestGetHandler.java](https://github.com/shruti1910/cars/blob/master/src/main/java/service/RequestGetHandler.java)
 - `/test`
    - `/data`: contains sample response json for tests. These json are read into `AppleCar` after deserializing them 
    with custom Jackson Deserializer, [AppleCarDeserializer.java](https://github.com/shruti1910/cars/blob/master/src/main/java/deserializer/AppleCarDeserializer.java)
      - [cars_1.json](https://github.com/shruti1910/cars/blob/master/src/test/data/cars_1.json)
      - [cars_2.json](https://github.com/shruti1910/cars/blob/master/src/test/data/cars_2.json)
      - [cars_3.json](https://github.com/shruti1910/cars/blob/master/src/test/data/cars_3.json)
      - [bad_car_response.json](https://github.com/shruti1910/cars/blob/master/src/test/data/bad_car_response.json)
    - `/java`
      - `/assessment`: test for all 3 assessment questions
        - [TestQuestion1.java](https://github.com/shruti1910/cars/blob/master/src/test/java/assessment/TestQuestion1.java)
        - [TestQuestion2.java](https://github.com/shruti1910/cars/blob/master/src/test/java/assessment/TestQuestion2.java)
        - [TestQuestion3.java](https://github.com/shruti1910/cars/blob/master/src/test/java/assessment/TestQuestion3.java)
      - `/deserializer`: test for custom jackson deserializer
      - `/models`: test for `AppleCar` class
      - `/service`: tesT for REST API handlers
    
    
  
  
