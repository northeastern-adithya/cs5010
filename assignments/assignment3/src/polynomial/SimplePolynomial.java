package polynomial;

import java.util.ArrayList;


public class SimplePolynomial extends AbstractPolynomial<Integer> {


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


    for (int power = 0; power <= maxDegree; power++) {
      int sum = this.getCoefficient(power) + other.getCoefficient(power);
      resultAfterAdding.addTerm(sum, power);
    }
    return resultAfterAdding;
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    Polynomial resultAfterMultiplying = new SimplePolynomial();


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
    for (int power = 1; power <= this.getDegree(); power++) {
      int derivativeCoefficient = findDerivativeCoefficient(this.getCoefficient(power), power);
      resultAfterDerivative.addTerm(derivativeCoefficient, power - 1);
    }
    return resultAfterDerivative;
  }


  @Override
  public int getMaxPower() {
    return polynomialElements.size() - 1;
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
  public int findCoefficient(int power) {
    return polynomialElements.get(power);
  }


  @Override
  protected boolean equalsAbstractPolynomial(AbstractPolynomial obj) {
    return obj.equalsSimplePolynomial(this);
  }


  @Override
  protected boolean equalsSimplePolynomial(SimplePolynomial obj) {
    return arePolynomialElementsEquals(obj.polynomialElements);
  }

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
  protected Polynomial addSimplePolynomial(SimplePolynomial simplePolynomial) {
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

  @Override
  protected Polynomial addSparsePolynomial(SparsePolynomial sparsePolynomial) {
    return sparsePolynomial.addSimplePolynomial(this);
  }


  private void cleanUpTrailingZeros() {
    int power = this.getDegree();
    while (!isPolynomialEmpty() && power >= 0 && this.getCoefficient(power) == 0) {
      polynomialElements.remove(power);
      power--;
    }
  }

}
