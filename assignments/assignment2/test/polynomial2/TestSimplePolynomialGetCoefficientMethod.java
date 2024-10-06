package polynomial2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Class to test the cases for get coefficient method in SimplePolynomial.
 */
public class TestSimplePolynomialGetCoefficientMethod {
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
   * Test the getCoefficient method with no elements in the polynomial.
   */
  @Test
  public void testGetCoefficientWithNoElements() {
    assertEquals(0, polynomialUnderTest.getCoefficient(0));
    assertEquals(0, polynomialUnderTest.getCoefficient(1));
  }

  /**
   * Test the getCoefficient method with one positive element in the polynomial.
   */
  @Test
  public void testGetCoefficientWithPositiveElement() {
    polynomialUnderTest.addTerm(2, 3);
    assertEquals(2, polynomialUnderTest.getCoefficient(3));
    assertEquals(0, polynomialUnderTest.getCoefficient(1));
  }

  /**
   * Test the getCoefficient method with one negative element in the polynomial.
   */
  @Test
  public void testGetCoefficientWithNegativeElement() {
    polynomialUnderTest.addTerm(-2, 3);
    assertEquals(-2, polynomialUnderTest.getCoefficient(3));
  }

  /**
   * Test the getCoefficient method with multiple elements in the polynomial.
   */
  @Test
  public void testGetCoefficientWithMultipleElements() {
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(2, 3);
    polynomialUnderTest.addTerm(2, 0);
    assertEquals(2, polynomialUnderTest.getCoefficient(3));
    assertEquals(-2, polynomialUnderTest.getCoefficient(1));
    assertEquals(2, polynomialUnderTest.getCoefficient(0));
    assertEquals(0, polynomialUnderTest.getCoefficient(4));
  }

  /**
   * Test the getCoefficient method by passing negative power.
   */
  @Test
  public void testGetCoefficientWithNegativePower() {
    polynomialUnderTest.addTerm(2, 3);
    assertEquals(0, polynomialUnderTest.getCoefficient(-3));
  }

  /**
   * Test the getCoefficient method by passing greater than degree.
   */
  @Test
  public void testGetCoefficientWithGreaterThanDegree() {
    polynomialUnderTest.addTerm(2, 3);
    assertEquals(0, polynomialUnderTest.getCoefficient(4));
  }

}
