package polynomial;

import java.util.LinkedList;
import java.util.Optional;

import polynomial.model.PolynomialElement;

public class SparsePolynomial extends AbstractPolynomial<PolynomialElement> {

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
        polynomialElements.add(index, new PolynomialElement(power, coefficient));
      } else {
        polynomialElements.set(index, new PolynomialElement(power, existingCoefficient + coefficient));
      }
    } else {
      polynomialElements.add(new PolynomialElement(power, coefficient));
    }
  }

  @Override
  protected Polynomial addSimplePolynomial(SimplePolynomial simplePolynomial) {
    SparsePolynomial resultAfterAddition = new SparsePolynomial();
    int previousPower = 0;

    for (PolynomialElement element : this.polynomialElements) {
      resultAfterAddition.addTerm(element.getCoefficient() + simplePolynomial.getCoefficient(element.getPower()), element.getPower());

      for (int power = previousPower + 1; power < element.getPower(); power++) {
        resultAfterAddition.addTerm(simplePolynomial.getCoefficient(power), power);
      }

      previousPower = element.getPower();
    }

    for (int power = previousPower + 1; power <= simplePolynomial.getDegree(); power++) {
      resultAfterAddition.addTerm(simplePolynomial.getCoefficient(power), power);
    }
    return resultAfterAddition;
  }

  @Override
  protected Polynomial addSparsePolynomial(SparsePolynomial sparsePolynomial) {
    return null;
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
            .filter(polynomialElement -> polynomialElement.getPower() == power)
            .map(PolynomialElement::getCoefficient)
            .findFirst();
    return optionalCoefficient.orElse(0);
  }

  @Override
  protected boolean equalsAbstractPolynomial(AbstractPolynomial obj) {
    return obj.equalsSparsePolynomial(this);
  }

  @Override
  protected boolean equalsSparsePolynomial(SparsePolynomial obj) {
    return arePolynomialElementsEquals(obj.polynomialElements);
  }

  @Override
  protected boolean equalsSimplePolynomial(SimplePolynomial obj) {
    return obj.equalsSparsePolynomial(this);
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (PolynomialElement element : polynomialElements) {
      hashCode += element.hashCode();
    }
    return hashCode;
  }
}
