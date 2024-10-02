import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a patient monitor. It monitors several blood pressure records,
 * specifically to see how many of them are going into hypertensive crisis.
 * It also provides method to add or remove a patient record to monitor.
 */

public class PatientMonitor implements Monitor {
  private final List<BloodPressureRecord> bpRecordList;

  public PatientMonitor() {
    this.bpRecordList = new ArrayList<BloodPressureRecord>();
  }

  public void add(BloodPressureRecord t) {
    bpRecordList.add(t);
  }

  public void remove(BloodPressureRecord t) {
    bpRecordList.remove(t);
  }

  public int getNumberOfRecords() {
    return bpRecordList.size();
  }


  /**
   * Returns true if there are more than one blood pressure records having emergency crises.
   * Emergency is when a record has a systolic reading greater
   * than 180 or a diastolic reading greater than 120.
   *
   * @return true if there are more than one blood pressure
   *         records having emergency crises, false otherwise.
   */
  public boolean emergency() {
    Map<String, Integer> patientToEmergencyCount = new HashMap<>();
    for (BloodPressureRecord t : bpRecordList) {
      if ((t.getSystolicReading() > 180) || (t.getDiastolicReading() > 120)) {
        patientToEmergencyCount
                .put(t.getID(), patientToEmergencyCount.getOrDefault(t.getID(), 0) + 1);
      }

    }
    int count = 0;
    for (int emergencyCount : patientToEmergencyCount.values()) {
      if (emergencyCount > 1) {
        count += 1;
      }
    }
    return count > 1;
  }

}
