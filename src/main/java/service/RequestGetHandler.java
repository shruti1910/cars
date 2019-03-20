package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import models.AppleCar;

import java.io.IOException;
import java.util.List;

/**
 * Reference for Unirest: https://www.baeldung.com/unirest
 */
public class RequestGetHandler {

  // sample values, since actual API path and auth are unknown
  private static final String BASE_PATH = "app.apple.com";
  private static final String URL = "/cars";
  private static final String GET_URL_PATH = BASE_PATH + URL;
  private static final String API_KEY = "****"; // is usually read from a config file or keyring

  public RequestGetHandler() {
  }

  /**
   * @param response
   *
   * @return
   *
   * @throws IOException
   */
  private List<AppleCar> deserializeResponseJSON(HttpResponse<JsonNode> response) throws IOException {
    String jsonArrayResponse = response.getBody().toString();
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(
        jsonArrayResponse,
        new TypeReference<List<AppleCar>>() {
        });
  }

  /**
   * @return returns a list of all available cars
   *
   * @throws UnirestException
   */
  public List<AppleCar> getAllCars() throws UnirestException, IOException {
    HttpResponse<JsonNode> response = Unirest.get(GET_URL_PATH)
        .header("accept", "application/json")
        .queryString("apiKey", API_KEY)
        .asJson();

    List<AppleCar> cars = deserializeResponseJSON(response);
    return cars;
  }

  /**
   * @param vin
   *
   * @return a list of cars for given vin, in json format.
   * Since vin is unique, this would return a list with <= 1 car
   *
   * @throws UnirestException
   */
  public HttpResponse<JsonNode> getCarFromVin(String vin) throws UnirestException {
    return Unirest.get(GET_URL_PATH)
        .header("accept", "application/json")
        .queryString("apiKey", API_KEY)
        .queryString("vin", vin)
        .asJson();
  }

  /**
   * @param make
   *
   * @return list of cars for given make, in json format
   *
   * @throws UnirestException
   */
  public HttpResponse<JsonNode> getAllCarsForMake(String make) throws UnirestException {
    return Unirest.get(GET_URL_PATH)
        .header("accept", "application/json")
        .queryString("apiKey", API_KEY)
        .queryString("make", make)
        .asJson();
  }

  /**
   * @param make
   * @param model
   *
   * @return list of cars for given make and model, in json format
   *
   * @throws UnirestException
   */
  public HttpResponse<JsonNode> getAllCarsForMakeAndModel(String make, String model) throws UnirestException {
    return Unirest.get(GET_URL_PATH)
        .header("accept", "application/json")
        .queryString("apiKey", API_KEY)
        .queryString("make", make)
        .queryString("model", model)
        .asJson();
  }

  public static void main(String[] args) throws UnirestException {

    HttpResponse<JsonNode> jsonResponse
        = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
        .header("accept", "application/json")
        .queryString("apiKey", API_KEY)
        .asJson();

    String jsonArray = jsonResponse.getBody().toString();

//    ObjectMapper mapper = new ObjectMapper();
//    System.out.println(jsonArray);
//    List<AppleCar> cars = mapper.readValue(
//        jsonArray, new TypeReference<List<AppleCar>>() { });

  }

}
