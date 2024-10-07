package polynomial.model;

import java.util.Objects;

/**
 * Class to represent the power and coefficient for the polynomial.
 */
public class PolynomialContainer {

  /**
   * The power of the polynomial.
   */
  private final int power;

  /**
   * The coefficient of the polynomial.
   */
  private final int coefficient;


  /**
   * Constructor to initialize the power and coefficient.
   *
   * @param power       the power of the polynomial.
   * @param coefficient the coefficient of the polynomial.
   */
  public PolynomialContainer(final int power, final int coefficient) {
    this.power = power;
    this.coefficient = coefficient;
  }

  /**
   * Get the power of the polynomial.
   *
   * @return the power of the polynomial.
   */
  public int getPower() {
    return this.power;
  }

  /**
   * Get the coefficient of the polynomial.
   *
   * @return the coefficient of the polynomial.
   */
  public int getCoefficient() {
    return this.coefficient;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof PolynomialContainer)) {
      return false;
    }

    PolynomialContainer that = (PolynomialContainer) obj;
    return this.power == that.power && this.coefficient == that.coefficient;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.coefficient, this.power);
  }


}
