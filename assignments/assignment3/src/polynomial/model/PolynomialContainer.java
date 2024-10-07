package polynomial.model;

import java.util.Objects;


public class PolynomialContainer {


  private final int power;


  private final int coefficient;


  public PolynomialContainer(final int power, final int coefficient) {
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
