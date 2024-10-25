package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a vegetarian pizza.
 */
public class VeggiePizza extends AlaCartePizza {

  /**
   * Create a veggie pizza with all vegetarian toppings, of the specified
   * size with the specified crust.
   *
   * @param size  the size of this pizza
   * @param crust the crust of this pizza
   */
  public VeggiePizza(Size size, Crust crust) {
    super(size, crust);
    this.toppings = getVeggieToppings();
  }

  protected VeggiePizza(Size size, Crust crust, Map<ToppingName,
          ToppingPortion> toppings) {
    super(size, crust, toppings);
  }

  private static Map<ToppingName, ToppingPortion> getVeggieToppings() {
    Map<ToppingName, ToppingPortion> veggieToppings = new HashMap<>();
    veggieToppings.put(ToppingName.Cheese, ToppingPortion.Full);
    veggieToppings.put(ToppingName.Sauce, ToppingPortion.Full);
    veggieToppings.put(ToppingName.BlackOlive, ToppingPortion.Full);
    veggieToppings.put(ToppingName.GreenPepper, ToppingPortion.Full);
    veggieToppings.put(ToppingName.Onion, ToppingPortion.Full);
    veggieToppings.put(ToppingName.Jalapeno, ToppingPortion.Full);
    veggieToppings.put(ToppingName.Tomato, ToppingPortion.Full);
    return veggieToppings;
  }

  /**
   * This class represents a builder for a veggie pizza.
   */
  public static class VeggiePizzaBuilder extends PizzaBuilder<VeggiePizzaBuilder> {

    /**
     * Create a new VeggiePizzaBuilder with veggie toppings.
     */
    public VeggiePizzaBuilder() {
      super();
      this.toppings = getVeggieToppings();
    }

    @Override
    public ObservablePizza build() {
      if (size == null) {
        throw new IllegalStateException("Received size as null.");
      }
      return new VeggiePizza(size, crust, toppings);
    }

    @Override
    public VeggiePizzaBuilder returnBuilder() {
      return this;
    }

    public VeggiePizzaBuilder noCheese() {
      this.toppings.remove(ToppingName.Cheese);
      return returnBuilder();
    }

    public VeggiePizzaBuilder noSauce() {
      this.toppings.remove(ToppingName.Sauce);
      return returnBuilder();
    }

    public VeggiePizzaBuilder noBlackOlives() {
      this.toppings.remove(ToppingName.BlackOlive);
      return returnBuilder();
    }

    public VeggiePizzaBuilder noGreenPepper() {
      this.toppings.remove(ToppingName.GreenPepper);
      return returnBuilder();
    }

    public VeggiePizzaBuilder noOnion() {
      this.toppings.remove(ToppingName.Onion);
      return returnBuilder();
    }

    public VeggiePizzaBuilder noTomato() {
      this.toppings.remove(ToppingName.Tomato);
      return returnBuilder();
    }

    public VeggiePizzaBuilder noJalapeno() {
      this.toppings.remove(ToppingName.Jalapeno);
      return returnBuilder();
    }

  }
}
