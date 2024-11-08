package spreadsheet;

/**
 * This interface represents a spreadsheet that can execute macros.
 */
public interface SpreadSheetWithMacro extends SpreadSheet {
  /**
   * Executes the macro on the given spreadsheet.
   *
   * @param macro the macro to execute
   */
  void executeMacro(SpreadSheetMacro macro);
}
