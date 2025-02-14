import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test to check the LazyWithMonitorPillDecorator class.
 */
public class PillBatchAddMonitorTest {

  @Test
  public void usage() {
    PillBatchAddMonitor counter = new PillBatchAddMonitor(new LoggingPillCounter());
    boolean result = conveyerBelt(counter);
    assertTrue(result);
    System.out.println(counter.getAddCounts());
  }

  private boolean conveyerBelt(PillCounter counter) {
    //make 100 bottles of 100 pills each
    for (int bottle = 0; bottle < 100; bottle += 1) {
      for (int pill = 0; pill < 100; pill += 1) {
        counter.addPill(1); //1 pill at a time
      }
      assertEquals(100, counter.getPillCount());
      counter.reset(); //for the next bottle
    }

    //make 1000 bottles of 20 pills each
    for (int bottle = 0; bottle < 1000; bottle += 1) {
      for (int pill = 0; pill < 20; pill += 4) {
        counter.addPill(4); //4 pills at a time (newer machine)
      }
      assertEquals(20, counter.getPillCount());
      counter.reset(); //for the next bottle
    }

    //make 500 bottles of 200 pills each
    for (int bottle = 0; bottle < 500; bottle += 1) {
      for (int pill = 0; pill < 200; pill += 2) {
        counter.addPill(2); //2 pills at a time (third machine)
      }
      assertEquals(200, counter.getPillCount());
      counter.reset(); //for the next bottle
    }
    return true;
  }
}
