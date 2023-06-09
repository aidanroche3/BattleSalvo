package cs3500.pa04.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa03.model.ComputerPlayer;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.ShipType;
import cs3500.pa04.Direction;
import cs3500.pa04.MockRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for holding Json test data
 */
public abstract class JsonTest {

  protected final ComputerPlayer player = new ComputerPlayer(new MockRandom());
  private final ObjectMapper mapper = new ObjectMapper();

  private final JsonNode joinNode =
      JsonUtils.serializeRecord(new JoinJson("user", GameType.SINGLE));
  private final MessageJson joinMessage = new MessageJson("join", joinNode);
  protected final JsonNode join = JsonUtils.serializeRecord(joinMessage);

  private final FleetSpecJson fleetSpec =
      new FleetSpecJson(1, 1, 1, 1);
  protected final JsonNode setupArgs =
      JsonUtils.serializeRecord(new SetupJson(6, 6, fleetSpec));
  private final CoordJson carrierCoord = new CoordJson(0, 0);
  private final ShipJson carrier = new ShipJson(carrierCoord, 6, Direction.VERTICAL);
  private final CoordJson battleshipCoord = new CoordJson(1, 1);
  private final ShipJson battleship = new ShipJson(battleshipCoord, 5, Direction.HORIZONTAL);
  private final CoordJson destroyerCoord = new CoordJson(2, 4);
  private final ShipJson destroyer = new ShipJson(destroyerCoord, 4, Direction.HORIZONTAL);
  private final CoordJson submarineCoord = new CoordJson(1, 3);
  private final ShipJson submarine = new ShipJson(submarineCoord, 3, Direction.VERTICAL);
  private final ShipJson[] ships = new ShipJson[]{carrier, battleship, destroyer, submarine};
  private final FleetJson fleet = new FleetJson(ships);
  private final JsonNode fleetArgs = JsonUtils.serializeRecord(fleet);
  private final MessageJson fleetMessage = new MessageJson("setup", fleetArgs);
  protected final JsonNode setup = JsonUtils.serializeRecord(fleetMessage);

  private final CoordJson takeShotOne = new CoordJson(2, 3);
  private final CoordJson takeShotTwo = new CoordJson(4, 4);
  private final CoordJson takeShotThree = new CoordJson(3, 3);
  private final CoordJson takeShotFour = new CoordJson(4, 3);
  private final CoordJson[] shots =
      new CoordJson[]{takeShotOne, takeShotTwo, takeShotThree, takeShotFour};
  private final CoordinatesJson coordinateShots = new CoordinatesJson(shots);
  private final JsonNode coordinatesNode = JsonUtils.serializeRecord(coordinateShots);
  private final MessageJson coordinatesMessage =
      new MessageJson("take-shots", coordinatesNode);
  protected final JsonNode takeShots = JsonUtils.serializeRecord(coordinatesMessage);

  private final CoordJson reportCoordOne = new CoordJson(0, 1);
  private final CoordJson reportCoordTwo = new CoordJson(0, 2);
  private final CoordJson reportCoordThree = new CoordJson(0, 3);
  private final CoordJson reportCoordFour = new CoordJson(0, 4);
  private final CoordJson[] coords = new CoordJson[]{reportCoordOne, reportCoordTwo,
      reportCoordThree, reportCoordFour};
  private final CoordinatesJson coordinatesJson = new CoordinatesJson(coords);
  protected final JsonNode reportDamageArgs = JsonUtils.serializeRecord(coordinatesJson);
  private final MessageJson reportDamageMessage =
      new MessageJson("report-damage", reportDamageArgs);
  protected final JsonNode reportDamage = JsonUtils.serializeRecord(reportDamageMessage);

  private final CoordJson successfulHitOne = new CoordJson(0, 0);
  private final CoordJson successfulHitTwo = new CoordJson(1, 3);
  private final CoordJson[] hits = new CoordJson[]{successfulHitOne, successfulHitTwo};
  private final CoordinatesJson successfulCoordinates = new CoordinatesJson(hits);
  protected final JsonNode successfulArgs = JsonUtils.serializeRecord(successfulCoordinates);
  private final JsonNode emptyArgs = mapper.createObjectNode();
  private final MessageJson successfulMessage =
      new MessageJson("successful-hits", emptyArgs);
  protected final JsonNode successfulHits = JsonUtils.serializeRecord(successfulMessage);

  private final EndJson endJson = new EndJson(GameResult.WIN, "You win because...");
  protected final JsonNode endGameArgs = JsonUtils.serializeRecord(endJson);
  private final MessageJson endResponse = new MessageJson("end-game", emptyArgs);
  protected final JsonNode endGame = JsonUtils.serializeRecord(endResponse);

  /**
   * Initializes the test data
   */
  protected void setupBoard() {
    Map<ShipType, Integer> specs = new HashMap<>();
    specs.put(ShipType.CARRIER, 1);
    specs.put(ShipType.BATTLESHIP, 1);
    specs.put(ShipType.DESTROYER, 1);
    specs.put(ShipType.SUBMARINE, 1);
    player.setup(6, 6, specs);
  }

}
