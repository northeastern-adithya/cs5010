package listadt;

import java.util.function.Function;

/**
 * This class implements the MutableListADT interface and extends the
 * ListADTImpl class.
 * It provides the implementation of the MutableListADT interface.
 *
 * @param <T> the type of the elements in the list
 */
public class MutableListADTImpl<T> extends ListADTImpl<T>
        implements MutableListADT<T> {

  public MutableListADTImpl() {
    super();
  }

  @Override
  public <R> MutableListADT<R> map(Function<T, R> converter) {
    ListADT<R> mappedList = super.map(converter);
    MutableListADT<R> finalResult = new MutableListADTImpl<>();
    for (int idx = 0; idx < mappedList.getSize(); idx++) {
      finalResult.addBack(mappedList.get(idx));
    }
    return finalResult;
  }

  @Override
  public ImmutableListADT<T> getImmutableList() {
    ImmutableListADTImpl.ImmutableListBuilder<T> builder =
            new ImmutableListADTImpl.ImmutableListBuilder<T>();
    for (int idx = 0; idx < this.getSize(); idx++) {
      builder.addBack(this.get(idx));
    }
    return builder.build();
  }
}
