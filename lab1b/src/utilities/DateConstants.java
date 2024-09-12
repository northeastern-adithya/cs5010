package utilities;

import java.util.Arrays;
import java.util.List;

/**
 * This class represents common constants required for working of MyDate.
 */
public class DateConstants {

  /**
   * Private constructor for date constants.
   */
  private DateConstants() {
  }

  /**
   * List containing months having 31 days.
   */
  public static final List<Integer> MONTHS_WITH_THIRTY_ONE_DAYS
          = Arrays.asList(1, 3, 5, 7, 8, 10, 12);

  /**
   * List containing months having 30 days.
   */
  public static final List<Integer> MONTHS_WITH_THIRTY_DAYS = Arrays.asList(4, 6, 9, 11);


}
