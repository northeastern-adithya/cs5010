import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;
import polynomial.SparsePolynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to test the cases for equals and hashcode method in Polynomial.
 * Runs with parameterized test runner.
 */
@RunWith(Parameterized.class)
public class TestPolynomialEqualsAndHashCodeMethod {

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
  public TestPolynomialEqualsAndHashCodeMethod(
          Class<? extends Polynomial> polynomialClassOfFirstType,
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
   * Test the equals and hash code method with no elements in the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeWithNoElements() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    Polynomial expectedPolynomial = TestUtils.createPolynomial(polynomialClassOfSecondType);
    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by passing a different class than the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeMethodWithDifferentClasses() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(2, 3);
    polynomialUnderTest.addTerm(2, 3);

    Integer integerValue = 3;
    assertNotEquals(integerValue, polynomialUnderTest);
    assertNotEquals(integerValue.hashCode(), polynomialUnderTest.hashCode());
  }


  /**
   * Test the equals and hashcode method by creating a new polynomial with same coefficients
   * starting with a positive term.
   */
  @Test
  public void testEqualsAndHashCodeMethodWithPositiveStartingTerm() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(2, 3);
    polynomialUnderTest.addTerm(-2, 1);
    polynomialUnderTest.addTerm(2, 0);

    Polynomial expectedPolynomial = TestUtils.createPolynomial(polynomialClassOfSecondType);
    expectedPolynomial.addTerm(2, 3);
    expectedPolynomial.addTerm(-2, 1);
    expectedPolynomial.addTerm(2, 0);

    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals(polynomialUnderTest,polynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with same coefficients
   * starting with a negative term.
   */
  @Test
  public void testEqualsMethodWithNegativeStartingTerm() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(-2, 3);
    polynomialUnderTest.addTerm(2, 1);
    polynomialUnderTest.addTerm(2, 0);

    Polynomial expectedPolynomial = TestUtils.createPolynomial(polynomialClassOfSecondType);
    expectedPolynomial.addTerm(-2, 3);
    expectedPolynomial.addTerm(2, 1);
    expectedPolynomial.addTerm(2, 0);
    assertEquals(expectedPolynomial, polynomialUnderTest);
    assertEquals(expectedPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with different coefficients
   * starting with a positive term.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentElementsStartingWithPositiveTerm() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(2, 3);
    polynomialUnderTest.addTerm(-2, 1);

    Polynomial differentPolynomial = TestUtils.createPolynomial(polynomialClassOfSecondType);
    differentPolynomial.addTerm(2, 3);
    assertNotEquals(differentPolynomial, polynomialUnderTest);
    assertNotEquals(differentPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method with polynomial having
   * non-zero and zero elements.
   */
  @Test
  public void testEqualsAndHashCodeWithNonZeroAndZeroElements() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(-2, 3);
    polynomialUnderTest.addTerm(-2, 1);

    Polynomial differentPolynomial = TestUtils.createPolynomial(polynomialClassOfSecondType);
    assertNotEquals(differentPolynomial, polynomialUnderTest);
    assertNotEquals(differentPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method by creating a new polynomial with different coefficients
   * starting with a negative term.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentElementsStartingWithNegativeTerm() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(-2, 3);
    polynomialUnderTest.addTerm(2, 1);

    Polynomial differentPolynomial = TestUtils.createPolynomial(polynomialClassOfSecondType);
    differentPolynomial.addTerm(-2, 3);
    assertNotEquals(differentPolynomial, polynomialUnderTest);
  }


  /**
   * Test the equals and hashcode method with an array having same elements the polynomial.
   */
  @Test
  public void testEqualsAndHashCodeOfSimplePolynomialWithArrayHavingSameElements() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(3, 0);
    polynomialUnderTest.addTerm(2, 1);

    List<Integer> coefficients = new ArrayList<>();
    coefficients.add(3);
    coefficients.add(2);

    assertNotEquals(coefficients, polynomialUnderTest);
    assertNotEquals(coefficients.hashCode(), polynomialUnderTest.hashCode());
  }

  /**
   * Test the equals and hashcode method of zero polynomial and polynomial
   * with no elements are equal.
   */
  @Test
  public void testZeroPolynomialIsEqualToPolynomialWithNoElements() {
    Polynomial polynomialUnderTest = TestUtils.createPolynomial(polynomialClassOfFirstType);
    polynomialUnderTest.addTerm(0, 0);
    polynomialUnderTest.addTerm(0, 3);
    Polynomial zeroPolynomial = TestUtils.createPolynomial(polynomialClassOfSecondType);
    assertEquals(zeroPolynomial, polynomialUnderTest);
    assertEquals(zeroPolynomial.hashCode(), polynomialUnderTest.hashCode());
  }


}
