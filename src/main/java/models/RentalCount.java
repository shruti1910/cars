package models;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class RentalCount {
  private int lastweek;
  private int yeartodate;

  public RentalCount() { }

  RentalCount(int lastweek, int yeartodate) {
    this.lastweek = lastweek;
    this.yeartodate = yeartodate;
  }

  @Override
  public String toString() {
    List<String> fields = Arrays.asList(
        String.valueOf(lastweek),
        String.valueOf(yeartodate));
    return "{" + StringUtils.join(fields, ", ") + "}";
  }

  public int getLastweek() {
    return lastweek;
  }

  public void setLastweek(int lastweek) {
    this.lastweek = lastweek;
  }

  public int getYeartodate() {
    return yeartodate;
  }

  public void setYeartodate(int yeartodate) {
    this.yeartodate = yeartodate;
  }
}
