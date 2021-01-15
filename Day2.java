import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    // Strings Clarification
    String name = "Edgar";
    String name2 = "Edgar";

    String name3 = new String("Edgar");
    String name4 = new String("Edgar");

    // Edgar's Tip -- Remember This!
    System.out.println(name3.equals(name4));

    // Arrays
    String[] people;

    String[] people2 = { "Matthew", "Edgar", "Laura", "Thomas", "Libo" };
    people2[0] = "Makarand";

    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }

    for (int j = 0; j < numbers.length; j++) {
      System.out.println(numbers[j]);
    }
    System.out.println(Arrays.toString(numbers));

    ArrayList<String> StringList = new ArrayList<String>();
    StringList.add("one");
    StringList.add("two");
    StringList.add("three");
    StringList.add("four");
    StringList.add("five");

    // Length / Size()
    // Starts From 1

    // Index
    // Always Starts From 0

    String name9 = "James";

    System.out.println(StringList);
    System.out.println(StringList.contains("Thomas"));
    for (String number : StringList) {
      System.out.println(number);
    }

    System.out.println(StringList.size());

    // HashMaps
    HashMap<String, String> ourHobbies = new HashMap<String, String>();
    ourHobbies.put("Matthew", "Photography");
    ourHobbies.put("Laura", "Sewing");
    ourHobbies.put("Tony", "Hockey");
    ourHobbies.put("Kevin", "Soccer");
    ourHobbies.put("Teresa", "Reading");
    ourHobbies.put("Victoria", "Comics");
    ourHobbies.put("Edgar", "Hiking/Biking");
    ourHobbies.put("Robert", "Gaming");
    ourHobbies.put("Thomas", "Movies");
    ourHobbies.put("James", "Art");
    ourHobbies.put("Michael", "DND");

    System.out.println(ourHobbies);

    for (String pumpkin : ourHobbies.values()) {
      System.out.println(pumpkin);
    }

    System.out.println(maxArrayValue(numbers));

    System.out.println("Were still here!");
  }

  public static int maxArrayValue(int[] nums) {
    // Take in an array consisting of array int
    // Create max value and assign it to the first index of array
    // loop through array, and if number is greater than max, replace max
    // return max.
    int maxValue = nums[0];
    for (int i = 1; i <= nums.length; i++) {
      try {
        if (nums[i] > maxValue) {
          maxValue = nums[i];
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    return maxValue;
  }
}