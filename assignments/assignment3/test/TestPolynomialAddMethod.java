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
 * Class to test the cases for add method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialAddMethod {

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
  public TestPolynomialAddMethod(Class<? extends Polynomial> polynomialClassOfFirstType,
                                 Class<? extends Polynomial> polynomialClassOfSecondType) {
    this.polynomialClassOfFirstType = polynomialClassOfFirstType;
    this.polynomialClassOfSecondType = polynomialClassOfSecondType;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Addition Test For Combination: {0} + {1}")
  public static Collection<Object[]> polynomialImplementations() {
    return Arrays.asList(new Object[][]{
            {SimplePolynomial.class, SimplePolynomial.class},
            {SparsePolynomial.class, SparsePolynomial.class},
            {SimplePolynomial.class, SparsePolynomial.class},
            {SparsePolynomial.class, SimplePolynomial.class}
    });
  }

  /**
   * Test the add method with same degree all elements present in the polynomial.
   */
  @Test
  public void testAdditionWithSameDegreeWithAllCoefficientsPresent() {
    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);

    firstPolynomialToAdd.addTerm(3, 2);
    firstPolynomialToAdd.addTerm(-2, 1);
    firstPolynomialToAdd.addTerm(5, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(1, 1);
    secondPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(-1, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("5x^2-1x^1+8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", firstPolynomialToAdd.toString());
    assertEquals("2x^2+1x^1+3", secondPolynomialToAdd.toString());

    assertNotEquals(firstPolynomialToAdd, actualResult);
    assertNotEquals(secondPolynomialToAdd, actualResult);
  }

  /**
   * Test the add method with same degree with few coefficients missing in one polynomial.
   */
  @Test
  public void testAdditionWithSameDegreeWithFewCoefficientsMissingInOnePolynomial() {
    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToAdd.addTerm(3, 2);
    firstPolynomialToAdd.addTerm(-2, 1);
    firstPolynomialToAdd.addTerm(5, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfSecondType);
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(-2, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("5x^2-2x^1+8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", firstPolynomialToAdd.toString());
    assertEquals("2x^2+3", secondPolynomialToAdd.toString());
    assertNotEquals(firstPolynomialToAdd, actualResult);
    assertNotEquals(secondPolynomialToAdd, actualResult);
  }

  /**
   * Test the addition of two zero polynomials.
   */
  @Test
  public void testAdditionOfTwoZeroPolynomials() {

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);

    Polynomial actualResult =
            TestUtils.createPolynomial(polynomialClassOfFirstType).add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());
  }

  /**
   * Test the addition with zero polynomials.
   */
  @Test
  public void testAdditionWithZeroPolynomials() {

    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToAdd.addTerm(2, 2);
    firstPolynomialToAdd.addTerm(-1, 0);
    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(2, 2);
    expectedResult.addTerm(-1, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("2x^2-1", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("2x^2-1", firstPolynomialToAdd.toString());
    assertEquals("0", secondPolynomialToAdd.toString());
  }

  /**
   * Test the addition to zero polynomials.
   */
  @Test
  public void testAdditionToZeroPolynomials() {

    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(-1, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(2, 2);
    expectedResult.addTerm(-1, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("2x^2-1", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("0", firstPolynomialToAdd.toString());
    assertEquals("2x^2-1", secondPolynomialToAdd.toString());
  }

  /**
   * Test the add method with different degree in the polynomial.
   */
  @Test
  public void testAdditionWithDifferentDegree() {
    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToAdd.addTerm(3, 2);
    firstPolynomialToAdd.addTerm(-2, 1);
    firstPolynomialToAdd.addTerm(5, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(2, 5);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(2, 5);
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(-2, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("2x^5+5x^2-2x^1+8", actualResult.toString());
    assertEquals(5, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2-2x^1+5", firstPolynomialToAdd.toString());
    assertEquals("2x^5+2x^2+3", secondPolynomialToAdd.toString());

    assertNotEquals(firstPolynomialToAdd, actualResult);
    assertNotEquals(secondPolynomialToAdd, actualResult);
  }


  /**
   * Test the add method with all positive coefficient.
   */
  @Test
  public void testAdditionWithAdditionOfAllPositiveCoefficients() {
    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToAdd.addTerm(3, 2);
    firstPolynomialToAdd.addTerm(2, 1);
    firstPolynomialToAdd.addTerm(5, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(2, 1);
    secondPolynomialToAdd.addTerm(3, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(5, 2);
    expectedResult.addTerm(4, 1);
    expectedResult.addTerm(8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("5x^2+4x^1+8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("3x^2+2x^1+5", firstPolynomialToAdd.toString());
    assertEquals("2x^2+2x^1+3", secondPolynomialToAdd.toString());

    assertNotEquals(firstPolynomialToAdd, actualResult);
    assertNotEquals(secondPolynomialToAdd, actualResult);
  }

  /**
   * Test the add method with all negative coefficient.
   */
  @Test
  public void testAdditionWithAdditionOfAllNegativeCoefficients() {
    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToAdd.addTerm(-3, 2);
    firstPolynomialToAdd.addTerm(-2, 1);
    firstPolynomialToAdd.addTerm(-5, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(-2, 2);
    secondPolynomialToAdd.addTerm(-2, 1);
    secondPolynomialToAdd.addTerm(-3, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
    expectedResult.addTerm(-5, 2);
    expectedResult.addTerm(-4, 1);
    expectedResult.addTerm(-8, 0);
    assertEquals(expectedResult, actualResult);
    assertEquals("-5x^2-4x^1-8", actualResult.toString());
    assertEquals(2, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertEquals("-3x^2-2x^1-5", firstPolynomialToAdd.toString());
    assertEquals("-2x^2-2x^1-3", secondPolynomialToAdd.toString());

    assertNotEquals(firstPolynomialToAdd, actualResult);
    assertNotEquals(secondPolynomialToAdd, actualResult);
  }


  /**
   * Test the add two polynomial to give the output as zero.
   */
  @Test
  public void testAddingTwoPolynomialGivingOutputAsZeroPolynomial() {
    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);

    firstPolynomialToAdd.addTerm(3, 2);
    firstPolynomialToAdd.addTerm(1, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(-3, 2);
    secondPolynomialToAdd.addTerm(-1, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);
    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);

    assertEquals(expectedResult, actualResult);
    assertEquals("0", actualResult.toString());
    assertEquals(0, actualResult.getDegree());

    // Check if the original polynomials are not modified.
    assertNotEquals(firstPolynomialToAdd, actualResult);
    assertNotEquals(secondPolynomialToAdd, actualResult);


    // Check if adding it the other way also gives empty result.
    assertEquals(expectedResult, secondPolynomialToAdd.add(firstPolynomialToAdd));
    assertEquals("0", actualResult.toString());
  }


  /**
   * Test the add method multiple times.
   */
  @Test
  public void testMultipleAdditions() {

    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToAdd.addTerm(2, 3);
    firstPolynomialToAdd.addTerm(1, 2);
    firstPolynomialToAdd.addTerm(2, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(-1, 3);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(10, 0);

    Polynomial thirdPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    thirdPolynomialToAdd.addTerm(2, 3);

    Polynomial fourthPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    fourthPolynomialToAdd.addTerm(-5, 3);
    fourthPolynomialToAdd.addTerm(2, 2);
    fourthPolynomialToAdd.addTerm(-4, 0);

    Polynomial actualResult = firstPolynomialToAdd.add(secondPolynomialToAdd)
            .add(thirdPolynomialToAdd).add(fourthPolynomialToAdd);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(actualResult);

    Polynomial expectedResult = TestUtils.createPolynomial(polynomialClassOfFirstType);
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

    Polynomial firstPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    firstPolynomialToAdd.addTerm(2, 3);
    firstPolynomialToAdd.addTerm(1, 2);
    firstPolynomialToAdd.addTerm(2, 0);

    Polynomial secondPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    secondPolynomialToAdd.addTerm(-1, 3);
    secondPolynomialToAdd.addTerm(2, 2);
    secondPolynomialToAdd.addTerm(10, 0);

    Polynomial thirdPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfFirstType);
    thirdPolynomialToAdd.addTerm(2, 3);

    Polynomial fourthPolynomialToAdd = TestUtils.createPolynomial(polynomialClassOfSecondType);
    fourthPolynomialToAdd.addTerm(-5, 3);
    fourthPolynomialToAdd.addTerm(2, 2);
    fourthPolynomialToAdd.addTerm(-4, 0);

    Polynomial firstResult = firstPolynomialToAdd.add(secondPolynomialToAdd)
            .add(thirdPolynomialToAdd).add(fourthPolynomialToAdd);
    Polynomial secondResult = secondPolynomialToAdd.add(thirdPolynomialToAdd)
            .add(firstPolynomialToAdd).add(fourthPolynomialToAdd);

    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(firstResult);
    assertIfResultIsSparseIfOneOfThePolynomialIsSparse(secondResult);
    assertEquals(firstResult, secondResult);

    assertEquals("-2x^3+5x^2+8", firstResult.toString());
    assertEquals("-2x^3+5x^2+8", secondResult.toString());
    assertEquals(3, firstResult.getDegree());
    assertEquals(3, secondResult.getDegree());

  }


  private void assertIfResultIsSparseIfOneOfThePolynomialIsSparse(Polynomial actualResult) {
    if (polynomialClassOfFirstType.equals(SparsePolynomial.class)
            || polynomialClassOfSecondType.equals(SparsePolynomial.class)) {
      assertEquals(SparsePolynomial.class, actualResult.getClass());
    }
  }

}
