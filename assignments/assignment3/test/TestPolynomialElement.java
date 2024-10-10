import org.junit.Test;

import polynomial.model.PolynomialElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

/**
 * Tests the model polynomial element.
 */
public class TestPolynomialElement {

  /**
   * Test the constructor of PolynomialElement
   * throws illegal argument exception when power is negative.
   */
  @Test
  public void testConstructorThrowsIllegalArgumentException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new PolynomialElement(2, -2));
    assertEquals("Power cannot be negative. Received: -2", exception.getMessage());
  }

  /**
   * Tests the getter method of PolynomialElement.
   */
  @Test
  public void testGetterMethods() {
    PolynomialElement polynomialElement = new PolynomialElement(3, 2);
    assertEquals(3, polynomialElement.getCoefficient());
    assertEquals(2, polynomialElement.getPower());
  }

  /**
   * Tests the equals method of PolynomialElement.
   */
  @Test
  public void testEqualsWithSameElement() {
    PolynomialElement firstPolynomialElement = new PolynomialElement(3, 2);
    PolynomialElement secondPolynomialElement = new PolynomialElement(3, 2);
    assertEquals(firstPolynomialElement, secondPolynomialElement);
    assertEquals(firstPolynomialElement,firstPolynomialElement);
  }

  /**
   * Tests the equals method of PolynomialElement if elements are different.
   */
  @Test
  public void testEqualsWithDifferentElement() {
    PolynomialElement firstPolynomialElement = new PolynomialElement(3, 2);
    // Different power
    PolynomialElement secondPolynomialElement = new PolynomialElement(3, 3);
    assertNotEquals(firstPolynomialElement, secondPolynomialElement);

    // Different coefficient
    secondPolynomialElement = new PolynomialElement(4, 2);
    assertNotEquals(firstPolynomialElement, secondPolynomialElement);

    // Different power and coefficient
    secondPolynomialElement = new PolynomialElement(4, 3);
    assertNotEquals(firstPolynomialElement, secondPolynomialElement);
  }

  /**
   * Tests the equals method of PolynomialElement with different object.
   */
  @Test
  public void testEqualsWithDifferentObject() {
    PolynomialElement polynomialElement = new PolynomialElement(3, 2);
    assertNotEquals(polynomialElement, new Object());
  }


  /**
   * Tests the toString with zero power.
   */
  @Test
  public void testToStringWithZeroPower() {
    PolynomialElement polynomialElement = new PolynomialElement(3, 0);
    assertEquals("3", polynomialElement.toString());
  }

  /**
   * Tests the toString with zero coefficient.
   */
  @Test
  public void testToStringWithZeroCoefficient() {
    PolynomialElement polynomialElement = new PolynomialElement(0, 2);
    assertEquals("", polynomialElement.toString());
  }

  /**
   * Tests the toString with zero coefficient and power.
   */
  @Test
  public void testToStringWithZeroCoefficientAndPower() {
    PolynomialElement polynomialElement = new PolynomialElement(0, 0);
    assertEquals("", polynomialElement.toString());
  }

  /**
   * Tests the toString with positive coefficient.
   */
  @Test
  public void testToStringWithPositiveCoefficient() {
    PolynomialElement polynomialElement = new PolynomialElement(3, 2);
    assertEquals("3x^2", polynomialElement.toString());
  }

  /**
   * Tests the toString with negative coefficient.
   */
  @Test
  public void testToStringWithNegativeCoefficient() {
    PolynomialElement polynomialElement = new PolynomialElement(-3, 2);
    assertEquals("-3x^2", polynomialElement.toString());
  }
}
