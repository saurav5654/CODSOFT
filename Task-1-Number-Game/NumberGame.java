import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            playGame(scanner);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("\nThanks for playing! ");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
        int attemptsLeft = MAX_ATTEMPTS;
        boolean isGuessed = false;

        System.out.println("\nI have selected a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts. Good luck!\n");

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            attemptsLeft--;

            if (guess == targetNumber) {
                System.out.println("Correct! You guessed the number.");
                System.out.println("Score: " + (attemptsLeft + 1) * 10);
                isGuessed = true;
                break;
            } else if (guess > targetNumber) {
                System.out.println("⬇ Too high! Attempts left: " + attemptsLeft);
            } else {
                System.out.println("⬆ Too low! Attempts left: " + attemptsLeft);
            }
        }

        if (!isGuessed) {
            System.out.println("You ran out of attempts.");
            System.out.println("The correct number was: " + targetNumber);
        }
    }
}
