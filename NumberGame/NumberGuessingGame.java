package NumberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 10;

        boolean playAgain = true;
        int totalRounds = 0;
        int totalWins = 0;

        System.out.println("=".repeat(50));
        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");
        System.out.println("=".repeat(50));

        while (playAgain) {
            totalRounds++;
            int targetNumber = rn.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasWon = false;

            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("A new number has been generated. Start guessing!");

            while (attemptsLeft > 0 && !hasWon) {
                System.out.print("Enter your guess (Attempts left: " + attemptsLeft + "): ");

                if (!sc.hasNextInt()) {
                    System.out.println("❌ Please enter a valid number.");
                    sc.next();
                    continue;
                }

                int userGuess = sc.nextInt();

                if (userGuess < MIN_NUMBER || userGuess > MAX_NUMBER) {
                    System.out.println("⚠️ Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                    continue;
                }

                if (userGuess == targetNumber) {
                    hasWon = true;
                    totalWins++;
                    System.out.println("🎉 Congratulations! You guessed the correct number: " + targetNumber);
                    System.out.println("You took " + (MAX_ATTEMPTS - attemptsLeft + 1) + " attempts.");
                } else if (userGuess < targetNumber) {
                    System.out.println("📉 Too Low! Try a higher number.");
                } else {
                    System.out.println("📈 Too High! Try a lower number.");
                }

                attemptsLeft--;

                if (attemptsLeft == 3 && !hasWon)
                    System.out.println("⚠️ Warning! Only 3 attempts left.");
                else if (attemptsLeft == 1 && !hasWon)
                    System.out.println("⚠️ Last Attempt! Make it count!");
            }

            if (!hasWon) {
                System.out.println("\n💔 Game Over! You've used all your attempts.");
                System.out.println("The correct number was: " + targetNumber);
            }

            System.out.println("\n📊 Your Statistics:");
            System.out.println("Rounds played: " + totalRounds);
            System.out.println("Rounds won: " + totalWins);
            System.out.println("Win rate: " + String.format("%.1f", (double) totalWins / totalRounds * 100) + "%");

            System.out.print("\nWould you like to play again? (yes/no): ");
            String playAgainInput = sc.next().trim().toLowerCase();

            if (!playAgainInput.equals("yes") && !playAgainInput.equals("y")) {
                playAgain = false;
                System.out.println("\nThank you for playing! Final Statistics:");
                System.out.println("Total rounds: " + totalRounds);
                System.out.println("Total wins: " + totalWins);
                System.out.println("Overall win rate: " + String.format("%.1f", (double) totalWins / totalRounds * 100) + "%");
                System.out.println("Goodbye! 👋");
            }
        }

        sc.close();
    }
}


