package polynomial.model;

import polynomial.PolynomialConstants;
import polynomial.PolynomialUtils;


/**
 * Represents a single element of a polynomial.
 * Stores the power and coefficient of the element.
 */
public class PolynomialElement {


  /**
   * The power of the element.
   */
  private final int power;


  /**
   * The coefficient of the element.
   */
  private final int coefficient;


  /**
   * Constructs a new PolynomialElement with the
   * given power and coefficient.
   *
   * @param coefficient the coefficient of the element
   * @param power       the power of the element
   * @throws IllegalArgumentException if the power is negative
   */
  public PolynomialElement(final int coefficient, final int power) throws IllegalArgumentException {
    PolynomialUtils.validatePower(power);
    this.power = power;
    this.coefficient = coefficient;
  }

  /**
   * Returns the power of the element.
   *
   * @return the power of the element
   */
  public int getPower() {
    return this.power;
  }


  /**
   * Returns the coefficient of the element.
   *
   * @return the coefficient of the element
   */
  public int getCoefficient() {
    return this.coefficient;
  }

  /**
   * Returns true if the given object is equal to the PolynomialElement.
   * Two PolynomialElements are equal if they have the same power and coefficient.
   *
   * @param obj the object to compare
   * @return true if the given object is equal to the PolynomialElement,false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof PolynomialElement)) {
      return false;
    }

    PolynomialElement that = (PolynomialElement) obj;
    return this.power == that.power && this.coefficient == that.coefficient;
  }

  /**
   * Returns the hash code of the PolynomialElement
   * by adding hash of coefficient and power.
   *
   * @return the hash code of the PolynomialElement
   */
  @Override
  public int hashCode() {
    return PolynomialUtils.getHashCodeOfPolynomial(this.coefficient, this.power);
  }

  /**
   * Returns the string representation of the PolynomialElement.
   * If the coefficient is 0, returns an empty string.
   * If the power is 0, returns the coefficient.
   * Otherwise, returns the coefficient and power in the form
   * ax^b where a is coefficient and b is the power.
   *
   * @return the string representation of the PolynomialElement
   */
  @Override
  public String toString() {

    if (this.coefficient == 0) {
      return PolynomialConstants.EMPTY_STRING;
    }

    if (this.power == 0) {
      return Integer.toString(this.coefficient);
    }
    return this.coefficient + PolynomialConstants.X_POWER_SYMBOL + this.power;
  }
}
