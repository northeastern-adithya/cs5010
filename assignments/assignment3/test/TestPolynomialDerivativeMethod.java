import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;
import polynomial.SparsePolynomial;

import static org.junit.Assert.assertEquals;


/**
 * Class to test the cases for derivative method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialDerivativeMethod {

  /**
   * The class of the polynomial to be tested.
   */
  private final Class<? extends Polynomial> polynomialClass;
  /**
   * The polynomial object to be tested.
   */
  private Polynomial polynomialUnderTest;

  /**
   * Constructor for parameterized to instantiate the class.
   *
   * @param polynomialClass – the class of the polynomial to be tested.
   */
  public TestPolynomialDerivativeMethod(Class<? extends Polynomial> polynomialClass) {
    this.polynomialClass = polynomialClass;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Derivative Tests For: {0}")
  public static Collection<Object[]> polynomialImplementations() {
    return Arrays.asList(new Object[][]{
            {SimplePolynomial.class},
            {SparsePolynomial.class}
    });
  }

  /**
   * Set up the polynomial under test with no elements.
   */
  @Before
  public void setUp() {
    polynomialUnderTest = TestUtils.createPolynomial(polynomialClass);
  }

  /**
   * Test the derivative method with all positive coefficients.
   */
  @Test
  public void testDerivativeOfAllPositiveCoefficients() {
    polynomialUnderTest.addTerm(3, 6);
    polynomialUnderTest.addTerm(2, 4);
    polynomialUnderTest.addTerm(1, 3);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial actualResult = polynomialUnderTest.derivative();

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClass);
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
    polynomialUnderTest.addTerm(-3, 6);
    polynomialUnderTest.addTerm(-2, 4);
    polynomialUnderTest.addTerm(-1, 3);
    polynomialUnderTest.addTerm(-5, 0);

    Polynomial actualResult = polynomialUnderTest.derivative();

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClass);
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
    polynomialUnderTest.addTerm(-3, 6);
    polynomialUnderTest.addTerm(2, 4);
    polynomialUnderTest.addTerm(1, 3);
    polynomialUnderTest.addTerm(-5, 0);

    Polynomial actualResult = polynomialUnderTest.derivative();

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClass);
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
    polynomialUnderTest.addTerm(2, 0);
    Polynomial actualResult = polynomialUnderTest.derivative();

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClass);
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
  }

  /**
   * Test the derivative method with zero polynomial.
   */
  @Test
  public void testDerivativeWithZeroPolynomial() {
    Polynomial actualResult = polynomialUnderTest.derivative();
    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClass);
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
  }

  /**
   * Test the derivative method called multiple times.
   */
  @Test
  public void testDerivativeCalledMultipleTimes() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(2, 1);
    polynomialUnderTest.addTerm(1, 0);

    Polynomial actualResult = polynomialUnderTest.derivative().derivative().derivative();

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClass);

    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
  }
}
