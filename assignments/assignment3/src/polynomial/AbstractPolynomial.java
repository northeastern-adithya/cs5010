package polynomial;

import java.util.List;

import polynomial.model.PolynomialElement;


/**
 * Abstract class that represents a polynomial.
 * T denotes the type of polynomial elements that can vary based on the implementation.
 * Implements the common functionalities that can be shared among different polynomial implementations.
 */
public abstract class AbstractPolynomial<T> implements Polynomial {


  /**
   * List of polynomial elements that represent the polynomial.
   */
  protected final List<T> polynomialElements;


  /**
   * Constructs a new AbstractPolynomial with the given polynomial elements.
   *
   * @param polynomialElements the polynomial elements of the polynomial
   */
  protected AbstractPolynomial(List<T> polynomialElements) {
    this.polynomialElements = polynomialElements;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    // Validates if the power is negative
    PolynomialUtils.validatePower(power);
    // Not adding the coefficient if it is zero as it does not affect the polynomial
    if (coefficient == 0) {
      return;
    }
    addCoefficientToAppropriateIndex(coefficient, power);
  }

  @Override
  public int getDegree() {
    // If the polynomial is empty, the degree is zero
    if (isPolynomialEmpty()) {
      return 0;
    }
    return getMaxPower();
  }

  @Override
  public String toString() {
    if (isPolynomialEmpty()) {
      return PolynomialConstants.EMPTY_POLYNOMIAL;
    }
    StringBuilder polynomialAsString = new StringBuilder();
    int currentDegree = this.getDegree();
    for (int i = currentDegree; i >= 0; i--) {
      int coefficient = this.getCoefficient(i);
      if (coefficient == 0) {
        continue;
      }
      if (coefficient > 0 && i != currentDegree) {
        polynomialAsString.append(PolynomialConstants.PLUS_SYMBOL);
      }
      polynomialAsString.append(coefficient);
      if (i > 0) {
        polynomialAsString.append(PolynomialConstants.X_POWER_SYMBOL).append(i);
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

  /**
   * Returns the hash code of the polynomial by iterating through
   * the polynomial elements and adding the hash code of each element.
   * If the coefficient is zero, it is not considered in the hash code.
   *
   * @return the hash code of the polynomial
   */
  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int power = 0; power <= this.getDegree(); power++) {
      int coefficient = this.getCoefficient(power);
      if (coefficient == 0) {
        continue;
      }
      hashCode += PolynomialUtils.getHashCodeOfPolynomial(coefficient, power);
    }
    return hashCode;
  }


  /**
   * Adds the coefficient to the appropriate index of polynomial elements list based on the power.
   */
  protected abstract void addCoefficientToAppropriateIndex(int coefficient, int power);

  /**
   * Returns the maximum power(degree) of the polynomial.
   *
   * @return the maximum power(degree) of the polynomial
   */
  protected abstract int getMaxPower();

  /**
   * Returns the coefficient of the polynomial element with the given power.
   *
   * @param power the power of the polynomial element
   * @return the coefficient of the polynomial element
   */
  protected abstract int findCoefficient(int power);


  /**
   * Adds the given simple polynomial to the current polynomial.
   *
   * @param simplePolynomial the simple polynomial to be added
   * @return the simple polynomial after adding the simple polynomial
   */
  protected Polynomial addSimplePolynomial(SimplePolynomial simplePolynomial) {
    Polynomial resultAfterAdding = new SimplePolynomial();
    int maxDegree = Math.max(this.getDegree(), simplePolynomial.getDegree());
    if (maxDegree == 0) {
      return resultAfterAdding;
    }
    // Add the coefficients of the same power terms from both polynomials.
    for (int power = 0; power <= maxDegree; power++) {
      int sum = this.getCoefficient(power) + simplePolynomial.getCoefficient(power);
      resultAfterAdding.addTerm(sum, power);
    }
    return resultAfterAdding;
  }

  /**
   * Adds the given sparse polynomial to the current polynomial.
   * The following optimises considering that sparse polynomial has only non-zero coefficients.
   *
   * @param sparsePolynomial the sparse polynomial to be added
   * @return the sparse polynomial after adding the sparse polynomial
   */
  protected Polynomial addSparsePolynomial(SparsePolynomial sparsePolynomial) {
    Polynomial resultAfterAddition = new SparsePolynomial();
    int previousPower = -1;
    for (PolynomialElement element : sparsePolynomial.polynomialElements) {
      resultAfterAddition.addTerm(element.getCoefficient() + this.getCoefficient(element.getPower()), element.getPower());

      // Adding the coefficients of the terms that are not present in the sparse polynomial.
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

  /**
   * Multiplies the given simple polynomial with the current polynomial.
   *
   * @param simplePolynomial the simple polynomial to be multiplied
   * @return the simple polynomial after multiplying the simple polynomial
   */
  protected Polynomial multiplySimplePolynomial(SimplePolynomial simplePolynomial) {
    Polynomial resultAfterMultiplying = new SimplePolynomial();
    for (int i = 0; i <= this.getDegree(); i++) {
      for (int j = 0; j <= simplePolynomial.getDegree(); j++) {
        int product = this.getCoefficient(i) * simplePolynomial.getCoefficient(j);
        resultAfterMultiplying.addTerm(product, i + j);
      }
    }
    return resultAfterMultiplying;
  }

  /**
   * Multiplies the given sparse polynomial with the current polynomial.
   * The following optimises considering that sparse polynomial has only non-zero coefficients.
   *
   * @param sparsePolynomial the sparse polynomial to be multiplied
   * @return the sparse polynomial after multiplying the sparse polynomial
   */
  protected Polynomial multiplySparsePolynomial(SparsePolynomial sparsePolynomial) {
    Polynomial resultAfterMultiplying = new SparsePolynomial();
    for (PolynomialElement element : sparsePolynomial.polynomialElements) {
      for (int i = 0; i <= this.getDegree(); i++) {
        int product = this.getCoefficient(i) * element.getCoefficient();
        resultAfterMultiplying.addTerm(product, i + element.getPower());
      }
    }
    return resultAfterMultiplying;
  }

  /**
   * Compares if the given object is equals to the simple polynomial.
   * Polynomials are equal if they have same non-zero coefficients at the same power.
   *
   * @return true if the given object is equals to the simple polynomial, false otherwise
   */
  protected boolean equalsSimplePolynomial(SimplePolynomial simplePolynomial) {

    if (this.getDegree() != simplePolynomial.getDegree()) {
      return false;
    }

    for (int i = 0; i <= simplePolynomial.getDegree(); i++) {
      if (this.getCoefficient(i) != simplePolynomial.getCoefficient(i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Compares if the given object is equals to the sparse polynomial.
   * Polynomials are equal if they have same non-zero coefficients at the same power.
   * This optimises the comparison by considering that sparse polynomial has only non-zero coefficients.
   *
   * @return true if the given object is equals to the sparse polynomial, false otherwise
   */
  protected boolean equalsSparsePolynomial(SparsePolynomial sparsePolynomial) {
    int previousPower = -1;
    for (PolynomialElement element : sparsePolynomial.polynomialElements) {
      if (this.getCoefficient(element.getPower()) != element.getCoefficient()) {
        return false;
      }
      // Checking if the coefficients of the terms that are not present in the sparse polynomial are zero.
      for (int power = previousPower + 1; power < element.getPower(); power++) {
        if (this.getCoefficient(power) != 0) {
          return false;
        }
      }
      previousPower = element.getPower();
    }

    return this.getDegree() <= previousPower;
  }

  /**
   * Compares if the given set of polynomial elements is
   * equal to the polynomial elements of the current polynomial.
   *
   * @return true if equal, false otherwise
   */
  protected boolean arePolynomialElementsEquals(List<T> polynomialElements) {
    return this.polynomialElements.equals(polynomialElements);
  }


  /**
   * Evaluates the value of the polynomial at the given x.
   *
   * @param coefficient the coefficient of the term
   * @param power       the power of the term
   * @param x           the value at which the polynomial is evaluated
   * @return the value of the polynomial at the given x
   */
  protected double evaluateValue(int coefficient, int power, double x) {
    return coefficient * Math.pow(x, power);
  }

  /**
   * Finds the coefficient after derivative of the term with the given power.
   *
   * @param currentCoefficient the coefficient of the term
   * @param power              the power of the term
   * @return the coefficient after derivative of the term
   */
  protected int findDerivativeCoefficient(int currentCoefficient, int power) {
    return currentCoefficient * power;
  }

  /**
   * Validates if the power defined is valid based on the polynomial elements present.
   *
   * @param power the power to be validated
   *              true, if the power is invalid, false otherwise
   */
  private boolean isInvalidPower(int power) {
    return power < 0 || power > this.getDegree() || isPolynomialEmpty();
  }

  /**
   * Checks if the polynomial is empty.
   *
   * @return true if the polynomial is empty, false otherwise
   */
  protected boolean isPolynomialEmpty() {
    return polynomialElements.isEmpty();
  }

}
