package polynomial;

import java.util.List;
import java.util.Objects;

import polynomial.model.PolynomialElement;


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
    validatePowerToAddTerm(power);
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

  @Override
  public int getCoefficient(int power) {
    if (isInvalidPower(power)) {
      return 0;
    }
    return findCoefficient(power);
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
    if (this.getDegree() != that.getDegree()) {
      return false;
    }
    return this.equalsAbstractPolynomial(that);
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int power = 0; power <= this.getDegree(); power++) {
      int coefficient = this.getCoefficient(power);
      if (coefficient == 0) {
        continue;
      }
      hashCode += Objects.hash(coefficient, power);
    }
    return hashCode;
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


  protected abstract int getMaxPower();

  protected abstract int findCoefficient(int power);

  protected abstract boolean equalsAbstractPolynomial(AbstractPolynomial obj);

  protected abstract void addCoefficientToAppropriateIndex(int coefficient, int power);


  protected boolean isPolynomialEmpty() {
    return polynomialElements.isEmpty();
  }



  protected abstract Polynomial addSimplePolynomial(SimplePolynomial simplePolynomial);


  protected abstract Polynomial addSparsePolynomial(SparsePolynomial sparsePolynomial);



  protected boolean equalsSparsePolynomial(SparsePolynomial obj) {
    for (PolynomialElement element : obj.polynomialElements) {
      if (this.getCoefficient(element.getPower()) != element.getCoefficient()) {
        return false;
      }
    }
    return true;
  }


  protected boolean equalsSimplePolynomial(SimplePolynomial obj) {
    for (int i = 0; i <= obj.getDegree(); i++) {
      if (this.getCoefficient(i) != obj.getCoefficient(i)) {
        return false;
      }
    }
    return true;
  }

  protected boolean arePolynomialElementsEquals(List<T> polynomialElements) {
    return this.polynomialElements.equals(polynomialElements);
  }


  protected double evaluateValue(int coefficient, int power, double x) {
    return coefficient * Math.pow(x, power);
  }

  protected int findDerivativeCoefficient(int currentCoefficient, int power) {
    return currentCoefficient * power;
  }

  private boolean isInvalidPower(int power) {
    return power < 0 || power > this.getDegree() || isPolynomialEmpty();
  }

  private void validatePowerToAddTerm(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException(
              String.format("Power cannot be negative. Received: %d", power));
    }
  }

}
