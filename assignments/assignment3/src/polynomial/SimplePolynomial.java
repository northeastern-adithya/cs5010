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

  @Override
  protected AbstractPolynomial<Integer> createNewInstance() {
    return new SimplePolynomial();
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
