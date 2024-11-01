import org.junit.Test;

import java.io.StringReader;
import java.util.Arrays;

import spreadsheet.BetterSpreadSheet;
import spreadsheet.SparseSpreadSheet;
import spreadsheet.SpreadSheetController;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * A class to test the SpreadSheet program.
 */
public class TestSpreadSheet {

  @Test
  public void testWelcomeMessage() {
    Readable input = new StringReader("q");
    Appendable output = new StringBuilder();
    BetterSpreadSheet sheet = new SparseSpreadSheet();
    SpreadSheetController controller = new SpreadSheetController(sheet, input,
            output);
    controller.controlSpreadSheets();

    String[] expected = {
        "Welcome to the spreadsheet program!",
        "Supported user instructions are: ",
        "assign-value row-num col-num value (set a cell to a value)",
        "print-value row-num col-num (print the value at a given cell)",
        "menu (Print supported instruction list)",
        "q or quit (quit the program) ",
    };
    String[] actual = output.toString().split("\n");
    //  Removing the thank you message.
    actual = Arrays.copyOf(actual, actual.length - 1);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testFarewellMessage() {
    Readable input = new StringReader("q");
    Appendable output = new StringBuilder();
    BetterSpreadSheet sheet = new SparseSpreadSheet();
    SpreadSheetController controller = new SpreadSheetController(sheet, input,
            output);
    controller.controlSpreadSheets();

    String expectedFarewellMessage = "Thank you for using this program!";
    String[] actual = output.toString().split("\n");

    String actualFarewellMessage =
            actual[actual.length - 1].split(":")[1].trim();
    assertEquals(expectedFarewellMessage, actualFarewellMessage);
  }

  @Test
  public void testAssignValue() {
    Readable in = new StringReader("assign-value B 10 5 q");
    Appendable log = new StringBuilder();
    BetterSpreadSheet sheet = new MockBetterSpreadSheet(log);
    SpreadSheetController controller = new SpreadSheetController(sheet, in,
            new StringBuilder());
    controller.controlSpreadSheets();
    assertEquals("SET row: 1 col: 9 value: 5.0", log.toString().trim());
  }

  @Test
  public void testPrintValue() {
    Readable in = new StringReader("print-value B 10 q");
    Appendable log = new StringBuilder();
    BetterSpreadSheet sheet = new MockBetterSpreadSheet(log);
    SpreadSheetController controller = new SpreadSheetController(sheet, in,
            new StringBuilder());
    controller.controlSpreadSheets();
    assertEquals("GET row: 1 col: 9", log.toString().trim());
  }

  @Test
  public void testBulkAssign() {
    Readable in = new StringReader("bulk-assign B 20 D 40 30 q");
    Appendable log = new StringBuilder();
    BetterSpreadSheet sheet = new MockBetterSpreadSheet(log);
    SpreadSheetController controller = new SpreadSheetController(sheet, in,
            new StringBuilder());
    controller.controlSpreadSheets();
    assertEquals("Setting number:30.0 in region:(1,20) to (3,40)",
            log.toString());
  }
}
