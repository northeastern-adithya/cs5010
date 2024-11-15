package listadt;

import java.util.function.Function;

/**
 * This is the implementation of a generic immutable list.
 */
public class ImmutableListADTImpl<T> implements ImmutableListADT<T> {

  private final ListADT<T> adapterList;

  /**
   * Constructor for the ImmutableListADTImpl class.
   */
  private ImmutableListADTImpl() {
    this.adapterList = new ListADTImpl<>();
  }

  @Override
  public <R> CommonListADT<R> map(Function<T, R> converter) {
    ImmutableListBuilder<R> builder = new ImmutableListBuilder<>();
    for (int idx = 0; idx < adapterList.getSize(); idx++) {
      builder.addBack(converter.apply(adapterList.get(idx)));
    }
    return builder.build();
  }

  private void addBack(T elem) {
    adapterList.addBack(elem);
  }

  @Override
  public int getSize() {
    return adapterList.getSize();
  }

  @Override
  public T get(int index) throws
          IllegalArgumentException {
    return adapterList.get(index);
  }

  @Override
  public MutableListADT<T> getMutableList() {
    MutableListADT<T> result = new MutableListADTImpl<>();
    for (int idx = 0; idx < adapterList.getSize(); idx++) {
      result.addBack(adapterList.get(idx));
    }
    return result;
  }

  /**
   * This is a builder class for the ImmutableListADTImpl class.
   *
   * @param <T> the type of the elements in the list
   */
  public static class ImmutableListBuilder<T> {
    private ImmutableListADTImpl<T> list;

    /**
     * Constructor for the ImmutableListBuilder class.
     */
    public ImmutableListBuilder() {
      this.list = new ImmutableListADTImpl<>();
    }

    public ImmutableListBuilder addBack(T elem) {
      list.addBack(elem);
      return this;
    }

    public ImmutableListADT<T> build() {
      return list;
    }
  }
}
