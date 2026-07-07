import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    public static void main(String[] args) {

        Random random = new Random();

        // ✅ Try-with-resources (auto closes Scanner)
        try (Scanner scan = new Scanner(System.in)) {

            boolean playAgain = true;

            while (playAgain) {

                System.out.println("\n=== Number Guessing Game ===");
                System.out.println("Choose difficulty:");
                System.out.println("1. Easy (1-50, 10 attempts)");
                System.out.println("2. Medium (1-100, 7 attempts)");
                System.out.println("3. Hard (1-200, 5 attempts)");

                int choice = getValidInt(scan);

                int maxNumber;
                int attempts;

                // ✅ Rule switch (modern Java)
                switch (choice) {
                    case 1 -> {
                        maxNumber = 50;
                        attempts = 10;
                    }
                    case 2 -> {
                        maxNumber = 100;
                        attempts = 7;
                    }
                    case 3 -> {
                        maxNumber = 200;
                        attempts = 5;
                    }
                    default -> {
                        System.out.println("Invalid choice. Defaulting to medium.");
                        maxNumber = 100;
                        attempts = 7;
                    }
                }

                int target = random.nextInt(maxNumber) + 1;
                boolean guessedCorrectly = false;

                while (attempts > 0) {
                    System.out.print("\nEnter your guess (1 to " + maxNumber + "): ");

                    int guess = getValidInt(scan);

                    if (guess < 1 || guess > maxNumber) {
                        System.out.println("⚠ Enter a number within range!");
                        continue;
                    }

                    if (guess == target) {
                        System.out.println("✅ Correct! You guessed the number!");
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
                    System.out.println("❌ Game over! The number was: " + target);
                }

                System.out.print("\nDo you want to play again? (yes/no): ");
                String answer = scan.next().toLowerCase();
                playAgain = answer.equals("yes");
            }

            System.out.println("Thanks for playing!");
        }
    }

    public static int getValidInt(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.print("⚠ Invalid input. Enter a number: ");
            scan.next();
        }
        return scan.nextInt();
    }
}