package cs3500.pa04.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing HandleJson and its associated methods
 */
class HandleJsonTest extends JsonTest {

  private HandleJson handler;

  /**
   * Initializes the test data
   */
  @BeforeEach
  public void setup() {
    handler = new HandleJson();
  }

  /**
   * Tests the handleJoin method
   */
  @Test
  public void testHandleJoin() {
    JsonNode response = handler.handleJoin();
    assertEquals(join, response);
  }

  /**
   * Tests the handleSetup method
   */
  @Test
  public void testHandleSetup() {
    JsonNode response = handler.handleSetup(setupArgs, player);
    assertEquals(setup, response);
  }

  /**
   * Tests the handleTakeShots method
   */
  @Test
  public void testHandleTakeShots() {
    setupBoard();
    JsonNode response = handler.handleTakeShots(player);
    assertEquals(takeShots, response);
  }

  /**
   * Tests the reportDamage method
   */
  @Test
  public void testReportDamage() {
    setupBoard();
    JsonNode response = handler.handleReportDamage(reportDamageArgs, player);
    assertEquals(reportDamage, response);
  }

  /**
   * Tests the successfulHits method
   */
  @Test
  public void testSuccessfulHits() {
    setupBoard();
    JsonNode response = handler.handleSuccessfulHits(successfulArgs, player);
    assertEquals(successfulHits, response);
  }

  /**
   * Tests the endGame method
   */
  @Test
  public void testEndGame() {
    setupBoard();
    JsonNode response = handler.handleEndGame(endGameArgs, player);
    assertEquals(endGame, response);
  }

}