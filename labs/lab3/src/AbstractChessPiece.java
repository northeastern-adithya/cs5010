public abstract class AbstractChessPiece implements ChessPiece {

  protected int row;
  protected int col;
  protected Color color;

  protected AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Illegal position");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return col;
  }

  @Override
  public Color getColor() {
    return color;
  }


  @Override
  public boolean canMove(int row, int col) {
    return (row >= 0) && (col >= 0) && (row < 8) && (col < 8);
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    return (this.getColor() != piece.getColor()) && canMove(
            piece.getRow(),
            piece.getColumn());
  }
}
