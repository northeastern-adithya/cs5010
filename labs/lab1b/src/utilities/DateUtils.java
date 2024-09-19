package utilities;

/**
 * This class represents a utility class for all the helper functions.
 */
public class DateUtils {


  /**
   * Private constructor for date utils.
   */
  private DateUtils() {
  }

  /**
   * Returns true if the given month is February, false otherwise.
   *
   * @param month month to check
   */
  public static boolean isFebruary(int month) {
    return month == 2;
  }


  /**
   * Returns true if the given month contains 31 days, false otherwise.
   *
   * @param month month to check
   */
  public static boolean doesMonthContainThirtyOneDays(int month) {
    return DateConstants.MONTHS_WITH_THIRTY_ONE_DAYS.contains(month);
  }

  /**
   * Returns true if the given month contains 30 days, false otherwise.
   *
   * @param month month to check
   */
  public static boolean doesMonthContainThirtyDays(int month) {
    return DateConstants.MONTHS_WITH_THIRTY_DAYS.contains(month);
  }

  /**
   * Returns true if the given year is leap year, false otherwise.
   *
   * @param year year to check
   */
  public static boolean isLeapYear(int year) {
    return (year % 4 == 0)
            && ((year % 100 != 0) || (year % 400 == 0) && year % 100 == 0);
  }


}
