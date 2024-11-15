package listadt;

/**
 * This interface represents a mutable list.
 * @param <T> the type of elements in the list
 */
public interface MutableListADT<T> extends ListADT<T> {

  /**
   * Return an immutable version of this list.
   *
   * @return an immutable version of this list
   */
  ImmutableListADT<T> getImmutableList();
}
