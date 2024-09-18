/**
 * Utility class for testing.
 */
public class TestUtility {

  /**
   * Private constructor of utility class.
   */
  private TestUtility(){

  }

  /**
   * Utility function to check if the boxSet contains the expected box.
   *
   * @param boxSet      the boxSet input
   * @param expectedBox the expected box to be checked
   * @return true if the boxSet contains the expected box, false otherwise
   */
  public static boolean containsBox(int[][] boxSet, int[] expectedBox) {
    for (int[] boxInBoxSet : boxSet) {
      if (boxInBoxSet[0] == expectedBox[0] && boxInBoxSet[1] == expectedBox[1]
              && boxInBoxSet[2] == expectedBox[2] && boxInBoxSet[3] == expectedBox[3]) {
        return true;
      }
    }
    return false;
  }
}
