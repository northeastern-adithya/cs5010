package formatter;


/**
 * Formatter to format date based on required formatting style.
 */
public interface DateFormatter {
  /**
   * Formats date based on the required formatting style.
   *
   * @param day   day part of the date.
   * @param month month part of the date.
   * @param year  year part of the date.
   * @return formatted date.
   */
  String format(int day, int month, int year);

}
