package polynomial;

import java.util.List;

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
  public int getCoefficient(int power) {
    if (isInvalidPower(power)) {
      return 0;
    }
    return findCoefficient(power);
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int power = 0; power <= this.getDegree(); power++) {
      int coefficient = this.getCoefficient(power);
      if (coefficient == 0) {
        continue;
      }
      hashCode += PolynomialUtils.getHashCodeOfPolynomial(coefficient,power);
    }
    return hashCode;
  }


  protected abstract void addCoefficientToAppropriateIndex(int coefficient, int power);

  protected abstract int getMaxPower();

  protected abstract int findCoefficient(int power);


  protected Polynomial addSimplePolynomial(SimplePolynomial simplePolynomial){
    Polynomial resultAfterAdding = new SimplePolynomial();
    int maxDegree = Math.max(this.getDegree(), simplePolynomial.getDegree());
    if (maxDegree == 0) {
      return resultAfterAdding;
    }
    for (int power = 0; power <= maxDegree; power++) {
      int sum = this.getCoefficient(power) + simplePolynomial.getCoefficient(power);
      resultAfterAdding.addTerm(sum, power);
    }
    return resultAfterAdding;
  }

  protected Polynomial addSparsePolynomial(SparsePolynomial sparsePolynomial){
    Polynomial resultAfterAddition = new SparsePolynomial();
    int previousPower = 0;
    for (PolynomialElement element : sparsePolynomial.polynomialElements) {
      resultAfterAddition.addTerm(element.getCoefficient() + this.getCoefficient(element.getPower()), element.getPower());
      for (int power = previousPower + 1; power < element.getPower(); power++) {
        resultAfterAddition.addTerm(this.getCoefficient(power), power);
      }
      previousPower = element.getPower();
    }
    for (int power = previousPower + 1; power <= this.getDegree(); power++) {
      resultAfterAddition.addTerm(this.getCoefficient(power), power);
    }
    return resultAfterAddition;
  }

  protected boolean equalsSimplePolynomial(SimplePolynomial simplePolynomial) {

    if(this.getDegree() != simplePolynomial.getDegree()) {
      return false;
    }

    for (int i = 0; i <= simplePolynomial.getDegree(); i++) {
      if (this.getCoefficient(i) != simplePolynomial.getCoefficient(i)) {
        return false;
      }
    }
    return true;
  }

  protected boolean equalsSparsePolynomial(SparsePolynomial sparsePolynomial) {
    int previousPower = -1;
    for (PolynomialElement element : sparsePolynomial.polynomialElements) {
      if (this.getCoefficient(element.getPower()) != element.getCoefficient()) {
        return false;
      }
      for (int power = previousPower + 1; power < element.getPower(); power++) {
        if (this.getCoefficient(power) != 0) {
          return false;
        }
      }
      previousPower = element.getPower();
    }

    return this.getDegree() <= previousPower;
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

  protected boolean isPolynomialEmpty() {
    return polynomialElements.isEmpty();
  }

}
