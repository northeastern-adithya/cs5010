package box;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SimpleBoxSet implements BoxSet {

  private Set<int[]> boxSet;

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


  private int[] findIntersection(int[] box1, int[] box2) {
    Point lowerLeftOfBoxOne = new Point(box1[0], box1[1]);
    Point upperRightOfBoxOne = new Point(lowerLeftOfBoxOne.x + box1[2], lowerLeftOfBoxOne.y + box1[3]);

    Point lowerLeftOfBoxTwo = new Point(box2[0], box2[1]);
    Point upperRightOfBoxTwo = new Point(lowerLeftOfBoxTwo.x + box2[2], lowerLeftOfBoxTwo.y + box2[3]);

    int xPointOfIntersection = Math.max(lowerLeftOfBoxOne.x, lowerLeftOfBoxTwo.x);
    int yPointOfIntersection = Math.max(lowerLeftOfBoxOne.y, lowerLeftOfBoxTwo.y);
    int widthOfIntersection = Math.min(upperRightOfBoxOne.x, upperRightOfBoxTwo.x) - xPointOfIntersection;
    int heightOfIntersection = Math.min(upperRightOfBoxOne.y, upperRightOfBoxTwo.y) - yPointOfIntersection;
    return new int[]{xPointOfIntersection, yPointOfIntersection, widthOfIntersection, heightOfIntersection};
  }

  private Set<int[]> findContainedDifference(int[] box, int[] containedBox) {
    Set<int[]> containedDifference = new HashSet<>();
    Point lowerLeftOfBox = new Point(box[0], box[1]);
    Point upperRightOfBox = new Point(lowerLeftOfBox.x + box[2], lowerLeftOfBox.y + box[3]);

    Point lowerLeftOfContainedBox = new Point(containedBox[0], containedBox[1]);
    Point upperRightOfContainedBox = new Point(lowerLeftOfContainedBox.x + containedBox[2], lowerLeftOfContainedBox.y + containedBox[3]);

    Point[] setOne = new Point[]{new Point(lowerLeftOfBox), new Point(lowerLeftOfContainedBox.x, upperRightOfBox.y)};
    Point[] setTwo = new Point[]{new Point(upperRightOfContainedBox.x, lowerLeftOfBox.y), new Point(upperRightOfBox)};
    Point[] setThree = new Point[]{new Point(lowerLeftOfContainedBox.x, upperRightOfContainedBox.y), new Point(upperRightOfContainedBox.x, upperRightOfBox.y)};
    Point[] setFour = new Point[]{new Point(lowerLeftOfContainedBox.x, lowerLeftOfBox.y), new Point(upperRightOfContainedBox.x, lowerLeftOfContainedBox.y)};

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

  private boolean doBoxesOverLap(int[] box1, int[] box2) {
    boolean doBoxesOverLapInXAxis = doBoxesOverLapInAxis(
            box1[0], box1[0] + box1[2], box2[0], box2[0] + box2[2]
    );
    boolean doBoxedOverLapInYAxis = doBoxesOverLapInAxis(
            box1[1], box1[1] + box1[3], box2[1], box2[1] + box2[3]
    );
    return doBoxesOverLapInXAxis && doBoxedOverLapInYAxis;
  }

  private boolean doBoxesOverLapInAxis(int minimumOfBox1, int maximumOfBox1, int minimumOfBox2, int maximumOfBox2) {
    return (minimumOfBox1 < maximumOfBox2) && (maximumOfBox1 > minimumOfBox2);
  }

  private void validate(int width, int height) throws IllegalArgumentException {
    if (width <= 0) {
      throw new IllegalArgumentException("Width must be a positive integer");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("Height must be a positive integer");
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
}
