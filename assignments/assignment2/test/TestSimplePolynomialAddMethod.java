import org.junit.Before;
import org.junit.Test;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Class to test the cases for add method in SimplePolynomial.
 */
public class TestSimplePolynomialAddMethod {
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
   * Test the add method with same degree all elements present in the polynomial.
   */
  @Test
  public void testAdditionWithSameDegreeWithAllCoefficientsPresent() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(2, 2);
    anotherPolynomialToAdd.addTerm(1, 1);
    anotherPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(-1, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("5x^2-1x^1+8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^2+1x^1+3", anotherPolynomialToAdd.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToAdd, actualResult);
  }

  /**
   * Test the add method with same degree with few coefficients missing in one polynomial.
   */
  @Test
  public void testAdditionWithSameDegreeWithFewCoefficientsMissingInOnePolynomial() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(2, 2);
    anotherPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(-2, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("5x^2-2x^1+8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^2+3", anotherPolynomialToAdd.toString());
    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToAdd, actualResult);
  }

  /**
   * Test the addition of two zero polynomials.
   */
  @Test
  public void testAdditionOfTwoZeroPolynomials() {

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());
  }

  /**
   * Test the addition with zero polynomials.
   */
  @Test
  public void testAdditionWithZeroPolynomials() {

    polynomialUnderTest.addTerm(2, 2);
    polynomialUnderTest.addTerm(-1, 0);
    Polynomial anotherPolynomialToAdd = new SimplePolynomial();

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(2, 2);
    expectedResult.addTerm(-1, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("2x^2-1", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("2x^2-1", polynomialUnderTest.toString());
    assertEquals("0", anotherPolynomialToAdd.toString());
  }

  /**
   * Test the addition to zero polynomials.
   */
  @Test
  public void testAdditionToZeroPolynomials() {

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(2, 2);
    anotherPolynomialToAdd.addTerm(-1, 0);

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(2, 2);
    expectedResult.addTerm(-1, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("2x^2-1", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("0", polynomialUnderTest.toString());
    assertEquals("2x^2-1", anotherPolynomialToAdd.toString());
  }

  /**
   * Test the add method with different degree in the polynomial.
   */
  @Test
  public void testAdditionWithDifferentDegree() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(2, 5);
    anotherPolynomialToAdd.addTerm(2, 2);
    anotherPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(2, 5);
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(-2, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("2x^5+5x^2-2x^1+8", actualResult.toString());
    assertEquals(5, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^5+2x^2+3", anotherPolynomialToAdd.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToAdd, actualResult);
  }


  /**
   * Test the add method with all positive coefficient.
   */
  @Test
  public void testAdditionWithAdditionOfAllPositiveCoefficients() {
    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(2, 1);
    polynomialUnderTest.addTerm(5, 0);

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(2, 2);
    anotherPolynomialToAdd.addTerm(2, 1);
    anotherPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(4, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("5x^2+4x^1+8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2+2x^1+5", polynomialUnderTest.toString());
    assertEquals("2x^2+2x^1+3", anotherPolynomialToAdd.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToAdd, actualResult);
  }

  /**
   * Test the add method with all negative coefficient.
   */
  @Test
  public void testAdditionWithAdditionOfAllNegativeCoefficients() {
    polynomialUnderTest.addTerm(-3, 2);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(-5, 0);

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(-2, 2);
    anotherPolynomialToAdd.addTerm(-2, 1);
    anotherPolynomialToAdd.addTerm(-3, 0);

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(-5, 2);
    expectedResult.addTerm(-4, 1);
    expectedResult.addTerm(-8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("-5x^2-4x^1-8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("-3x^2-2x^1-5", polynomialUnderTest.toString());
    assertEquals("-2x^2-2x^1-3", anotherPolynomialToAdd.toString());

    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToAdd, actualResult);
  }


  /**
   * Test the add two polynomial to give the output as zero.
   */
  @Test
  public void testAddingTwoPolynomialGivingOutputAsZeroPolynomial() {

    polynomialUnderTest.addTerm(3, 2);
    polynomialUnderTest.addTerm(1, 0);

    Polynomial anotherPolynomialToAdd = new SimplePolynomial();
    anotherPolynomialToAdd.addTerm(-3, 2);
    anotherPolynomialToAdd.addTerm(-1, 0);

    Polynomial actualResult = polynomialUnderTest.add(anotherPolynomialToAdd);
    Polynomial expectedResult = new SimplePolynomial();

    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertNotEquals(polynomialUnderTest, actualResult);
    assertNotEquals(anotherPolynomialToAdd, actualResult);


    // Check if adding it the other way also gives empty result.
    assertEquals(expectedResult, anotherPolynomialToAdd.add(polynomialUnderTest));
    assertEquals("0", actualResult.toString());
  }


  /**
   * Test the add method multiple times.
   */
  @Test
  public void testMultipleAdditions() {

    Polynomial firstPolynomialToAdd = new SimplePolynomial();
    firstPolynomialToAdd.addTerm(2, 3);
    firstPolynomialToAdd.addTerm(1, 2);
    firstPolynomialToAdd.addTerm(2, 0);

    Polynomial secondPolynomialToAdd = new SimplePolynomial();
    secondPolynomialToAdd.addTerm(-1, 3);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(10, 0);

    Polynomial thirdPolynomialToAdd = new SimplePolynomial();
    thirdPolynomialToAdd.addTerm(2, 3);

    Polynomial fourthPolynomialToAdd = new SimplePolynomial();
    fourthPolynomialToAdd.addTerm(-5, 3);
    fourthPolynomialToAdd.addTerm(2, 2);
    fourthPolynomialToAdd.addTerm(-4, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd)
            .add(thirdPolynomialToAdd).add(fourthPolynomialToAdd);

    Polynomial expectedResult = new SimplePolynomial();
    expectedResult.addTerm(-2, 3);
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("-2x^3+5x^2+8", actualResult.toString());
    assertEquals(3, actualResult.getDegree());

  }

  /**
   * Tests to verify is addition is associative.
   */
  @Test
  public void testIfAdditionIsAssociative() {

    Polynomial firstPolynomialToAdd = new SimplePolynomial();
    firstPolynomialToAdd.addTerm(2, 3);
    firstPolynomialToAdd.addTerm(1, 2);
    firstPolynomialToAdd.addTerm(2, 0);

    Polynomial secondPolynomialToAdd = new SimplePolynomial();
    secondPolynomialToAdd.addTerm(-1, 3);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(10, 0);

    Polynomial thirdPolynomialToAdd = new SimplePolynomial();
    thirdPolynomialToAdd.addTerm(2, 3);

    Polynomial fourthPolynomialToAdd = new SimplePolynomial();
    fourthPolynomialToAdd.addTerm(-5, 3);
    fourthPolynomialToAdd.addTerm(2, 2);
    fourthPolynomialToAdd.addTerm(-4, 0);

    Polynomial firstResult = firstPolynomialToAdd.add(secondPolynomialToAdd)
            .add(thirdPolynomialToAdd).add(fourthPolynomialToAdd);
    Polynomial secondResult = secondPolynomialToAdd.add(thirdPolynomialToAdd)
            .add(firstPolynomialToAdd).add(fourthPolynomialToAdd);

    assertEquals(firstResult, secondResult);

    assertEquals("-2x^3+5x^2+8", firstResult.toString());
    assertEquals("-2x^3+5x^2+8", secondResult.toString());
    assertEquals(3, firstResult.getDegree());
    assertEquals(3, secondResult.getDegree());

  }

}
