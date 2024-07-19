import java.util.Random;
import java.util.Scanner;

public class guessno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // Create an instance of Random
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;

        while (playAgain) {
            totalRounds++;
            int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int maxAttempts = 10;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + totalRounds + ": Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }

            totalAttempts += attempts;

            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! You played " + totalRounds + " rounds with a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}