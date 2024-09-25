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
   * The polynomial under test.
   */
  private Polynomial simplePolynomialUnderTest;

  /**
   * Set up the polynomial under test with the initial object.
   */
  @Before
  public void setUp() {
    simplePolynomialUnderTest = new SimplePolynomial();
  }


  /**
   * Test the equals and hash code method with no elements in the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeWithNoElements() {
    Polynomial expectedPolynomial = new SimplePolynomial();
    assertEquals(expectedPolynomial, simplePolynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), simplePolynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by passing a different class than the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeMethodWithDifferentClasses() {
    simplePolynomialUnderTest.addTerm(2, 3);
    simplePolynomialUnderTest.addTerm(2, 3);

    Integer integerValue = 3;
    assertNotEquals(integerValue, simplePolynomialUnderTest);
    assertNotEquals(integerValue.hashCode(), simplePolynomialUnderTest.hashCode());
  }


  /**
   * Test the equals and hashcode method by creating a new polynomial with same coefficients
   * starting with a positive term.
   */
  @Test
  public void testEqualsAndHashCodeMethodWithPositiveStartingTerm() {
    simplePolynomialUnderTest.addTerm(2, 3);
    simplePolynomialUnderTest.addTerm(-2, 1);
    simplePolynomialUnderTest.addTerm(2, 0);

    Polynomial expectedPolynomial = new SimplePolynomial();
    expectedPolynomial.addTerm(2, 3);
    expectedPolynomial.addTerm(-2, 1);
    expectedPolynomial.addTerm(2, 0);

    assertEquals(expectedPolynomial, simplePolynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), simplePolynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with same coefficients
   * starting with a negative term.
   */
  @Test
  public void testEqualsMethodWithNegativeStartingTerm() {
    simplePolynomialUnderTest.addTerm(-2, 3);
    simplePolynomialUnderTest.addTerm(2, 1);
    simplePolynomialUnderTest.addTerm(2, 0);

    Polynomial expectedPolynomial = new SimplePolynomial();
    expectedPolynomial.addTerm(-2, 3);
    expectedPolynomial.addTerm(2, 1);
    expectedPolynomial.addTerm(2, 0);
    assertEquals(expectedPolynomial, simplePolynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), simplePolynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with different coefficients
   * starting with a positive term.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentElementsStartingWithPositiveTerm() {
    simplePolynomialUnderTest.addTerm(2, 3);
    simplePolynomialUnderTest.addTerm(-2, 1);

    Polynomial differentPolynomial = new SimplePolynomial();
    differentPolynomial.addTerm(2, 3);
    assertNotEquals(differentPolynomial, simplePolynomialUnderTest);
    assertNotEquals(differentPolynomial.hashCode(), simplePolynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method with polynomial having
   * non-zero and zero elements.
   */
  @Test
  public void testEqualsAndHashCodeWithNonZeroAndZeroElements() {
    simplePolynomialUnderTest.addTerm(-2, 3);
    simplePolynomialUnderTest.addTerm(-2, 1);

    Polynomial differentPolynomial = new SimplePolynomial();
    assertNotEquals(differentPolynomial, simplePolynomialUnderTest);
    assertNotEquals(differentPolynomial.hashCode(), simplePolynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with different coefficients
   * starting with a negative term.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentElementsStartingWithNegativeTerm() {
    simplePolynomialUnderTest.addTerm(-2, 3);
    simplePolynomialUnderTest.addTerm(2, 1);

    Polynomial differentPolynomial = new SimplePolynomial();
    differentPolynomial.addTerm(-2, 3);
    assertNotEquals(differentPolynomial, simplePolynomialUnderTest);
  }


  /**
   * Test the equals and hashcode method with an array having same elements the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeOfSimplePolynomialWithArrayHavingSameElements() {
    simplePolynomialUnderTest.addTerm(3, 0);
    simplePolynomialUnderTest.addTerm(2, 1);

    List<Integer> coefficients = new ArrayList<>();
    coefficients.add(3);
    coefficients.add(2);

    assertNotEquals(coefficients, simplePolynomialUnderTest);
    assertNotEquals(coefficients.hashCode(), simplePolynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method of zero polynomial and polynomial
   * with no elements are equal.
   */
  @Test
  public void testZeroPolynomialIsEqualToPolynomialWithNoElements() {
    simplePolynomialUnderTest.addTerm(0, 0);
    simplePolynomialUnderTest.addTerm(0, 3);
    Polynomial zeroPolynomial = new SimplePolynomial();
    assertEquals(zeroPolynomial, simplePolynomialUnderTest);
    assertEquals(zeroPolynomial.hashCode(), simplePolynomialUnderTest.hashCode());
  }


}
