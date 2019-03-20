package deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import models.AppleCar;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AppleCarDeserializerDemo {

  public static void main(String[] args) throws IOException {

    File json = new File("data/car_example.json");

    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(AppleCar.class, new AppleCarDeserializer());
    mapper.registerModule(module);

    AppleCar readValue = mapper.readValue(json, AppleCar.class);
    System.out.println(readValue);

    File jsonArray = new File("data/cars_example.json");
    System.out.println(jsonArray);
    List<AppleCar> cars = mapper.readValue(
        jsonArray, new TypeReference<List<AppleCar>>() { });

    for (Object car : cars) {
      System.out.println(car);
      System.out.println(car.getClass());
    }
  }
}
