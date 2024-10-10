import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import polynomial.Polynomial;
import polynomial.SimplePolynomial;
import polynomial.SparsePolynomial;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for polynomial methods to see how it behaves
 * when a new class is added to polynomial interface.
 */
@RunWith(Parameterized.class)
public class TestPolynomialWithoutSimpleAndSparse {

  /**
   * The class of the polynomial to be tested.
   */
  private final Class<? extends Polynomial> polynomialClass;

  /**
   * The class of the mock polynomial.
   */
  private final Class<? extends Polynomial> mockPolynomialClass;


  /**
   * The polynomial object to be tested.
   */
  private Polynomial polynomialUnderTest;

  /**
   * Constructor for parameterized to instantiate the class.
   *
   * @param polynomialClass – the class of the polynomial to be tested.
   */
  public TestPolynomialWithoutSimpleAndSparse(
          Class<? extends Polynomial> polynomialClass,
          Class<? extends Polynomial> mockPolynomialClass) {
    this.polynomialClass = polynomialClass;
    this.mockPolynomialClass = mockPolynomialClass;
  }

  /**
   * Create a collection of polynomial implementations to be tested.
   *
   * @return the collection of polynomial implementations to be tested.
   */
  @Parameterized.Parameters(name = "Additional Class Tests For: {0} and {1}")
  public static Collection<Object[]> polynomialImplementations() {
    return Arrays.asList(new Object[][]{
            {SimplePolynomial.class, MockPolynomial.class},
            {SimplePolynomial.class, MockChildAbstractPolynomial.class},
            {SparsePolynomial.class, MockPolynomial.class},
            {SparsePolynomial.class, MockChildAbstractPolynomial.class}
    });
  }

  /**
   * Tests the add method with another polynomial.
   */
  @Test
  public void testAddMethodWithAnotherPolynomial() {
    Polynomial mockPolynomial = TestUtils.createPolynomial(mockPolynomialClass);
    polynomialUnderTest = TestUtils.createPolynomial(polynomialClass);
    assertTrue(polynomialUnderTest.add(mockPolynomial) instanceof Polynomial);
  }

  /**
   * Tests the multiply method with another polynomial.
   */
  @Test
  public void testMultiplyMethodWithAnotherPolynomial() {
    Polynomial mockPolynomial = TestUtils.createPolynomial(mockPolynomialClass);
    polynomialUnderTest = TestUtils.createPolynomial(polynomialClass);
    assertTrue(polynomialUnderTest.add(mockPolynomial) instanceof Polynomial);
  }

  /**
   * Tests the equals method with another polynomial.
   */
  @Test
  public void testEqualsAndHashCodeMethodWithAnotherPolynomial() {
    Polynomial mockPolynomial = TestUtils.createPolynomial(mockPolynomialClass);
    polynomialUnderTest = TestUtils.createPolynomial(polynomialClass);
    polynomialUnderTest.addTerm(1,2);
    assertNotEquals(polynomialUnderTest, mockPolynomial);
    assertNotEquals(polynomialUnderTest.hashCode(), mockPolynomial.hashCode());
  }
}
