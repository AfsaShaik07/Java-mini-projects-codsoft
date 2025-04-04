
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int totalRounds = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean numberGuessed = false;

            System.out.println("\nRound " + (totalRounds + 1) + ":");
            System.out.println("Guess a number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                totalAttempts++;
                attemptsLeft--;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please guess a number within the specified range.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    numberGuessed = true;
                    break;
                }
            }

            if (!numberGuessed) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
            }

            totalRounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total attempts made: " + totalAttempts);
        System.out.println("Average attempts per round: " + (totalRounds > 0 ? (double) totalAttempts / totalRounds : 0));

        scanner.close();
    }
}
