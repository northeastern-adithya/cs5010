import java.util.Objects;

/**
 * This class implements the BloodPressureRecord interface giving options to
 * retrieve id, get/update systolic and diastolic readings.
 * It represents a single blood pressure record capable
 * of storing only one blood pressure reading at a time.
 */
public class SingleBloodPressureRecord implements BloodPressureRecord {

  /**
   * The unique ID of the blood pressure record.
   */
  private final String id;

  /**
   * The systolic blood pressure reading.
   */
  private double sys;

  /**
   * The diastolic blood pressure reading.
   */
  private double dias;


  /**
   * Constructs a new SingleBloodPressureRecord object with the
   * given ID, systolic and diastolic readings.
   *
   * @param id   the unique ID of the blood pressure record
   * @param sys  the systolic blood pressure reading
   * @param dias the diastolic blood pressure reading
   * @throws IllegalArgumentException if the ID is null or empty,
   *                                  or if the systolic or diastolic readings are negative
   *                                  or if the systolic reading
   *                                  is lower than the diastolic reading
   */
  public SingleBloodPressureRecord(String id, double sys, double dias)
          throws IllegalArgumentException {
    validateInput(id, sys, dias);
    this.id = id;
    this.sys = sys;
    this.dias = dias;
  }


  @Override
  public String getID() {
    return this.id;
  }

  @Override
  public double getSystolicReading() {
    return this.sys;
  }

  @Override
  public double getDiastolicReading() {
    return this.dias;
  }

  /**
   * Updates the systolic blood pressure reading.
   * Throws an IllegalArgumentException if the given systolic reading is negative and
   * new systolic reading is lower than the existing diastolic reading.
   *
   * @param sys the new systolic blood pressure reading
   * @throws IllegalArgumentException if the new systolic reading is negative or
   *                                  if it is lower than the existing diastolic reading
   */
  @Override
  public void updateSystolicReading(double sys) throws IllegalArgumentException {
    validateBloodPressureReading(sys, this.dias);
    this.sys = sys;
  }

  /**
   * Updates the diastolic blood pressure reading.
   * Throws an IllegalArgumentException if the given diastolic reading is negative and
   * new diastolic reading is higher than the existing systolic reading.
   *
   * @param dias the new diastolic blood pressure reading
   * @throws IllegalArgumentException if the new diastolic reading is negative or
   *                                  if it is higher than the existing systolic reading
   */
  @Override
  public void updateDiastolicReading(double dias) throws IllegalArgumentException {
    validateBloodPressureReading(this.sys, dias);
    this.dias = dias;
  }

  /**
   * Validates the inputs given to the constructor.
   *
   * @param id   the unique ID of the blood pressure record
   * @param sys  the systolic blood pressure reading
   * @param dias the diastolic blood pressure reading
   * @throws IllegalArgumentException if the ID is null or empty, or if the systolic or
   *                                  diastolic readings are negative
   *                                  or if the systolic reading is lower than the diastolic reading
   */
  private void validateInput(String id, double sys, double dias) throws IllegalArgumentException {
    validateId(id);
    validateBloodPressureReading(sys, dias);
  }

  /**
   * Validates the ID of the blood pressure record.
   *
   * @param id the unique ID of the blood pressure record
   * @throws IllegalArgumentException if the ID is null or empty
   */
  private void validateId(String id) throws IllegalArgumentException {
    if (Objects.isNull(id) || id.isEmpty()) {
      throw new IllegalArgumentException("Invalid id");
    }
  }


  /**
   * Validates the blood pressure readings in the record.
   *
   * @param sys  the systolic blood pressure reading
   * @param dias the diastolic blood pressure reading
   * @throws IllegalArgumentException if the systolic or diastolic readings
   *                                  are negative
   *                                  or if the systolic reading is lower than the diastolic reading
   */
  private void validateBloodPressureReading(double sys, double dias)
          throws IllegalArgumentException {
    if (sys < 0 || dias < 0 || sys < dias) {
      throw new IllegalArgumentException("Invalid blood pressure reading");
    }
  }


  //  /**
  //   * Compares if two blood pressure records are equal.
  //   * Two blood pressure records are equal if they have the same ID(case-sensitive)
  //   * and their systolic and diastolic readings are within 1 unit of each other.
  //   *
  //   * @return true if equal, false otherwise
  //   */
  //  @Override
  //  public boolean equals(Object obj) {
  //    if (this == obj) {
  //      return true;
  //    }
  //    if (!(obj instanceof SingleBloodPressureRecord)) {
  //      return false;
  //    }
  //
  //    SingleBloodPressureRecord record = (SingleBloodPressureRecord) obj;
  //
  //    return this.id.equals(record.id)
  //    && Math.abs(this.dias - record.dias) < 1 && Math.abs(this.sys - record.sys) < 1;
  // }


  /**
   * Compares if two blood pressure records are equal.
   * Two blood pressure records are equal if they have the same ID(case-sensitive)
   * and their systolic and diastolic readings are equal after rounding to the nearest integer.
   *
   * @return true if equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SingleBloodPressureRecord)) {
      return false;
    }

    SingleBloodPressureRecord that = (SingleBloodPressureRecord) obj;

    return this.id.equals(that.id)
            && Math.round(this.dias) == Math.round(that.dias)
            && Math.round(this.sys) == Math.round(that.sys);
  }


  /**
   * Returns the hash code of the blood pressure record using id.
   *
   * @return the hash code of the blood pressure record
   */
  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
