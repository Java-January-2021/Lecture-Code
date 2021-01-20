import java.util.Arrays;

public class PizzaTester {
  // Entry Point Method
  public static void main(String[] args) {
    // Pizza myPizza = new Pizza();
    // myPizza.type = "Pepperoni";
    String[] toppings = { "cheese", "pepperoni" };
    // myPizza.toppings = toppings;
    // myPizza.size = "Large";
    // myPizza.slices = 12;
    // System.out.printf("This is a %s pizza with %d slices\n", myPizza.type,
    // myPizza.slices);

    Pizza myPizza = new Pizza("Pepperoni", toppings, "L", 12);
    System.out.println(myPizza.displayPizza());
    myPizza.eatSlice(2);
    System.out.println(myPizza.getSlices());

    Pizza meatLovers = new Pizza("Meat Lovers", new String[] { "Pepperoni", "Sasuage", "steak", "Venison" }, "XL", 12);

    meatLovers.pizzaFight(myPizza);
    System.out.println(myPizza.getSlices());

    Pizza vegetarian = new Pizza("Vegetarian", new String[] { "spinach", "onion", "bell pepper", "pineapple" });
    vegetarian.eatSlice();
  }
}