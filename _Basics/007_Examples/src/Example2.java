import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		
		// Question: Find the greater number among the two numbers entered 
		// from the input.		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();
		System.out.print("Enter second number: ");
		int num2 = scanner.nextInt();
		
		if(num1 > num2) {
			System.out.println("The first number you entered (" + num1 + ") is greater.");
		}else if(num2 > num1) {
			System.out.println("The second number you entered (" + num2 + ") is greater.");
		}else {
			System.out.println("The numbers you entered are equal.");
		}
		System.out.println("----------------------------------------");
		// Question: Get how many numbers the users wants to enter as an
		// input. Get those numbers from the user as input. Find the 
		// greatest number among those numbers.
		System.out.print("How many numbers do you want to enter: ");
		int numberOfInputs = scanner.nextInt();
		
		int max = 0;
		System.out.println("Enter the numbers one by one:");
		for(int i=1; i<=numberOfInputs; i++) {
			int currentInput = scanner.nextInt();
			if(currentInput > max) {
				max = currentInput;
			}
		}
		System.out.println("The maximum number is: " + max);
	
		

		
		scanner.close();
	}
}
