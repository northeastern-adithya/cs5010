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
 * Class to test the cases for evaluate method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialEvaluateMethod {

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
  public TestPolynomialEvaluateMethod(Class<? extends Polynomial> polynomialClass) {
    this.polynomialClass = polynomialClass;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Evaluate Tests For: {0}")
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
   * Test the evaluate method with positive integer value.
   */
  @Test
  public void testEvaluateAPositiveValue() {
    polynomialUnderTest.addTerm(2, 4);
    polynomialUnderTest.addTerm(-1, 2);
    polynomialUnderTest.addTerm(9, 1);
    polynomialUnderTest.addTerm(-2, 0);
    assertEquals(44, polynomialUnderTest.evaluate(2), 0.0);
  }

  /**
   * Test the evaluate method with negative integer value.
   */
  @Test
  public void testEvaluateANegativeValue() {
    polynomialUnderTest.addTerm(2, 4);
    polynomialUnderTest.addTerm(-1, 2);
    polynomialUnderTest.addTerm(9, 1);
    polynomialUnderTest.addTerm(-2, 0);
    assertEquals(8, polynomialUnderTest.evaluate(-2), 0.0);
  }

  /**
   * Test the evaluate method with zero.
   */
  @Test
  public void testEvaluateZero() {
    polynomialUnderTest.addTerm(2, 4);
    polynomialUnderTest.addTerm(-1, 2);
    polynomialUnderTest.addTerm(9, 1);
    polynomialUnderTest.addTerm(-2, 0);
    assertEquals(-2, polynomialUnderTest.evaluate(0), 0.0);
  }

  /**
   * Test the evaluate method with zero coefficient in polynomial.
   */
  @Test
  public void testEvaluateWithZeroCoefficients() {
    polynomialUnderTest.addTerm(0, 4);
    polynomialUnderTest.addTerm(0, 2);
    polynomialUnderTest.addTerm(0, 1);
    polynomialUnderTest.addTerm(0, 0);
    assertEquals(0, polynomialUnderTest.evaluate(2), 0.0);
  }

  /**
   * Test the evaluate method with positive decimal value.
   */
  @Test
  public void testEvaluateWithPositiveDecimalValue() {
    polynomialUnderTest.addTerm(2, 4);
    polynomialUnderTest.addTerm(-1, 2);
    polynomialUnderTest.addTerm(9, 1);
    polynomialUnderTest.addTerm(-2, 0);
    assertEquals(92.375, polynomialUnderTest.evaluate(2.5), 0.0);
  }

  /**
   * Test the evaluate method with negative decimal value.
   */
  @Test
  public void evaluateWithNegativeDecimalValue() {
    polynomialUnderTest.addTerm(2, 4);
    polynomialUnderTest.addTerm(-1, 2);
    polynomialUnderTest.addTerm(9, 1);
    polynomialUnderTest.addTerm(-2, 0);
    assertEquals(47.375, polynomialUnderTest.evaluate(-2.5), 0.0);
  }


}
