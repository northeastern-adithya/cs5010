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
public class TestSimpleBoxSetAddition {

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
    IllegalArgumentException exception
            = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, -1, 2));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with zero width.
   */
  @Test
  public void testAdditionWithZeroWidth() {
    IllegalArgumentException exception
            = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 0, 2));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with negative height.
   */
  @Test
  public void testAdditionNegativeHeight() {
    IllegalArgumentException exception
            = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 2, -1));
    assertEquals("Height must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with zero height.
   */
  @Test
  public void testAdditionWithZeroHeight() {
    IllegalArgumentException exception
            = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 2, 0));
    assertEquals("Height must be a positive integer", exception.getMessage());
  }


  /**
   * Tests addition with negative width and height.
   */
  @Test
  public void testAdditionWithNegativeWidthAndHeight() {
    IllegalArgumentException exception
            = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, -1, -1));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }

  /**
   * Tests addition with zero width and height.
   */
  @Test
  public void testAdditionWithZeroWidthAndHeight() {
    IllegalArgumentException exception
            = assertThrows(IllegalArgumentException.class, () -> boxSet.add(0, 0, 0, 0));
    assertEquals("Width must be a positive integer", exception.getMessage());
  }

  /**
   * Tests addition with two boxes intersecting in the first quadrant
   * in the bottom right of one box and top left of the other box.
   */
  @Test
  public void tesAdditionWithTwoBoxesIntersectingInFirstQuadrant() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 1, 5, 3);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 4, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 1, 5, 3}));
  }

  /**
   * Tests addition with two boxes intersecting in the second quadrant.
   */
  @Test
  public void tesAdditionWithTwoBoxesIntersectingInSecondQuadrant() {
    boxSet.add(-4, 2, 2, 2);
    boxSet.add(-3, 0, 3, 3);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, 3, 1, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, 0, 3, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-4, 2, 1, 2}));
  }

  /**
   * Tests addition with two boxes intersecting in the third quadrant.
   */
  @Test
  public void tesAdditionWithTwoBoxesIntersectingInThirdQuadrant() {
    boxSet.add(-4, -3, 2, 2);
    boxSet.add(-3, -5, 3, 3);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, -2, 1, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, -5, 3, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-4, -3, 1, 2}));
  }


  /**
   * Tests addition with two boxes intersecting in the fourth quadrant.
   */
  @Test
  public void tesAdditionWithTwoBoxesIntersectingInFourthQuadrant() {
    boxSet.add(2, -3, 4, 2);
    boxSet.add(4, -4, 4, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, -2, 2, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, -4, 4, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{2, -3, 2, 2}));
  }

  /**
   * Tests addition of box contained and touching the bottom left corner of another box.
   */
  @Test
  public void testBoxAdditionContainedInBottomLeftCorner() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(3, 2, 2, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 4, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 2, 2}));
  }

  /**
   * Tests addition of box contained and touching the bottom center of another box.
   */
  @Test
  public void testBoxAdditionContainedInBottomCenter() {
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
   * Tests addition of box contained and touching the bottom right corner of another box.
   */
  @Test
  public void testBoxAdditionContainedInBottomRightCorner() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 2, 2, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 4, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 2, 2, 2}));
  }

  /**
   * Tests addition of box contained and touching the left middle of another box.
   */
  @Test
  public void testBoxAdditionContainedInLeftMiddle() {
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
   * Tests addition of box contained and touching the left corner of another box.
   */
  @Test
  public void testBoxAdditionContainedInUpperLeftCorner() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(3, 4, 2, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 4, 2, 2}));
  }


  /**
   * Tests addition of box contained and touching the middle of another box.
   */
  @Test
  public void testBoxAdditionContainedInUpperMiddle() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(4, 5, 3, 1);
    assertEquals(4, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 1, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{7, 2, 1, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 5, 3, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 2, 3, 3}));
  }

  /**
   * Tests addition of box containedand touching the upper right corner of another box.
   */
  @Test
  public void testBoxAdditionContainedInUpperRightCorner() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 5, 2, 1);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 2, 2, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 5, 2, 1}));
  }

  /**
   * Tests addition of box contained and touching the right middle of another box.
   */
  @Test
  public void testBoxAdditionContainedInRightMiddle() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 3, 2, 2);
    assertEquals(4, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 5, 2, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 2, 2, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 3, 2, 2}));
  }

  /**
   * Tests addition of box contained in center of the other box.
   */
  @Test
  public void testBoxAdditionContainedInCenter() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(4, 3, 3, 2);
    assertEquals(5, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{7, 2, 1, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 5, 3, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 1, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 2, 3, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 3, 3, 2}));
  }


  /**
   * Tests addition of box contained and covers half of the outer box.
   */
  @Test
  public void testBoxAdditionContainedAndInHalf() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(3, 2, 5, 2);
    assertEquals(2, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 5, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 4, 5, 2}));
  }

  /**
   * Tests addition of box overlapping in right side of one box to left side of another box.
   */
  @Test
  public void testBoxAdditionWithOverlappingEachOther() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 2, 5, 4);
    assertEquals(2, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 2, 5, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
  }

  /**
   * Tests addition of box overlapping in right upper corner of one box
   * to left bottom corner of another box.
   */
  @Test
  public void testBoxAdditionWithOverlappingInTheRightUpperCornerOfBoxOne() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 4, 5, 4);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 2, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 4, 5, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
  }

  /**
   * Tests addition of box overlapping in right bottom corner of one box
   * to left upper corner of another box.
   */
  @Test
  public void testBoxAdditionWithOverlappingInTheRightBottomCornerOfBoxOne() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(6, 0, 5, 4);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 4, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 3, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{6, 0, 5, 4}));
  }

  /**
   * Tests addition of box overlapping in left bottom corner of one box
   * to right upper corner of another box.
   */
  @Test
  public void testBoxAdditionWithOverlappingInTheLeftBottomCornerOfBoxOne() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(0, 0, 4, 4);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{0, 0, 4, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 4, 1, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 2, 4, 4}));
  }

  /**
   * Tests addition of box overlapping in right top corner of one box
   * to left bottom corner of another box.
   * Also tests between
   */
  @Test
  public void testBoxAdditionWithOverlappingInTheRightTopCornerOfBoxOne() {
    boxSet.add(3, 2, 5, 4);
    boxSet.add(-3, 4, 7, 4);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 1, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, 4, 7, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 2, 4, 4}));
  }


  /**
   * Tests bigger box completely overlaps smaller box.
   */
  @Test
  public void testBiggerBoxCompletelyOverlapsSmallerBox() {
    boxSet.add(5, 4, 2, 2);
    boxSet.add(3, 2, 6, 5);
    assertEquals(1, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 2, 6, 5}));
  }

  /**
   * Tests boxes overlapping in the second and third quadrant.
   */
  @Test
  public void testOverlappingInTheSecondAndThirdQuadrant() {
    boxSet.add(-4, -1, 2, 2);
    boxSet.add(-3, 0, 2, 2);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, -1, 1, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, 0, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-4, -1, 1, 2}));

  }

  /**
   * Tests boxes overlapping in the third and fourth quadrant.
   */
  @Test
  public void testOverlappingInTheThirdAndFourthQuadrant() {
    boxSet.add(-2, -3, 3, 2);
    boxSet.add(0, -3, 3, 2);
    assertEquals(2, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{0, -3, 3, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-2, -3, 2, 2}));
  }

  /**
   * Tests boxes overlapping in the fourth and first quadrant.
   */
  @Test
  public void testOverlappingInTheFourthAndFirstQuadrant() {
    boxSet.add(2, -3, 4, 2);
    boxSet.add(1, -2, 4, 4);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{2, -3, 3, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{1, -2, 4, 4}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, -3, 1, 2}));
  }


  /**
   * Tests addition of 4 boxes overlapping.
   */
  @Test
  public void testAdditionWithFourOverlappingBoxes() {
    boxSet.add(-4, 1, 2, 3);
    boxSet.add(-3, 0, 4, 2);
    boxSet.add(-1, 1, 4, 2);
    boxSet.add(2, 1, 3, 3);
    assertEquals(6, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();

    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, 2, 1, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-4, 1, 1, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-1, 1, 3, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-3, 0, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{-1, 0, 2, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{2, 1, 3, 3}));

  }

  /**
   * Tests 3 boxes non overlapping.
   */
  @Test
  public void testAdditionOfThreeNonOverlappingBoxes() {
    boxSet.add(1, 1, 2, 3);
    boxSet.add(5, 1, 2, 3);
    boxSet.add(8, 1, 2, 3);
    assertEquals(3, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{1, 1, 2, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{5, 1, 2, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{8, 1, 2, 3}));
  }


  /**
   * Tests two boxes touching on an edge.
   */
  @Test
  public void testAdditionOfTwoBoxesTouchingOnOneEdge() {
    boxSet.add(1, 1, 2, 3);
    boxSet.add(3, 1, 2, 3);
    assertEquals(2, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{1, 1, 2, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{3, 1, 2, 3}));
  }


  /**
   * Tests addition of big box containing 4 boxes covering the entire area.
   */
  @Test
  public void testAdditionOfFourBoxesContainedInABigBox() {
    boxSet.add(1, 1, 7, 3);
    boxSet.add(1, 1, 3, 1);
    boxSet.add(1, 2, 3, 2);
    boxSet.add(4, 1, 4, 1);
    boxSet.add(4, 2, 4, 2);
    assertEquals(4, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{1, 1, 3, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{1, 2, 3, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 1, 4, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{4, 2, 4, 2}));
  }


  /**
   * Tests addition of big box and 4 small boxes in corners.
   */
  @Test
  public void testAdditionOfFourBoxesInCornersOfBigBox() {
    boxSet.add(1, 1, 7, 3);
    boxSet.add(7, 0, 2, 2);
    boxSet.add(0, 0, 2, 2);
    boxSet.add(0, 3, 2, 2);
    boxSet.add(7, 3, 2, 2);
    assertEquals(7, boxSet.size());
    int[][] actualBoxSet = boxSet.getBoxes();
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{7, 0, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{0, 0, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{7, 2, 1, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{1, 2, 1, 1}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{7, 3, 2, 2}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{2, 1, 5, 3}));
    assertTrue(TestUtility.containsBox(actualBoxSet, new int[]{0, 3, 2, 2}));


  }


}
