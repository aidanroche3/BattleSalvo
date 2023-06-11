package cs3500.pa03.model;

import cs3500.pa04.controller.Randomable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for a hard difficulty computer player
 */
public class HardComputer extends SalvoPlayer {

  private final ArrayList<Coord> checkerStack = new ArrayList<>();
  private final ArrayList<Coord> coordStack = new ArrayList<>();
  private int row = 0;
  private int col = 0;
  private int offset = 1;
  private boolean finishedCheckerboard;

  /**
   * Instantiates a BattleSalvo player
   *
   * @param random a random object
   */
  public HardComputer(Randomable random) {
    super("Difficult AI", random);
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public List<Coord> takeShots() {
    int numShots = getShotCount();
    if (!finishedCheckerboard) {
      List<Coord> shots = completeCheckerboard(numShots);
      if (shots.size() < numShots) {
        int extra = numShots - shots.size();
        for (int i = 0; i < extra; i++) {
          shots.add(coordStack.remove(0));
        }
      }
      setCurrentTurnShots(shots);
      return shots;
    } else {
      ArrayList<Coord> shots = new ArrayList<>();
      for (int i = 0; i < numShots; i++) {
        shots.add(coordStack.remove(0));
      }
      setCurrentTurnShots(shots);
      return shots;
    }
  }

  private List<Coord> completeCheckerboard(int numShots) {
    ArrayList<Coord> shots = new ArrayList<>();
    for (int i = 0; i < numShots; i++) {
      if (col > opponentBoard[row].length - 1) {
        row++;
        col = offset;
        offset++;
        if (offset > 2) {
          offset = 0;
        }
      }
      if (row > opponentBoard.length - 1) {
        finishedCheckerboard = true;
        populateCoordStack();
        return shots;
      }
      checkerStack.add(opponentBoard[row][col]);
      shots.add(opponentBoard[row][col]);
      col += 3;
    }
    return shots;
  }

  private void populateCoordStack() {
    for (Coord[] coords : opponentBoard) {
      for (Coord c : coords) {
        if (c.isEmpty() && !checkerStack.contains(c)) {
          coordStack.add(c);
        }
      }
    }
    Collections.shuffle(coordStack);
  }



}
