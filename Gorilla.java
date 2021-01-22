public class Gorilla extends Mammal {
  public Gorilla() {
    // directly call mammal constructor
    super("gorilla", 500);
  }

  public void eatBanana() {
    this.health += 5;
    System.out.printf("I am a %s eating a banana\n", this.species);
  }

  @Override
  public void takeDamage(int damageAmount) {
    this.health -= (damageAmount / 5);
  }
}