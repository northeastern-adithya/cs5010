import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
   * List containing months having 31 days.
   */
  private static final List<Integer> MONTHS_WITH_THIRTY_ONE_DAYS
          = Arrays.asList(1, 3, 5, 7, 8, 10, 12);

  /**
   * List containing months having 30 days.
   */
  private static final List<Integer> MONTHS_WITH_THIRTY_DAYS = Arrays.asList(4, 6, 9, 11);

  /**
   * Construct a cs5010.hw01.date;
   * MyDate object that has the provided day, month and  year.
   *
   * @param day   the day of given date.
   * @param month the month of given date.
   * @param year  the year of given date.
   * @throws IllegalArgumentException if the given date in invalid.
   */
  public MyDate(Integer day, Integer month, Integer year) throws IllegalArgumentException {
    if (Objects.isNull(day) || Objects.isNull(month) || Objects.isNull(year)) {
      throw new IllegalArgumentException("Received day,month or year as null");
    }
    this.day = day;
    this.month = month;
    this.year = year;
    validateMyDate();
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
      if (doesMonthContainThirtyOneDays()) {
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
      } else if (doesMonthContainThirtyDays()) {
        if (this.day == 30) {
          this.day = 1;
          this.month++;
        } else {
          this.day++;
        }
      } else if (isFebruary()) {
        if (isLeapYear()) {
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
          if (isLeapYear()) {
            this.day = 29;
          } else {
            this.day = 28;
          }
        } else {
          this.month -= 1;
          if (doesMonthContainThirtyDays()) {
            this.day = 30;
          } else if (doesMonthContainThirtyOneDays()) {
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
   * Validates if the given date is valid.
   *
   * @throws IllegalArgumentException if the given date is not valid.
   */
  private void validateMyDate() throws IllegalArgumentException {
    validateYear();
    if (isFebruary()) {
      validateDayForFebruary();
    } else if (doesMonthContainThirtyOneDays()) {
      validateDayForMonthsWithThirtyOneDays();
    } else if (doesMonthContainThirtyDays()) {
      validateDayForMonthsWithThirtyDays();
    } else {
      invalidDate();
    }
  }

  /**
   * Validates if the year is valid.
   *
   * @throws IllegalArgumentException if the given year is not valid.
   */
  private void validateYear() throws IllegalArgumentException {
    if (!(this.year >= 0 && this.year <= 9999)) {
      invalidDate();
    }
  }

  /**
   * Validates day for the month of February.
   *
   * @throws IllegalArgumentException if the given day for February is not valid.
   */
  private void validateDayForFebruary() throws IllegalArgumentException {
    if (this.isLeapYear()) {
      if (!(this.day >= 1 && this.day <= 29)) {
        invalidDate();
      }
    } else {
      if (!(this.day >= 1 && this.day <= 28)) {
        invalidDate();
      }
    }
  }

  /**
   * Returns true if the given year is leap year, false otherwise.
   */
  private boolean isLeapYear() {
    return (this.year % 4 == 0)
            && ((this.year % 100 != 0) || (this.year % 400 == 0) && this.year % 100 == 0);
  }

  /**
   * Validates day for the months containing 31 days.
   *
   * @throws IllegalArgumentException if the given day is not valid.
   */
  private void validateDayForMonthsWithThirtyOneDays() throws IllegalArgumentException {
    if (!(this.day >= 1 && this.day <= 31)) {
      invalidDate();
    }
  }

  /**
   * Validates day for the months containing 30 days.
   *
   * @throws IllegalArgumentException if the given day is not valid.
   */
  private void validateDayForMonthsWithThirtyDays() throws IllegalArgumentException {
    if (!(this.day >= 1 && this.day <= 30)) {
      invalidDate();
    }
  }

  /**
   * Returns true if the given month is February, false otherwise.
   */
  private boolean isFebruary() {
    return this.month == 2;
  }


  /**
   * Returns true if the given month contains 31 days, false otherwise.
   */
  private boolean doesMonthContainThirtyOneDays() {
    return MONTHS_WITH_THIRTY_ONE_DAYS.contains(this.month);
  }

  /**
   * Returns true if the given month contains 30 days, false otherwise.
   */
  private boolean doesMonthContainThirtyDays() {
    return MONTHS_WITH_THIRTY_DAYS.contains(this.month);
  }

  /**
   * Common method to throw exception if the date is invalid.
   *
   * @throws IllegalArgumentException throws a generic invalid date exception.
   */
  private void invalidDate() throws IllegalArgumentException {
    throw new IllegalArgumentException(String.format("Invalid date: %s", this));
  }

  /**
   * String representation of the object.
   *
   * @return Padded representation of MyDate object.
   */
  @Override
  public String toString() {
    return String.format("%s-%s-%s", padYear(), padMonth(), padDay());
  }

  /**
   * Pads year part of date.
   *
   * @return Pads year to have minimum 4 digits.
   */
  private String padYear() {
    return this.year > 9999 ? String.format("%d", this.year) : String.format("%04d", this.year);
  }

  /**
   * Pads month part of date.
   *
   * @return Pads month to have 2 digits.
   */
  private String padMonth() {
    return String.format("%02d", this.month);
  }

  /**
   * Pads day part of date.
   *
   * @return Pads day to have 2 digits.
   */
  private String padDay() {
    return String.format("%02d", this.day);
  }
}
