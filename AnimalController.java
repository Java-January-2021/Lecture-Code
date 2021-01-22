public class AnimalController {
  // Entry Point Method
  public static void main(String[] args) {
    Animal wolf = new Animal("Wolf", 10, "howl");
    Animal gorilla = new Animal("Gorilla", 12, "Arroooooo");

    wolf.battle(gorilla, "bite");
    System.out.println("Target Animal's Health" + gorilla.getHealth());

    gorilla.battle(wolf, "punch");
    System.out.println("Target Animal's Health" + wolf.getHealth());

    wolf.battle(gorilla);
  }
}