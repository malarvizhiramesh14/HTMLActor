
import java.util.Random;
import java.util.Scanner;
public class GUessGame{
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("number Guessing game");
        System.out.println("choose the number:");
        System.out.println("1.easy 1-50 , 10 attempts)");


        System.out.println("2. medium 1-100,7 attempts)");
        System.out.println("3.high 1-200, 5 attempts)");

        int choice = scan.nextInt();

        int maxNumber = 100;
        int attempts = 7;

        switch (choice){
            case 1:
                maxNumber =50;
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
int target = random.nextInt(maxNumber)+1;
           boolean guessedCorrectly = false;

           while(attempts > 0){
            System.out.println("\nEnter your guess(1 to "+maxNumber+"):");

            int guess = scan.nextInt();

            if (guess == target){
                System.out.println("correct! YOU GUESSED THE NUMBER!");

                guessCorrectly = true;

                break;
            }else if (guess < target)
            {
                System.out.println("Too low");
            }else{
                 System.out.println("Too high");

            }
            attempts--;
            System.out.println("attempts left" + attempts);
           }

           if(!guessCorrectly){
              System.out.println("game over !The number was:" + target);

           }
           scan.close();
    }


}
