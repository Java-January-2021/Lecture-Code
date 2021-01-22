public class Animal {
  private String name;
  private int strength;
  private int health;
  private String sound;

  // Constructor
  public Animal(String name, int strength, String sound) {
    this.name = name;
    this.strength = strength;
    this.health = 100;
    this.sound = sound;
  }

  // Getters and Setters
  public String getName() {
    return this.name;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getHealth() {
    return this.health;
  }

  public String getSound() {
    return this.sound;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  // Attacks Another Animal
  public void battle(Animal target, String powerMove) {
    // Define the logic of how an animal attacks
    int damage;
    if (powerMove.equals("bite")) {
      damage = 5;
    } else if (powerMove.equals("pounce")) {
      damage = 3;
    } else if (powerMove.equals("claw")) {
      damage = 4;
    } else if (powerMove.equals("Banana Peel Slap")) {
      damage = 6;
    } else {
      System.out.println("Move Not Recognized");
      return;
    }

    // Multiply the damage x strength
    int effectiveDamage = this.strength * damage;

    // Reduce the target's health by the effectiveDamage
    int targetHealth = target.getHealth();
    target.setHealth(targetHealth -= effectiveDamage);

    // print to the console what just happened using a formatted string
    System.out.printf("%s attacks %s for %d health points\n", this.name, target.getName(), effectiveDamage);
  }

  public void battle(Animal target) {
    battle(target, "bite");
  }
}