package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents an ala carte pizza (i.e. a pizza that can
 * have an arbitrary number of ingredients.
 */
public class AlaCartePizza implements ObservablePizza {
  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  /**
   * Create a pizza given its crust type, size and toppings.
   */
  public AlaCartePizza(Size size, Crust crust) {
    this.crust = crust;
    this.size = size;
    this.toppings = new HashMap<>();
  }

  protected AlaCartePizza(Size size, Crust crust, Map<ToppingName,
          ToppingPortion> toppings) {
    this(size, crust);
    validatePizzaInput(size, crust, toppings);
    this.toppings = toppings;
  }

  private void validatePizzaInput(Size size, Crust crust, Map<ToppingName,
          ToppingPortion> toppings) {
    if (size == null || crust == null || toppings == null) {
      throw new IllegalArgumentException("Received inputs as null.");
    }
  }

  @Override
  public ToppingPortion hasTopping(ToppingName name) {
    return this.toppings.getOrDefault(name, null);
  }

  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<ToppingName, ToppingPortion> item :
            this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultiplier();
    }
    return cost + this.size.getBaseCost();
  }

  /**
   * This class is a builder for AlaCartePizza.
   */
  public static class AlaCartePizzaBuilder extends PizzaBuilder<AlaCartePizzaBuilder> {

    /**
     * Create a new AlaCartePizzaBuilder.
     */
    public AlaCartePizzaBuilder() {
      super();
    }

    @Override
    public ObservablePizza build() {
      if (size == null) {
        throw new IllegalStateException("Got size as null.");
      }
      return new AlaCartePizza(size, crust, toppings);
    }

    @Override
    public AlaCartePizzaBuilder returnBuilder() {
      return this;
    }
  }

}
