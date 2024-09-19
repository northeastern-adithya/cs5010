import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


/**
 * Tests to check working of MyDate class.
 * Is in a different package than root to verify testing of
 * MyDate.java across packages.
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
    assertEquals("2000-01-31", new MyDate(31, 1, 2000).toString());
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
    assertEquals("2000-02-29", new MyDate(29, 2, 2000).toString());
  }

  /**
   * Validates if the date for March is initialised properly.
   */
  @Test
  public void validateDateForMarch() {
    assertEquals("2000-03-01", new MyDate(1, 3, 2000).toString());
    assertEquals("2000-03-10", new MyDate(10, 3, 2000).toString());
    assertEquals("2000-03-21", new MyDate(21, 3, 2000).toString());
    assertEquals("2000-03-31", new MyDate(31, 3, 2000).toString());
  }

  /**
   * Validates if the date for April is initialised properly.
   */
  @Test
  public void validateDateForApril() {
    assertEquals("2000-04-01", new MyDate(1, 4, 2000).toString());
    assertEquals("2000-04-10", new MyDate(10, 4, 2000).toString());
    assertEquals("2000-04-21", new MyDate(21, 4, 2000).toString());
    assertEquals("2000-04-30", new MyDate(30, 4, 2000).toString());
  }

  /**
   * Validates if the date for May is initialised properly.
   */
  @Test
  public void validateDateForMay() {
    assertEquals("2000-05-01", new MyDate(1, 5, 2000).toString());
    assertEquals("2000-05-10", new MyDate(10, 5, 2000).toString());
    assertEquals("2000-05-21", new MyDate(21, 5, 2000).toString());
    assertEquals("2000-05-31", new MyDate(31, 5, 2000).toString());
  }

  /**
   * Validates if the date for June is initialised properly..
   */
  @Test
  public void validateDateForJune() {
    assertEquals("2000-06-01", new MyDate(1, 6, 2000).toString());
    assertEquals("2000-06-10", new MyDate(10, 6, 2000).toString());
    assertEquals("2000-06-21", new MyDate(21, 6, 2000).toString());
    assertEquals("2000-06-30", new MyDate(30, 6, 2000).toString());
  }

  /**
   * Validates if the date for July is initialised properly.
   */
  @Test
  public void validateDateForJuly() {
    assertEquals("2000-07-01", new MyDate(1, 7, 2000).toString());
    assertEquals("2000-07-10", new MyDate(10, 7, 2000).toString());
    assertEquals("2000-07-21", new MyDate(21, 7, 2000).toString());
    assertEquals("2000-07-31", new MyDate(31, 7, 2000).toString());
  }

  /**
   * Validates if the date for August is initialised properly.
   */
  @Test
  public void validateDateForAugust() {
    assertEquals("2000-08-01", new MyDate(1, 8, 2000).toString());
    assertEquals("2000-08-10", new MyDate(10, 8, 2000).toString());
    assertEquals("2000-08-21", new MyDate(21, 8, 2000).toString());
    assertEquals("2000-08-31", new MyDate(31, 8, 2000).toString());
  }

  /**
   * Validates if the date for September is initialised properly.
   */
  @Test
  public void validateDateForSeptember() {
    assertEquals("2000-09-01", new MyDate(1, 9, 2000).toString());
    assertEquals("2000-09-10", new MyDate(10, 9, 2000).toString());
    assertEquals("2000-09-21", new MyDate(21, 9, 2000).toString());
    assertEquals("2000-09-30", new MyDate(30, 9, 2000).toString());
  }

  /**
   * Validates if the date for October is initialised properly.
   */
  @Test
  public void validateDateForOctober() {
    assertEquals("2000-10-01", new MyDate(1, 10, 2000).toString());
    assertEquals("2000-10-10", new MyDate(10, 10, 2000).toString());
    assertEquals("2000-10-21", new MyDate(21, 10, 2000).toString());
    assertEquals("2000-10-31", new MyDate(31, 10, 2000).toString());
  }

  /**
   * Validates if the date for November is initialised properly.
   */
  @Test
  public void validateDateForNovember() {
    assertEquals("2000-11-01", new MyDate(1, 11, 2000).toString());
    assertEquals("2000-11-10", new MyDate(10, 11, 2000).toString());
    assertEquals("2000-11-21", new MyDate(21, 11, 2000).toString());
    assertEquals("2000-11-30", new MyDate(30, 11, 2000).toString());
  }

  /**
   * Validates if the date for December is initialised properly.
   */
  @Test
  public void validateDateForDecember() {
    assertEquals("2000-12-01", new MyDate(1, 12, 2000).toString());
    assertEquals("2000-12-10", new MyDate(10, 12, 2000).toString());
    assertEquals("2000-12-21", new MyDate(21, 12, 2000).toString());
    assertEquals("2000-12-31", new MyDate(31, 12, 2000).toString());
  }

  /**
   * Validates if the months with 31 days does not throw exception when initialised with 31st day.
   */
  @Test
  public void validateMonthsWithThirtyOneDays() {
    assertEquals("2000-01-31", new MyDate(31, 1, 2000).toString());
    assertEquals("2000-03-31", new MyDate(31, 3, 2000).toString());
    assertEquals("2000-05-31", new MyDate(31, 5, 2000).toString());
    assertEquals("2000-07-31", new MyDate(31, 7, 2000).toString());
    assertEquals("2000-08-31", new MyDate(31, 8, 2000).toString());
    assertEquals("2000-10-31", new MyDate(31, 10, 2000).toString());
    assertEquals("2000-12-31", new MyDate(31, 12, 2000).toString());
  }

  /**
   * Validates if the months with 30 days does not throw exception when initialised with 30th day.
   */
  @Test
  public void validateMonthsWithThirtyDays() {
    assertEquals("2000-04-30", new MyDate(30, 4, 2000).toString());
    assertEquals("2000-06-30", new MyDate(30, 6, 2000).toString());
    assertEquals("2000-09-30", new MyDate(30, 9, 2000).toString());
    assertEquals("2000-11-30", new MyDate(30, 11, 2000).toString());
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
    assertThrows(IllegalArgumentException.class, () -> new MyDate(null, 12, 2000));
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
    assertThrows(IllegalArgumentException.class, () -> new MyDate(29, -1, 2001));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(28, null, 2000));
  }

  /**
   * Validate with invalid year.
   */
  @Test
  public void validateWithInvalidYear() {
    assertThrows(IllegalArgumentException.class, () -> new MyDate(1, 1, -1));
    assertThrows(IllegalArgumentException.class, () -> new MyDate(1, 12, null));
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

  /**
   * Checks toString method for padding year with five digits.
   */
  @Test
  public void toStringForPaddingYearWithFiveDigits() {
    assertEquals("20000-10-10", new MyDate(10, 10, 20000).toString());
  }


  /**
   * Tests going advancing the number of days.
   */
  @Test
  public void testDateGoingForwardInDays() {
    MyDate myDate = new MyDate(10, 10, 2024);
    myDate.advance(10);
    assertEquals(LocalDate.of(2024, 10, 10).plusDays(10).toString(), myDate.toString());
  }

  /**
   * Tests going back with the number of days.
   */
  @Test
  public void testDateGoingBackwardInDays() {
    MyDate myDate = new MyDate(20, 10, 2024);
    myDate.advance(-10);
    assertEquals(LocalDate.of(2024, 10, 20).minusDays(10).toString(), myDate.toString());

  }

  /**
   * Tests going forward by months for both thirty days and thirty one days months.
   */
  @Test
  public void testDateGoingForwardInMonths() {
    {
      // For thirty one days month
      MyDate myDate = new MyDate(10, 10, 2024);
      myDate.advance(30);
      assertEquals(LocalDate.of(2024, 10, 10).plusDays(30).toString(), myDate.toString());

    }

    {
      // For thirty days month
      MyDate myDate = new MyDate(10, 9, 2024);
      myDate.advance(30);
      assertEquals(LocalDate.of(2024, 9, 10).plusDays(30).toString(), myDate.toString());
    }
  }

  /**
   * Tests going backward by months for both thirty days and thirty one days months.
   */
  @Test
  public void testDateGoingBackwardInMonths() {
    {
      // For thirty one days month
      MyDate myDate = new MyDate(10, 10, 2024);
      myDate.advance(-30);
      assertEquals(LocalDate.of(2024, 10, 10).minusDays(30).toString(), myDate.toString());

    }

    {
      // For thirty days month
      MyDate myDate = new MyDate(10, 9, 2024);
      myDate.advance(-30);
      assertEquals(LocalDate.of(2024, 9, 10).minusDays(30).toString(), myDate.toString());
    }
  }

  /**
   * Tests going forward by year.
   */
  @Test
  public void testDateGoingForwardInYear() {

    MyDate myDate = new MyDate(11, 9, 2024);
    myDate.advance(865);
    assertEquals(LocalDate.of(2024, 9, 11).plusDays(865).toString(), myDate.toString());

  }

  /**
   * Tests going backwards by year.
   */
  @Test
  public void testDateGoingBackwardsInYear() {
    MyDate myDate = new MyDate(11, 9, 2024);
    myDate.advance(-865);
    assertEquals(LocalDate.of(2024, 9, 11).minusDays(865).toString(), myDate.toString());

  }

  /**
   * Tests going forward by boundary condition.
   */
  @Test
  public void testDateGoingForwardBoundaryCondition() {
    {
      MyDate myDate = new MyDate(11, 9, 2024);
      myDate.advance(2912919);
      assertEquals("9999-12-31", myDate.toString());
    }

    {
      MyDate myDate = new MyDate(11, 9, 2024);
      myDate.advance(3912919);
      assertEquals("12737-11-27", myDate.toString());
    }

  }


  /**
   * Tests going forward by backward condition to not cross 0000-01-01.
   */
  @Test
  public void testDateGoingBackwardBoundaryCondition() {
    {
      MyDate myDate = new MyDate(11, 9, 2024);
      myDate.advance(-739507);
      assertEquals("0000-01-01", myDate.toString());
    }

    {
      MyDate myDate = new MyDate(11, 9, 2024);
      myDate.advance(-839141);
      assertEquals("0000-01-01", myDate.toString());
    }
  }

  /**
   * Tests going forward in days during a leap year.
   */
  @Test
  public void testDateGoingForwardForLeapYear() {
    MyDate myDate = new MyDate(10, 2, 2024);
    myDate.advance(10);
    assertEquals(LocalDate.of(2024, 2, 10).plusDays(10).toString(), myDate.toString());

  }

  /**
   * Tests going backward in days during a leap year.
   */
  @Test
  public void testDateGoingBackwardForLeapYear() {
    MyDate myDate = new MyDate(10, 2, 2024);
    myDate.advance(-10);
    assertEquals(LocalDate.of(2024, 2, 10).minusDays(10).toString(), myDate.toString());

  }

  /**
   * Tests going forward in months during a leap year.
   */
  @Test
  public void testDateGoingForwardForMonthInLeapYear() {
    MyDate myDate = new MyDate(10, 2, 2024);
    myDate.advance(30);
    assertEquals(LocalDate.of(2024, 2, 10).plusDays(30).toString(), myDate.toString());
  }

  /**
   * Tests going backward in months during a leap year.
   */
  @Test
  public void testDateGoingBackwardForMonthInLeapYear() {
    MyDate myDate = new MyDate(10, 3, 2024);
    myDate.advance(-30);
    assertEquals(LocalDate.of(2024, 3, 10).minusDays(30).toString(), myDate.toString());
  }

  /**
   * Tests going forward in years with leap year included.
   */
  @Test
  public void testDateGoingForwardForYearsInLeapYear() {
    MyDate myDate = new MyDate(10, 3, 2023);
    myDate.advance(894);
    assertEquals(LocalDate.of(2023, 3, 10).plusDays(894).toString(), myDate.toString());
  }

  /**
   * Tests going backward in years with leap year included.
   */
  @Test
  public void testDateGoingBackwardForYearsInLeapYear() {
    MyDate myDate = new MyDate(10, 3, 2025);
    myDate.advance(-894);
    assertEquals(LocalDate.of(2025, 3, 10).minusDays(894).toString(), myDate.toString());
  }

  /**
   * Tests if initialization of 0000-01-01 happens properly.
   */
  @Test
  public void testInitializationOfBoundaryDate() {
    MyDate myDate = new MyDate(1, 1, 0);
    assertEquals("0000-01-01", myDate.toString());
  }

  /**
   * Tests for date addition from Jan to Feb.
   */
  @Test
  public void testDateAdditionFromJanToFeb() {
    MyDate myDate = new MyDate(31, 1, 2024);
    myDate.advance(1);
    assertEquals("2024-02-01", myDate.toString());
  }

  /**
   * Tests for date addition in Feb during leap year.
   */
  @Test
  public void testDateAdditionInFebDuringLeapYear() {
    MyDate myDate = new MyDate(28, 2, 2024);
    myDate.advance(1);
    assertEquals("2024-02-29", myDate.toString());
  }

  /**
   * Tests for date addition in Feb to March during leap year.
   */
  @Test
  public void testDateAdditionInFebToMarchDuringLeapYear() {
    MyDate myDate = new MyDate(29, 2, 2024);
    myDate.advance(1);
    assertEquals("2024-03-01", myDate.toString());
  }

  /**
   * Tests for date addition in Feb during non leap year.
   */
  @Test
  public void testDateAdditionInFebDuringNonLeapYear() {
    MyDate myDate = new MyDate(28, 2, 2023);
    myDate.advance(1);
    assertEquals("2023-03-01", myDate.toString());
  }

  /**
   * Tests for date addition from March to April.
   */
  @Test
  public void testDateAdditionFromMarchToApril() {
    MyDate myDate = new MyDate(31, 3, 2024);
    myDate.advance(1);
    assertEquals("2024-04-01", myDate.toString());
  }

  /**
   * Tests for date addition from April to May.
   */
  @Test
  public void testDateAdditionFromAprilToMay() {
    MyDate myDate = new MyDate(30, 4, 2024);
    myDate.advance(1);
    assertEquals("2024-05-01", myDate.toString());
  }

  /**
   * Tests for date addition from May to June.
   */
  @Test
  public void testDateAdditionFromMayToJune() {
    MyDate myDate = new MyDate(31, 5, 2024);
    myDate.advance(1);
    assertEquals("2024-06-01", myDate.toString());
  }

  /**
   * Tests for date addition from June to July.
   */
  @Test
  public void testDateAdditionFromJuneToJuly() {
    MyDate myDate = new MyDate(30, 6, 2024);
    myDate.advance(1);
    assertEquals("2024-07-01", myDate.toString());
  }

  /**
   * Tests for date addition from July to Aug.
   */
  @Test
  public void testDateAdditionFromJulyToAug() {
    MyDate myDate = new MyDate(31, 7, 2024);
    myDate.advance(1);
    assertEquals("2024-08-01", myDate.toString());
  }

  /**
   * Tests for date addition from Aug to Sept.
   */
  @Test
  public void testDateAdditionFromAugToSept() {
    MyDate myDate = new MyDate(31, 8, 2024);
    myDate.advance(1);
    assertEquals("2024-09-01", myDate.toString());
  }

  /**
   * Tests for date addition from Sept to Oct.
   */
  @Test
  public void testDateAdditionFromSeptToOct() {
    MyDate myDate = new MyDate(30, 9, 2024);
    myDate.advance(1);
    assertEquals("2024-10-01", myDate.toString());
  }

  /**
   * Tests for date addition from Oct to Nov.
   */
  @Test
  public void testDateAdditionFromOctToNovember() {
    MyDate myDate = new MyDate(31, 10, 2024);
    myDate.advance(1);
    assertEquals("2024-11-01", myDate.toString());
  }

  /**
   * Tests for date addition from Nov to Dec.
   */
  @Test
  public void testDateAdditionFromNovToDec() {
    MyDate myDate = new MyDate(30, 11, 2024);
    myDate.advance(1);
    assertEquals("2024-12-01", myDate.toString());
  }

  /**
   * Tests for date addition from Dec to Jan.
   */
  @Test
  public void testDateAdditionFromDecToJan() {
    MyDate myDate = new MyDate(31, 12, 2024);
    myDate.advance(1);
    assertEquals("2025-01-01", myDate.toString());
  }


  /**
   * Tests for date subtraction from Dec to Nov.
   */
  @Test
  public void testDateSubtractionFromDecToNov() {
    MyDate myDate = new MyDate(1, 12, 2024);
    myDate.advance(-1);
    assertEquals("2024-11-30", myDate.toString());
  }

  /**
   * Tests for date subtraction from Nov to Oct.
   */
  @Test
  public void testDateSubtractionFromNovToOct() {
    MyDate myDate = new MyDate(1, 11, 2024);
    myDate.advance(-1);
    assertEquals("2024-10-31", myDate.toString());
  }

  /**
   * Tests for date subtraction from Oct to Sept.
   */
  @Test
  public void testDateSubtractionFromOctToSept() {
    MyDate myDate = new MyDate(1, 10, 2024);
    myDate.advance(-1);
    assertEquals("2024-09-30", myDate.toString());
  }

  /**
   * Tests for date subtraction from Sept to Aug.
   */
  @Test
  public void testDateSubtractionFromSeptToAug() {
    MyDate myDate = new MyDate(1, 9, 2024);
    myDate.advance(-1);
    assertEquals("2024-08-31", myDate.toString());
  }

  /**
   * Tests for date subtraction from Aug to July.
   */
  @Test
  public void testDateSubtractionFromAugToJuly() {
    MyDate myDate = new MyDate(1, 8, 2024);
    myDate.advance(-1);
    assertEquals("2024-07-31", myDate.toString());
  }

  /**
   * Tests for date subtraction from July to June.
   */
  @Test
  public void testDateSubtractionFromJulyToJune() {
    MyDate myDate = new MyDate(1, 7, 2024);
    myDate.advance(-1);
    assertEquals("2024-06-30", myDate.toString());
  }

  /**
   * Tests for date subtraction from June to May.
   */
  @Test
  public void testDateSubtractionFromJuneToMay() {
    MyDate myDate = new MyDate(1, 6, 2024);
    myDate.advance(-1);
    assertEquals("2024-05-31", myDate.toString());
  }

  /**
   * Tests for date subtraction from May to April.
   */
  @Test
  public void testDateSubtractionFromMayToApril() {
    MyDate myDate = new MyDate(1, 5, 2024);
    myDate.advance(-1);
    assertEquals("2024-04-30", myDate.toString());
  }

  /**
   * Tests for date subtraction from April to March.
   */
  @Test
  public void testDateSubtractionFromAprilToMarch() {
    MyDate myDate = new MyDate(1, 4, 2024);
    myDate.advance(-1);
    assertEquals("2024-03-31", myDate.toString());
  }

  /**
   * Tests for date subtraction from March to Feb during leap year.
   */
  @Test
  public void testDateSubtractionFromMarchToFebDuringLeapYear() {
    MyDate myDate = new MyDate(1, 3, 2024);
    myDate.advance(-1);
    assertEquals("2024-02-29", myDate.toString());
  }

  /**
   * Tests for date subtraction from March to Feb during non leap year.
   */
  @Test
  public void testDateSubtractionFromMarchToFebDuringNonLeapYear() {
    MyDate myDate = new MyDate(1, 3, 2023);
    myDate.advance(-1);
    assertEquals("2023-02-28", myDate.toString());
  }

  /**
   * Tests for date subtraction from Feb to Jan.
   */
  @Test
  public void testDateSubtractionFromFebToJan() {
    MyDate myDate = new MyDate(1, 2, 2024);
    myDate.advance(-1);
    assertEquals("2024-01-31", myDate.toString());
  }

  /**
   * Tests for date subtraction from Jan to December.
   */
  @Test
  public void testDateSubtractionFromJanToDecember() {
    MyDate myDate = new MyDate(1, 1, 2024);
    myDate.advance(-1);
    assertEquals("2023-12-31", myDate.toString());
  }


}
