import java.util.ArrayList;
import java.util.List;

/**
 * A decorator that adds monitoring to the PillCounter. It keeps track of the
 * number of pills added along with delaying adding pills until the next reset
 * or pill count request.
 */
public class PillBatchAddMonitor extends PillDecorator {
  private final List<Integer> addCounts = new ArrayList<>();
  private int pendingPills = 0;
  private int currentAddCount = 0;

  /**
   * Create a new LazyWithMonitorPillDecorator.
   *
   * @param decoratedPillCounter The pill counter to decorate.
   */
  public PillBatchAddMonitor(PillCounter decoratedPillCounter) {
    super(decoratedPillCounter);
  }

  @Override
  public void addPill(int count) {
    pendingPills += count;
    currentAddCount += count;
  }

  @Override
  public void reset() {
    if (pendingPills > 0) {
      super.addPill(pendingPills);
      pendingPills = 0;
    }

    if (currentAddCount > 0) {
      addCounts.add(currentAddCount);
      currentAddCount = 0;
    }
    super.reset();
  }

  @Override
  public int getPillCount() {
    if (pendingPills > 0) {
      super.addPill(pendingPills);
      pendingPills = 0;
    }
    return super.getPillCount();
  }

  public List<Integer> getAddCounts() {
    return new ArrayList<>(addCounts);
  }


}
