package spreadsheet;


import java.awt.Point;

/**
 * This interface represents a better spreadsheet. A better spreadsheet is a
 * spreadsheet that can set a value in a region of cells.
 */
public interface BetterSpreadSheet extends SpreadSheet {


  /**
   * Set the value of all the cells in the region defined by the upper left and
   * lower right points to the specified value.
   *
   * @param upperLeft  the upper left point of the region
   * @param lowerRight the lower right point of the region
   * @param value      the value that all the cells in the region must be set to
   */
  void setValueInRegion(Point upperLeft, Point lowerRight, double value);
}
