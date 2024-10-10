import polynomial.Polynomial;

/**
 * Mock class for implementing Polynomial interface.
 */
public class MockPolynomial implements Polynomial {

  @Override
  public Polynomial add(Polynomial other) {
    return new MockPolynomial();
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    return new MockPolynomial();
  }

  @Override
  public Polynomial derivative() {
    return new MockPolynomial();
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    //Mock method does not do anything.
  }

  @Override
  public int getDegree() {
    return 2;
  }

  @Override
  public double evaluate(double x) {
    return 1;
  }

  @Override
  public int getCoefficient(int power) {
    return 1;
  }

  @Override
  public boolean equals(Object obj) {
    return false;
  }

  @Override
  public int hashCode() {
    return 1;
  }
}
