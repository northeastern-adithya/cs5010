package spreadsheet;

/**
 * This interface represents a macro that can be executed on a spreadsheet.
 */
public interface SpreadSheetMacro {

  /**
   * Executes the macro on the given spreadsheet.
   *
   * @param spreadsheet the spreadsheet to execute the macro on
   */
  void execute(SpreadSheet spreadsheet);
}
