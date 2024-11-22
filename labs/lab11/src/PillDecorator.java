/**
 * PillDecorator is a decorator class that implements PillCounter interface.
 */
public class PillDecorator implements PillCounter {


  protected final PillCounter decoratedPillCounter;

  /**
   * Create a new PillDecorator.
   *
   * @param decoratedPillCounter The pill counter to decorate.
   */
  public PillDecorator(PillCounter decoratedPillCounter) {
    this.decoratedPillCounter = decoratedPillCounter;
  }

  @Override
  public void addPill(int count) {
    decoratedPillCounter.addPill(count);
  }

  @Override
  public void removePill() {
    decoratedPillCounter.removePill();
  }

  @Override
  public void reset() {
    decoratedPillCounter.reset();
  }

  @Override
  public int getPillCount() {
    return decoratedPillCounter.getPillCount();
  }
}
