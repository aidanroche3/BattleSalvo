package cs3500.pa04.adapters;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.CoordType;
import cs3500.pa04.json.CoordJson;
import org.junit.jupiter.api.BeforeEach;

/**
 * Represents tests for coord adapter
 */
class CoordAdapterTest {
  Coord coord1;
  CoordJson coordJson1;

  /**
   * Instantiates coords and coord jsons
   */
  @BeforeEach
  void setup() {
    coord1 = new Coord(5, 4, CoordType.EMPTY);
    coordJson1 = new CoordJson(5, 4);
  }



}
