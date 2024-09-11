import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


/**
 * Tests to check working of MyDate class.
 */
public class TestMyDate {
  /**
   * Validates if the date for January is initialised properly.
   */
  @Test
  public void validateDateForJanuary() {
    assertEquals("2000-01-01", new MyDate(1, 1, 2000).toString());
    assertEquals("2000-01-10", new MyDate(10, 1, 2000).toString());
    assertEquals("2000-01-21", new MyDate(21, 1, 2000).toString());
  }

  /**
   * Validates if the date for February is initialised properly.
   */
  @Test
  public void validateDateForFebruary() {
    assertEquals("2000-02-01", new MyDate(1, 2, 2000).toString());
    assertEquals("2000-02-10", new MyDate(10, 2, 2000).toString());
    assertEquals("2000-02-21", new MyDate(21, 2, 2000).toString());
    assertEquals("2000-02-28", new MyDate(28, 2, 2000).toString());
  }

  /**
   * Validates if the date for March is initialised properly.
   */
  @Test
  public void validateDateForMarch() {
    assertEquals("2000-03-01", new MyDate(1, 3, 2000).toString());
    assertEquals("2000-03-10", new MyDate(10, 3, 2000).toString());
    assertEquals("2000-03-21", new MyDate(21, 3, 2000).toString());
  }

  /**
   * Validates if the date for April is initialised properly.
   */
  @Test
  public void validateDateForApril() {
    assertEquals("2000-04-01", new MyDate(1, 4, 2000).toString());
    assertEquals("2000-04-10", new MyDate(10, 4, 2000).toString());
    assertEquals("2000-04-21", new MyDate(21, 4, 2000).toString());
  }

  /**
   * Validates if the date for May is initialised properly.
   */
  @Test
  public void validateDateForMay() {
    assertEquals("2000-05-01", new MyDate(1, 5, 2000).toString());
    assertEquals("2000-05-10", new MyDate(10, 5, 2000).toString());
    assertEquals("2000-05-21", new MyDate(21, 5, 2000).toString());
  }

  /**
   * Validates if the date for June is initialised properly..
   */
  @Test
  public void validateDateForJune() {
    assertEquals("2000-06-01", new MyDate(1, 6, 2000).toString());
    assertEquals("2000-06-10", new MyDate(10, 6, 2000).toString());
    assertEquals("2000-06-21", new MyDate(21, 6, 2000).toString());
  }

  /**
   * Validates if the date for July is initialised properly.
   */
  @Test
  public void validateDateForJuly() {
    assertEquals("2000-07-01", new MyDate(1, 7, 2000).toString());
    assertEquals("2000-07-10", new MyDate(10, 7, 2000).toString());
    assertEquals("2000-07-21", new MyDate(21, 7, 2000).toString());
  }

  /**
   * Validates if the date for August is initialised properly.
   */
  @Test
  public void validateDateForAugust() {
    assertEquals("2000-08-01", new MyDate(1, 8, 2000).toString());
    assertEquals("2000-08-10", new MyDate(10, 8, 2000).toString());
    assertEquals("2000-08-21", new MyDate(21, 8, 2000).toString());
  }

  /**
   * Validates if the date for September is initialised properly.
   */
  @Test
  public void validateDateForSeptember() {
    assertEquals("2000-09-01", new MyDate(1, 9, 2000).toString());
    assertEquals("2000-09-10", new MyDate(10, 9, 2000).toString());
    assertEquals("2000-09-21", new MyDate(21, 9, 2000).toString());
  }

  /**
   * Validates if the date for October is initialised properly.
   */
  @Test
  public void validateDateForOctober() {
    assertEquals("2000-10-01", new MyDate(1, 10, 2000).toString());
    assertEquals("2000-10-10", new MyDate(10, 10, 2000).toString());
    assertEquals("2000-10-21", new MyDate(21, 10, 2000).toString());
  }

  /**
   * Validates if the date for November is initialised properly.
   */
  @Test
  public void validateDateForNovember() {
    assertEquals("2000-11-01", new MyDate(1, 11, 2000).toString());
    assertEquals("2000-11-10", new MyDate(10, 11, 2000).toString());
    assertEquals("2000-11-21", new MyDate(21, 11, 2000).toString());
  }

  /**
   * Validates if the date for December is initialised properly.
   */
  @Test
  public void validateDateForDecember() {
    assertEquals("2000-12-01", new MyDate(1, 12, 2000).toString());
    assertEquals("2000-12-10", new MyDate(10, 12, 2000).toString());
    assertEquals("2000-12-21", new MyDate(21, 12, 2000).toString());
  }

  /**
   * Validates if the months with 31 days does not throw exception when initialised with 31st day.
   */
  @Test
  public void validateMonthsWithThirtyOneDays() {
    assertEquals("2000-01-01", new MyDate(1, 1, 2000).toString());
    assertEquals("2000-03-01", new MyDate(1, 3, 2000).toString());
    assertEquals("2000-05-01", new MyDate(1, 5, 2000).toString());
    assertEquals("2000-07-01", new MyDate(1, 7, 2000).toString());
    assertEquals("2000-08-01", new MyDate(1, 8, 2000).toString());
    assertEquals("2000-10-01", new MyDate(1, 10, 2000).toString());
    assertEquals("2000-12-01", new MyDate(1, 12, 2000).toString());
  }

  /**
   * Validates if the months with 30 days does not throw exception when initialised with 30th day.
   */
  @Test
  public void validateMonthsWithThirtyDays() {
    assertEquals("2000-04-01", new MyDate(1, 4, 2000).toString());
    assertEquals("2000-06-01", new MyDate(1, 6, 2000).toString());
    assertEquals("2000-09-01", new MyDate(1, 9, 2000).toString());
    assertEquals("2000-11-01", new MyDate(1, 11, 2000).toString());
  }

  /**
   * Validates February 29th for leap year.
   */
  @Test
  public void validateFebruaryWithLeapYear() {
    assertEquals("2000-02-29", new MyDate(29, 2, 2000).toString());
    assertEquals("2004-02-29", new MyDate(29, 2, 2004).toString());
    assertEquals("2012-02-29", new MyDate(29, 2, 2012).toString());
  }

  /**
   * Validates February 28th for non leap year.
   */
  @Test
  public void validateFebruaryWithoutLeapYear() {
    assertEquals("2001-02-28", new MyDate(28, 2, 2001).toString());
  }

  /**
   * Validates date for a non 31 days month where day is specified as 31.
   */
  @Test
  public void validateDateForNonThirtyOneDaysMonth() {
    assertThrows(IllegalArgumentException.class, () -> new MyDate(31, 2, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(31, 4, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(31, 6, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(31, 9, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(31, 11, 2000));
  }

  /**
   * Validates date where day is greater than 31.
   */
  @Test
  public void validateDateHavingInvalidDay() {
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 1, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 2, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 3, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 4, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 5, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 6, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 7, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 8, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 9, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 10, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 11, 2000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(32, 12, 2000));

  }

  /**
   * Validates February date for a non leap year.
   */
  @Test
  public void validateFebruaryDateForNonLeapYear() {
    assertThrows(IllegalArgumentException.class, () -> new MyDate(29, 2, 2001));
  }

  /**
   * Validate with invalid day.
   */
  @Test
  public void validateWithInvalidDay() {
    assertThrows(IllegalArgumentException.class, () -> new MyDate(0, 1, 2001));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(-1, 1, 2001));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(1000, 1, 2001));
  }

  /**
   * Validate with invalid month.
   */
  @Test
  public void validateWithInvalidMonth() {
    assertThrows(IllegalArgumentException.class, () -> new MyDate(29, 20, 2001));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(29, -20, 2001));
  }

  /**
   * Validate with invalid year.
   */
  @Test
  public void validateWithInvalidYear() {
    assertThrows(IllegalArgumentException.class, () -> new MyDate(1, 1, 10000));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(1, 1, -1));
  }


  /**
   * Checks toString method for padding day.
   */
  @Test
  public void toStringForPaddingDay() {
    assertEquals("2001-10-01", new MyDate(1, 10, 2001).toString());
  }

  /**
   * Checks toString method for padding month.
   */
  @Test
  public void toStringForPaddingMonth() {
    assertEquals("2001-01-10", new MyDate(10, 1, 2001).toString());
  }

  /**
   * Checks toString method for padding year.
   */
  @Test
  public void toStringForPaddingYear() {
    assertEquals("0020-10-10", new MyDate(10, 10, 20).toString());
  }
}
