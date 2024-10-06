package polynomial.model;

/**
 * Class to represent the power and coefficient for the polynomial.
 */
public class PolynomialContainer {

  /**
   * The power of the polynomial.
   */
  private final int power;

  /**
   * The coefficient of the polynomial.
   */
  private final int coefficient;


  /**
   * Constructor to initialize the power and coefficient.
   *
   * @param power       the power of the polynomial.
   * @param coefficient the coefficient of the polynomial.
   */
  public PolynomialContainer(final int power, final int coefficient) {
    this.power = power;
    this.coefficient = coefficient;
  }

  /**
   * Get the power of the polynomial.
   *
   * @return the power of the polynomial.
   */
  public int getPower() {
    return this.power;
  }

  /**
   * Get the coefficient of the polynomial.
   *
   * @return the coefficient of the polynomial.
   */
  public int getCoefficient() {
    return this.coefficient;
  }


}
