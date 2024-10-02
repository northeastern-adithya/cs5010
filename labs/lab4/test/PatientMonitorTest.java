import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

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
   * Tests the emergency method of PatientMonitor class where only single patient has emergency.
   */
  @Test
  public void testEmergencyWorksForSinglePatientHavingEmergency() {
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 181, 120));
    monitorUnderTest.add(new SingleBloodPressureRecord("1", 180, 121));
    monitorUnderTest.add(new SingleBloodPressureRecord("2", 180, 120));
    assertFalse(monitorUnderTest.emergency());
  }

}
