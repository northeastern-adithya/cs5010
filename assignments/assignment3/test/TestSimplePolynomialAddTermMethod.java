import org.junit.Before;
import org.junit.Test;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Class to test the cases for addTerm method in SimplePolynomial.
 */
public class TestSimplePolynomialAddTermMethod {
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
   * Test the addTerm method with negative power.
   */
  @Test
  public void testWithNegativePower() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> polynomialUnderTest.addTerm(3, -2));
    assertEquals("Power cannot be negative. Received: -2", exception.getMessage());
  }

  /**
   * Test the addTerm method where coefficient is added to same power.
   */
  @Test
  public void testAddTermToSamePlaceTwice() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 2);

    Polynomial expectedPolynomial = new SimplePolynomial();
    expectedPolynomial.addTerm(1, 2);

    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals("1x^2", polynomialUnderTest.toString());
  }

  /**
   * Test the addTerm method with zero coefficient.
   */
  @Test
  public void testAddTermWithZeroCoefficient() {
    polynomialUnderTest.addTerm(0, 2);

    Polynomial expectedPolynomial = new SimplePolynomial();

    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals("0", polynomialUnderTest.toString());


    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(0, 1);

    expectedPolynomial = new SimplePolynomial();
    expectedPolynomial.addTerm(3, 2);

    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals("3x^2", polynomialUnderTest.toString());
  }


  /**
   * Test the addTerm method where same coefficient
   * with different sign is added.
   */
  @Test
  public void testAddSameCoefficientWithDifferentSignTwice() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-3, 2);

    Polynomial expectedPolynomial = new SimplePolynomial();
    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals("0", polynomialUnderTest.toString());
  }


  /**
   * Test the addTerm method with positive coefficient.
   */
  @Test
  public void testAddPositiveTerm() {
    polynomialUnderTest.addTerm(3, 2);
    assertEquals("3x^2", polynomialUnderTest.toString());
  }

  /**
   * Test the addTerm method with negative coefficient.
   */
  @Test
  public void testAddNegativeTerm() {
    polynomialUnderTest.addTerm(-3, 2);
    assertEquals("-3x^2", polynomialUnderTest.toString());
  }

  /**
   * Test the addTerm method with multiple terms.
   */
  @Test
  public void testMultipleTerms() {
    polynomialUnderTest.addTerm(-3, 2);
    polynomialUnderTest.addTerm(5, 6);
    polynomialUnderTest.addTerm(3, 4);
    polynomialUnderTest.addTerm(1, 0);
    assertEquals("5x^6+3x^4-3x^2+1", polynomialUnderTest.toString());
  }

  /**
   * Test the addTerm method by removing the highest power
   * and verifying if the degree is changed.
   */
  @Test
  public void testRemoveHighestPowerWithAddTerm() {
    polynomialUnderTest.addTerm(-3, 2);
    polynomialUnderTest.addTerm(5, 6);
    polynomialUnderTest.addTerm(3, 4);
    polynomialUnderTest.addTerm(1, 0);
    assertEquals("5x^6+3x^4-3x^2+1", polynomialUnderTest.toString());
    assertEquals(6, polynomialUnderTest.getDegree());

    polynomialUnderTest.addTerm(-5, 6);
    assertEquals("3x^4-3x^2+1", polynomialUnderTest.toString());
    assertEquals(4, polynomialUnderTest.getDegree());
  }

}
