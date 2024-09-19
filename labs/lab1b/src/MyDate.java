import formatter.ISODateFormatter;
import utilities.DateUtils;
import validator.DateValidator;

/**
 * This class represents a date. A date has a year, a month and a day.
 */
public class MyDate {


  /**
   * Variable to represent a  day.
   */
  private int day;
  /**
   * Variable to represent a  month.
   */
  private int month;
  /**
   * Variable to represent a year.
   */
  private int year;

  /**
   * Formatter to format date as YYYY-MM-DD.
   */
  private static final ISODateFormatter ISO_DATE_FORMATTER = new ISODateFormatter();

  /**
   * Construct a MyDate object that has the provided day, month and  year.
   *
   * @param day   the day of given date.
   * @param month the month of given date.
   * @param year  the year of given date.
   * @throws IllegalArgumentException if the given date in invalid.
   */
  public MyDate(Integer day, Integer month, Integer year) throws IllegalArgumentException {
    new DateValidator(day, month, year).validate();
    this.day = day;
    this.month = month;
    this.year = year;
  }


  /**
   * Advances the date based on given number of days.
   *
   * @param days number of days to advance, if negative will subtract the date.
   */
  public void advance(int days) {
    if (days > 0) {
      advanceForward(days);
    } else if (days < 0) {
      advanceReverse(days);
    }
  }

  /**
   * Advances the date in a forward manner.
   *
   * @param days number of days to advance.
   */
  private void advanceForward(int days) {
    while (days > 0) {
      if (DateUtils.doesMonthContainThirtyOneDays(this.month)) {
        if (this.day == 31) {
          this.day = 1;
          if (this.month == 12) {
            this.month = 1;
            this.year++;
          } else {
            this.month++;
          }
        } else {
          this.day++;
        }
      } else if (DateUtils.doesMonthContainThirtyDays(this.month)) {
        if (this.day == 30) {
          this.day = 1;
          this.month++;
        } else {
          this.day++;
        }
      } else if (DateUtils.isFebruary(this.month)) {
        if (DateUtils.isLeapYear(this.year)) {
          if (this.day == 29) {
            this.day = 1;
            this.month++;
          } else {
            this.day++;
          }
        } else {
          if (this.day == 28) {
            this.day = 1;
            this.month++;
          } else {
            this.day++;
          }
        }
      }
      days--;
    }
  }

  /**
   * Advances the date in a reverse manner.
   *
   * @param days number of days to go backwards.
   */
  private void advanceReverse(int days) {
    days = Math.abs(days);
    while (days > 0) {
      if (this.day == 1) {
        if (this.month == 1) {
          this.year -= 1;
          this.month = 12;
          this.day = 31;
        } else if (this.month == 2) {
          this.month -= 1;
          this.day = 31;
        } else if (this.month == 3) {
          this.month -= 1;
          if (DateUtils.isLeapYear(this.year)) {
            this.day = 29;
          } else {
            this.day = 28;
          }
        } else {
          this.month -= 1;
          if (DateUtils.doesMonthContainThirtyDays(this.month)) {
            this.day = 30;
          } else if (DateUtils.doesMonthContainThirtyOneDays(this.month)) {
            this.day = 31;
          }
        }
      } else {
        this.day--;
      }
      days--;
      if (this.day == 1 && this.month == 1 && this.year == 0) {
        break;
      }
    }
  }

  /**
   * String representation of the object.
   *
   * @return Padded representation of MyDate object in ISO date format.
   */
  @Override
  public String toString() {
    return ISO_DATE_FORMATTER.format(this.day, this.month, this.year);
  }
}
