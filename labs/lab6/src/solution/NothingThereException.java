package solution;

/**
 * This exception is thrown when the tree does not have any data to perform operation.
 */
public class NothingThereException extends RuntimeException {

  /**
   * Constructor for the NothingThereException with a message.
   *
   * @param message the message to be displayed
   */
  public NothingThereException(String message) {
    super(message);
  }

}
