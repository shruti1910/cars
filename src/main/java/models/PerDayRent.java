package models;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class PerDayRent {
  private int price;
  private int discount;

  public PerDayRent() { }

  public PerDayRent(int price, int discount) {
    this.price = price;
    this.discount = discount;
  }

  @Override
  public String toString() {
    List<String> fields = Arrays.asList(
        String.valueOf(price),
        String.valueOf(discount));
    return "{" + StringUtils.join(fields, ", ") + "}";
  }

  public int getFinalPrice() {
    return (int) (price - (1 - (double) discount/100));

  }


  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getDiscount() {
    return discount;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }
}
