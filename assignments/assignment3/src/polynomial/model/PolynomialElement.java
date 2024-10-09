package polynomial.model;

import polynomial.PolynomialConstants;
import polynomial.PolynomialUtils;


public class PolynomialElement {


  private final int power;


  private final int coefficient;


  public PolynomialElement(final int power, final int coefficient) {
    this.power = power;
    this.coefficient = coefficient;
  }

  public int getPower() {
    return this.power;
  }


  public int getCoefficient() {
    return this.coefficient;
  }


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

  @Override
  public int hashCode() {
    return PolynomialUtils.getHashCodeOfPolynomial(this.coefficient, this.power);
  }

  @Override
  public String toString() {
    if (this.power == 0) {
      return Integer.toString(this.coefficient);
    }
    if (this.coefficient == 0) {
      return PolynomialConstants.EMPTY_STRING;
    }
    return this.coefficient + PolynomialConstants.X_POWER_SYMBOL + this.power;
  }


}
