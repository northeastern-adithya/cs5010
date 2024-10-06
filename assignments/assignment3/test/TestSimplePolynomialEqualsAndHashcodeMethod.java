import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to test the cases for equals and hashcode method in SimplePolynomial.
 */
public class TestSimplePolynomialEqualsAndHashcodeMethod {

  /**
   * The polynomial object to be tested.
   */
  private Polynomial polynomialUnderTest;

  /**
   * Set up the polynomial under test with no elements.
   */
  @Before
  public void setUp() {
    polynomialUnderTest = new SimplePolynomial();
  }


  /**
   * Test the equals and hash code method with no elements in the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeWithNoElements() {
    Polynomial expectedPolynomial = new SimplePolynomial();
    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by passing a different class than the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeMethodWithDifferentClasses() {
    polynomialUnderTest.addTerm(2, 3);
    polynomialUnderTest.addTerm(2, 3);

    Integer integerValue = 3;
    assertNotEquals(integerValue, polynomialUnderTest);
    assertNotEquals(integerValue.hashCode(), polynomialUnderTest.hashCode());
  }


  /**
   * Test the equals and hashcode method by creating a new polynomial with same coefficients
   * starting with a positive term.
   */
  @Test
  public void testEqualsAndHashCodeMethodWithPositiveStartingTerm() {
    polynomialUnderTest.addTerm(2, 3);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(2, 0);

    Polynomial expectedPolynomial = new SimplePolynomial();
    expectedPolynomial.addTerm(2, 3);
    expectedPolynomial.addTerm(-2, 1);
    expectedPolynomial.addTerm(2, 0);

    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with same coefficients
   * starting with a negative term.
   */
  @Test
  public void testEqualsMethodWithNegativeStartingTerm() {
    polynomialUnderTest.addTerm(-2, 3);
    polynomialUnderTest.addTerm(2, 1);
    polynomialUnderTest.addTerm(2, 0);

    Polynomial expectedPolynomial = new SimplePolynomial();
    expectedPolynomial.addTerm(-2, 3);
    expectedPolynomial.addTerm(2, 1);
    expectedPolynomial.addTerm(2, 0);
    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with different coefficients
   * starting with a positive term.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentElementsStartingWithPositiveTerm() {
    polynomialUnderTest.addTerm(2, 3);
    polynomialUnderTest.addTerm(-2, 1);

    Polynomial differentPolynomial = new SimplePolynomial();
    differentPolynomial.addTerm(2, 3);
    assertNotEquals(differentPolynomial, polynomialUnderTest);
    assertNotEquals(differentPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method with polynomial having
   * non-zero and zero elements.
   */
  @Test
  public void testEqualsAndHashCodeWithNonZeroAndZeroElements() {
    polynomialUnderTest.addTerm(-2, 3);
    polynomialUnderTest.addTerm(-2, 1);

    Polynomial differentPolynomial = new SimplePolynomial();
    assertNotEquals(differentPolynomial, polynomialUnderTest);
    assertNotEquals(differentPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with different coefficients
   * starting with a negative term.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentElementsStartingWithNegativeTerm() {
    polynomialUnderTest.addTerm(-2, 3);
    polynomialUnderTest.addTerm(2, 1);

    Polynomial differentPolynomial = new SimplePolynomial();
    differentPolynomial.addTerm(-2, 3);
    assertNotEquals(differentPolynomial, polynomialUnderTest);
  }


  /**
   * Test the equals and hashcode method with an array having same elements the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeOfSimplePolynomialWithArrayHavingSameElements() {
    polynomialUnderTest.addTerm(3, 0);
    polynomialUnderTest.addTerm(2, 1);

    List<Integer> coefficients = new ArrayList<>();
    coefficients.add(3);
    coefficients.add(2);

    assertNotEquals(coefficients, polynomialUnderTest);
    assertNotEquals(coefficients.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method of zero polynomial and polynomial
   * with no elements are equal.
   */
  @Test
  public void testZeroPolynomialIsEqualToPolynomialWithNoElements() {
    polynomialUnderTest.addTerm(0, 0);
    polynomialUnderTest.addTerm(0, 3);
    Polynomial zeroPolynomial = new SimplePolynomial();
    assertEquals(zeroPolynomial, polynomialUnderTest);
    assertEquals(zeroPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }


}
