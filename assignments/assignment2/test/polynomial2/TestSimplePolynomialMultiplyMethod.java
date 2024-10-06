package polynomial2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to test the cases for multiple method in SimplePolynomial.
 */
public class TestSimplePolynomialMultiplyMethod {

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
   * Test the multiply method with same degree all elements present in the polynomial.
   */
  @Test
  public void testMultiplicationWithSameDegreeWithAllCoefficientsPresent() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();
    anotherPolynomialToMultiply.addTerm(2, 2);
    anotherPolynomialToMultiply.addTerm(1, 1);
    anotherPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(6, 4);
    expectedResult.addTerm(-1, 3);
    expectedResult.addTerm(17, 2);
    expectedResult.addTerm(-1, 1);
    expectedResult.addTerm(15, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("6x^4-1x^3+17x^2-1x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^2+1x^1+3", anotherPolynomialToMultiply.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToMultiply, actualResult);
  }

  /**
   * Test the multiply method with same degree with few coefficients missing in one polynomial.
   */
  @Test
  public void testMultiplicationWithSameDegreeWithFewCoefficientsMissingInOnePolynomial() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();
    anotherPolynomialToMultiply.addTerm(2, 2);
    anotherPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(6, 4);
    expectedResult.addTerm(-4, 3);
    expectedResult.addTerm(19, 2);
    expectedResult.addTerm(-6, 1);
    expectedResult.addTerm(15, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("6x^4-4x^3+19x^2-6x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^2+3", anotherPolynomialToMultiply.toString());
    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToMultiply, actualResult);
  }

  /**
   * Test the multiplication of two zero polynomials.
   */
  @Test
  public void testMultiplicationOfTwoZeroPolynomials() {

    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    Polynomial expectedResult = new SimplePolynomial();
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());
  }

  /**
   * Test the multiplication with zero polynomials.
   */
  @Test
  public void testMultiplicationWithZeroPolynomials() {

    polynomialUnderTest.addTerm(2, 2);
    polynomialUnderTest.addTerm(-1, 0);
    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    Polynomial expectedResult = new SimplePolynomial();
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("2x^2-1", polynomialUnderTest.toString());
    assertEquals("0", anotherPolynomialToMultiply.toString());
  }

  /**
   * Test the multiplication to zero polynomials.
   */
  @Test
  public void testMultiplicationToZeroPolynomials() {

    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();
    anotherPolynomialToMultiply.addTerm(2, 2);
    anotherPolynomialToMultiply.addTerm(-1, 0);

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    Polynomial expectedResult = new SimplePolynomial();
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("0", polynomialUnderTest.toString());
    assertEquals("2x^2-1", anotherPolynomialToMultiply.toString());
  }

  /**
   * Test the multiply method with different degree in the polynomial.
   */
  @Test
  public void testMultiplicationWithDifferentDegree() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();
    anotherPolynomialToMultiply.addTerm(2, 5);
    anotherPolynomialToMultiply.addTerm(2, 2);
    anotherPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    assertEquals("6x^7-4x^6+10x^5+6x^4-4x^3+19x^2-6x^1+15", actualResult.toString());
    assertEquals(7, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^5+2x^2+3", anotherPolynomialToMultiply.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToMultiply, actualResult);
  }


  /**
   * Test the multiply method with all positive coefficient.
   */
  @Test
  public void testMultiplicationOfAllPositiveCoefficients() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();
    anotherPolynomialToMultiply.addTerm(2, 2);
    anotherPolynomialToMultiply.addTerm(2, 1);
    anotherPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    assertEquals("6x^4+10x^3+23x^2+16x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2+2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^2+2x^1+3", anotherPolynomialToMultiply.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToMultiply, actualResult);
  }

  /**
   * Test the multiplication method with all negative coefficient.
   */
  @Test
  public void testMultiplicationOfAllNegativeCoefficients() {
    polynomialUnderTest.addTerm(-3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(-5, 0);

    Polynomial anotherPolynomialToMultiply = new SimplePolynomial();
    anotherPolynomialToMultiply.addTerm(-2, 2);
    anotherPolynomialToMultiply.addTerm(-2, 1);
    anotherPolynomialToMultiply.addTerm(-3, 0);

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToMultiply);

    assertEquals("6x^4+10x^3+23x^2+16x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("-3x^2-2x^1-5", polynomialUnderTest.toString());
    assertEquals("-2x^2-2x^1-3", anotherPolynomialToMultiply.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToMultiply, actualResult);
  }


  /**
   * Test the multiply method multiple times.
   */
  @Test
  public void testMultipleMultiplications() {

    Polynomial firstPolynomialToMultiply = new SimplePolynomial();
    firstPolynomialToMultiply.addTerm(2, 3);
    firstPolynomialToMultiply.addTerm(1, 2);
    firstPolynomialToMultiply.addTerm(2, 0);

    Polynomial secondPolynomialToMultiply = new SimplePolynomial();
    secondPolynomialToMultiply.addTerm(-1, 3);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(10, 0);

    Polynomial thirdPolynomialToMultiply = new SimplePolynomial();
    thirdPolynomialToMultiply.addTerm(2, 3);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply)
            .multiply(thirdPolynomialToMultiply);
    assertEquals("-4x^9+6x^8+4x^7+36x^6+28x^5+40x^3", actualResult.toString());
    assertEquals(9, actualResult.getDegree());

  }

  /**
   * Tests to verify is multiplication is associative.
   */
  @Test
  public void testIfMultiplicationIsAssociative() {

    Polynomial firstPolynomialToMultiply = new SimplePolynomial();
    firstPolynomialToMultiply.addTerm(2, 3);
    firstPolynomialToMultiply.addTerm(1, 2);
    firstPolynomialToMultiply.addTerm(2, 0);

    Polynomial secondPolynomialToMultiply = new SimplePolynomial();
    secondPolynomialToMultiply.addTerm(-1, 3);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(10, 0);

    Polynomial thirdPolynomialToMultiply = new SimplePolynomial();
    thirdPolynomialToMultiply.addTerm(2, 3);

    Polynomial firstResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply)
            .multiply(thirdPolynomialToMultiply);

    Polynomial secondResult = secondPolynomialToMultiply.multiply(firstPolynomialToMultiply)
            .multiply(thirdPolynomialToMultiply);

    assertEquals(firstResult, secondResult);

    assertEquals("-4x^9+6x^8+4x^7+36x^6+28x^5+40x^3", firstResult.toString());
    assertEquals(9, firstResult.getDegree());
    assertEquals("-4x^9+6x^8+4x^7+36x^6+28x^5+40x^3", secondResult.toString());
    assertEquals(9, secondResult.getDegree());

  }


  /**
   * Test the addition,multiplication and derivative called once.
   */
  @Test
  public void testAllMethodsCalledOnce() {
    polynomialUnderTest.addTerm(-3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(-5, 0);


    Polynomial anotherPolynomialToDoOperations = new SimplePolynomial();
    anotherPolynomialToDoOperations.addTerm(2, 3);
    anotherPolynomialToDoOperations.addTerm(1, 2);
    anotherPolynomialToDoOperations.addTerm(2, 0);

    Polynomial actualResult = polynomialUnderTest.multiply(anotherPolynomialToDoOperations)
            .add(anotherPolynomialToDoOperations).derivative();

    assertEquals("-30x^4-28x^3-30x^2-20x^1-4", actualResult.toString());
    assertEquals(4, actualResult.getDegree());
  }
}
