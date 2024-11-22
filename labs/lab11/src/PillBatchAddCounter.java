/**
 * A decorator that delays adding pills until the next reset or pill count
 * request.
 */
public class PillBatchAddCounter extends PillDecorator {
  private int pendingPills = 0;

  /**
   * Create a new LazyPillDecorator.
   *
   * @param decoratedPillCounter The pill counter to decorate.
   */
  public PillBatchAddCounter(PillCounter decoratedPillCounter) {
    super(decoratedPillCounter);
  }

  @Override
  public void addPill(int count) {
    pendingPills += count;
  }

  @Override
  public void reset() {
    if (pendingPills > 0) {
      super.addPill(pendingPills);
      pendingPills = 0;
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
}
