package box;

/**
 * This interface represents a set of non-overlapping axis-aligned boxes.
 */
public interface BoxSet {
  /**
   * Adds a new box to the  existing set.
   * If box overlaps with existing box, the intersection is taken and
   * contained difference is added to the set else the new box is added as is.
   *
   * @param x      the x-coordinate of the lower-left corner of the box
   * @param y      the y-coordinate of the lower-left corner of the box
   * @param width  the width of the box
   * @param height the height of the box
   * @throws IllegalArgumentException if the width or height is less than or equal to 0
   */
  void add(int x, int y, int width, int height) throws IllegalArgumentException;

  /**
   * Subtracts a box from the existing set.
   * If box overlaps with existing box, the intersection is taken and
   * contained difference is added to the set else the existing box is added as it is.
   *
   * @param x      the x-coordinate of the lower-left corner of the box
   * @param y      the y-coordinate of the lower-left corner of the box
   * @param width  the width of the box
   * @param height the height of the box
   * @throws IllegalArgumentException if the width or height is less than or equal to 0
   */
  void subtract(int x, int y, int width, int height) throws IllegalArgumentException;

  /**
   * Returns the boxes present in the set.
   *
   * @return the boxes present in the set in a 2d array.
   */
  int[][] getBoxes();

  /**
   * Returns the number of boxes present in the set.
   *
   * @return the number of boxes present in the set.
   */
  int size();
}
