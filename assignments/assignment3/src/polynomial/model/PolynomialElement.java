package polynomial.model;

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
    return PolynomialUtils.getHashCodeOfPolynomial(this.coefficient,this.power);
  }


}
