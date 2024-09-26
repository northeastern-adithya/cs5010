package solution;

/**
 * Test the Queen class.
 */
public class QueenTest extends AbstractChessPieceTest {


  @Override
  protected ChessPiece createChessPiece(int row, int col, Color color) {
    return new Queen(row, col, color);
  }

  protected void setupResults(int row, int col) {
    moveHorizontalOrVertical(row, col);
    moveDiagonal(row, col);
  }


}