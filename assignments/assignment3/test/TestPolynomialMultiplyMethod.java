import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;
import polynomial.SparsePolynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to test the cases for multiply method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialMultiplyMethod {

  /**
   * The class of the polynomial of first type to be tested.
   */
  private final Class<? extends Polynomial> polynomialClassOfFirstType;

  /**
   * The class of the polynomial of second type to be tested.
   */
  private final Class<? extends Polynomial> polynomialClassOfSecondType;

  /**
   * Constructor for parameterized to instantiate the class.
   *
   * @param polynomialClassOfFirstType – the class of the polynomial to be tested.
   */
  public TestPolynomialMultiplyMethod(Class<? extends Polynomial> polynomialClassOfFirstType,
                                      Class<? extends Polynomial> polynomialClassOfSecondType) {
    this.polynomialClassOfFirstType = polynomialClassOfFirstType;
    this.polynomialClassOfSecondType = polynomialClassOfSecondType;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Multiplication Test For Combination: {0} + {1}")
  public static Collection<Object[]> polynomialImplementations() {
    return Arrays.asList(new Object[][]{
            {SimplePolynomial.class, SimplePolynomial.class},
            {SparsePolynomial.class, SparsePolynomial.class},
            {SimplePolynomial.class, SparsePolynomial.class},
            {SparsePolynomial.class, SimplePolynomial.class}
    });
  }

  /**
   * Test the multiply method with same degree all elements present in the polynomial.
   */
  @Test
  public void testMultiplicationWithSameDegreeWithAllCoefficientsPresent() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(3, 2);
    firstPolynomialToMultiply.addTerm(-2, 1);
    firstPolynomialToMultiply.addTerm(5, 0);

    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(1, 1);
    secondPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(6, 4);
    expectedResult.addTerm(-1, 3);
    expectedResult.addTerm(17, 2);
    expectedResult.addTerm(-1, 1);
    expectedResult.addTerm(15, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("6x^4-1x^3+17x^2-1x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", firstPolynomialToMultiply.toString());
    assertEquals("2x^2+1x^1+3", secondPolynomialToMultiply.toString());

    assertNotEquals(firstPolynomialToMultiply, actualResult);
    assertNotEquals(secondPolynomialToMultiply, actualResult);
  }

  /**
   * Test the multiply method with same degree with few coefficients missing in one polynomial.
   */
  @Test
  public void testMultiplicationWithSameDegreeWithFewCoefficientsMissingInOnePolynomial() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(3, 2);
    firstPolynomialToMultiply.addTerm(-2, 1);
    firstPolynomialToMultiply.addTerm(5, 0);

    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(6, 4);
    expectedResult.addTerm(-4, 3);
    expectedResult.addTerm(19, 2);
    expectedResult.addTerm(-6, 1);
    expectedResult.addTerm(15, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("6x^4-4x^3+19x^2-6x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", firstPolynomialToMultiply.toString());
    assertEquals("2x^2+3", secondPolynomialToMultiply.toString());
    assertNotEquals(firstPolynomialToMultiply, actualResult);
    assertNotEquals(secondPolynomialToMultiply, actualResult);
  }

  /**
   * Test the multiplication of two zero polynomials.
   */
  @Test
  public void testMultiplicationOfTwoZeroPolynomials() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());
  }

  /**
   * Test the multiplication with zero polynomials.
   */
  @Test
  public void testMultiplicationWithZeroPolynomials() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(2, 2);
    firstPolynomialToMultiply.addTerm(-1, 0);
    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);


    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("2x^2-1", firstPolynomialToMultiply.toString());
    assertEquals("0", secondPolynomialToMultiply.toString());
  }

  /**
   * Test the multiplication to zero polynomials.
   */
  @Test
  public void testMultiplicationToZeroPolynomials() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(-1, 0);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("0", firstPolynomialToMultiply.toString());
    assertEquals("2x^2-1", secondPolynomialToMultiply.toString());
  }

  /**
   * Test the multiply method with different degree in the polynomial.
   */
  @Test
  public void testMultiplicationWithDifferentDegree() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(3, 2);
    firstPolynomialToMultiply.addTerm(-2, 1);
    firstPolynomialToMultiply.addTerm(5, 0);

    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(2, 5);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    assertEquals("6x^7-4x^6+10x^5+6x^4-4x^3+19x^2-6x^1+15", actualResult.toString());
    assertEquals(7, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", firstPolynomialToMultiply.toString());
    assertEquals("2x^5+2x^2+3", secondPolynomialToMultiply.toString());

    assertNotEquals(firstPolynomialToMultiply, actualResult);
    assertNotEquals(secondPolynomialToMultiply, actualResult);
  }


  /**
   * Test the multiply method with all positive coefficient.
   */
  @Test
  public void testMultiplicationOfAllPositiveCoefficients() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(3, 2);
    firstPolynomialToMultiply.addTerm(2, 1);
    firstPolynomialToMultiply.addTerm(5, 0);

    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(2, 1);
    secondPolynomialToMultiply.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    assertEquals("6x^4+10x^3+23x^2+16x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2+2x^1+5", firstPolynomialToMultiply.toString());
    assertEquals("2x^2+2x^1+3", secondPolynomialToMultiply.toString());

    assertNotEquals(firstPolynomialToMultiply, actualResult);
    assertNotEquals(secondPolynomialToMultiply, actualResult);
  }

  /**
   * Test the multiplication method with all negative coefficient.
   */
  @Test
  public void testMultiplicationOfAllNegativeCoefficients() {
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(-3, 2);
    firstPolynomialToMultiply.addTerm(-2, 1);
    firstPolynomialToMultiply.addTerm(-5, 0);

    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(-2, 2);
    secondPolynomialToMultiply.addTerm(-2, 1);
    secondPolynomialToMultiply.addTerm(-3, 0);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    assertEquals("6x^4+10x^3+23x^2+16x^1+15", actualResult.toString());
    assertEquals(4, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("-3x^2-2x^1-5", firstPolynomialToMultiply.toString());
    assertEquals("-2x^2-2x^1-3", secondPolynomialToMultiply.toString());

    assertNotEquals(firstPolynomialToMultiply, actualResult);
    assertNotEquals(secondPolynomialToMultiply, actualResult);
  }


  /**
   * Test the multiply method multiple times.
   */
  @Test
  public void testMultipleMultiplications() {

    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(2, 3);
    firstPolynomialToMultiply.addTerm(1, 2);
    firstPolynomialToMultiply.addTerm(2, 0);

    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(-1, 3);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(10, 0);

    Polynomial thirdPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    thirdPolynomialToMultiply.addTerm(2, 3);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply)
            .multiply(thirdPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    assertEquals("-4x^9+6x^8+4x^7+36x^6+28x^5+40x^3", actualResult.toString());
    assertEquals(9, actualResult.getDegree());

  }

  /**
   * Tests to verify is multiplication is associative.
   */
  @Test
  public void testIfMultiplicationIsAssociative() {

    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(2, 3);
    firstPolynomialToMultiply.addTerm(1, 2);
    firstPolynomialToMultiply.addTerm(2, 0);

    Polynomial secondPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToMultiply.addTerm(-1, 3);
    secondPolynomialToMultiply.addTerm(2, 2);
    secondPolynomialToMultiply.addTerm(10, 0);

    Polynomial thirdPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    thirdPolynomialToMultiply.addTerm(2, 3);

    Polynomial firstResult = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply)
            .multiply(thirdPolynomialToMultiply);
    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(firstResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(firstResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    Polynomial secondResult = secondPolynomialToMultiply.multiply(firstPolynomialToMultiply)
            .multiply(thirdPolynomialToMultiply);

    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(secondResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(secondResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

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
    Polynomial firstPolynomialToMultiply = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToMultiply.addTerm(-3, 2);
    firstPolynomialToMultiply.addTerm(-2, 1);
    firstPolynomialToMultiply.addTerm(-5, 0);


    Polynomial anotherPolynomialToDoOperations
            = TestUtils.createPolynomial(polynomialClassOfSecondType);
    anotherPolynomialToDoOperations.addTerm(2, 3);
    anotherPolynomialToDoOperations.addTerm(1, 2);
    anotherPolynomialToDoOperations.addTerm(2, 0);

    Polynomial actualResult = firstPolynomialToMultiply.multiply(anotherPolynomialToDoOperations)
            .add(anotherPolynomialToDoOperations).derivative();

    TestUtils.assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(actualResult,
            polynomialClassOfFirstType, polynomialClassOfSecondType);

    assertEquals("-30x^4-28x^3-30x^2-20x^1-4", actualResult.toString());
    assertEquals(4, actualResult.getDegree());
  }
}
