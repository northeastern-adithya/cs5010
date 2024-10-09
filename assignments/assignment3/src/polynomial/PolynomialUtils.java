package polynomial;

import java.util.Objects;

public class PolynomialUtils {

  private PolynomialUtils() {

  }

  public static int getHashCodeOfPolynomial(int coefficient, int power) {
    return Objects.hash(coefficient, power);
  }
}
