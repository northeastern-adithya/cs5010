import java.util.ArrayList;
import java.util.List;

/**
 * A decorator that adds monitoring to the PillCounter. It keeps track of the
 * number of pills added.
 */
public class PillAddMonitor extends PillDecorator {
  private final List<Integer> addCounts = new ArrayList<>();
  private int currentAddCount = 0;

  /**
   * Create a new MonitorPillDecorator.
   *
   * @param decoratedPillCounter The pill counter to decorate.
   */
  public PillAddMonitor(PillCounter decoratedPillCounter) {
    super(decoratedPillCounter);
  }

  @Override
  public void addPill(int count) {
    super.addPill(count);
    currentAddCount += count;
  }


  @Override
  public void reset() {
    super.reset();
    if (currentAddCount > 0) {
      addCounts.add(currentAddCount);
      currentAddCount = 0;
    }
  }

  public List<Integer> getAddCounts() {
    return new ArrayList<>(addCounts);
  }
}
