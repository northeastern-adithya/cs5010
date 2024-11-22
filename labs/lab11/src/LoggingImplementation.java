import java.io.FileOutputStream;

/**
 * This implementation of a logging system writes messages to a file.
 */
public class LoggingImplementation implements Logging {
  @Override
  public void log(String message) {
    FileOutputStream out = null;
    try {
      //open file to append, this will not overwrite file if present
      out = new FileOutputStream("log.txt", true);
      out.write(message.getBytes());
      out.close();
    } catch (Exception e) {
      System.out.println("Log cannot be opened");
    }
  }
}
