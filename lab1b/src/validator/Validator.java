package validator;


/**
 * Validator interface which to be implemented by different validators.
 */
public interface Validator {

  /**
   * method to validate based on the type of validator.
   *
   * @throws IllegalArgumentException if the validation fails.
   */
  void validate() throws IllegalArgumentException;
}
