package models;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Metadata {
  private String color;
  private String notes;

  public Metadata() {}

  Metadata(String color, String notes) {
    this.color = color;
    this.notes = notes;
  }

  @Override
  public String toString() {
    List<String> fields = Arrays.asList(
        String.valueOf(color),
        String.valueOf(notes));
    return "{" + StringUtils.join(fields, ", ") + "}";
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
