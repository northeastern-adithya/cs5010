package spreadsheet;

/**
 * This class represents a macro that calculates the average of the cells in a
 * given range and stores the result in a specified cell.
 */
public class AverageMacro implements SpreadSheetMacro {

  private final int startingRow;
  private final int startingColumn;
  private final int endingRow;
  private final int endingColumn;

  private final int destinationRow;
  private final int destinationColumn;


  /**
   * Constructs an AverageMacro with the specified range and destination cell.
   *
   * @param startingRow       the starting row of the range
   * @param startingColumn    the starting column of the range
   * @param endingRow         the ending row of the range
   * @param endingColumn      the ending column of the range
   * @param destinationRow    the row of the cell where the average will be
   *                          stored
   * @param destinationColumn the column of the cell where the average will
   *                          be stored
   * @throws IllegalArgumentException if any of the row or column indices are
   *                                  negative,
   *                                  or if the end row/column is less than
   *                                  the start row/column
   */
  public AverageMacro(int startingRow, int startingColumn, int endingRow,
                      int endingColumn, int destinationRow,
                      int destinationColumn) {
    validateRowAndColumn(startingRow, startingColumn, endingRow, endingColumn
            , destinationRow, destinationColumn);
    this.startingRow = startingRow;
    this.startingColumn = startingColumn;
    this.endingRow = endingRow;
    this.endingColumn = endingColumn;
    this.destinationRow = destinationRow;
    this.destinationColumn = destinationColumn;
  }

  /**
   * Validates the row and column indices.
   *
   * @param startingRow       the starting row of the range
   * @param startingColumn    the starting column of the range
   * @param endingRow         the ending row of the range
   * @param endingColumn      the ending column of the range
   * @param destinationRow    the row of the cell where the average will be
   *                          stored
   * @param destinationColumn the column of the cell where the average will
   *                          be stored
   * @throws IllegalArgumentException if any of the row or column indices are
   *                                  negative,
   *                                  or if the end row/column is less than
   *                                  the start row/column
   */
  private void validateRowAndColumn(int startingRow, int startingColumn,
                                    int endingRow, int endingColumn,
                                    int destinationRow, int destinationColumn) {
    if (startingRow < 0 || startingColumn < 0 || endingRow < 0
            || endingColumn < 0 || destinationRow < 0 || destinationColumn < 0) {
      throw new IllegalArgumentException("Row and column indices must be " +
              "non-negative");
    }
    if (endingRow < startingRow || endingColumn < startingColumn) {
      throw new IllegalArgumentException(
              "End row/column must be greater than or equal to start row/column"
      );
    }
  }

  @Override
  public void execute(SpreadSheet spreadsheet) {
    double sum = 0.0;
    int count = 0;
    for (int row = startingRow; row <= endingRow; row++) {
      for (int col = startingColumn; col <= endingColumn; col++) {
        sum += spreadsheet.get(row, col);
        count++;
      }
    }
    double average = sum / count;
    spreadsheet.set(destinationRow, destinationColumn, average);
  }
}
