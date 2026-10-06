import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] var0) throws IOException {
      ArrayCollection<String> animals = new ArrayCollection<>(600);
      ArrayCollection<String> usedAnimals = new ArrayCollection<>(100);
      Scanner scanner = new Scanner(new File("Animals.txt"));

      while(scanner.hasNextLine()) {
         String line = scanner.nextLine().trim();
         if (!line.isEmpty()) {
            animals.add(line);
         }
      }
      scanner.close();
      
      Random random = new Random();
      char startingChar = (char)('A' + random.nextInt(26));
      int count = 0;
      String userInput;
      System.out.println("Name an animal starting with " + startingChar + ":");
      Scanner s = new Scanner(System.in);
      userInput = s.nextLine().trim();
      while (userInput.charAt(0) == startingChar && !usedAnimals.contains(userInput) && animals.contains(userInput)) {
         usedAnimals.add(userInput);
         ++count;
         System.out.println("Name another animal starting with " + startingChar + ":");
         userInput = s.nextLine().trim();
      }
      s.close();
      System.out.println("You named " + count + " animals starting with " + startingChar + ".");
   }
}

