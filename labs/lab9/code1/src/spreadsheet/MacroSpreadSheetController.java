package spreadsheet;

import java.util.Scanner;

/**
 * A controller for a spreadsheet that can execute macros.
 */
public class MacroSpreadSheetController extends SpreadSheetController {
  /**
   * Constructs a MacroSpreadSheetController with the specified
   * spreadsheet, readable, and appendable.
   *
   * @param sheet      the spreadsheet to control
   * @param readable   the readable source for user input
   * @param appendable the appendable destination for output
   */
  public MacroSpreadSheetController(SpreadSheet sheet, Readable readable,
                                    Appendable appendable) {
    super(sheet, readable, appendable);
  }


  protected void processCommand(String userInstruction, Scanner sc,
                                SpreadSheet sheet) {
    try {
      switch (userInstruction) {
        case "bulk-assign-value": {
          handleBulkAssign(sc, sheet);
          break;
        }
        case "average": {
          handleAverage(sc, sheet);
          break;
        }
        case "range-assign": {
          handleRangeAssign(sc, sheet);
          break;
        }
        default:
          super.processCommand(userInstruction, sc, sheet);
      }
    } catch (IllegalArgumentException e) {
      writeMessage("Error: " + e.getMessage() + System.lineSeparator());
    }

  }

  private void handleAverage(Scanner sc, SpreadSheet sheet) {
    int startRow = getRowNum(sc.next());
    int startCol = sc.nextInt() - 1;
    int endRow = getRowNum(sc.next());
    int endCol = sc.nextInt() - 1;
    int destRow = getRowNum(sc.next());
    int destCol = sc.nextInt() - 1;
    new AverageMacro(startRow, startCol, endRow, endCol, destRow, destCol).execute(sheet);
  }


  private void handleRangeAssign(Scanner sc, SpreadSheet sheet) {
    int startRow = getRowNum(sc.next());
    int startCol = sc.nextInt() - 1;
    int endRow = getRowNum(sc.next());
    int endCol = sc.nextInt() - 1;
    int startValue = sc.nextInt();
    int increment = sc.nextInt();
    new RangeAssignMacro(startRow, startCol, endRow, endCol, startValue,
            increment).execute(sheet);
  }

  private void handleBulkAssign(Scanner sc, SpreadSheet sheet) {
    int startingRow = getRowNum(sc.next());
    int startingCol = sc.nextInt() - 1;
    int endingRow = getRowNum(sc.next());
    int endingCol = sc.nextInt() - 1;
    double value = sc.nextDouble();
    new BulkAssignMacro(startingRow, startingCol, endingRow, endingCol
            , value).execute(sheet);
  }

  @Override
  protected void printMenu() throws IllegalStateException {
    writeMessage("Supported user instructions are: " + System.lineSeparator());
    writeMessage("assign-value row-num col-num value (set a cell to a value)"
            + System.lineSeparator());
    writeMessage("print-value row-num col-num (print the value at a given cell)"
            + System.lineSeparator());
    writeMessage("bulk-assign-value from-row-num from-col-num to-row-num " +
            "to-col-num value (set a range of cells to a value)" + System.lineSeparator() +
            "range-assign from-row-num from-col-num to-row-num to-col-num " +
            "start-value increment (set a row or column of cells to a range " +
            "of values starting at the given value and advancing by the " +
            "increment)" + System.lineSeparator() +
            "average from-row-num from-col-num to-row-num to-col-num " +
            "dest-row-num dest-col-num (compute the average of a range of " +
            "cells and put it at the given location)" + System.lineSeparator());

    writeMessage("menu (Print supported instruction list)" + System.lineSeparator());
    writeMessage("q or quit (quit the program) " + System.lineSeparator());
  }
}
