package solution;

/**
 * Represents a Queen in chess.
 */
public class Queen extends AbstractChessPiece {

  /**
   * Create a Queen object.
   *
   * @param row   the row of the piece
   * @param col   the column of the piece
   * @param color the color of the piece
   * @throws IllegalArgumentException if row or col is negative.
   */
  public Queen(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    }
    // The queen can move horizontally, vertically, or diagonally
    return canMoveHorizontallyOrVertically(row, col)
            || canMoveDiagonally(row, col);
  }
}
