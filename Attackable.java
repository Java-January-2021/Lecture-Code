public interface Attackable {
  // Attackable Things Must Have Health
  int getHealth();

  void setHealth(int health);

  void takeDamage(int damageAmount);
}