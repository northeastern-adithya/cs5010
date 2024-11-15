package listadt;

import java.util.function.Function;

/**
 * This interface represents a list of elements of type T. It provides all the methods that are
 * common between mutable and immutable lists.
 * @param <T> the type of elements in the list
 */
public interface CommonListADT<T> {


  /**
   * A general purpose map higher order function on this list, that returns
   * the corresponding list of type R.
   *
   * @param converter the function that converts T into R
   * @param <R>       the type of data in the resulting list
   * @return the resulting list that is identical in structure to this list,
   *          but has data of type R
   */
  <R> CommonListADT<R> map(Function<T, R> converter);

  /**
   * Return the number of objects currently in this list.
   *
   * @return the size of the list
   */
  int getSize();

  /**
   * Get the (index)th object in this list.
   *
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  T get(int index) throws IllegalArgumentException;
}
