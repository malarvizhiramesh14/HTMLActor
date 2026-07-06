
import java.util.Random;
import java.util.Scanner;

public class GUSEE {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("Number Guessing Game");
        System.out.println("Choose the difficulty:");
        System.out.println("1. Easy (1-50, 10 attempts)");
        System.out.println("2. Medium (1-100, 7 attempts)");
        System.out.println("3. Hard (1-200, 5 attempts)");

        int choice = scan.nextInt();

        int maxNumber = 100;
        int attempts = 7;

        switch (choice) {
            case 1:
                maxNumber = 50;
                attempts = 10;
                break;
            case 2:
                maxNumber = 100;
                attempts = 7;
                break;
            case 3:
                maxNumber = 200;
                attempts = 5;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to medium.");
        }

        int target = random.nextInt(maxNumber) + 1;
        boolean guessedCorrectly = false;

        while (attempts > 0) {
            System.out.println("\nEnter your guess (1 to " + maxNumber + "):");

            int guess = scan.nextInt();

            if (guess == target) {
                System.out.println("Correct! You guessed the number!");
                guessedCorrectly = true;
                break;
            } else if (guess < target) {
                System.out.println("Too low");
            } else {
                System.out.println("Too high");
            }

            attempts--;
            System.out.println("Attempts left: " + attempts);
        }

        if (!guessedCorrectly) {
            System.out.println("Game over! The number was: " + target);
        }

        scan.close();
    }
}