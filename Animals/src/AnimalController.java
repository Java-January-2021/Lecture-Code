import java.util.ArrayList;

public class AnimalController {
	// Entry Point Method
	public static void main(String[] args) {
		Animal dog = new Animal("Buster", "Dog", 4, "white");
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
		myAnimals.add(dog);
		
		for(Animal a : myAnimals) {
			System.out.println(a.getSpecies());
		}
		
	}
}
