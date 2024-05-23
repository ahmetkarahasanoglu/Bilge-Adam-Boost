import java.util.Scanner;

public class Arrays2_Example {

	public static void main(String[] args) {
		
	/* User will input how many numbers he wants to enter. Sum up the 
	 * numbers and show the average value.
	 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter how many numbers you want to enter: ");
		int howMany = sc.nextInt();
		int[] numbersArr = new int[howMany];
		int total = 0;
		for(int i=0; i<howMany; i++) {
			System.out.print("Enter the " + (i+1) + ". number: ");
			numbersArr[i] = sc.nextInt();
			total += numbersArr[i];
		}
		System.out.println("Total: " + total);		
		System.out.println("Average: " + total/howMany);
		
		
		
		
	}
}
