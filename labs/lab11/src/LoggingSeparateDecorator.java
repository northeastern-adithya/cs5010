/**
 * A decorator that logs the actions of the pill counter.
 */
public class LoggingSeparateDecorator extends PillDecorator {
  private final Logging log;

  /**
   * Create a new LoggingSeparateDecorator.
   *
   * @param decoratedPillCounter The pill counter to decorate.
   * @param log The logging object to use.
   */
  public LoggingSeparateDecorator(PillCounter decoratedPillCounter,
                                  Logging log) {
    super(decoratedPillCounter);
    this.log = log;
  }

  @Override
  public void addPill(int count) {
    decoratedPillCounter.addPill(count);
    log.log("Added " + count + " pills");
  }

  @Override
  public void removePill() {
    decoratedPillCounter.removePill();
    log.log("Removed 1\n");
  }

  @Override
  public void reset() {
    decoratedPillCounter.reset();
    log.log("Reset\n");
  }

  @Override
  public int getPillCount() {
    return decoratedPillCounter.getPillCount();
  }


}
