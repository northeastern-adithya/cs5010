public class Queen extends AbstractChessPiece {

  public Queen(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    }
    return ((this.row == row) || (this.col == col)
            || (Math.abs(this.row - row) == Math.abs(this.col - col)));
  }
}
