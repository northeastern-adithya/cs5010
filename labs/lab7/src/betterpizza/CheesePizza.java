package betterpizza;

import java.util.HashMap;
import java.util.Map;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

/**
 * This class represents a cheese pizza.
 */
public class CheesePizza extends AlaCartePizza {

  /**
   * Create a cheese pizza of the specified size with the specified crust.
   *
   * @param size  the size of this pizza
   * @param crust the crust of this pizza
   */
  public CheesePizza(Size size, Crust crust) {
    super(size, crust);
    this.toppings = getCheeseToppings();
  }

  protected CheesePizza(Size size, Crust crust, Map<ToppingName,
          ToppingPortion> toppings) {
    super(size, crust, toppings);
  }

  /**
   * Add cheese toppings to the pizza.
   */
  private static Map<ToppingName, ToppingPortion> getCheeseToppings() {
    Map<ToppingName, ToppingPortion> cheeseToppings = new HashMap<>();
    cheeseToppings.put(ToppingName.Cheese, ToppingPortion.Full);
    cheeseToppings.put(ToppingName.Sauce, ToppingPortion.Full);
    return cheeseToppings;
  }

  /**
   * This class represents a builder for a cheese pizza.
   */
  public static class CheesePizzaBuilder extends PizzaBuilder<CheesePizzaBuilder> {

    /**
     * Create a new CheesePizzaBuilder.
     */
    public CheesePizzaBuilder() {
      super();
      this.toppings = getCheeseToppings();
    }


    public CheesePizzaBuilder noCheese() {
      this.toppings.remove(ToppingName.Cheese);
      return returnBuilder();
    }

    public CheesePizzaBuilder leftHalfCheese() {
      this.toppings.put(ToppingName.Cheese, ToppingPortion.LeftHalf);
      return returnBuilder();
    }

    public CheesePizzaBuilder rightHalfCheese() {
      this.toppings.put(ToppingName.Cheese, ToppingPortion.RightHalf);
      return returnBuilder();
    }

    @Override
    public ObservablePizza build() {
      return new CheesePizza(this.size, this.crust, this.toppings);
    }

    @Override
    public CheesePizzaBuilder returnBuilder() {
      return this;
    }

  }
}

