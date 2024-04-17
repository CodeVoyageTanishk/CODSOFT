mport java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        
        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            int lowerBound = 1;
            int upperBound = 100;
            int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("I've selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (!guessedCorrectly && attempts >= 5) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + secretNumber + ".");
                    break;
                }
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}