public class Rook extends AbstractChessPiece {

  public Rook(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if (!super.canMove(row, col)) {
      return false;
    }
    return ((this.row == row) || (this.col == col));
  }


}
