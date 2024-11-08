package spreadsheet;

/**
 * This interface represents a spreadsheet that can execute macros.
 */
public class SpreadSheetWithMacroImpl extends SparseSpreadSheet implements SpreadSheetWithMacro {

  /**
   * Executes the macro on the given spreadsheet.
   *
   * @param macro the macro to execute
   */
  @Override
  public void executeMacro(SpreadSheetMacro macro) {
    macro.execute(this);
  }
}
