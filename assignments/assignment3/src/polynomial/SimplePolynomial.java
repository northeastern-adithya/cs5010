package polynomial;

import java.util.ArrayList;


public class SimplePolynomial extends AbstractPolynomial<Integer> {

  public SimplePolynomial() {
    super(new ArrayList<>());
  }


  @Override
  protected void addCoefficientToAppropriateIndex(int coefficient, int power) {
    if (power < polynomialElements.size()) {
      polynomialElements.set(power, this.getCoefficient(power) + coefficient);
    } else {
      for (int i = polynomialElements.size(); i < power; i++) {
        polynomialElements.add(0);
      }
      polynomialElements.add(coefficient);
    }
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
      return abstractPolynomial.addSimplePolynomial(this);
    }
    return other.add(this);
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    if (other instanceof AbstractPolynomial) {
      AbstractPolynomial<?> abstractPolynomial = (AbstractPolynomial<?>) other;
      return abstractPolynomial.multiplySimplePolynomial(this);
    }
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

  @Override
  protected boolean equalsSimplePolynomial(SimplePolynomial simplePolynomial) {
    return arePolynomialElementsEquals(simplePolynomial.polynomialElements);
  }

  private void cleanUpTrailingZeros() {
    int power = this.getDegree();
    while (!isPolynomialEmpty() && power >= 0 && this.getCoefficient(power) == 0) {
      polynomialElements.remove(power);
      power--;
    }
  }
}
