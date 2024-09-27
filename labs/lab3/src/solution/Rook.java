package solution;

/**
 * Represents a rook in chess.
 */
public class Rook extends AbstractChessPiece {

  /**
   * Create a Rook object.
   *
   * @param row   the row of the piece
   * @param col   the column of the piece
   * @param color the color of the piece
   * @throws IllegalArgumentException if row or col is negative.
   */
  public Rook(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    }
    // The rook can move horizontally or vertically
    return canMoveHorizontallyOrVertically(row, col);
  }


}
