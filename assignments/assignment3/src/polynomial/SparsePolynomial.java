package polynomial;

import java.util.LinkedList;
import java.util.Optional;

import polynomial.model.PolynomialContainer;

public class SparsePolynomial extends AbstractPolynomial<PolynomialContainer> {

  public SparsePolynomial() {
    super(new LinkedList<>());
  }

  @Override
  public Polynomial add(Polynomial other) {

    return null;
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    return null;
  }

  @Override
  public Polynomial derivative() {
    Polynomial resultAfterDerivative = new SparsePolynomial();
    polynomialElements.forEach(
            element -> {
              int derivativeCoefficient = findDerivativeCoefficient(element.getCoefficient(), element.getPower());
              resultAfterDerivative.addTerm(derivativeCoefficient, element.getPower() - 1);
            }
    );
    return resultAfterDerivative;
  }


  @Override
  protected void addCoefficientToAppropriateIndex(int coefficient, int power) {
    if (power < this.getDegree()) {
      int index = 0;
      while (index < polynomialElements.size() && polynomialElements.get(index).getPower() < power) {
        index++;
      }
      int existingCoefficient = this.getCoefficient(power);
      if (existingCoefficient == 0) {
        polynomialElements.add(index, new PolynomialContainer(power, coefficient));
      } else {
        polynomialElements.set(index, new PolynomialContainer(power, existingCoefficient + coefficient));
      }
    } else {
      polynomialElements.add(new PolynomialContainer(power, coefficient));
    }
  }

  @Override
  protected AbstractPolynomial<PolynomialContainer> createNewInstance() {
    return new SparsePolynomial();
  }

  @Override
  public int getMaxPower() {
    return polynomialElements.get(
            polynomialElements.size() - 1
    ).getPower();
  }

  @Override
  public double evaluate(double x) {
    return polynomialElements.stream()
            .mapToDouble(element
                    -> evaluateValue(element.getCoefficient(), element.getPower(), x))
            .sum();
  }


  @Override
  public int findCoefficient(int power) {
    Optional<Integer> optionalCoefficient = polynomialElements.stream()
            .filter(polynomialContainer -> polynomialContainer.getPower() == power)
            .map(PolynomialContainer::getCoefficient)
            .findFirst();
    return optionalCoefficient.orElse(0);
  }
}
