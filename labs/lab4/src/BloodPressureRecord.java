/**
 * This interface represents a blood pressure record.
 * It provides methods to retrieve and update the systolic and diastolic blood pressure readings,
 * as well as a unique ID for the record.
 */
public interface BloodPressureRecord {

  /**
   * Returns the ID of the blood pressure record.
   *
   * @return the ID of the blood pressure record
   */
  String getID();

  /**
   * Returns the systolic blood pressure reading.
   *
   * @return the systolic blood pressure reading
   */
  double getSystolicReading();

  /**
   * Returns the diastolic blood pressure reading.
   *
   * @return the diastolic blood pressure reading
   */
  double getDiastolicReading();

  /**
   * Updates the systolic blood pressure reading.
   * Throws an IllegalArgumentException if the new systolic reading
   * is lower than the existing diastolic reading.
   *
   * @param sys the new systolic blood pressure reading
   * @throws IllegalArgumentException if the new systolic reading
   *                                  is lower than the existing diastolic reading
   */
  void updateSystolicReading(double sys) throws IllegalArgumentException;

  /**
   * Updates the diastolic blood pressure reading.
   * Throws an IllegalArgumentException if the new diastolic reading
   * is higher than the existing systolic reading.
   *
   * @param dias the new diastolic blood pressure reading
   * @throws IllegalArgumentException if the new diastolic reading
   *                                  is higher than the existing systolic reading
   */
  void updateDiastolicReading(double dias) throws IllegalArgumentException;
}