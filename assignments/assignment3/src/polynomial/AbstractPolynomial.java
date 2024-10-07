package polynomial;

import java.util.List;
import java.util.Objects;


public abstract class AbstractPolynomial<T> implements Polynomial {


  private static final String EMPTY_POLYNOMIAL = "0";


  private static final String PLUS_SYMBOL = "+";


  private static final String X_POWER_SYMBOL = "x^";


  protected final List<T> polynomialElements;


  protected AbstractPolynomial(List<T> polynomialElements) {
    this.polynomialElements = polynomialElements;
  }


  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {

    validatePower(power);
    if (coefficient == 0) {
      return;
    }
    addCoefficientToAppropriateIndex(coefficient, power);
  }


  @Override
  public int getDegree() {
    if (isPolynomialEmpty()) {
      return 0;
    }
    return getMaxPower();
  }

  protected abstract int getMaxPower();

  @Override
  public int getCoefficient(int power) {
    if (isInvalidPower(power)) {
      return 0;
    }
    return findCoefficient(power);
  }


  protected abstract int findCoefficient(int power);

  private boolean isInvalidPower(int power) {
    return power < 0 || power > this.getDegree() || isPolynomialEmpty();
  }


  @Override
  public String toString() {
    if (isPolynomialEmpty()) {
      return EMPTY_POLYNOMIAL;
    }
    StringBuilder polynomialAsString = new StringBuilder();
    int currentDegree = this.getDegree();
    for (int i = currentDegree; i >= 0; i--) {
      int coefficient = this.getCoefficient(i);
      if (coefficient == 0) {
        continue;
      }
      if (coefficient > 0 && i != currentDegree) {
        polynomialAsString.append(PLUS_SYMBOL);
      }
      polynomialAsString.append(coefficient);
      if (i > 0) {
        polynomialAsString.append(X_POWER_SYMBOL).append(i);
      }
    }
    return polynomialAsString.toString();
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof AbstractPolynomial)) {
      return false;
    }
    AbstractPolynomial that = (AbstractPolynomial) obj;
    return this.toString().equals(that.toString());
  }


  @Override
  public int hashCode() {
    return Objects.hash(this.toString());
  }


  protected abstract void addCoefficientToAppropriateIndex(int coefficient, int power);


  protected abstract AbstractPolynomial<T> createNewInstance();


  protected boolean isPolynomialEmpty() {
    return polynomialElements.isEmpty();
  }


  protected void validatePower(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException(
              String.format("Power cannot be negative. Received: %d", power));
    }
  }


  protected double evaluateValue(int coefficient, int power, double x) {
    return coefficient * Math.pow(x, power);
  }

  protected int findDerivativeCoefficient(int currentCoefficient, int power) {
    return currentCoefficient * power;
  }
}
