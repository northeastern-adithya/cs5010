import org.junit.Test;

import betterpizza.AlaCartePizza;
import betterpizza.ObservablePizza;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;

import static org.junit.Assert.assertEquals;


/**
 * The test class for pizza builder.
 */
public class PizzaBuilderTest {

  @Test
  public void testAlaCartePizza() {
    ObservablePizza alacarte = new AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Classic)
            .size(Size.Medium)
            .addTopping(ToppingName.Cheese, ToppingPortion.Full)
            .addTopping(ToppingName.Sauce, ToppingPortion.Full)
            .addTopping(ToppingName.GreenPepper, ToppingPortion.Full)
            .addTopping(ToppingName.Onion, ToppingPortion.Full)
            .addTopping(ToppingName.Jalapeno, ToppingPortion.LeftHalf)
            .build();

    assertEquals(ToppingPortion.Full, alacarte.hasTopping(ToppingName.Cheese));
  }
}
