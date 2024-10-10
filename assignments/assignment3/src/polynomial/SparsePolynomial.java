package polynomial;

import java.util.LinkedList;
import java.util.Optional;

import polynomial.model.PolynomialElement;

/**
 * A simple polynomial class that extends AbstractPolynomial.
 * This class stores polynomial elements as linked list of these elements.
 * Provides concrete implementation to function present in polynomial interface.
 */
public class SparsePolynomial extends AbstractPolynomial<PolynomialElement> {


  /**
   * Constructs a SimplePolynomial object with an empty linked list.
   */
  public SparsePolynomial() {
    super(new LinkedList<>());
  }

  @Override
  protected void addCoefficientToAppropriateIndex(int coefficient, int power) {
    if (power <= this.getDegree()) {
      int index = 0;
      while (index < polynomialElements.size()
              && polynomialElements.get(index).getPower() < power) {
        index++;
      }
      int existingCoefficient = this.getCoefficient(power);
      if (existingCoefficient == 0) {
        polynomialElements.add(index, new PolynomialElement(coefficient, power));
      } else {
        // This cases handles the scenario when the power already exists in the polynomial.
        int coefficientSum = existingCoefficient + coefficient;
        if (coefficientSum == 0) {
          // Removing the element if the sum of coefficients becomes zero.
          polynomialElements.remove(index);
        } else {
          // Updating the coefficient if the sum is non-zero.
          polynomialElements.set(index, new PolynomialElement(coefficientSum, power));
        }
      }
    } else {
      polynomialElements.add(new PolynomialElement(coefficient, power));
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
    if (other instanceof AbstractPolynomial) {
      AbstractPolynomial<?> abstractPolynomial = (AbstractPolynomial<?>) other;
      // Delegates the addition knowing the fact
      // that the current polynomial is a sparse polynomial.
      return abstractPolynomial.addSparsePolynomial(this);
    }
    // If a polynomial is not abstract polynomial,
    // then addition is delegated to the other polynomial.
    return other.add(this);
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    if (other instanceof AbstractPolynomial) {
      AbstractPolynomial<?> abstractPolynomial = (AbstractPolynomial<?>) other;
      // Delegates the multiplication knowing
      // the fact that the current polynomial is a sparse polynomial.
      return abstractPolynomial.multiplySparsePolynomial(this);
    }
    // If a polynomial is not abstract polynomial,
    // then multiplication is delegated to the other polynomial.
    return other.multiply(this);
  }

  @Override
  public Polynomial derivative() {
    Polynomial resultAfterDerivative = new polynomial.SparsePolynomial();
    polynomialElements.forEach(
        element -> {
            // Zero is the derivative of a constant, hence ignoring it.
            if (element.getPower() == 0) {
              return;
            }
            int derivativeCoefficient =
                    findDerivativeCoefficient(element.getCoefficient(), element.getPower());
            resultAfterDerivative
                    .addTerm(derivativeCoefficient, element.getPower() - 1);
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

  /**
   * Compares sparse polynomial with another object to verify if they are equal or not.
   * If the object is not an instance of Polynomial then returns false.
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
    if (!(obj instanceof Polynomial)) {
      return false;
    }
    if (obj instanceof AbstractPolynomial) {
      AbstractPolynomial<?> that = (AbstractPolynomial<?>) obj;
      return that.equalsSparsePolynomial(this);
    }
    return obj.equals(this);
  }

  /**
   * Returns the hash code of the polynomial by iterating through
   * the polynomial elements and adding the hash code of each element.
   *
   * @return the hash code of the polynomial
   */
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
    // Using addition with sparse polynomial since its more optimized.
    // Function output is changed to a sparse polynomial.
    return simplePolynomial.addSparsePolynomial(this);
  }


  /**
   * Adds the given sparse polynomial to the current polynomial.
   * Addition is performed considering both the polynomials are sparse polynomial
   *
   * @param sparsePolynomial the sparse polynomial to be added
   * @return the sparse polynomial after adding the sparse polynomial
   */
  @Override
  protected Polynomial addSparsePolynomial(SparsePolynomial sparsePolynomial) {
    int indexOfThis = 0;
    int indexOfOtherSparsePolynomial = 0;

    int thisPolynomialSize = this.polynomialElements.size();
    int otherSparsePolynomialSize = sparsePolynomial.polynomialElements.size();

    Polynomial resultAfterAddition = new SparsePolynomial();

    while (indexOfThis < thisPolynomialSize
            && indexOfOtherSparsePolynomial < otherSparsePolynomialSize) {
      PolynomialElement thisElement = this.polynomialElements.get(indexOfThis);
      PolynomialElement otherElement
              = sparsePolynomial.polynomialElements.get(indexOfOtherSparsePolynomial);
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
      PolynomialElement otherElement
              = sparsePolynomial.polynomialElements.get(indexOfOtherSparsePolynomial);
      resultAfterAddition.addTerm(otherElement.getCoefficient(), otherElement.getPower());
      indexOfOtherSparsePolynomial++;
    }

    return resultAfterAddition;
  }

  @Override
  public Polynomial multiplySimplePolynomial(SimplePolynomial simplePolynomial) {
    // Using multiplication with sparse polynomial since its more optimized.
    return simplePolynomial.multiplySparsePolynomial(this);
  }

  /**
   * Multiplies the given sparse polynomial to the current polynomial.
   * Multiplication is performed considering both the polynomials are sparse polynomial
   *
   * @param sparsePolynomial the sparse polynomial to be multiplied
   * @return the sparse polynomial after multiplying the sparse polynomial
   */
  @Override
  public Polynomial multiplySparsePolynomial(SparsePolynomial sparsePolynomial) {
    Polynomial resultAfterMultiplying = new SparsePolynomial();
    // Iterating through all the non-zero coefficients
    for (PolynomialElement thisElement : this.polynomialElements) {
      for (PolynomialElement otherElement : sparsePolynomial.polynomialElements) {
        int power = thisElement.getPower() + otherElement.getPower();
        int coefficient = thisElement.getCoefficient() * otherElement.getCoefficient();
        resultAfterMultiplying.addTerm(coefficient, power);
      }
    }
    return resultAfterMultiplying;
  }

  @Override
  protected boolean equalsSimplePolynomial(SimplePolynomial simplePolynomial) {
    // Using equals with sparse polynomial since its more optimized.
    return simplePolynomial.equalsSparsePolynomial(this);
  }

  @Override
  protected boolean equalsSparsePolynomial(polynomial.SparsePolynomial sparsePolynomial) {
    // Comparing arrays directly since both objects are simple polynomials
    return arePolynomialElementsEquals(sparsePolynomial.polynomialElements);
  }


  // Is efficient since the elements have non-zero coefficients
  // and are stored in increasing order of their power.
  @Override
  public String toString() {
    if (isPolynomialEmpty()) {
      return PolynomialConstants.EMPTY_POLYNOMIAL;
    }
    StringBuilder polynomialAsString = new StringBuilder();
    int elementsSize = polynomialElements.size();
    for (int index = elementsSize - 1; index >= 0; index--) {
      PolynomialElement element = polynomialElements.get(index);
      if (element.getCoefficient() > 0 && index != elementsSize - 1) {
        polynomialAsString.append(PolynomialConstants.PLUS_SYMBOL);
      }
      polynomialAsString.append(element);
    }
    return polynomialAsString.toString();

  }
}

