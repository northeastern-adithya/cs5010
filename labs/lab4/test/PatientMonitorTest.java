import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the add,remove,emergency methods PatientMonitor class.
 */
public class PatientMonitorTest {

  private Monitor monitorUnderTest;

  @Before
  public void setUp() {
    monitorUnderTest = new PatientMonitor();
  }


  /**
   * Tests the add method of PatientMonitor class.
   */
  @Test
  public void testAddMethod() {
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 181, 120));
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 180, 121));
    monitorUnderTest.add(new SingleBloodPressureRecord("2", 180, 120));
    assertEquals(3, monitorUnderTest.getNumberOfRecords());
  }

  /**
   * Tests the remove method of PatientMonitor class.
   */
  @Test
  public void testRemoveMethod() {
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 181, 120));
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 180, 121));
    monitorUnderTest.add(new SingleBloodPressureRecord("2", 180, 120));
    monitorUnderTest.remove(new SingleBloodPressureRecord("1", 181, 120));
    assertEquals(2, monitorUnderTest.getNumberOfRecords());
  }


  /**
   * Tests the emergency method of PatientMonitor class where only single patient has emergency.
   */
  @Test
  public void testEmergencyWorksForSinglePatientHavingEmergency() {
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 181, 120));
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 180, 121));
    monitorUnderTest.add(new SingleBloodPressureRecord("2", 180, 120));
    assertFalse(monitorUnderTest.emergency());
  }

  /**
   * Tests the emergency method of PatientMonitor class where multiple patients has emergency.
   */
  @Test
  public void testEmergencyWorksForMultiplePatients() {
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 181, 120));
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 180, 121));
    monitorUnderTest.add(new SingleBloodPressureRecord("2", 184, 120.5));
    assertTrue(monitorUnderTest.emergency());
  }

  /**
   * Tests the emergency method of PatientMonitor class where zero patients has emergency.
   */
  @Test
  public void testEmergencyWorksForZeroPatientsHavingEmergency() {
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 179, 120));
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 180, 120));
    monitorUnderTest.add(new SingleBloodPressureRecord("2", 175, 119));
    assertFalse(monitorUnderTest.emergency());
  }

}
