package solution;

public class Queen extends AbstractChessPiece {

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
