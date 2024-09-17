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
    int x1 = box1[0];
    int y1 = box1[1];
    int x2 = x1 + box1[2];
    int y2 = y1 + box1[3];

    int x3 = box2[0];
    int y3 = box2[1];
    int x4 = x3 + box2[2];
    int y4 = y3 + box2[3];

    int xPointOfIntersection = Math.max(x1, x3);
    int yPointOfIntersection = Math.max(y1, y3);
    int widthOfIntersection = Math.min(x2, x4) - xPointOfIntersection;
    int heightOfIntersection = Math.min(y2, y4) - yPointOfIntersection;
    return new int[]{xPointOfIntersection, yPointOfIntersection, widthOfIntersection, heightOfIntersection};
  }

  private Set<int[]> findContainedDifference(int[] box, int[] containedBox) {
    // TODO: implement the method
    Set<int[]> containedDifference = new HashSet<>();

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
