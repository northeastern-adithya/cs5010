package polynomial;

import java.util.LinkedList;
import java.util.Optional;

import polynomial.model.PolynomialContainer;

public class SparsePolynomial extends AbstractPolynomial<PolynomialContainer> {

  protected SparsePolynomial() {
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
    return null;
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
  public int getDegree() {
    if (isPolynomialEmpty()) {
      return 0;
    }
    Optional<Integer> maxPower = polynomialElements.stream()
            .map(PolynomialContainer::getPower)
            .max(Integer::compareTo);

    return maxPower.orElse(0);
  }


  @Override
  public int getCoefficient(int power) {
    if (isInvalidPower(power)) {
      return 0;
    }
    Optional<Integer> coefficient = polynomialElements.stream()
            .filter(polynomialContainer -> polynomialContainer.getPower() == power)
            .map(PolynomialContainer::getCoefficient)
            .findFirst();

    return coefficient.orElse(0);
  }
}
