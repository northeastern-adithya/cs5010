package spreadsheet;

import java.io.InputStreamReader;

/**
 * The main class for the spreadsheet program.
 */
public class SpreadSheetProgram {
  /**
   * The main method for the spreadsheet program.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    BetterSpreadSheet model = new SparseSpreadSheet();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    SpreadSheetController controller = new SpreadSheetController(model, rd, ap);
    controller.controlSpreadSheets();
  }
}
