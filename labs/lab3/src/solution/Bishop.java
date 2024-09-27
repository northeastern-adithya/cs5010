package solution;

/**
 * Represents a bishop in chess.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * Create a Bishop object.
   *
   * @param row   the row of the piece
   * @param col   the column of the piece
   * @param color the color of the piece
   * @throws IllegalArgumentException if row or col is negative.
   */
  public Bishop(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    }
    // The bishop can move diagonally
    return canMoveDiagonally(row, col);
  }

}
