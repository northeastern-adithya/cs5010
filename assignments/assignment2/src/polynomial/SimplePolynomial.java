package polynomial;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Polynomial interface providing implementation
 * to add, multiply, and differentiate polynomials.
 * Is a simple polynomial with single variable and integer coefficients.
 */
public class SimplePolynomial implements Polynomial {


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
   * The index of the element represents the power of the term.
   */
  private final List<Integer> polynomialCoefficients;


  /**
   * Constructs a SimplePolynomial object with an empty array list.
   */
  public SimplePolynomial() {
    polynomialCoefficients = new ArrayList<>();
  }


  @Override
  public Polynomial add(Polynomial other) {
    Polynomial resultAfterAdding = new SimplePolynomial();
    int maxDegree = Math.max(this.getDegree(), other.getDegree());

    // Add the coefficients of the same power terms from both polynomials.
    for (int power = 0; power <= maxDegree; power++) {
      int sum = this.getCoefficient(power) + other.getCoefficient(power);
      resultAfterAdding.addTerm(sum, power);
    }
    return resultAfterAdding;
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    Polynomial resultAfterMultiplying = new SimplePolynomial();

    // Multiply the coefficients of the terms from both polynomials.
    for (int i = 0; i <= this.getDegree(); i++) {
      for (int j = 0; j <= other.getDegree(); j++) {
        int product = this.getCoefficient(i) * other.getCoefficient(j);
        resultAfterMultiplying.addTerm(product, i + j);
      }
    }
    return resultAfterMultiplying;
  }

  @Override
  public Polynomial derivative() {
    Polynomial resultAfterDerivative = new SimplePolynomial();

    // Ignoring the first derivative since derivative of a constant is 0.
    for (int power = 1; power <= this.getDegree(); power++) {
      int derivativeCoefficient = this.getCoefficient(power) * power;
      resultAfterDerivative.addTerm(derivativeCoefficient, power - 1);
    }
    return resultAfterDerivative;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    addCoefficientToAppropriateIndex(coefficient, power);
    // Cleaning up trailing zeroes is necessary to ensure that maximum degree is the last element.
    cleanUpTrailingZeros();
  }

  @Override
  public int getDegree() {
    // Returns 0 if the polynomial is empty.
    if (isPolynomialEmpty()) {
      return 0;
    }
    return polynomialCoefficients.size() - 1;
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
  public int getCoefficient(int power) {

    // If power is out of bounds, returns 0.
    if (power < 0 || power > this.getDegree()) {
      return 0;
    }
    return polynomialCoefficients.get(power);
  }

  /**
   * Compares simple polynomial with another object to verify if they are equal or not.
   * If the object is not an instance of SimplePolynomial then returns false.
   * Additional checks are performed to ensure polynomial coefficients are equal.
   *
   * @param obj the object to compare with
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SimplePolynomial)) {
      return false;
    }
    SimplePolynomial that = (SimplePolynomial) obj;
    return polynomialCoefficients.equals(that.polynomialCoefficients);
  }

  /**
   * Generates a hash code using coefficients of the simple polynomial.
   *
   * @return the hash code for the simple polynomial
   */
  @Override
  public int hashCode() {
    return polynomialCoefficients.hashCode();
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
   * Checks if the polynomial is empty.
   *
   * @return true if the polynomial is empty, false otherwise
   */
  private boolean isPolynomialEmpty() {
    return polynomialCoefficients.isEmpty();
  }

  /**
   * Removes trailing zeros from the polynomial by checking
   * the coefficients from the highest power to the lowest until a non-zero
   * coefficient is encountered.
   */
  private void cleanUpTrailingZeros() {
    int power = this.getDegree();
    while (!isPolynomialEmpty() && power >= 0 && this.getCoefficient(power) == 0) {
      polynomialCoefficients.remove(power);
      power--;
    }
  }

  /**
   * Validates the power of the term to be added.
   *
   * @param power power of the term to be added
   * @throws IllegalArgumentException if the power is negative
   */
  private void validatePower(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException(
              String.format("Power cannot be negative. Received: %d", power));
    }
  }

  /**
   * Adds the coefficient to the appropriate index in the polynomial.
   * If the coefficient is 0, it is not added to the polynomial.
   *
   * @param coefficient the coefficient of the term to be added
   * @param power       the power of the term to be added
   * @throws IllegalArgumentException if power fails validation
   */
  private void addCoefficientToAppropriateIndex(
          int coefficient, int power) throws IllegalArgumentException {
    // Validation is necessary before adding the polynomial term.
    validatePower(power);
    if (coefficient == 0) {
      return;
    }
    if (power < polynomialCoefficients.size()) {
      polynomialCoefficients.set(power, this.getCoefficient(power) + coefficient);
    } else {
      // Defaults to add 0 as coefficients for missing powers.
      for (int i = polynomialCoefficients.size(); i < power; i++) {
        polynomialCoefficients.add(0);
      }
      polynomialCoefficients.add(coefficient);
    }
  }

}
