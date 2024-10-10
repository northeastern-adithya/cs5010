import org.junit.Test;

import polynomial.PolynomialUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Tests the utility methods available for polynomial.
 */
public class TestPolynomialUtils {

  /**
   * Test the getHashCodeOfPolynomial method.
   */
  @Test
  public void testGetHashCodeOfPolynomial() {
    assertEquals(1056, PolynomialUtils.getHashCodeOfPolynomial(3, 2));
  }

  /**
   * Test the validatePower method to throw illegal argument exception on negative power.
   */
  @Test
  public void testValidatePowerThrowsIllegalArgumentException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> PolynomialUtils.validatePower(-2));
    assertEquals("Power cannot be negative. Received: -2", exception.getMessage());
  }
}
