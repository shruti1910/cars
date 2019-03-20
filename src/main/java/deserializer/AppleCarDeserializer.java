package deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import models.AppleCar;
import models.Metadata;
import models.Metrics;
import models.PerDayRent;
import models.RentalCount;

import java.io.IOException;

public class AppleCarDeserializer extends StdDeserializer<AppleCar> {

  public AppleCarDeserializer() {
    this(null);
  }

  public AppleCarDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public AppleCar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {

    AppleCar appleCar = new AppleCar();

    JsonNode carNode = jsonParser.getCodec().readTree(jsonParser);

    appleCar.setMake(carNode.get("make").asText());
    appleCar.setModel(carNode.get("model").asText());
    appleCar.setVin(carNode.get("vin").asText());

    JsonNode metadataNode = carNode.get("metadata");
    appleCar.setMetadata(parseMetaData(metadataNode));

    JsonNode perdayrentNode = carNode.get("perdayrent");
    appleCar.setPerDayRent(parsePerDayRent(perdayrentNode));

    JsonNode metricsNode = carNode.get("metrics");
    appleCar.setMetrics(parseMetrics(metricsNode));

    System.out.println(carNode);

    return appleCar;
  }

  private PerDayRent parsePerDayRent(JsonNode perdayrentNode) {
    PerDayRent perDayRent = new PerDayRent();
    perDayRent.setPrice(perdayrentNode.get("price").asInt());
    perDayRent.setDiscount(perdayrentNode.get("discount").asInt());
    return perDayRent;
  }

  private Metadata parseMetaData(JsonNode metadataNode) {
    Metadata metadata = new Metadata();
    metadata.setColor(metadataNode.get("color").asText());
    metadata.setNotes(metadataNode.get("notes").asText());
    return metadata;
  }

  private Metrics parseMetrics(JsonNode metricsNode) {
    Metrics metrics = new Metrics();

    double yoymaintenancecost = metricsNode.get("yoymaintenancecost").asDouble();
    metrics.setYoymaintenancecost(yoymaintenancecost);

    double depreciation = metricsNode.get("depreciation").asDouble();
    metrics.setDepreciation(depreciation);

    JsonNode rentalCountNode = metricsNode.get("rentalcount");
    RentalCount rentalCount = parseRentalCount(rentalCountNode);
    metrics.setRentalCount(rentalCount);

    return metrics;
  }

  private RentalCount parseRentalCount(JsonNode rentalCountNode) {
    RentalCount rentalCount = new RentalCount();
    rentalCount.setLastweek(rentalCountNode.get("lastweek").asInt());
    rentalCount.setYeartodate(rentalCountNode.get("yeartodate").asInt());
    return rentalCount;
  }
}
