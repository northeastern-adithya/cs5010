import java.lang.reflect.InvocationTargetException;

import polynomial.Polynomial;
import polynomial.SparsePolynomial;

import static org.junit.Assert.assertEquals;

/**
 * Utility class to have helper methods for testing.
 */
public class TestUtils {

  /**
   * Private constructor to prevent instantiation
   * since the utility methods are static.
   */
  private TestUtils() {
  }

  /**
   * Creates a polynomial object of the given class.
   * Converts the checked exceptions to unchecked exceptions.
   *
   * @param polynomialClass the class of the polynomial to be created.
   * @return the polynomial object of the given class.
   * @throws RuntimeException if the polynomial object cannot be created.
   */
  public static Polynomial createPolynomial(Class<? extends Polynomial> polynomialClass) {
    try {
      return polynomialClass.getDeclaredConstructor().newInstance();
    } catch (NoSuchMethodException | InvocationTargetException
             | InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Asserts if the result is sparse if one of the polynomial is sparse.
   *
   * @param actualResult                the actual result to be checked.
   * @param polynomialClassOfFirstType  the class of the first polynomial.
   * @param polynomialClassOfSecondType the class of the second polynomial.
   */
  public static void assertIfResultIsSparseIfOneOfThePolynomialIsSparse(
          Polynomial actualResult,
          Class<?> polynomialClassOfFirstType,
          Class<?> polynomialClassOfSecondType) {
    if (polynomialClassOfFirstType.equals(SparsePolynomial.class)
            || polynomialClassOfSecondType.equals(SparsePolynomial.class)) {
      assertEquals(SparsePolynomial.class, actualResult.getClass());
    }
  }
}
