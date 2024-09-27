package solution;

/**
 * Represents a knight in chess.
 */
public class Knight extends AbstractChessPiece {

  /**
   * Create a Knight object.
   *
   * @param row   the row of the piece
   * @param col   the column of the piece
   * @param color the color of the piece
   * @throws IllegalArgumentException if row or col is negative.
   */
  public Knight(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    }
    // The knight can move in an L-shape
    return (Math.abs(row - getRow()) == 2 && Math.abs(col - getColumn()) == 1)
            || (Math.abs(row - getRow()) == 1 && Math.abs(col - getColumn()) == 2);
  }
}
