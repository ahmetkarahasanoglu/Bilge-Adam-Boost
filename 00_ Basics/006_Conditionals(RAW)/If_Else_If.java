import java.util.Scanner;

public class If_Else_If {

	public static void main(String[] args) {
		
		// Question: Take the birthyear of the user as an input. Current 
		// year is 2023. Print if the user is "younger than 18 years old" 
		// or "18 years old or older".

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your birth year: ");
		int birthYear = scanner.nextInt();
		int currentYear = 2023;
		if(currentYear - birthYear >= 18) {
			System.out.println("You are 18 years old or older.");
		}else {
			System.out.println("You are younger than 18 years old.");
		}

		System.out.println("-----------------------------------------");
		// Question: Hold a number. User will guess. User has 3 attempts.
		int targetNumber = 7;
		int attempts = 3;
		System.out.print("Let's play a number guessing game. ");
		do{
			System.out.print("Hold a number: ");
			int usersGuess = scanner.nextInt();
			if(usersGuess != targetNumber) {
				attempts--;
				System.out.println("Sorry, that's not the number I held. Attempts left: " + attempts);
				if (attempts == 0) {
					System.out.println("You lost.");
				}
			}else {
				System.out.println("You guessed right. Target number was " + targetNumber);
				break;
			}
		}while(attempts>0);		
		
		
		
		scanner.close();
	}

}
