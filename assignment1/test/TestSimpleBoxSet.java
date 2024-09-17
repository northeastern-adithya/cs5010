import org.junit.Before;
import org.junit.Test;

import box.BoxSet;
import box.SimpleBoxSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestSimpleBoxSet {

  private BoxSet boxSet;

  @Before
  public void setUp() {
    boxSet = new SimpleBoxSet();
    boxSet.add(0, 0, 4, 2);
  }


  @Test
  public void testSubtract() {
    boxSet.subtract(2, -1, 4, 2);
    assertEquals(2, boxSet.size());
    int[][] expectedBoxSetAfterSubtraction = new int[2][4];
    expectedBoxSetAfterSubtraction[0] = new int[]{0, 0, 2, 2};
    expectedBoxSetAfterSubtraction[1] = new int[]{2, 1, 2, 1};
    assertArrayEquals(expectedBoxSetAfterSubtraction, boxSet.getBoxes());
  }

  @Test
  public void tesAdd() {
    boxSet.subtract(2, -1, 4, 2);
    assertEquals(3, boxSet.size());
    int[][] expectedBoxSetAfterSubtraction = new int[3][4];
    expectedBoxSetAfterSubtraction[0] = new int[]{0, 0, 2, 2};
    expectedBoxSetAfterSubtraction[1] = new int[]{2, 1, 2, 1};
    expectedBoxSetAfterSubtraction[2] = new int[]{2, -1, 4, 2};
    assertArrayEquals(expectedBoxSetAfterSubtraction, boxSet.getBoxes());
  }


}
