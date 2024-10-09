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
 * Class to test the cases for getDegree method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialGetDegreeMethod {

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
  public TestPolynomialGetDegreeMethod(Class<? extends Polynomial> polynomialClass) {
    this.polynomialClass = polynomialClass;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Get Degree Tests For: {0}")
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
   * Test the getDegree method where coefficient is added to same power.
   */
  @Test
  public void testAddTermToSamePlaceTwice() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 2);

    assertEquals(2, polynomialUnderTest.getDegree());
  }

  /**
   * Test the getDegree method with zero coefficient.
   */
  @Test
  public void testWithZeroCoefficient() {
    polynomialUnderTest.addTerm(0, 2);
    assertEquals(0, polynomialUnderTest.getDegree());


    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(0, 1);
    assertEquals(2, polynomialUnderTest.getDegree());
  }


  /**
   * Test the getDegree method where same coefficient
   * with different sign is added.
   */
  @Test
  public void testAddSameCoefficientWithDifferentSignTwice() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-3, 2);
    assertEquals(0, polynomialUnderTest.getDegree());
  }


  /**
   * Test the getDegree method with positive coefficient.
   */
  @Test
  public void testAddPositiveTerm() {
    polynomialUnderTest.addTerm(3, 2);
    assertEquals(2, polynomialUnderTest.getDegree());
  }

  /**
   * Test the getDegree method with negative coefficient.
   */
  @Test
  public void testAddNegativeTerm() {
    polynomialUnderTest.addTerm(-3, 2);
    assertEquals(2, polynomialUnderTest.getDegree());
  }

  /**
   * Test the getDegree method with multiple terms.
   */
  @Test
  public void testMultipleTerms() {
    polynomialUnderTest.addTerm(-3, 2);
    polynomialUnderTest.addTerm(5, 6);
    polynomialUnderTest.addTerm(3, 4);
    polynomialUnderTest.addTerm(1, 0);
    assertEquals(6, polynomialUnderTest.getDegree());
  }

  /**
   * Test the getDegree method by removing the highest power
   * and verifying if the degree is changed.
   */
  @Test
  public void testRemoveHighestPower() {
    polynomialUnderTest.addTerm(-3, 2);
    polynomialUnderTest.addTerm(5, 6);
    polynomialUnderTest.addTerm(3, 4);
    polynomialUnderTest.addTerm(1, 0);
    assertEquals(6, polynomialUnderTest.getDegree());

    polynomialUnderTest.addTerm(-5, 6);
    assertEquals(4, polynomialUnderTest.getDegree());
  }

}
