package solution;

/**
 * Abstract class for implementing chess piece.
 */
public abstract class AbstractChessPiece implements ChessPiece {

  /**
   * The row of the piece.
   */
  protected int row;
  /**
   * The column of the piece.
   */
  protected int col;

  /**
   * The color of the piece.
   */
  protected Color color;

  /**
   * Constructor for the abstract chess piece.
   *
   * @param row   the row of the piece
   * @param col   the column of the piece
   * @param color the color of the piece
   * @throws IllegalArgumentException if row or col is negative.
   */
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

  protected boolean canMoveDiagonally(int row, int col) {
    return (Math.abs(this.row - row) == Math.abs(this.col - col));
  }

  protected boolean canMoveHorizontallyOrVertically(int row, int col) {
    return ((this.row == row) || (this.col == col));
  }
}
