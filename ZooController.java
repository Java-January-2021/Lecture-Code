import java.util.ArrayList;

public class ZooController {
  public static void main(String[] args) {
    Mammal matthew = new Mammal("human", 100);
    Gorilla dk = new Gorilla();

    ArrayList<Mammal> mammals = new ArrayList<Mammal>();
    mammals.add(matthew);
    mammals.add(dk);

    dk.eatBanana();
    System.out.println(dk.getHealth());

    Barrel barrel1 = new Barrel();

    matthew.attack(barrel1);
    System.out.println(dk.getHealth());
  }
}