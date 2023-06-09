package cs3500.pa04;

import cs3500.pa04.controller.Randomable;

/**
 * Mock class for testing random seeded methods
 */
public class MockRandom implements Randomable {

  private int intsIndex = 0;
  private int boolIndex = 0;
  private final int[] ints =
      new int[]{0, 0, 0, 0, 2, 4, 1, 1, 1, 1, 3, 0, 4, 2, 3, 1, 20, 27, 20, 20, 9, 30, 28, 1, 5,
          26, 15, 4, 0, 2, 11, 3, 9, 0, 9, 16, 11, 5, 5, 2, 9, 0, 0, 3, 5, 5, 4, 3, 1, 0, 1, 0};
  private final boolean[] booleans =
      new boolean[]{true, false, false, true, true, false, false, true, true};

  /**
   * Get the next random integer
   *
   * @return the next integer in the random sequence
   */
  @Override
  public int nextInt() {
    int next = ints[intsIndex];
    this.intsIndex++;
    return next;
  }

  /**
   * Gets the next random integer within the given bound
   *
   * @param bound the upper bound
   * @return the next integer in the random sequence within the bound
   */
  @Override
  public int nextInt(int bound) {
    return nextInt();
  }

  /**
   * Gets the next random boolean
   *
   * @return the next boolean in the random sequence
   */
  @Override
  public boolean nextBoolean() {
    boolean next = booleans[boolIndex];
    this.boolIndex++;
    return next;
  }
}
