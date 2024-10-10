import java.util.ArrayList;
import java.util.Arrays;

import polynomial.AbstractPolynomial;
import polynomial.Polynomial;

/**
 * A mock class extending abstract polynomial.
 */
public class MockChildAbstractPolynomial extends AbstractPolynomial<Integer> {
  /**
   * Used to construct mock of class extending abstract polynomial.
   */
  public MockChildAbstractPolynomial() {
    super(new ArrayList<>(Arrays.asList(1, 2)));
  }

  @Override
  protected void addCoefficientToAppropriateIndex(int coefficient, int power) {
    //Mock method does not do anything.
  }

  @Override
  protected int getMaxPower() {
    return 2;
  }

  @Override
  protected int findCoefficient(int power) {
    return 0;
  }

  @Override
  public Polynomial add(Polynomial other) {
    return new MockChildAbstractPolynomial();
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    return new MockChildAbstractPolynomial();
  }

  @Override
  public Polynomial derivative() {
    return new MockChildAbstractPolynomial();
  }

  @Override
  public double evaluate(double x) {
    return 0;
  }
}
