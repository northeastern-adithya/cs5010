import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test class for SimpleMoney.
 */
public class TestSimpleMoney {

  /**
   * Test the constructor with negative dollars.
   */
  @Test
  public void testWithNegativeDollars() {
    IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new SimpleMoney(-1, 10));
    assertEquals("Received an invalid US money", exception.getMessage());
  }

  /**
   * Test the constructor with negative cents.
   */
  @Test
  public void testWithNegativeCents() {
    IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new SimpleMoney(10, -5));
    assertEquals("Received an invalid US money", exception.getMessage());
  }

  /**
   * Test the constructor with negative dollars and cents.
   */
  @Test
  public void testWithNegativeDollarsAndCents() {
    IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> new SimpleMoney(-10, -5));
    assertEquals("Received an invalid US money", exception.getMessage());
  }

  /**
   * Test the constructor with zero dollars and cents.
   */
  @Test
  public void testWithZeroDollarsAndCents() {
    Money moneyUnderTest = new SimpleMoney(0, 0);
    assertEquals(0.0, moneyUnderTest.getDecimalValue(), 0.0);
    assertEquals("$0.00", moneyUnderTest.toString());
  }

  /**
   * Tests addition of just dollars with zero cents.
   */
  @Test
  public void addWithDollars() {
    Money moneyUnderTest = new SimpleMoney(11, 0);

    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(5, 0);
      Money result = moneyUnderTest.add(moneyToAdd);
      assertEquals(16.00, result.getDecimalValue(), 0.0);
      assertEquals("$16.00", result.toString());
    }

    {
      // Test add method with dollars and cents.
      Money result = moneyUnderTest.add(5, 0);
      assertEquals(16.00, result.getDecimalValue(), 0.0);
      assertEquals("$16.00", result.toString());
    }

  }

  /**
   * Tests addition of both dollars and cents.
   */
  @Test
  public void addWithDollarsAndCents() {
    Money moneyUnderTest = new SimpleMoney(11, 90);

    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(5, 12);
      Money result = moneyUnderTest.add(moneyToAdd);
      assertEquals(17.02, result.getDecimalValue(), 0.0);
      assertEquals("$17.02", result.toString());
    }

    {
      // Test add method with dollars and cents.
      Money result = moneyUnderTest.add(5, 12);
      assertEquals(17.02, result.getDecimalValue(), 0.0);
      assertEquals("$17.02", result.toString());
    }

  }

  /**
   * Tests addition of dollars and cents to existing dollar object.
   */
  @Test
  public void addWithDollarsAndCentsToExistingDollar() {
    Money moneyUnderTest = new SimpleMoney(11, 0);

    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(5, 12);
      Money result = moneyUnderTest.add(moneyToAdd);
      assertEquals(16.12, result.getDecimalValue(), 0.0);
      assertEquals("$16.12", result.toString());
    }

    {
      // Test add method with dollars and cents.
      Money result = moneyUnderTest.add(5, 12);
      assertEquals(16.12, result.getDecimalValue(), 0.0);
      assertEquals("$16.12", result.toString());
    }

  }

  /**
   * Tests addition of dollars to existing dollar and cents object.
   */

  @Test
  public void addWithDollarsToExistingDollarAndCents() {
    Money moneyUnderTest = new SimpleMoney(11, 12);

    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(5, 0);
      Money result = moneyUnderTest.add(moneyToAdd);
      assertEquals(16.12, result.getDecimalValue(), 0.0);
      assertEquals("$16.12", result.toString());
    }

    {
      // Test add method with dollars and cents.
      Money result = moneyUnderTest.add(5, 0);
      assertEquals(16.12, result.getDecimalValue(), 0.0);
      assertEquals("$16.12", result.toString());
    }
  }

  /**
   * Tests addition of zero dollars and cents to existing money.
   */
  @Test
  public void addZeroDollarsAndCentsToExistingMoney() {
    Money moneyUnderTest = new SimpleMoney(11, 2);

    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(0, 0);
      Money result = moneyUnderTest.add(moneyToAdd);
      assertEquals(11.02, result.getDecimalValue(), 0.0);
      assertEquals("$11.02", result.toString());
    }

    {
      // Test add method with dollars and cents.
      Money result = moneyUnderTest.add(0, 0);
      assertEquals(11.02, result.getDecimalValue(), 0.0);
      assertEquals("$11.02", result.toString());
    }
  }

  /**
   * Tests creating money with cents greater than 100.
   * Also validates the addition of money crossing 100 cents.
   */
  @Test
  public void addWithCentsGreaterThanHundred() {
    Money moneyUnderTest = new SimpleMoney(100, 502);
    assertEquals(105.02, moneyUnderTest.getDecimalValue(), 0.0);
    assertEquals("$105.02", moneyUnderTest.toString());

    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(5, 98);
      Money result = moneyUnderTest.add(moneyToAdd);
      assertEquals(111.00, result.getDecimalValue(), 0.0);
      assertEquals("$111.00", result.toString());
    }
    {
      // Test add method with dollars and cents.
      Money result = moneyUnderTest.add(5, 98);
      assertEquals(111.00, result.getDecimalValue(), 0.0);
      assertEquals("$111.00", result.toString());
    }
  }

  /**
   * Tests adding money with cents greater than 1000.
   */

  @Test
  public void testAddingWithCentsGreaterThanThousands() {
    Money moneyUnderTest = new SimpleMoney(100, 10);
    assertEquals(100.10, moneyUnderTest.getDecimalValue(), 0.0);
    assertEquals("$100.10", moneyUnderTest.toString());

    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(5, 5012);
      Money result = moneyUnderTest.add(moneyToAdd);
      assertEquals(155.22, result.getDecimalValue(), 0.0);
      assertEquals("$155.22", result.toString());
    }

    {
      // Test add method with dollars and cents.
      Money result = moneyUnderTest.add(5, 5012);
      assertEquals(155.22, result.getDecimalValue(), 0.0);
      assertEquals("$155.22", result.toString());
    }
  }

  /**
   * Tests adding invalid money throws Exception.
   */
  @Test
  public void testAddingInvalidMoneyThrowsException() {
    Money moneyUnderTest = new SimpleMoney(1, 2);
    {
      // Add null money.
      IllegalArgumentException exception =
              assertThrows(IllegalArgumentException.class, () -> moneyUnderTest.add(null));
      assertEquals("Received an invalid US money", exception.getMessage());
    }

    {
      // Add negative dollars.
      IllegalArgumentException exception =
              assertThrows(IllegalArgumentException.class, () -> moneyUnderTest.add(-1, 0));
      assertEquals("Received an invalid US money", exception.getMessage());
    }

    {
      // Add negative cents.
      IllegalArgumentException exception =
              assertThrows(IllegalArgumentException.class, () -> moneyUnderTest.add(1, -1));
      assertEquals("Received an invalid US money", exception.getMessage());
    }

    {
      // Add negative dollars and cents.
      IllegalArgumentException exception =
              assertThrows(IllegalArgumentException.class, () -> moneyUnderTest.add(-1, -1));
      assertEquals("Received an invalid US money", exception.getMessage());
    }
  }

  /**
   * Test getDecimal and toString with single digit cents.
   */
  @Test
  public void testWithSingleDigitCent() {
    Money moneyUnderTest = new SimpleMoney(1, 2);
    assertEquals(1.02, moneyUnderTest.getDecimalValue(), 0.0);
    assertEquals("$1.02", moneyUnderTest.toString());
  }

  /**
   * Test getDecimal and toString with double digit cents.
   */
  @Test
  public void testWithDoubleDigitCent() {
    Money moneyUnderTest = new SimpleMoney(1, 12);
    assertEquals(1.12, moneyUnderTest.getDecimalValue(), 0.0);
    assertEquals("$1.12", moneyUnderTest.toString());
  }

  /**
   * Test getDecimal and toString with triple digit cents.
   */
  @Test
  public void testWithTripleDigitCent() {
    Money moneyUnderTest = new SimpleMoney(1, 120);
    assertEquals(2.20, moneyUnderTest.getDecimalValue(), 0.0);
    assertEquals("$2.20", moneyUnderTest.toString());
  }

  /**
   * Tests addition if overflow occurs.
   */
  @Test
  public void testForOverFlow() {
    Money moneyUnderTest = new SimpleMoney(Integer.MAX_VALUE, 0);
    {
      // Test add method with Money object.
      Money moneyToAdd = new SimpleMoney(0, 1);
      IllegalArgumentException exception =
              assertThrows(IllegalArgumentException.class, () -> moneyUnderTest.add(moneyToAdd));
      assertEquals("Overflow occurred while adding money", exception.getMessage());
    }
    {
      // Test add method with dollars and cents.
      IllegalArgumentException exception =
              assertThrows(IllegalArgumentException.class, () -> moneyUnderTest.add(0, 1));
      assertEquals("Overflow occurred while adding money", exception.getMessage());
    }
  }


}
