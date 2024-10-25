package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;


/**
 * Pizza builder class that allows for the
 * construction of a pizza with a crust, size, and toppings.
 */
public abstract class PizzaBuilder<T extends PizzaBuilder<T>> {

  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  protected PizzaBuilder() {
    this.toppings = new HashMap<>();
  }

  public T crust(Crust crust) {
    this.crust = crust;
    return returnBuilder();
  }

  public T size(Size size) {
    this.size = size;
    return returnBuilder();
  }

  public T addTopping(ToppingName name, ToppingPortion portion) {
    this.toppings.put(name, portion);
    return returnBuilder();
  }

  public abstract ObservablePizza build();

  public abstract T returnBuilder();

}