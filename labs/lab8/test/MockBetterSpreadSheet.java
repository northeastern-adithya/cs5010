import java.awt.Point;
import java.io.IOException;

import spreadsheet.BetterSpreadSheet;

/**
 * A mock implementation of the BetterSpreadSheet interface.
 */
public class MockBetterSpreadSheet implements BetterSpreadSheet {

  private final Appendable log;


  /**
   * Create a new MockBetterSpreadSheet.
   *
   * @param log the log to append to
   */
  public MockBetterSpreadSheet(Appendable log) {
    this.log = log;
  }

  @Override
  public void setValueInRegion(Point upperLeft, Point lowerRight,
                               double value) {
    try {
      log.append(String.format("Setting number:%s in region:(%d,%d)"
                      + " to (%d,%d)", value, upperLeft.x,
              upperLeft.y, lowerRight.x, lowerRight.y));
    } catch (IOException ignore) {
      // Do nothing
    }
  }

  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public void set(int row, int col, double value) throws IllegalArgumentException {
    // Do nothing
  }

  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    return false;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }
}
