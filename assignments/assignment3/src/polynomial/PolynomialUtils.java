package polynomial;

import java.util.Objects;

/**
 * Utility class for common polynomial operations.
 */
public class PolynomialUtils {

  /**
   * Private constructor to prevent instantiation
   * since the utility methods are static.
   */
  private PolynomialUtils() {

  }

  /**
   * Returns the hash code of a polynomial element by getting hash
   * of coefficient and power.
   *
   * @param coefficient the coefficient of the polynomial element.
   * @param power       the power of the polynomial element.
   * @return the hash code of the polynomial element.
   */
  public static int getHashCodeOfPolynomial(int coefficient, int power) {
    return Objects.hash(coefficient, power);
  }

  /**
   * Validates the power of a polynomial element.
   *
   * @param power the power of the polynomial element.
   * @throws IllegalArgumentException if the power is negative.
   */
  public static void validatePower(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException(
              String.format("Power cannot be negative. Received: %d", power));
    }
  }
}
