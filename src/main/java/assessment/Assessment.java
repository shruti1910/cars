package assessment;

import models.AppleCar;

import java.util.ArrayList;
import java.util.List;

public class Assessment {

  Assessment() {
  }

  /**
   * @param cars
   */
  public List<AppleCar> printAllTeslaWithNotes(List<AppleCar> cars) {

    List<AppleCar> blueTeslas = new ArrayList<AppleCar>();
    for (AppleCar car : cars) {

      String make = car.getMake();
      String color = car.getMetadata().getColor();
      String notes = car.getMetadata().getNotes();

      if (make.toLowerCase().equals("tesla") &&
          color.toLowerCase().equals("blue")) {
        blueTeslas.add(car);
        System.out.println(car);
        System.out.println(notes);
      }
    }

    return blueTeslas;
  }

  /**
   * @param cars
   *
   * @return
   */
  public List<AppleCar> lowestPerDayRentalOnPrice(List<AppleCar> cars) {

    List<AppleCar> lowestRentalCars = new ArrayList<AppleCar>();

    int minimumPrice = Integer.MAX_VALUE;
    for (AppleCar car : cars) {
      int price = car.getPerDayRent().getPrice();
      minimumPrice = Math.min(price, minimumPrice);
    }

    for (AppleCar car : cars) {
      int price = car.getPerDayRent().getPrice();
      if (price == minimumPrice) {
        lowestRentalCars.add(car);
      }
    }

    return lowestRentalCars;
  }

  /**
   * @param cars
   *
   * @return
   */
  public List<AppleCar> lowestPerDayRentalOnPriceAfterDiscount(List<AppleCar> cars) {
    List<AppleCar> lowestRentalCars = new ArrayList<AppleCar>();

    int minimumPriceAfterDiscount = Integer.MAX_VALUE;
    for (AppleCar car : cars) {
      int priceAfterDiscount = car.getPerDayRent().getFinalPrice();
      minimumPriceAfterDiscount = Math.min(priceAfterDiscount, minimumPriceAfterDiscount);
    }

    for (AppleCar car : cars) {
      int priceAfterDiscount = car.getPerDayRent().getFinalPrice();
      if (priceAfterDiscount == minimumPriceAfterDiscount) {
        lowestRentalCars.add(car);
      }
    }

    return lowestRentalCars;
  }

  /**
   * @param cars
   *
   * @return
   */
  public List<AppleCar> highestRevenueGeneratingCar(List<AppleCar> cars) {

    List<AppleCar> highestRevenueCars = new ArrayList<AppleCar>();

    int maxRevenue = Integer.MIN_VALUE;
    for (AppleCar car : cars) {
      int netIncome = getNetRevenue(car);
      maxRevenue = Math.max(netIncome, maxRevenue);
    }

    for (AppleCar car : cars) {
      int netIncome = getNetRevenue(car);
      if (netIncome == maxRevenue) {
        highestRevenueCars.add(car);
      }
    }

    return highestRevenueCars;
  }

  private int getNetRevenue(AppleCar car) {
    int pricePerDayAfterDiscount = car.getPerDayRent().getFinalPrice();
    int ytd = car.getMetrics().getRentalCount().getYeartodate();
    int totalIncome = pricePerDayAfterDiscount * ytd;

    double maintenanceCost = car.getMetrics().getYoymaintenancecost();
    double depreciation = car.getMetrics().getDepreciation();
    double totalExpense = maintenanceCost + depreciation;

    return (int) (totalIncome - totalExpense);
  }

}
