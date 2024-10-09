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
import static org.junit.Assert.assertThrows;

/**
 * Class to test the cases for addTerm method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialAddTermMethod {

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
  public TestPolynomialAddTermMethod(Class<? extends Polynomial> polynomialClass) {
    this.polynomialClass = polynomialClass;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Add Term Tests For: {0}")
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

    Polynomial expectedPolynomial = TestUtils.createPolynomial(polynomialClass);
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

    Polynomial expectedPolynomial = TestUtils.createPolynomial(polynomialClass);

    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals("0", polynomialUnderTest.toString());


    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(0, 1);

    expectedPolynomial = TestUtils.createPolynomial(polynomialClass);
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

    Polynomial expectedPolynomial = TestUtils.createPolynomial(polynomialClass);
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
