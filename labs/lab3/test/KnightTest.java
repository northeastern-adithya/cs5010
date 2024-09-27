import solution.ChessPiece;
import solution.Color;
import solution.Knight;

/**
 * Test the Knight class.
 */
public class KnightTest extends AbstractChessPieceTest {

  @Override
  protected ChessPiece createChessPiece(int row, int col, Color color) {
    return new Knight(row, col, color);
  }

  protected void setupResults(int row, int col) {
    moveLShape(row, col);
  }

  /**
   * Move the knight in L shape.
   *
   * @param row the row of the piece
   * @param col the column of the piece
   */
  private void moveLShape(int row, int col) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((Math.abs(row - i) == 2 && Math.abs(col - j) == 1)
                || (Math.abs(row - i) == 1 && Math.abs(col - j) == 2)) {
          results[i][j] = true;
        }
      }
    }
  }
}
