/**
 * Interface for different types of Money.
 */
public interface Money {

  /**
   * Adds the given money to the existing money.
   *
   * @param other the money to be added
   * @return the new money after adding
   * @throws IllegalArgumentException if the given money is null
   *         or if adding the given money causes overflow(> Integer.MAX_VALUE)
   */
  Money add(Money other) throws IllegalArgumentException;

  /**
   * Adds the given money to the existing money.
   *
   * @param dollars the dollars to be added
   * @param cents   the cents to be added
   * @return the new money after adding
   * @throws IllegalArgumentException if dollars or cents less than 0
   *         or if adding the given money causes overflow(> Integer.MAX_VALUE)
   */

  Money add(int dollars, int cents) throws IllegalArgumentException;

  /**
   * Returns the decimal value of the money.
   *
   * @return the decimal value of the money
   */
  double getDecimalValue();

}
