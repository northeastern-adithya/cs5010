package polynomial2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class to test the cases for getDegree method in SimplePolynomial.
 */
public class TestSimplePolynomialGetDegreeMethod {
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
