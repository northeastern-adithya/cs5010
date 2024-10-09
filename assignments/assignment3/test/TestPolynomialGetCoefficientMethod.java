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
 * Class to test the cases for getCoefficient method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialGetCoefficientMethod {

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
  public TestPolynomialGetCoefficientMethod(Class<? extends Polynomial> polynomialClass) {
    this.polynomialClass = polynomialClass;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Get Coefficient Tests For: {0}")
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
