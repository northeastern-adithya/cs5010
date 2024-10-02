/**
 * Monitor interface provides methods to add and remove blood pressure records,
 * get the number of records and check for emergency.
 */
public interface Monitor {

  /**
   * Adds a blood pressure record to the monitor.
   *
   * @param t the blood pressure record to add
   */
  void add(BloodPressureRecord t);

  /**
   * Removes a blood pressure record from the monitor.
   *
   * @param t the blood pressure record to remove
   */
  void remove(BloodPressureRecord t);

  /**
   * Returns the number of blood pressure records in the monitor.
   *
   * @return the number of blood pressure records in the monitor
   */
  int getNumberOfRecords();

  /**
   * Returns true if there are more than one blood pressure records having emergency crises.
   *
   * @return true if there are more than one blood pressure records
   *         having emergency crises, false otherwise.
   */
  boolean emergency();
}
