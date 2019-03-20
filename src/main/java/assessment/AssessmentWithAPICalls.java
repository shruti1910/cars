package assessment;

import com.mashape.unirest.http.exceptions.UnirestException;
import models.AppleCar;
import service.RequestGetHandler;

import java.io.IOException;
import java.util.List;

public class AssessmentWithAPICalls {

  private Assessment assessment;
  private List<AppleCar> allCars;

  AssessmentWithAPICalls() throws IOException, UnirestException {
    assessment = new Assessment();
    RequestGetHandler requestGetHandler = new RequestGetHandler();
    List<AppleCar> allCars = requestGetHandler.getAllCars();
  }

  public void printAllTeslaWithNotes() {
    assessment.printAllTeslaWithNotes(allCars);
  }

  public List<AppleCar> lowestPerDayRentalOnPrice() {
    return assessment.lowestPerDayRentalOnPrice(allCars);
  }

  public List<AppleCar> lowestPerDayRentalOnPriceAfterDiscount() {
    return assessment.lowestPerDayRentalOnPriceAfterDiscount(allCars);
  }

  public List<AppleCar> highestRevenueGeneratingCar() {
    return assessment.highestRevenueGeneratingCar(allCars);
  }

}
