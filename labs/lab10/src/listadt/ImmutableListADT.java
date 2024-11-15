package listadt;

/**
 * This interface represents a read-only list.
 *
 * @param <T> the type of elements in the list
 */
public interface ImmutableListADT<T> extends CommonListADT<T> {

  /**
   * Return a mutable version of this list.
   *
   * @return a mutable version of this list
   */
  MutableListADT<T> getMutableList();

}
