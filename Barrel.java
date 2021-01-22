public class Barrel implements Attackable {
  private String name;
  private int health;

  public Barrel() {
    this.name = "Barrel";
    this.health = 20;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }

}