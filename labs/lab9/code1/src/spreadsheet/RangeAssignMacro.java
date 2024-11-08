package spreadsheet;

/**
 * This class represents a macro that assigns values to a range of cells in a
 * spreadsheet.
 */
public class RangeAssignMacro implements SpreadSheetMacro {
  private final int startingRow;
  private final int startingColumn;
  private final int endingRow;
  private final int endingColumn;
  private final double startValue;
  private final double increment;

  /**
   * Constructs a RangeAssignMacro with the specified range and values.
   *
   * @param startingRow    the starting row of the range
   * @param startingColumn the starting column of the range
   * @param endingRow      the ending row of the range
   * @param endingColumn   the ending column of the range
   * @param startValue     the starting value to assign to the range
   * @param increment      the amount to increment the value by for each cell
   * @throws IllegalArgumentException if any of the row or column indices are
   *                                  negative,
   *                                  or if the end row/column is less than
   *                                  the start row/column
   */
  public RangeAssignMacro(int startingRow, int startingColumn, int endingRow,
                          int endingColumn, double startValue,
                          double increment) {
    validateRowAndColumn(startingRow, startingColumn, endingRow, endingColumn);
    this.startValue = startValue;
    this.increment = increment;
    this.startingRow = startingRow;
    this.startingColumn = startingColumn;
    this.endingRow = endingRow;
    this.endingColumn = endingColumn;
  }

  private void validateRowAndColumn(int startingRow, int startingColumn,
                                    int endingRow, int endingColumn) {
    if (startingRow < 0 || startingColumn < 0 || endingRow < 0 || endingColumn < 0) {
      throw new IllegalArgumentException("Row and column indices must be "
              + "non-negative");
    }
    if (endingRow < startingRow || endingColumn < startingColumn) {
      throw new IllegalArgumentException(
              "End row/column must be greater than or equal to start row/column"
      );
    }
  }

  @Override
  public void execute(SpreadSheet spreadsheet) {
    double value = startValue;
    for (int row = startingRow; row <= endingRow; row++) {
      for (int col = startingColumn; col <= endingColumn; col++) {
        spreadsheet.set(row, col, value);
        value += increment;
      }
    }

  }
}
