
/**
 * This implementation of a pill counter has a built-in logging capability.
 * Every change to the count of pills is written to a log file.
 * THIS FILE EXISTS IN LEGACY CODE. YOU DO NOT HAVE THE CORRECT
 * PRIVILEGES TO EDIT THIS FILE TO IMPROVE IT.
 */

public class LoggingPillCounter implements PillCounter {
  private int count;

  /**
   * Create a pill counter initialized to a zero count.
   */
  public LoggingPillCounter() {
    count = 0;

  }

  @Override
  public void addPill(int count) {
    if (count > 0) {
      this.count += count;
    }
  }

  @Override
  public void removePill() {
    if (count > 0) {
      this.count -= 1;
    }
  }

  @Override
  public void reset() {
    count = 0;
  }

  @Override
  public int getPillCount() {
    return this.count;
  }
}
