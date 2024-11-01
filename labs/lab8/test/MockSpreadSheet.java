import java.io.IOException;

import spreadsheet.SpreadSheet;

/**
 * A mock implementation of the SpreadSheet interface.
 */
public class MockSpreadSheet implements SpreadSheet {


  private final Appendable log;

  /**
   * Create a new MockSpreadSheet.
   *
   * @param log the log to append to
   */
  public MockSpreadSheet(Appendable log) {
    this.log = log;
  }

  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    try {
      log.append(String.format("GET row: %s col: %s", row, col));
    } catch (IOException ignore) {
      // Do nothing
    }

    return 0;

  }

  @Override
  public void set(int row, int col, double value) throws IllegalArgumentException {
    try {
      log.append(String.format("SET row: %s col:%s value:%s", row, col, value));
    } catch (IOException ignore) {
      //  Do nothing
    }
  }

  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    try {
      log.append(String.format("isEmpty row:%s col:%s", row, col));
    } catch (IOException ignore) {
      // Do nothing
    }
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
