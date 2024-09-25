import org.junit.Before;
import org.junit.Test;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;

import static org.junit.Assert.assertEquals;


/**
 * Class to test the cases for derivative method in SimplePolynomial.
 */
public class TestSimplePolynomialDerivativeMethod {

  private Polynomial simplePolynomialUnderTest;

  /**
   * Set up the polynomial under test with the initial object.
   */
  @Before
  public void setUp() {
    simplePolynomialUnderTest = new SimplePolynomial();
  }


  /**
   * Test the derivative method with all positive coefficients.
   */
  @Test
  public void testDerivativeOfAllPositiveCoefficients() {
    simplePolynomialUnderTest.addTerm(3, 6);
    simplePolynomialUnderTest.addTerm(2, 4);
    simplePolynomialUnderTest.addTerm(1, 3);
    simplePolynomialUnderTest.addTerm(5, 0);

    Polynomial actualResult = simplePolynomialUnderTest.derivative();

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(18, 5);
    expectedResult.addTerm(8, 3);
    expectedResult.addTerm(3, 2);

    assertEquals(expectedResult, actualResult);
    assertEquals("18x^5+8x^3+3x^2", actualResult.toString());
  }


  /**
   * Test the derivative method with all negative coefficients.
   */
  @Test
  public void testDerivativeOfAllNegativeCoefficients() {
    simplePolynomialUnderTest.addTerm(-3, 6);
    simplePolynomialUnderTest.addTerm(-2, 4);
    simplePolynomialUnderTest.addTerm(-1, 3);
    simplePolynomialUnderTest.addTerm(-5, 0);

    Polynomial actualResult = simplePolynomialUnderTest.derivative();

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(-18, 5);
    expectedResult.addTerm(-8, 3);
    expectedResult.addTerm(-3, 2);

    assertEquals(expectedResult, actualResult);
    assertEquals("-18x^5-8x^3-3x^2", actualResult.toString());
  }


  /**
   * Test the derivative method with positive and negative coefficients.
   */
  @Test
  public void testDerivativeOfBothPositiveAndNegativeCoefficients() {
    simplePolynomialUnderTest.addTerm(-3, 6);
    simplePolynomialUnderTest.addTerm(2, 4);
    simplePolynomialUnderTest.addTerm(1, 3);
    simplePolynomialUnderTest.addTerm(-5, 0);

    Polynomial actualResult = simplePolynomialUnderTest.derivative();

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(-18, 5);
    expectedResult.addTerm(8, 3);
    expectedResult.addTerm(3, 2);

    assertEquals(expectedResult, actualResult);
    assertEquals("-18x^5+8x^3+3x^2", actualResult.toString());
  }

  /**
   * Test the derivative method with just constant.
   */
  @Test
  public void testDerivativeWithConstant() {
    simplePolynomialUnderTest.addTerm(2, 0);
    Polynomial actualResult = simplePolynomialUnderTest.derivative();

    Polynomial expectedResult = new SimplePolynomial();
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
  }

  /**
   * Test the derivative method with zero polynomial.
   */
  @Test
  public void testDerivativeWithZeroPolynomial() {
    Polynomial actualResult = simplePolynomialUnderTest.derivative();
    Polynomial expectedResult = new SimplePolynomial();
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
  }

  /**
   * Test the derivative method called multiple times.
   */
  @Test
  public void testDerivativeCalledMultipleTimes() {
    simplePolynomialUnderTest.addTerm(3, 2);
    simplePolynomialUnderTest.addTerm(2, 1);
    simplePolynomialUnderTest.addTerm(1, 0);

    Polynomial actualResult = simplePolynomialUnderTest.derivative().derivative().derivative();

    Polynomial expectedResult = new SimplePolynomial();

    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
  }
}
