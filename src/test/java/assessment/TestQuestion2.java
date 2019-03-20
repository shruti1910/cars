package assessment;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import deserializer.AppleCarDeserializer;
import models.AppleCar;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestQuestion2 {

  private static Assessment assessment = new Assessment();

  @Test
  public void testFindLowestPerDayRentalCarOnPrice() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(AppleCar.class, new AppleCarDeserializer());
    mapper.registerModule(module);

    File jsonArray = new File("src/test/data/cars_1.json");
    System.out.println(jsonArray);
    List<AppleCar> cars = mapper.readValue(
        jsonArray, new TypeReference<List<AppleCar>>() {
        });

    List<AppleCar> cheapestCars = assessment.lowestPerDayRentalOnPrice(cars);
    assertEquals(1, cheapestCars.size());
  }

  @Test
  public void testFindLowestPerDayRentalCarOnPriceAfterDiscount() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(AppleCar.class, new AppleCarDeserializer());
    mapper.registerModule(module);

    File jsonArray = new File("data/cars_1.json");
    System.out.println(jsonArray);
    List<AppleCar> cars = mapper.readValue(
        jsonArray, new TypeReference<List<AppleCar>>() {
        });

    List<AppleCar> cheapestCars = assessment.lowestPerDayRentalOnPriceAfterDiscount(cars);
    assertEquals(1, cheapestCars.size());
  }
}
