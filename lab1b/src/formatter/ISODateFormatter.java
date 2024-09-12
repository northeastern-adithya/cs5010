package formatter;

/**
 * Formatter to format date based on ISO date format: YYYY-MM-DD.
 */
public class ISODateFormatter implements DateFormatter {


  /**
   * Constructor to initiate ISO date formatter.
   */
  public ISODateFormatter() {
    // Is an empty constructor to prevent initializing it every time a formatter is called.
    // Hence, the format function takes in day, month and year as arguments.
  }

  /**
   * Formats date based on the iso date format.
   *
   * @param day   day part of the date.
   * @param month month part of the date.
   * @param year  year part of the date.
   * @return formatted date of format YYYY-MM-DD
   */
  @Override
  public String format(int day, int month, int year) {
    return String.format("%s-%s-%s", padYear(year), padMonth(month), padDay(day));
  }


  /**
   * Pads year part of date.
   *
   * @param year to be padded.
   * @return Pads year to have minimum 4 digits.
   */
  private String padYear(int year) {
    return year > 9999 ? String.format("%d", year) : String.format("%04d", year);
  }

  /**
   * Pads month part of date.
   *
   * @param month to be padded.
   * @return Pads month to have 2 digits.
   */
  private String padMonth(int month) {
    return String.format("%02d", month);
  }

  /**
   * Pads day part of date.
   *
   * @param day to be padded.
   * @return Pads day to have 2 digits.
   */
  private String padDay(int day) {
    return String.format("%02d", day);
  }
}
