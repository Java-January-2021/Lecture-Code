public class FirstProgram {
  // Entry Point Method
  public static void main(String[] args) {
    // Variables
    byte myByte = 100; // stroes whole numbers from -128 to 127
    short myShort = 1000; // stores whole numbers from -32,768 to 32,767
    int myInt = 1000000; // stores whole numbers from -2,147,483,648 to 2,147,483,637
    long myLong = 1000000000; // Stores whole numbers from -9,223,372,036,854,775,808 to
                              // 9,223,372,036,854,775,807

    float myFloat = 3.124f; // stores fractional numbers, 6 to 7 decimal digits
    double myDouble = 3.123456; // stores fractional numbers up to 15 decimal digits

    boolean myBool = true; // true or false values
    char myChar = 'c'; // stores one character or ASCII value

    Character myChara = 'c';

    Integer myInte = 4;

    // Strings

    String myString = "Java January 2021";

    System.out.println(myString.length());

    String bootcamp = "Java";
    String bootCamp = "January";
    String bootCAMP = "2021";

    System.out.println(bootcamp + bootCamp + bootCAMP);

    // Operators and Conditionals
    int first = 1;
    int second = 1;

    System.out.println(first == second);

    String name = "Matt";
    String name2 = "Matt";

    System.out.println(name.equals(name2));

    int isOdd = 5;

    if (isOdd % 2 != 0) {
      System.out.println("Number is odd");
    } else {
      System.out.println("Number Is Not Odd");
    }

    // Loops

    // While
    int i = 0;
    while (i < 4) {
      System.out.println(i);
      i++;
    }

    // For Loop
    for (int index = 0; i < 4; index++) {
      System.out.println(index);
    }
    // Methods
    System.out.println(sayHello("Laura"));
    System.out.println(returnInt());
    sayHallelujah();
    mycountingApp();
  }

  public static String sayHello(String name) {
    return "Hello " + name;
  }

  public static int returnInt() {
    return 4;
  }

  public static void sayHallelujah() {
    System.out.println("Hallelujah!");
  }

  public static void mycountingApp() {
    for (int c = 0; c < 50; c++) {
      System.out.println(c);
    }
  }
}