package solution;

public class Bishop extends AbstractChessPiece {

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
