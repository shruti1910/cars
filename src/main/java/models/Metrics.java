package models;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Metrics {
  public double getYoymaintenancecost() {
    return yoymaintenancecost;
  }

  public void setYoymaintenancecost(double yoymaintenancecost) {
    this.yoymaintenancecost = yoymaintenancecost;
  }

  public double getDepreciation() {
    return depreciation;
  }

  public void setDepreciation(double depreciation) {
    this.depreciation = depreciation;
  }

  public RentalCount getRentalCount() {
    return rentalCount;
  }

  public void setRentalCount(RentalCount rentalCount) {
    this.rentalCount = rentalCount;
  }

  private double yoymaintenancecost;
  private double depreciation;
  private RentalCount rentalCount;

  public Metrics() {}

  public Metrics(double yoymaintenancecost, double depreciation, RentalCount rentalCount) {
    this.yoymaintenancecost = yoymaintenancecost;
    this.depreciation = depreciation;
    this.rentalCount = rentalCount;
  }

  @Override
  public String toString() {
    List<String> fields = Arrays.asList(
        String.valueOf(yoymaintenancecost),
        String.valueOf(depreciation),
        String.valueOf(rentalCount));
    return "{" + StringUtils.join(fields, ", ") + "}";
  }
}
