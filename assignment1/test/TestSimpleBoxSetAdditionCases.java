import org.junit.Before;
import org.junit.Test;

import box.BoxSet;
import box.SimpleBoxSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the SimpleBoxSet addition cases.
 */
public class TestSimpleBoxSetAdditionCases {

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

  /**
   * Tests addition with negative width.
   */
  @Test
  public void testAdditionWithNegativeWidth() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, -1, 2));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with zero width.
   */
  @Test
  public void testAdditionWithZeroWidth() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 0, 2));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with negative height.
   */
  @Test
  public void testAdditionNegativeHeight() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 2, -1));
    assertEquals("Height must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with zero height.
   */
  @Test
  public void testAdditionWithZeroHeight() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 2, 0));
    assertEquals("Height must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with negative width and height.
   */
  @Test
  public void testAdditionWithNegativeWidthAndHeight() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, -1, -1));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }

  /**
   * Tests addition with zero width and height.
   */
  @Test
  public void testAdditionWithZeroWidthAndHeight() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 0, 0));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }

  /**
   * Tests addition with two rectangles intersecting in the first quadrant.
   */
  @Test
  public void tesAdditionWithTwoRectanglesIntersectingInFirstQuadrant() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 1, 5, 3);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 4, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 1, 5, 3}));
  }

  /**
   * Tests addition of rectangle contained in bottom left corner.
   */
  @Test
  public void testRectangleAdditionContainedInBottomLeftCorner() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(3, 2, 2, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 4, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 2, 2}));
  }

  /**
   * Tests addition of rectangle contained in bottom center.
   */
  @Test
  public void testRectangleAdditionContainedInBottomCenter() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(5, 2, 2, 3);
    assertEquals(4, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 2, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{7, 2, 1, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 2, 2, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 5, 2, 1}));
  }

  /**
   * Tests addition of rectangle contained in bottom right corner.
   */
  @Test
  public void testRectangleAdditionContainedInBottomRightCorner() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 2, 2, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 4, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 2, 2, 2}));
  }

  /**
   * Tests addition of rectangle contained in left middle.
   */
  @Test
  public void testRectangleAdditionContainedInLeftMiddle() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(3, 3, 2, 2);
    assertEquals(4, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 5, 2, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 3, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 2, 1}));
  }

  /**
   * Tests addition of rectangle contained in upper left corner.
   */
  @Test
  public void testRectangleAdditionContainedInUpperLeftCorner() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(3, 4, 2, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 4, 2, 2}));
  }


}
