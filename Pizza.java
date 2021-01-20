import java.util.Arrays;

public class Pizza {
  // Attributes Pizzas Have
  // Access Modifiers
  private String type;
  private String[] toppings;
  private String size;
  private int slices;

  // Constructor
  public Pizza(String type, String[] toppings, String size, int slices) {
    this.type = type;
    this.toppings = toppings;
    this.size = size;
    this.slices = slices;
  }

  // Method Overloading
  public Pizza(String type, String[] toppings) {
    this.type = type;
    this.toppings = toppings;
    this.size = "XL";
    this.slices = 16;
  }

  // Getters
  public String getType() {
    return this.type;
  }

  public String[] getToppings() {
    return this.toppings;
  }

  public String getSize() {
    return this.size;
  }

  public int getSlices() {
    return this.slices;
  }

  // Setters
  public void setType(String type) {
    if (type.equals("")) {
      System.out.println("Type Not Recgoznied");
      return;
    }
    this.type = type;
  }

  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  // Methods
  // Display Pizza
  public String displayPizza() {
    return "This is a " + this.type + " Pizza " + "with " + Arrays.toString(this.toppings);
  }

  public int eatSlice(int slices) {
    System.out.println("You have eaten " + slices + " slices of " + this.type + " pizza");
    this.slices = this.slices - slices;
    return this.slices;
  }

  // Overloaded Method
  public void eatSlice() {
    this.slices = this.slices - 1;
  }

  public static void advertise() {
    System.out.println("Come To James and Camerons for the best pizza around! Instructor Matt eats free");
  }

  // Method interacting with Other Object
  public void pizzaFight(Pizza otherPizza) {
    int otherSlices = otherPizza.getSlices();
    otherPizza.setSlices(otherSlices -= 1);
    System.out.println(this.type + " knocked " + otherPizza.getType() + " block off and they are missing one slice");

  }

}