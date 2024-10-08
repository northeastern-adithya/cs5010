package polynomial;

import java.util.LinkedList;
import java.util.Optional;

import polynomial.model.PolynomialElement;

public class SparsePolynomial extends AbstractPolynomial<PolynomialElement> {


  public SparsePolynomial() {
    super(new LinkedList<>());
  }

  @Override
  protected void addCoefficientToAppropriateIndex(int coefficient, int power) {
    if (power <= this.getDegree()) {
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
  public int getMaxPower() {
    return polynomialElements.get(
            polynomialElements.size() - 1
    ).getPower();
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
  public Polynomial add(Polynomial other) {
    return null;
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    return null;
  }

  @Override
  public Polynomial derivative() {
    Polynomial resultAfterDerivative = new polynomial.SparsePolynomial();
    polynomialElements.forEach(
            element -> {
              int derivativeCoefficient = findDerivativeCoefficient(element.getCoefficient(), element.getPower());
              resultAfterDerivative.addTerm(derivativeCoefficient, element.getPower() - 1);
            }
    );
    return resultAfterDerivative;
  }

  @Override
  public double evaluate(double x) {
    return polynomialElements.stream()
            .mapToDouble(element
                    -> evaluateValue(element.getCoefficient(), element.getPower(), x))
            .sum();
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
      return that.equalsSparsePolynomial(this);
    }
    return obj.equals(this);
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (PolynomialElement element : polynomialElements) {
      hashCode += element.hashCode();
    }
    return hashCode;
  }

  @Override
  protected Polynomial addSimplePolynomial(SimplePolynomial simplePolynomial) {
    return simplePolynomial.addSparsePolynomial(this);
  }

  @Override
  protected Polynomial addSparsePolynomial(SparsePolynomial sparsePolynomial) {
    int indexOfThis = 0;
    int indexOfOtherSparsePolynomial = 0;

    int thisPolynomialSize = this.polynomialElements.size();
    int otherSparsePolynomialSize = sparsePolynomial.polynomialElements.size();

    SparsePolynomial resultAfterAddition = new SparsePolynomial();

    while (indexOfThis < thisPolynomialSize && indexOfOtherSparsePolynomial < otherSparsePolynomialSize) {
      PolynomialElement thisElement = this.polynomialElements.get(indexOfThis);
      PolynomialElement otherElement = sparsePolynomial.polynomialElements.get(indexOfOtherSparsePolynomial);
      if (thisElement.getPower() == otherElement.getPower()) {
        int sum = thisElement.getCoefficient() + otherElement.getCoefficient();
        resultAfterAddition.addTerm(sum, thisElement.getPower());
        indexOfThis++;
        indexOfOtherSparsePolynomial++;
      } else if (thisElement.getPower() < otherElement.getPower()) {
        resultAfterAddition.addTerm(thisElement.getCoefficient(), thisElement.getPower());
        indexOfThis++;
      } else {
        resultAfterAddition.addTerm(otherElement.getCoefficient(), otherElement.getPower());
        indexOfOtherSparsePolynomial++;
      }
    }

    while (indexOfThis < thisPolynomialSize) {
      PolynomialElement thisElement = this.polynomialElements.get(indexOfThis);
      resultAfterAddition.addTerm(thisElement.getCoefficient(), thisElement.getPower());
      indexOfThis++;
    }

    while (indexOfOtherSparsePolynomial < otherSparsePolynomialSize) {
      PolynomialElement otherElement = sparsePolynomial.polynomialElements.get(indexOfOtherSparsePolynomial);
      resultAfterAddition.addTerm(otherElement.getCoefficient(), otherElement.getPower());
      indexOfOtherSparsePolynomial++;
    }

    return null;
  }

  @Override
  protected boolean equalsSimplePolynomial(SimplePolynomial simplePolynomial) {
    return simplePolynomial.equalsSparsePolynomial(this);
  }

  @Override
  protected boolean equalsSparsePolynomial(polynomial.SparsePolynomial sparsePolynomial) {
    return arePolynomialElementsEquals(sparsePolynomial.polynomialElements);
  }
}

