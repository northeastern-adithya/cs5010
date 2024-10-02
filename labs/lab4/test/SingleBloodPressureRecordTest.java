import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

/**
 * JUnit test class to test constructor, get id, get systolic reading,get diastolic reading,
 * update systolic reading, update diastolic reading of SingleBloodPressureRecord class.
 */
public class SingleBloodPressureRecordTest {


  /**
   * Test method for creating single blood pressure with valid inputs.
   */
  @Test
  public void testConstructorWithValidInputs() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    assertEquals("1A", bloodPressureRecordUnderTest.getID());
    assertEquals(120, bloodPressureRecordUnderTest.getSystolicReading(), 0);
    assertEquals(80, bloodPressureRecordUnderTest.getDiastolicReading(), 0);
  }


  /**
   * Test method for creating single blood pressure with null or blank strings.
   */
  @Test
  public void testConstructorWithInvalidString() {
    // Test with empty string
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new SingleBloodPressureRecord("", 120, 80));
    assertEquals("Invalid id", exception.getMessage());

    // Test with null string
    exception = assertThrows(IllegalArgumentException.class,
        () -> new SingleBloodPressureRecord(null, 120, 80));
    assertEquals("Invalid id", exception.getMessage());
  }


  /**
   * Test method for creating single blood pressure with negative systolic reading.
   */
  @Test
  public void testConstructorWithNegativeSystolicReading() {
    // Test with negative systolic reading
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new SingleBloodPressureRecord("1A", -120, 80));
    assertEquals("Invalid blood pressure reading", exception.getMessage());
  }

  /**
   * Test method for creating single blood pressure with negative diastolic reading.
   */
  @Test
  public void testConstructorWithNegativeDiastolicReading() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new SingleBloodPressureRecord("1A", 120, -80));
    assertEquals("Invalid blood pressure reading", exception.getMessage());
  }


  /**
   * Test method for creating single blood pressure
   * with systolic reading less than diastolic reading.
   */
  @Test
  public void testConstructorWithSystolicReadingLessThanDiastolicReading() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> new SingleBloodPressureRecord("1A", 80, 120));
    assertEquals("Invalid blood pressure reading", exception.getMessage());
  }


  /**
   * Test method for reading id of the single blood pressure record.
   */
  @Test
  public void testGetID() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    assertEquals("1A",
            bloodPressureRecordUnderTest.getID());
  }

  /**
   * Test method for reading systolic reading
   * of the single blood pressure record.
   */
  @Test
  public void testGetSystolicReading() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    assertEquals(120,
            bloodPressureRecordUnderTest.getSystolicReading(), 0);
  }

  /**
   * Test method for reading diastolic reading
   * of the single blood pressure record.
   */
  @Test
  public void testGetDiastolicReading() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    assertEquals(80,
            bloodPressureRecordUnderTest.getDiastolicReading(), 0);
  }

  /**
   * Test method for updating systolic reading
   * of the single blood pressure record with valid input.
   */
  @Test
  public void testUpdateSystolicReadingWithValidInput() {
    //With higher value
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    bloodPressureRecordUnderTest.updateSystolicReading(130);
    assertEquals(130,
            bloodPressureRecordUnderTest.getSystolicReading(), 0);

    //With lower value
    bloodPressureRecordUnderTest.updateSystolicReading(100);
    assertEquals(100,
            bloodPressureRecordUnderTest.getSystolicReading(), 0);

    //With equal value
    bloodPressureRecordUnderTest.updateSystolicReading(100);
    assertEquals(100,
            bloodPressureRecordUnderTest.getSystolicReading(), 0);
  }

  /**
   * Test method for updating systolic reading
   * of the single blood pressure record with negative input.
   */
  @Test
  public void testUpdateSystolicReadingWithNegativeInput() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> bloodPressureRecordUnderTest.updateSystolicReading(-130));
    assertEquals("Invalid blood pressure reading", exception.getMessage());
  }

  /**
   * Test method for updating systolic reading
   * of the single blood pressure record with value less than diastolic reading.
   */
  @Test
  public void testUpdateSystolicReadingWithValueLessThanDiastolicReading() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> bloodPressureRecordUnderTest.updateSystolicReading(70));
    assertEquals("Invalid blood pressure reading", exception.getMessage());
  }

  /**
   * Test method for updating systolic reading of
   * the single blood pressure record with value equal to diastolic reading.
   */
  @Test
  public void testUpdateSystolicReadingWithValueEqualToDiastolicReading() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    bloodPressureRecordUnderTest.updateSystolicReading(80);
    assertEquals(80,
            bloodPressureRecordUnderTest.getSystolicReading(), 0);
  }

  /**
   * Test method for updating diastolic
   * reading of the single blood pressure record with valid input.
   */
  @Test
  public void testUpdateDiastolicReadingWithValidInput() {
    // with higher value
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 70);
    bloodPressureRecordUnderTest.updateDiastolicReading(80);
    assertEquals(80,
            bloodPressureRecordUnderTest.getDiastolicReading(), 0);

    // with lower value
    bloodPressureRecordUnderTest.updateDiastolicReading(60);
    assertEquals(60,
            bloodPressureRecordUnderTest.getDiastolicReading(), 0);

    // with equal value
    bloodPressureRecordUnderTest.updateDiastolicReading(60);
    assertEquals(60,
            bloodPressureRecordUnderTest.getDiastolicReading(), 0);
  }

  /**
   * Test method for updating diastolic reading
   * of the single blood pressure record with negative input.
   */
  @Test
  public void testUpdateDiastolicReadingWithNegativeInput() {
    BloodPressureRecord bloodPressureRecordUnderTest = new SingleBloodPressureRecord("1A", 120, 80);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> bloodPressureRecordUnderTest.updateDiastolicReading(-70));
    assertEquals("Invalid blood pressure reading", exception.getMessage());
  }

  /**
   * Test method for updating Diastolic reading
   * of the single blood pressure record with value higher than systolic reading.
   */
  @Test
  public void testUpdateDiastolicReadingWithValueLessThanSystolicReading() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> bloodPressureRecordUnderTest.updateDiastolicReading(130));
    assertEquals("Invalid blood pressure reading", exception.getMessage());
  }

  /**
   * Test method for updating diastolic reading
   * of the single blood pressure record with value equal to systolic reading.
   */
  @Test
  public void testUpdateDiastolicReadingWithValueEqualToSystolicReading() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    bloodPressureRecordUnderTest.updateSystolicReading(120);
    assertEquals(120, bloodPressureRecordUnderTest.getSystolicReading(), 0);
  }


  /**
   * Test method for equals and hashcode method with object of different class.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentObject() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    Object obj = new Object();
    assertNotEquals(bloodPressureRecordUnderTest, obj);
    assertNotEquals(bloodPressureRecordUnderTest.hashCode(), obj.hashCode());
  }

  /**
   * Test method for equals and hashcode method with different id.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentID() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    BloodPressureRecord anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1B", 120, 80);
    assertNotEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertNotEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }

  /**
   * Test method for equals and hashcode method with same object.
   */
  @Test
  public void testEqualsAndHashCodeWithSameObject() {
    // With integer
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    BloodPressureRecord anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    assertEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());

    // With double
    bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120.3, 80.82);
    anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120.3, 80.82);
    assertEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }

  //  /**
  //   * Test method for equals and hashcode method
  //   with different systolic reading with difference under 1.
  //   */
  //  @Test
  //  public void testEqualsAndHashCodeWithDifferentSystolicReadingUnderOne() {
  //    BloodPressureRecord bloodPressureRecordUnderTest =
  //    new SingleBloodPressureRecord("1A", 120, 80);
  //    BloodPressureRecord anotherBloodPressureRecordUnderTest =
  //    new SingleBloodPressureRecord("1A", 120.3, 80);
  //    assertEquals(bloodPressureRecordUnderTest,
  //    anotherBloodPressureRecordUnderTest);
  //    assertEquals(bloodPressureRecordUnderTest.hashCode(),
  //    anotherBloodPressureRecordUnderTest.hashCode());
  //  }

  //  /**
  //   * Test method for equals and hashcode method
  //   with different diastolic reading with difference under 1.
  //   */
  //  @Test
  //  public void testEqualsAndHashCodeWithDifferentDiastolicReadingUnderOne() {
  //    BloodPressureRecord bloodPressureRecordUnderTest =
  //    new SingleBloodPressureRecord("1A", 120, 80);
  //    BloodPressureRecord anotherBloodPressureRecordUnderTest =
  //    new SingleBloodPressureRecord("1A", 120, 80.9);
  //    assertEquals(bloodPressureRecordUnderTest,
  //    anotherBloodPressureRecordUnderTest);
  //    assertEquals(bloodPressureRecordUnderTest.hashCode(),
  //    anotherBloodPressureRecordUnderTest.hashCode());
  //  }


  //  /**
  //   * Test method for equals and hashcode method
  //   with different sys and diastolic reading with difference under 1.
  //   */
  //  @Test
  //  public void testEqualsAndHashCodeWithDifferentSysAndDiastolicReadingUnderOne() {
  //    BloodPressureRecord bloodPressureRecordUnderTest =
  //    new SingleBloodPressureRecord("1A", 120, 80);
  //    BloodPressureRecord anotherBloodPressureRecordUnderTest =
  //    new SingleBloodPressureRecord("1A", 120.5, 80.9);
  //    assertEquals(bloodPressureRecordUnderTest,
  //    anotherBloodPressureRecordUnderTest);
  //    assertEquals(bloodPressureRecordUnderTest.hashCode(),
  //    anotherBloodPressureRecordUnderTest.hashCode());
  //  }

  /**
   * Test method for equals and hashcode method
   * with different systolic reading with difference equal to 1.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentSystolicReadingEqualToOne() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    BloodPressureRecord anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 122, 80);
    assertNotEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }

  /**
   * Test method for equals and hashcode
   * method with different diastolic reading with difference equal to 1.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentDiastolicReadingEqualToOne() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 80);
    BloodPressureRecord anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 81);
    assertNotEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }

  @Test
  public void testEqualsAndHashCodeWithDifferentSysAndDiastolicReading() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 81);
    BloodPressureRecord anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 121.9, 89);
    assertNotEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }


  /**
   * Test method for equals and hashcode method with different systolic reading after rounding off.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentSystolicReadingAfterRoundingOff() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120.2, 80);
    BloodPressureRecord anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 119.5, 80);
    assertEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }

  /**
   * Test method for equals and hashcode method with different diastolic reading after rounding off.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentDiastolicReadingAfterRoundingOff() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 82.5);
    BloodPressureRecord anotherBloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120, 83.4);
    assertEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }


  /**
   * Test method for equals and hashcode method with
   * different sys and diastolic reading after rounding off.
   */
  @Test
  public void testEqualsAndHashCodeWithDifferentSysAndDiastolicReadingAfterRoundingOff() {
    BloodPressureRecord bloodPressureRecordUnderTest =
            new SingleBloodPressureRecord("1A", 120.4, 80.9);
    BloodPressureRecord anotherBloodPressureRecordUnderTest
            = new SingleBloodPressureRecord("1A", 120, 81.45);
    assertEquals(bloodPressureRecordUnderTest,
            anotherBloodPressureRecordUnderTest);
    assertEquals(bloodPressureRecordUnderTest.hashCode(),
            anotherBloodPressureRecordUnderTest.hashCode());
  }


}
