import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomGenerator = new Random();

        int totalPoints = 0;
        int gamesPlayed = 0;
        boolean keepPlaying = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (keepPlaying) {
            int secretNumber = randomGenerator.nextInt(100) + 1;
            int chancesLeft = 10;
            boolean guessedIt = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("Can you guess it? You have " + chancesLeft + " attempts.");

            while (chancesLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                try {
                    guess = input.nextInt();

                    if (guess == secretNumber) {
                        System.out.println("🎉 Congrats! You guessed the number!");
                        totalPoints += chancesLeft;
                        guessedIt = true;
                        break;
                    } else if (guess > secretNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }

                    chancesLeft--;
                    if (chancesLeft > 0) {
                        System.out.println("Chances left: " + chancesLeft);
                    } else {
                        System.out.println("Oh no! You are out of chances.");
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number only.");
                    input.next();
                }
            }

            if (!guessedIt) {
                System.out.println("The correct number was: " + secretNumber);
            }

            gamesPlayed++;
            System.out.println("Games played: " + gamesPlayed + " | Total points: " + totalPoints);

            System.out.print("Do you want to play another game? (yes/no): ");
            String answer = input.next().toLowerCase();
            keepPlaying = answer.equals("yes") || answer.equals("y");
        }

        System.out.println("\nThanks for playing the game!");
        System.out.println("Your final score: " + totalPoints + " | Games played: " + gamesPlayed);
        input.close();
    }
}
