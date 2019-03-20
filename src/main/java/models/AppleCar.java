package models;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class AppleCar {
  private String make;
  private String model;
  private String vin;
  private Metadata metadata;
  private PerDayRent perDayRent;
  private Metrics metrics;

  public AppleCar() {
  }

  public AppleCar(String make, String model, String vin, Metadata metadata,
                  PerDayRent perDayRent, Metrics metrics) {
    this.make = make;
    this.model = model;
    this.vin = vin;
    this.metadata = metadata;
    this.perDayRent = perDayRent;
    this.metrics = metrics;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public PerDayRent getPerDayRent() {
    return perDayRent;
  }

  public void setPerDayRent(PerDayRent perDayRent) {
    this.perDayRent = perDayRent;
  }

  public Metrics getMetrics() {
    return metrics;
  }

  public void setMetrics(Metrics metrics) {
    this.metrics = metrics;
  }

  @Override
  public String toString() {
    List<String> fields = Arrays.asList(
        make,
        model,
        vin,
        String.valueOf(metadata),
        String.valueOf(perDayRent),
        String.valueOf(metrics)
    );
    return StringUtils.join(fields, ", ");
  }
}

