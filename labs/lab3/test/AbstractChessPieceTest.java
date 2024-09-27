import org.junit.Before;
import org.junit.Test;

import solution.ChessPiece;
import solution.Color;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Abstract class to test all the common methods of the ChessPiece.
 */
public abstract class AbstractChessPieceTest {

  /**
   * The results of the canMove method for all the possible moves.
   */
  protected boolean[][] results;

  /**
   * Set up the results array.
   */
  @Before
  public void setup() {
    results = new boolean[8][8];

  }

  /**
   * Verify the results of the canMove method.
   *
   * @param piece the piece to be tested.
   */
  private void verifyMoveResults(ChessPiece piece) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }

        assertEquals("Piece at :"
                        + piece.getRow()
                        + ","
                        + piece.getColumn()
                        + ", Unexpected canMove result "
                        + "for "
                        + "i="
                        + i
                        + " j="
                        + j
                        + "",
                results[i][j], piece.canMove(i, j));

      }
    }
  }

  /**
   * Verify the results of the canKill method.
   *
   * @param piece the piece to be tested.
   */
  private void verifyKillResults(ChessPiece piece) {

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {

        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }

        ChessPiece another = createChessPiece(i, j,
                Color.values()[(piece.getColor().ordinal() + 1)
                        % Color.values().length]);


        assertEquals("Unexpected canKill result for "
                        + "i="
                        + i
                        + " j="
                        + j
                        + "",
                results[i][j], piece.canKill(another));

      }
    }
  }


  /**
   * Test the getters of the ChessPiece class.
   */
  @Test(timeout = 500)
  public void testGetters() {
    ChessPiece piece;


    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        for (Color c : Color.values()) {
          piece = createChessPiece(row, col, c);
          assertEquals("Row number does not match what was initialized", row,
                  piece.getRow());
          assertEquals("Column number does not match what was initialized",
                  col, piece.getColumn());
          assertEquals("solution.solution.Color does not match what was initialized",
                  c, piece.getColor());

        }
      }
    }

  }

  /**
   * Test the constructor of ChessPiece class throws IllegalArgumentException.
   */
  @Test(timeout = 500)
  public void testInvalidConstructions() {
    ChessPiece piece;

    for (Color c : Color.values()) {
      for (int i = 0; i < 8; i++) {


        try {
          piece = createChessPiece(i, -1, c);
          fail("Did not throw an exception when rook is created with invalid " +
                  "row");
        } catch (IllegalArgumentException e) {
          //passes
        }

        try {
          piece = createChessPiece(-1, i, c);
          fail("Did not throw an exception when rook is created with invalid " +
                  "column");
        } catch (IllegalArgumentException e) {
          //passes
        }

      }
    }
  }


  /**
   * Test the canMove method of the ChessPiece class.
   */
  @Test(timeout = 500)
  public void testChessPieceMoves() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        initializeResults();
        ChessPiece piece = createChessPiece(row, col, Color.BLACK);

        setupResults(row, col);
        verifyMoveResults(piece);
      }
    }
  }

  /**
   * Test the canKill method of the ChessPiece class.
   */
  @Test(timeout = 500)
  public void testChessPieceKills() {

    for (Color c : Color.values()) {
      for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
          initializeResults();
          ChessPiece piece = createChessPiece(row, col, c);

          setupResults(row, col);
          verifyKillResults(piece);
        }
      }
    }
  }


  /**
   * Initialize the results array to false.
   */
  private void initializeResults() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        results[row][col] = false;
      }
    }
  }

  /**
   * Create a chess piece of the type that is being tested.
   *
   * @param row   the row of the piece
   * @param col   the column of the piece
   * @param color the color of the piece
   * @return the chess piece
   */
  protected abstract ChessPiece createChessPiece(int row, int col, Color color);

  /**
   * Set up the results array for the piece being tested to test canMove and canKill.
   *
   * @param row the row of the piece
   * @param col the column of the piece
   */
  protected abstract void setupResults(int row, int col);


  /**
   * To indicate a piece can be moved horizontally or vertically.
   *
   * @param row the row of the piece
   * @param col the column of the piece
   */
  protected void moveHorizontalOrVertical(int row, int col) {
    //check if canMove works
    for (int i = 0; i < 8; i++) {
      results[i][col] = true;
      results[row][i] = true;
    }
  }


  /**
   * To indicate a piece can be moved diagonally.
   *
   * @param row the row of the piece
   * @param col the column of the piece
   */
  protected void moveDiagonal(int row, int col) {
    //check if canMove works
    for (int i = 0; i < 8; i++) {

      if ((row + i) < 8) {
        if ((col + i) < 8) {
          results[row + i][col + i] = true;
        }
        if (col >= i) {
          results[row + i][col - i] = true;
        }

      }

      if (row >= i) {
        if ((col + i) < 8) {
          results[row - i][col + i] = true;
        }
        if (col >= i) {
          results[row - i][col - i] = true;
        }
      }
    }
  }
}
