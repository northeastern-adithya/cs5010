package spreadsheet;

/**
 * This class represents a macro that assigns a value to a range of cells in a
 * spreadsheet.
 */
public class BulkAssignMacro implements SpreadSheetMacro {
  private final double value;
  private final int startingRow;
  private final int startingColumn;
  private final int endingRow;
  private final int endingColumn;

  /**
   * Constructs a BulkAssignMacro with the specified range and value.
   *
   * @param startingRow    the starting row of the range
   * @param startingColumn the starting column of the range
   * @param endingRow      the ending row of the range
   * @param endingColumn   the ending column of the range
   * @param value          the value to assign to the range
   * @throws IllegalArgumentException if any of the row or column indices are
   *                                  negative,
   *                                  or if the end row/column is less than
   *                                  the start row/column
   */
  public BulkAssignMacro(int startingRow, int startingColumn, int endingRow,
                         int endingColumn, double value) {
    validateRowAndColumn(startingRow, startingColumn, endingRow, endingColumn);
    this.value = value;
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
    for (int row = startingRow; row <= endingRow; row++) {
      for (int col = startingColumn; col <= endingColumn; col++) {
        spreadsheet.set(row, col, value);
      }
    }

  }
}
