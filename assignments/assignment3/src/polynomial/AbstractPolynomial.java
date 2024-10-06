package polynomial;

import java.util.List;

/**
 * This class provides an abstract implementation of the Polynomial interface.
 * It provides the common methods to add a term, evaluate the polynomial and
 * convert the polynomial to a string.
 */
public abstract class AbstractPolynomial<T> implements Polynomial {

  /**
   * A string representation of an empty polynomial.
   */
  private static final String EMPTY_POLYNOMIAL = "0";

  /**
   * A string representation of the plus symbol.
   */
  private static final String PLUS_SYMBOL = "+";

  /**
   * A string representation of the x^ symbol.
   */
  private static final String X_POWER_SYMBOL = "x^";

  /**
   * A list to store the coefficients of the polynomial.
   * The type is dependent on the implementation
   */
  protected final List<T> polynomialElements;

  /**
   * Constructs an AbstractPolynomial object with the given list of coefficients.
   *
   * @param polynomialElements the list of coefficients of the polynomial
   */
  protected AbstractPolynomial(List<T> polynomialElements) {
    this.polynomialElements = polynomialElements;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    // Validation is necessary before adding the polynomial term.
    validatePower(power);
    if (coefficient == 0) {
      return;
    }
    addCoefficientToAppropriateIndex(coefficient, power);
  }

  @Override
  public double evaluate(double x) {
    double evaluatedValue = 0;

    for (int power = 0; power <= this.getDegree(); power++) {
      evaluatedValue += this.getCoefficient(power) * Math.pow(x, power);
    }
    return evaluatedValue;
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


  /**
   * Adds the coefficient to the appropriate index in the polynomial.
   * If the coefficient is 0, it is not added to the polynomial.
   *
   * @param coefficient the coefficient of the term to be added
   * @param power       the power of the term to be added
   * @throws IllegalArgumentException if power fails validation
   */
  protected abstract void addCoefficientToAppropriateIndex(int coefficient, int power);

  /**
   * Checks if the polynomial is empty.
   *
   * @return true if the polynomial is empty, false otherwise
   */
  protected boolean isPolynomialEmpty() {
    return polynomialElements.isEmpty();
  }


  protected boolean isInvalidPower(int power) {
    return power < 0 || power > this.getDegree() || isPolynomialEmpty();
  }

  /**
   * Validates the power of the term to be added.
   *
   * @param power power of the term to be added
   * @throws IllegalArgumentException if the power is negative
   */
  protected void validatePower(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException(
              String.format("Power cannot be negative. Received: %d", power));
    }
  }
}
