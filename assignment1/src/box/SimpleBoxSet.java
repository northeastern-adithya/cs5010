package box;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * This class implements the BoxSet interface providing methods to add and subtract boxes.
 */
public class SimpleBoxSet implements BoxSet {

  /**
   * A set to store the axis aligned non-overlapping axis-aligned rectangles.
   * Each box is represented as an array of 4 integers:
   * lower left x coordinate, lower left y coordinate , width, height.
   */
  private Set<int[]> boxSet;

  /**
   * Constructs a SimpleBoxSet object with an empty HashSet.
   */
  public SimpleBoxSet() {
    boxSet = new HashSet<>();
  }

  @Override
  public void add(int x, int y, int width, int height) throws IllegalArgumentException {
    validate(width, height);
    subtract(x, y, width, height);
    boxSet.add(new int[]{x, y, width, height});
  }

  @Override
  public void subtract(int x, int y, int width, int height) throws IllegalArgumentException {
    validate(width, height);
    Set<int[]> setAfterSubtracting = new HashSet<>();
    int[] boxToSubtract = new int[]{x, y, width, height};
    for (int[] box : boxSet) {
      if (doBoxesOverLap(box, boxToSubtract)) {
        int[] containedBox = findIntersection(box, boxToSubtract);
        setAfterSubtracting.addAll(findContainedDifference(box, containedBox));
      } else {
        setAfterSubtracting.add(box);
      }
      boxSet = setAfterSubtracting;
    }
  }

  @Override
  public int[][] getBoxes() {
    return boxSet.toArray(new int[boxSet.size()][4]);
  }

  @Override
  public int size() {
    return boxSet.size();
  }


  /**
   * Finds the intersection of two boxes.
   *
   * @param box1 the first box
   * @param box2 the second box
   * @return array containing lower left x and y coordinate, width and height of the intersection
   */
  private int[] findIntersection(int[] box1, int[] box2) {
    Point lowerLeftOfBoxOne =
            new Point(box1[0], box1[1]);
    Point upperRightOfBoxOne =
            new Point(lowerLeftOfBoxOne.x + box1[2], lowerLeftOfBoxOne.y + box1[3]);

    Point lowerLeftOfBoxTwo =
            new Point(box2[0], box2[1]);
    Point upperRightOfBoxTwo =
            new Point(lowerLeftOfBoxTwo.x + box2[2], lowerLeftOfBoxTwo.y + box2[3]);

    int xPointOfIntersection =
            Math.max(lowerLeftOfBoxOne.x, lowerLeftOfBoxTwo.x);
    int yPointOfIntersection =
            Math.max(lowerLeftOfBoxOne.y, lowerLeftOfBoxTwo.y);
    int widthOfIntersection =
            Math.min(upperRightOfBoxOne.x, upperRightOfBoxTwo.x) - xPointOfIntersection;
    int heightOfIntersection =
            Math.min(upperRightOfBoxOne.y, upperRightOfBoxTwo.y) - yPointOfIntersection;

    return new int[]{
        xPointOfIntersection,
        yPointOfIntersection,
        widthOfIntersection,
        heightOfIntersection};
  }

  /**
   * Finds the contained difference between two boxes.
   *
   * @param box          the box
   * @param containedBox the contained box
   * @return set of boxes after calculating contained difference
   */
  private Set<int[]> findContainedDifference(int[] box, int[] containedBox) {
    Set<int[]> containedDifference = new HashSet<>();

    Point lowerLeftOfBox =
            new Point(box[0], box[1]);
    Point upperRightOfBox =
            new Point(lowerLeftOfBox.x + box[2], lowerLeftOfBox.y + box[3]);
    Point lowerLeftOfContainedBox =
            new Point(containedBox[0], containedBox[1]);
    Point upperRightOfContainedBox =
            new Point(lowerLeftOfContainedBox.x + containedBox[2],
                    lowerLeftOfContainedBox.y + containedBox[3]);

    // Forming a set of 4 boxes to find coordinates of contained difference
    Point[] setOne =
                new Point[]{new Point(lowerLeftOfBox),
                    new Point(lowerLeftOfContainedBox.x, upperRightOfBox.y)};
    Point[] setTwo =
                new Point[]{new Point(upperRightOfContainedBox.x, lowerLeftOfBox.y),
                    new Point(upperRightOfBox)};
    Point[] setThree =
                new Point[]{new Point(lowerLeftOfContainedBox.x, upperRightOfContainedBox.y),
                    new Point(upperRightOfContainedBox.x, upperRightOfBox.y)};
    Point[] setFour =
                new Point[]{new Point(lowerLeftOfContainedBox.x, lowerLeftOfBox.y),
                    new Point(upperRightOfContainedBox.x, lowerLeftOfContainedBox.y)};

    // Going through the set and ignoring values with width or height 0
    for (Point[] set : new Point[][]{setOne, setTwo, setThree, setFour}) {
      int x = set[0].x;
      int y = set[0].y;
      int width = Math.abs(set[1].x - set[0].x);
      int height = Math.abs(set[1].y - set[0].y);
      if (width != 0 && height != 0) {
        containedDifference.add(new int[]{x, y, width, height});
      }
    }
    return containedDifference;
  }

  /**
   * Checks if two boxes overlap.
   *
   * @param box1 the first box
   * @param box2 the second box
   * @return true if the boxes overlap, false otherwise
   */
  private boolean doBoxesOverLap(int[] box1, int[] box2) {
    boolean doBoxesOverLapInXAxis = doBoxesOverLapInAxis(
            box1[0], box1[0] + box1[2], box2[0], box2[0] + box2[2]
    );
    boolean doBoxedOverLapInYAxis = doBoxesOverLapInAxis(
            box1[1], box1[1] + box1[3], box2[1], box2[1] + box2[3]
    );
    return doBoxesOverLapInXAxis && doBoxedOverLapInYAxis;
  }

  /**
   * Checks if two boxes overlap in a given axis.
   *
   * @param minimumOfBox1 the minimum axis value of the first box
   * @param maximumOfBox1 the maximum axis value of the first box
   * @param minimumOfBox2 the minimum axis value of the second box
   * @param maximumOfBox2 the maximum axis value of the second box
   * @return true if the boxes overlap in the given axis, false otherwise
   */
  private boolean doBoxesOverLapInAxis(int minimumOfBox1, int maximumOfBox1,
                                       int minimumOfBox2, int maximumOfBox2) {
    return (minimumOfBox1 < maximumOfBox2) && (maximumOfBox1 > minimumOfBox2);
  }

  /**
   * Validates the width and height of the box.
   *
   * @param width  the width of the box
   * @param height the height of the box
   * @throws IllegalArgumentException if the width or height is less than or equal to 0
   */
  private void validate(int width, int height) throws IllegalArgumentException {
    if (width <= 0) {
      throw new IllegalArgumentException("Width must be a positive integer");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("Height must be a positive integer");
    }

  }
}
