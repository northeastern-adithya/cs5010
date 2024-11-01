package spreadsheet;

import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents the controller of an interactive spreadsheet
 * application.
 * This controller offers a simple text interface in which the user can
 * type instructions to manipulate a spreadsheet.
 *
 * <p>This controller works with any Readable to read its inputs and
 * any Appendable to transmit output. This controller directly uses
 * the Appendable object (i.e. there is no official "view")
 *
 * <p>A cell in the spreadsheet is referred to using a row-letter and a column
 * number.
 * The row letter starts from A-Z and then AA-ZZ, then AAA-ZZZ and so on.
 * The column numbers begin with 1.
 *
 * <p>For example, the cell in the first row and column is A 1.
 * The cell in the 30th row and 26th column is AD 26.
 *
 * <p>In this way it tries to simulate how Microsoft Excel works (except that
 * it uses letters for rows, not columns).
 */
public class SpreadSheetController {
  private Readable readable;
  private Appendable appendable;
  private BetterSpreadSheet sheet;

  /**
   * Create a controller to work with the specified sheet (model),
   * readable (to take inputs) and appendable (to transmit output).
   *
   * @param sheet      the sheet to work with (the model)
   * @param readable   the Readable object for inputs
   * @param appendable the Appendable objects to transmit any output
   */
  public SpreadSheetController(BetterSpreadSheet sheet, Readable readable,
                               Appendable appendable) {
    if ((sheet == null) || (readable == null) || (appendable == null)) {
      throw new IllegalArgumentException("Sheet, readable or appendable is "
              + "null");
    }
    this.sheet = sheet;
    this.appendable = appendable;
    this.readable = readable;
  }

  /**
   * The main method that relinquishes control of the application to the
   * controller.
   *
   * @throws IllegalStateException if the controller is unable to transmit
   *                               output
   */
  public void controlSpreadSheets() throws IllegalStateException {
    Scanner sc = new Scanner(readable);
    boolean quit = false;
    int row;
    int col;
    double value;

    //print the welcome message
    this.welcomeMessage();

    while (!quit) { //continue until the user quits
      writeMessage("Type instruction: "); //prompt for the instruction name
      String userInstruction = sc.next(); //take an instruction name
      switch (userInstruction) {
        case "assign-value": //assign a value to a cell
          try {
            row = getRowNum(sc.next()); //get in the row string
            col = sc.nextInt(); //get in the column number, starting with 1
            System.out.println("Setting cell (" + row + "," + (col - 1));
            sheet.set(row, col - 1, sc.nextDouble()); //use the spreadsheet
          } catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "print-value": //print a value from the cell
          try {
            row = getRowNum(sc.next()); //get the row string
            col = sc.nextInt(); //get the column number, starting with 1
            writeMessage("Value: " + sheet.get(row, col - 1) + System.lineSeparator());
          } catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "bulk-assign":
          try {
            Point upperLeft = new Point(getRowNum(sc.next()), sc.nextInt());
            Point lowerRight = new Point(getRowNum(sc.next()), sc.nextInt());
            value = sc.nextDouble();
            writeMessage(String.format("Setting number:%s in region:(%d,%d)"
                            + " to (%d,%d)\n", value, upperLeft.x,
                    upperLeft.y, lowerRight.x, lowerRight.y));
            sheet.setValueInRegion(upperLeft, lowerRight, value);
          } catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "menu": //print the menu of supported instructions
          welcomeMessage();
          break;
        case "q": //quit
        case "quit": //quit
          quit = true;
          break;
        default: //error due to unrecognized instruction
          writeMessage("Undefined instruction: " + userInstruction + System.lineSeparator());
      }
    }

    //after the user has quit, print farewell message
    this.farewellMessage();

  }

  //converts a row string into a row number starting with 0
  private int getRowNum(String rowLetters) throws IllegalArgumentException {
    int rownumber = 0;

    for (int i = 0; i < rowLetters.length(); i = i + 1) {
      char c = rowLetters.charAt(i);
      if (!Character.isAlphabetic(c)) {
        throw new IllegalArgumentException("Invalid row");
      }
      rownumber = 26 * rownumber + ((int) Character.toLowerCase(c) - 'a' + 1);
    }
    return rownumber - 1;
  }


  private void writeMessage(String message) throws IllegalStateException {
    try {
      appendable.append(message);

    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  private void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("assign-value row-num col-num value (set a cell to a value)"
            + System.lineSeparator());
    writeMessage("print-value row-num col-num (print the value at a given "
            + "cell)" + System.lineSeparator());
    writeMessage("menu (Print supported instruction list)" + System.lineSeparator());
    writeMessage("q or quit (quit the program) " + System.lineSeparator());
  }

  private void welcomeMessage() throws IllegalStateException {
    writeMessage("Welcome to the spreadsheet program!" + System.lineSeparator());
    printMenu();
  }

  private void farewellMessage() throws IllegalStateException {
    writeMessage("Thank you for using this program!");
  }


}
