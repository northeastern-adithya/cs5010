package polynomial;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This class implements the Polynomial interface providing implementation
 * to add, multiply, and differentiate polynomials.
 * Is a simple polynomial with single variable and integer coefficients.
 */
public class SimplePolynomial extends AbstractPolynomial<Integer> {


  /**
   * Constructs a SimplePolynomial object with an empty array list.
   */
  public SimplePolynomial() {
    super(new ArrayList<>());
  }


  @Override
  public Polynomial add(Polynomial other) {
    Polynomial resultAfterAdding = new SimplePolynomial();
    int maxDegree = Math.max(this.getDegree(), other.getDegree());

    if (maxDegree == 0) {
      return resultAfterAdding;
    }

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
  public int getDegree() {
    // Returns 0 if the polynomial is empty.
    if (isPolynomialEmpty()) {
      return 0;
    }
    return polynomialElements.size() - 1;
  }


  @Override
  public int getCoefficient(int power) {

    // If power is out of bounds, returns 0.
    if (isInvalidPower(power)) {
      return 0;
    }
    return polynomialElements.get(power);
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
    return polynomialElements.equals(that.polynomialElements);
  }

  /**
   * Generates a hash code using coefficients,toString and the class type of the simple polynomial.
   * Uses toString to include the powers along with the coefficients.
   *
   * @return the hash code for the simple polynomial
   */
  @Override
  public int hashCode() {
    return Objects.hash(polynomialElements, this.toString(), this.getClass());
  }

  protected void addCoefficientToAppropriateIndex(int coefficient, int power) {

    if (power < polynomialElements.size()) {
      polynomialElements.set(power, this.getCoefficient(power) + coefficient);
    } else {
      // Defaults to add 0 as coefficients for missing powers.
      for (int i = polynomialElements.size(); i < power; i++) {
        polynomialElements.add(0);
      }
      polynomialElements.add(coefficient);
    }
    // Cleaning up trailing zeroes is necessary to ensure that maximum degree is the last element.
    cleanUpTrailingZeros();
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
