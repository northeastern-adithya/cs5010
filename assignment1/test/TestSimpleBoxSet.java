import org.junit.Before;
import org.junit.Test;

import box.BoxSet;
import box.SimpleBoxSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the SimpleBoxSet class.
 */
public class TestSimpleBoxSet {

  /**
   * The BoxSet object to be tested.
   */
  private BoxSet boxSet;

  /**
   * Sets up the BoxSet object before each test.
   */
  @Before
  public void setUp() {
    boxSet = new SimpleBoxSet();
  }


  @Test
  public void testSubtract() {
    boxSet.add(0, 0, 4, 2);
    boxSet.subtract(2, -1, 4, 2);
    assertEquals(2, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(containsBox(actualBoxSet, new int[]{0, 0, 2, 2}));
    assertTrue(containsBox(actualBoxSet, new int[]{2, 1, 2, 1}));
  }

  @Test
  public void tesAdd() {
    boxSet.add(0, 0, 4, 2);
    boxSet.add(2, -1, 4, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(containsBox(actualBoxSet, new int[]{0, 0, 2, 2}));
    assertTrue(containsBox(actualBoxSet, new int[]{2, 1, 2, 1}));
    assertTrue(containsBox(actualBoxSet, new int[]{2, -1, 4, 2}));
  }


  /**
   * Utility function to check if the boxSet contains the expected box.
   *
   * @param boxSet      the boxSet input
   * @param expectedBox the expected box to be checked
   * @return true if the boxSet contains the expected box, false otherwise
   */
  private boolean containsBox(int[][] boxSet, int[] expectedBox) {
    for (int[] boxInBoxSet : boxSet) {
      if (boxInBoxSet[0] == expectedBox[0] && boxInBoxSet[1] == expectedBox[1]
              && boxInBoxSet[2] == expectedBox[2] && boxInBoxSet[3] == expectedBox[3]) {
        return true;
      }
    }
    return false;
  }

}
