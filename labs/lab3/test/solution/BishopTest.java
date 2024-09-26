package solution;

/**
 * Test the Bishop class.
 */
public class BishopTest extends AbstractChessPieceTest {

  @Override
  protected ChessPiece createChessPiece(int row, int col, Color color) {
    return new Bishop(row, col, color);
  }


  protected void setupResults(int row, int col) {
    moveDiagonal(row, col);
  }


}