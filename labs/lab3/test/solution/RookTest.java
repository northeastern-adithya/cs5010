package solution;

/**
 * Test the Rook class.
 */
public class RookTest extends AbstractChessPieceTest {


  @Override
  protected ChessPiece createChessPiece(int row, int col, Color color) {
    return new Rook(row, col, color);
  }

  protected void setupResults(int row, int col) {
    moveHorizontalOrVertical(row, col);
  }

}