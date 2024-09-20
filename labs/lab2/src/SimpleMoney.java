import java.math.BigDecimal;
import java.util.Objects;

/**
 * A class to represent Simple Money.
 */
public class SimpleMoney implements Money {

  /**
   * The dollars in the money.
   */
  private final int dollars;
  /**
   * The cents in the money.
   */
  private final int cents;

  /**
   * Constructs a SimpleMoney object with the given dollars and cents.
   * Converts cents accordingly to dollars if cents are greater than 100.
   *
   * @param dollars the dollars in the money
   * @param cents   the cents in the money
   * @throws IllegalArgumentException if the given dollars or cents fails validation
   */
  public SimpleMoney(int dollars, int cents) throws IllegalArgumentException {
    validate(dollars, cents);
    if (cents >= 100) {
      this.dollars = dollars + cents / 100;
      this.cents = cents % 100;
    } else {
      this.dollars = dollars;
      this.cents = cents;
    }
  }

  @Override
  public Money add(Money other) throws IllegalArgumentException {
    if (Objects.isNull(other)) {
      throw new IllegalArgumentException("Received an invalid US money");
    }
    BigDecimal currentMoney = BigDecimal.valueOf(this.getDecimalValue());
    BigDecimal moneyToAdd = BigDecimal.valueOf(other.getDecimalValue());
    validateForOverflow(other);
    BigDecimal newMoney = currentMoney.add(moneyToAdd);
    return new SimpleMoney(newMoney.intValue(),
            (newMoney.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue()));
  }

  @Override
  public Money add(int dollars, int cents) throws IllegalArgumentException {
    return add(new SimpleMoney(dollars, cents));
  }

  @Override
  public double getDecimalValue() {
    return dollars + cents / 100.0;
  }

  /**
   * Returns the string representation of the money with cents represented with 2 scale.
   *
   * @return the string representation of the money
   */
  @Override
  public String toString() {
    return String.format("$%.2f", getDecimalValue());
  }

  /**
   * Validates if given money causes integer overflow.
   *
   * @param moneyToAdd the money to be added
   * @throws IllegalArgumentException if adding the given money causes overflow.
   */
  private void validateForOverflow(Money moneyToAdd) {
    double subtractingWithIntMax = (double) Integer.MAX_VALUE - this.getDecimalValue();
    if (subtractingWithIntMax < moneyToAdd.getDecimalValue()) {
      throw new IllegalArgumentException("Overflow occurred while adding money");
    }
  }


  /**
   * Validates the given dollars and cents.
   * Checks if dollars and cents are greater than or equal to 0.
   *
   * @param dollars the dollars to be validated
   * @param cents   the cents to be validated
   * @throws IllegalArgumentException if the given dollars or cents fails validation.
   */
  private void validate(int dollars, int cents) throws IllegalArgumentException {
    if (dollars < 0 || cents < 0) {
      throw new IllegalArgumentException("Received an invalid US money");
    }
  }
}
