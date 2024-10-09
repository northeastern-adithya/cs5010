package polynomial;

import java.util.ArrayList;


/**
 * A simple polynomial class that extends AbstractPolynomial.
 * This class stores polynomial elements as an integer array list.
 * Provides concrete implementation to function present in polynomial interface.
 */
public class SimplePolynomial extends AbstractPolynomial<Integer> {

  /**
   * Constructs a SimplePolynomial object with an empty array list.
   */
  public SimplePolynomial() {
    super(new ArrayList<>());
  }


  @Override
  protected void addCoefficientToAppropriateIndex(int coefficient, int power) {
    if (power < polynomialElements.size()) {
      // This cases handles the scenario when the power already exists in the polynomial.
      polynomialElements.set(power, this.getCoefficient(power) + coefficient);
    } else {
      // // Defaults to add 0 as coefficients for missing powers.
      for (int i = polynomialElements.size(); i < power; i++) {
        polynomialElements.add(0);
      }
      polynomialElements.add(coefficient);
    }
    // Cleaning up trailing zeroes is necessary to ensure that maximum degree is the last element.
    cleanUpTrailingZeros();
  }

  @Override
  public int getMaxPower() {
    return polynomialElements.size() - 1;
  }

  @Override
  public int findCoefficient(int power) {
    return polynomialElements.get(power);
  }

  @Override
  public Polynomial add(Polynomial other) {
    if (other instanceof AbstractPolynomial) {
      AbstractPolynomial<?> abstractPolynomial = (AbstractPolynomial<?>) other;
      // Delegates the addition knowing the fact that the current polynomial is a simple polynomial.
      return abstractPolynomial.addSimplePolynomial(this);
    }
    // If a polynomial is not abstract polynomial,
    // then addition is delegated to the other polynomial.
    return other.add(this);
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    if (other instanceof AbstractPolynomial) {
      AbstractPolynomial<?> abstractPolynomial = (AbstractPolynomial<?>) other;
      // Delegates the multiplication knowing
      // the fact that the current polynomial is a simple polynomial.
      return abstractPolynomial.multiplySimplePolynomial(this);
    }
    // If a polynomial is not abstract polynomial,
    // then multiplication is delegated to the other polynomial.
    return other.multiply(this);
  }

  @Override
  public Polynomial derivative() {
    Polynomial resultAfterDerivative = new SimplePolynomial();
    for (int power = 1; power <= this.getDegree(); power++) {
      int derivativeCoefficient = findDerivativeCoefficient(this.getCoefficient(power), power);
      resultAfterDerivative.addTerm(derivativeCoefficient, power - 1);
    }
    return resultAfterDerivative;
  }

  @Override
  public double evaluate(double x) {
    double evaluatedValue = 0;
    for (int power = 0; power <= this.getDegree(); power++) {
      evaluatedValue += evaluateValue(this.getCoefficient(power), power, x);
    }
    return evaluatedValue;
  }

  /**
   * Compares simple polynomial with another object to verify if they are equal or not.
   * If the object is not an instance of Polynomial then returns false.
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

    if (!(obj instanceof Polynomial)) {
      return false;
    }

    if (obj instanceof AbstractPolynomial) {
      AbstractPolynomial<?> that = (AbstractPolynomial<?>) obj;
      return that.equalsSimplePolynomial(this);
    }
    return obj.equals(this);
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

  @Override
  protected boolean equalsSimplePolynomial(SimplePolynomial simplePolynomial) {
    // Comparing arrays directly since both objects are simple polynomials
    return arePolynomialElementsEquals(simplePolynomial.polynomialElements);
  }

  /**
   * Removes trailing zeros from the polynomial by checking
   * the coefficients from the highest power to the lowest until a non-zero
   * coefficient is encountered.
   */
  private void cleanUpTrailingZeros() {
    int power = this.getDegree();
    while (!isPolynomialEmpty() && power >= 0 && this.getCoefficient(power) == 0) {
      polynomialElements.remove(power);
      power--;
    }
  }
}
