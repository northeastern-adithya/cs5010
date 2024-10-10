import org.junit.Test;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;
import polynomial.SparsePolynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the efficient of polynomial implementation.
 */
public class TestEfficiencyOfPolynomial {

  /**
   * Tests the efficiency of add method of when adding
   * two simple polynomial.
   */
  @Test
  public void testAddEfficiencyOfSimplePolynomial() {
    Polynomial firstPolynomialToAdd = new SimplePolynomial();
    firstPolynomialToAdd.addTerm(1, 10000);
    firstPolynomialToAdd.addTerm(1, 0);

    Polynomial secondPolynomialToAdd = new SimplePolynomial();
    secondPolynomialToAdd.addTerm(1, 10000);
    secondPolynomialToAdd.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToAdd.add(secondPolynomialToAdd);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    assertTrue(executionTime < 10);
  }

  /**
   * Tests the efficiency of multiply method of when multiplying
   * two simple polynomial.
   */
  @Test
  public void testMultiplyEfficiencyOfSimplePolynomial() {
    Polynomial firstPolynomialToMultiply = new SimplePolynomial();
    firstPolynomialToMultiply.addTerm(1, 10000);
    firstPolynomialToMultiply.addTerm(1, 0);

    Polynomial secondPolynomialToMultiply = new SimplePolynomial();
    secondPolynomialToMultiply.addTerm(1, 10000);
    secondPolynomialToMultiply.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    assertTrue(executionTime < 3000);
  }


  /**
   * Tests the efficiency of add method of when adding
   * two sparse polynomial.
   */
  @Test
  public void testAddEfficiencyOfSparsePolynomial() {
    Polynomial firstPolynomialToAdd = new SparsePolynomial();
    firstPolynomialToAdd.addTerm(1, 10000);
    firstPolynomialToAdd.addTerm(1, 0);

    Polynomial secondPolynomialToAdd = new SparsePolynomial();
    secondPolynomialToAdd.addTerm(1, 10000);
    secondPolynomialToAdd.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToAdd.add(secondPolynomialToAdd);
    long endTime = System.currentTimeMillis();
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of multiply method of when multiplying
   * two sparse polynomial.
   */
  @Test
  public void testMultiplyEfficiencyOfSparsePolynomial() {
    Polynomial firstPolynomialToMultiply = new SparsePolynomial();
    firstPolynomialToMultiply.addTerm(1, 10000);
    firstPolynomialToMultiply.addTerm(1, 0);

    Polynomial secondPolynomialToMultiply = new SparsePolynomial();
    secondPolynomialToMultiply.addTerm(1, 10000);
    secondPolynomialToMultiply.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    assertTrue(executionTime < 400);
  }

  /**
   * Tests the efficiency of add method of when adding
   * a simple and a sparse polynomial.
   */
  @Test
  public void testAddEfficiencyOfSimpleAndSparsePolynomial() {
    Polynomial firstPolynomialToAdd = new SimplePolynomial();
    firstPolynomialToAdd.addTerm(1, 10000);
    firstPolynomialToAdd.addTerm(1, 0);

    Polynomial secondPolynomialToAdd = new SparsePolynomial();
    secondPolynomialToAdd.addTerm(1, 10000);
    secondPolynomialToAdd.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToAdd.add(secondPolynomialToAdd);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of add method of when adding
   * a sparse and a simple polynomial.
   */
  @Test
  public void testAddEfficiencyOfSparseAndSimplePolynomial() {
    Polynomial firstPolynomialToAdd = new SparsePolynomial();
    firstPolynomialToAdd.addTerm(1, 10000);
    firstPolynomialToAdd.addTerm(1, 0);

    Polynomial secondPolynomialToAdd = new SparsePolynomial();
    secondPolynomialToAdd.addTerm(1, 10000);
    secondPolynomialToAdd.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToAdd.add(secondPolynomialToAdd);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToAdd.getClass(), secondPolynomialToAdd.getClass());
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of multiply method of when multiplying
   * a simple and a sparse polynomial.
   */
  @Test
  public void testMultiplyEfficiencyOfSimpleAndSparsePolynomial() {
    Polynomial firstPolynomialToMultiply = new SimplePolynomial();
    firstPolynomialToMultiply.addTerm(1, 10000);
    firstPolynomialToMultiply.addTerm(1, 0);

    Polynomial secondPolynomialToMultiply = new SparsePolynomial();
    secondPolynomialToMultiply.addTerm(1, 10000);
    secondPolynomialToMultiply.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    assertTrue(executionTime < 400);
  }

  /**
   * Tests the efficiency of multiply method of when multiplying
   * a sparse and a simple polynomial.
   */
  @Test
  public void testMultiplyEfficiencyOfSparseAndSimplePolynomial() {
    Polynomial firstPolynomialToMultiply = new SparsePolynomial();
    firstPolynomialToMultiply.addTerm(1, 10000);
    firstPolynomialToMultiply.addTerm(1, 0);

    Polynomial secondPolynomialToMultiply = new SimplePolynomial();
    secondPolynomialToMultiply.addTerm(1, 10000);
    secondPolynomialToMultiply.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    Polynomial result = firstPolynomialToMultiply.multiply(secondPolynomialToMultiply);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    TestUtils.assertIfResultIsSimpleIfBothThePolynomialAreSimple(
            result, firstPolynomialToMultiply.getClass(), secondPolynomialToMultiply.getClass());
    assertTrue(executionTime < 400);
  }

  /**
   * Tests the efficiency of equals and hashcode method of when comparing
   * two simple polynomial.
   */
  @Test
  public void testEqualsAndHashcodeEfficiencyOfSimple() {
    Polynomial firstPolynomial = new SimplePolynomial();
    firstPolynomial.addTerm(1, 10000);
    firstPolynomial.addTerm(1, 0);

    Polynomial secondPolynomial = new SimplePolynomial();
    secondPolynomial.addTerm(1, 10000);
    secondPolynomial.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    assertEquals(firstPolynomial, secondPolynomial);
    assertEquals(firstPolynomial.hashCode(), secondPolynomial.hashCode());
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 10);
  }

  /**
   * Tests the efficiency of equals and hashcode method of when comparing
   * two sparse polynomial.
   */
  @Test
  public void testEqualsAndHashcodeEfficiencyOfSparse() {
    Polynomial firstPolynomial = new SparsePolynomial();
    firstPolynomial.addTerm(1, 10000);
    firstPolynomial.addTerm(1, 0);

    Polynomial secondPolynomial = new SparsePolynomial();
    secondPolynomial.addTerm(1, 10000);
    secondPolynomial.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    assertEquals(firstPolynomial, secondPolynomial);
    assertEquals(firstPolynomial.hashCode(), secondPolynomial.hashCode());
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of equals and hashcode
   * method of when comparing a simple and a sparse polynomial.
   */
  @Test
  public void testEqualsAndHashcodeEfficiencyOfSimpleAndSparse() {
    Polynomial firstPolynomial = new SimplePolynomial();
    firstPolynomial.addTerm(1, 10000);
    firstPolynomial.addTerm(1, 0);

    Polynomial secondPolynomial = new SparsePolynomial();
    secondPolynomial.addTerm(1, 10000);
    secondPolynomial.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    assertEquals(firstPolynomial, secondPolynomial);
    assertEquals(firstPolynomial.hashCode(), secondPolynomial.hashCode());
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of equals and hashcode
   * method of when comparing a sparse and a simple polynomial.
   */
  @Test
  public void testEqualsAndHashcodeEfficiencyOfSparseAndSimple() {
    Polynomial firstPolynomial = new SparsePolynomial();
    firstPolynomial.addTerm(1, 10000);
    firstPolynomial.addTerm(1, 0);

    Polynomial secondPolynomial = new SimplePolynomial();
    secondPolynomial.addTerm(1, 10000);
    secondPolynomial.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    assertEquals(firstPolynomial, secondPolynomial);
    assertEquals(firstPolynomial.hashCode(), secondPolynomial.hashCode());
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of derivative method of
   * simple polynomial.
   */
  @Test
  public void testEfficiencyOfDerivativeMethodForSimple() {
    Polynomial polynomialUnderTest = new SimplePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    polynomialUnderTest.derivative();

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 10);
  }

  /**
   * Tests the efficiency of derivative method of
   * sparse polynomial.
   */
  @Test
  public void testEfficiencyOfDerivativeMethodForSparse() {
    Polynomial polynomialUnderTest = new SparsePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    polynomialUnderTest.derivative();

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of add term method of
   * simple polynomial.
   */
  @Test
  public void testEfficiencyOfAddTermMethodForSimple() {
    Polynomial polynomialUnderTest = new SimplePolynomial();
    long startTime = System.currentTimeMillis();
    polynomialUnderTest.addTerm(1, 0);
    polynomialUnderTest.addTerm(1, 10000);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 10);
  }

  /**
   * Tests the efficiency of add term method of
   * sparse polynomial.
   */
  @Test
  public void testEfficiencyOfAddTermForSparse() {
    Polynomial polynomialUnderTest = new SparsePolynomial();
    long startTime = System.currentTimeMillis();
    polynomialUnderTest.addTerm(1, 0);
    polynomialUnderTest.addTerm(1, 10000);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of toString method of
   * simple polynomial.
   */
  @Test
  public void testEfficiencyOfToStringMethodForSimple() {
    Polynomial polynomialUnderTest = new SimplePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    polynomialUnderTest.toString();
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 10);
  }

  /**
   * Tests the efficiency of toString method of
   * sparse polynomial.
   */
  @Test
  public void testEfficiencyOfToStringMethodForSparse() {
    Polynomial polynomialUnderTest = new SparsePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    polynomialUnderTest.toString();
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of evaluate method of
   * simple polynomial.
   */
  @Test
  public void testEfficiencyOfEvaluateMethodForSimple() {
    Polynomial polynomialUnderTest = new SimplePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    polynomialUnderTest.evaluate(2);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 20);
  }

  /**
   * Tests the efficiency of evaluate method of
   * sparse polynomial.
   */
  @Test
  public void testEfficiencyOfEvaluateMethodForSparse() {
    Polynomial polynomialUnderTest = new SparsePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(1, 0);

    long startTime = System.currentTimeMillis();
    polynomialUnderTest.evaluate(2);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 10);
  }

  /**
   * Tests the efficiency of getCoefficient method of
   * simple polynomial.
   */
  @Test
  public void testEfficiencyOfGetCoefficientMethodForSimple() {
    Polynomial polynomialUnderTest = new SimplePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(2, 10);
    polynomialUnderTest.addTerm(3, 0);
    long startTime = System.currentTimeMillis();
    polynomialUnderTest.getCoefficient(1000);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 5);
  }

  /**
   * Tests the efficiency of getCoefficient method of
   * sparse polynomial.
   */
  @Test
  public void testEfficiencyOfGetCoefficientMethodForSparse() {
    Polynomial polynomialUnderTest = new SparsePolynomial();
    polynomialUnderTest.addTerm(1, 10000);
    polynomialUnderTest.addTerm(2, 10);
    polynomialUnderTest.addTerm(3, 0);
    long startTime = System.currentTimeMillis();
    polynomialUnderTest.getCoefficient(1000);
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    assertTrue(executionTime < 10);
  }


}
