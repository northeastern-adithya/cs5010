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
 * Class to test the cases for toString method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialToStringMethod {

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
  public TestPolynomialToStringMethod(Class<? extends Polynomial> polynomialClass) {
    this.polynomialClass = polynomialClass;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "To String Tests For: {0}")
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
   * Test the toString method with no elements in the polynomial.
   */
  @Test
  public void testToStringWithNoElements() {
    assertEquals("0", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with negative coefficient in the beginning.
   */
  @Test
  public void testToStringWithNegativeCoefficientInTheBeginning() {
    polynomialUnderTest.addTerm(-3, 6);
    polynomialUnderTest.addTerm(2, 2);
    polynomialUnderTest.addTerm(-1, 3);
    polynomialUnderTest.addTerm(5, 0);

    assertEquals("-3x^6-1x^3+2x^2+5", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with positive coefficient in the beginning.
   */
  @Test
  public void testToStringWithPositiveCoefficientInTheBeginning() {
    polynomialUnderTest.addTerm(3, 6);
    polynomialUnderTest.addTerm(-2, 2);
    polynomialUnderTest.addTerm(1, 3);
    polynomialUnderTest.addTerm(5, 0);

    assertEquals("3x^6+1x^3-2x^2+5", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with zero coefficient in middle.
   */
  @Test
  public void testToStringWithZeroCoefficientInTheMiddle() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(0, 1);
    polynomialUnderTest.addTerm(-2, 0);

    assertEquals("3x^2-2", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with all positive coefficients.
   */
  @Test
  public void testToStringWithAllPositiveCoefficients() {
    polynomialUnderTest.addTerm(3, 6);
    polynomialUnderTest.addTerm(2, 2);
    polynomialUnderTest.addTerm(1, 3);
    polynomialUnderTest.addTerm(5, 0);

    assertEquals("3x^6+1x^3+2x^2+5", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with all negative coefficients.
   */
  @Test
  public void testToStringWithAllNegativeCoefficients() {
    polynomialUnderTest.addTerm(-3, 6);
    polynomialUnderTest.addTerm(-2, 2);
    polynomialUnderTest.addTerm(-1, 3);
    polynomialUnderTest.addTerm(-5, 0);

    assertEquals("-3x^6-1x^3-2x^2-5", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with positive constant.
   */
  @Test
  public void testToStringWithPositiveConstant() {
    polynomialUnderTest.addTerm(5, 0);
    assertEquals("5", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with negative constant.
   */
  @Test
  public void testToStringWithNegativeConstant() {
    polynomialUnderTest.addTerm(-5, 0);
    assertEquals("-5", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with positive coefficient.
   */
  @Test
  public void testToStringWithPositiveCoefficient() {
    polynomialUnderTest.addTerm(3, 6);

    assertEquals("3x^6", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method with negative coefficient.
   */
  @Test
  public void testToStringWithNegativeCoefficient() {
    polynomialUnderTest.addTerm(-3, 6);

    assertEquals("-3x^6", polynomialUnderTest.toString());
  }

  /**
   * Test the toString method prints in descending order.
   */
  @Test
  public void testToStringPrintsInDescendingOrder() {
    polynomialUnderTest.addTerm(3, 6);
    polynomialUnderTest.addTerm(2, 2);
    polynomialUnderTest.addTerm(1, 3);
    polynomialUnderTest.addTerm(5, 0);
    assertEquals("3x^6+1x^3+2x^2+5", polynomialUnderTest.toString());
  }


}
