package com.ahmet;
import java.util.Random;
import java.util.Scanner;
// Kod Chat-Gpt'den.
public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(40) + 1; // Generates a random number between 1 and 40 inclusive
        int attempts = 5;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 40.");
        System.out.println("You have " + attempts + " attempts to guess it.");

        while (attempts > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You've guessed the correct number: " + randomNumber);
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Go higher.");
            } else {
                System.out.println("Go lower.");
            }

            attempts--;
            if (attempts > 0) {
                System.out.println("You have " + attempts + " attempts left.");
            } else {
                System.out.println("Sorry, you've run out of attempts. The number was: " + randomNumber);
            }
        }

        scanner.close();
    }
}
