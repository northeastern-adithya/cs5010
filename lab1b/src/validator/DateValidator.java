package validator;

import java.util.Objects;

import utilities.DateUtils;


/**
 * A type of validator to check if the date is valid or not.
 */
public class DateValidator implements Validator {

  /**
   * Variable to represent a  day.
   */
  private final int day;
  /**
   * Variable to represent a  month.
   */
  private final int month;
  /**
   * Variable to represent a year.
   */
  private final int year;

  /**
   * A date validator constructor to check if the date is valid or not.
   *
   * @throws IllegalArgumentException if the given date is not valid.
   */
  public DateValidator(Integer day, Integer month, Integer year) throws IllegalArgumentException {
    if (Objects.isNull(day) || Objects.isNull(month) || Objects.isNull(year)) {
      throw new IllegalArgumentException("Received day,month or year as null");
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Validates if the date defined is proper or not.
   *
   * @throws IllegalArgumentException if the validation fails.
   */
  @Override
  public void validate() throws IllegalArgumentException {
    validateMyDate();
  }


  /**
   * Validates if the given date is valid.
   *
   * @throws IllegalArgumentException if the given date is not valid.
   */
  private void validateMyDate() throws IllegalArgumentException {
    validateYear();
    if (DateUtils.isFebruary(this.month)) {
      validateDayForFebruary();
    } else if (DateUtils.doesMonthContainThirtyOneDays(this.month)) {
      validateDayForMonthsWithThirtyOneDays();
    } else if (DateUtils.doesMonthContainThirtyDays(this.month)) {
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
    if (this.year < 0) {
      invalidDate();
    }
  }

  /**
   * Validates day for the month of February.
   *
   * @throws IllegalArgumentException if the given day for February is not valid.
   */
  private void validateDayForFebruary() throws IllegalArgumentException {
    if (DateUtils.isLeapYear(this.year)) {
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
   * Common method to throw exception if the date is invalid.
   *
   * @throws IllegalArgumentException throws a generic invalid date exception.
   */
  private void invalidDate() throws IllegalArgumentException {
    throw new IllegalArgumentException(String.format("Invalid date: %s", this));
  }
}
