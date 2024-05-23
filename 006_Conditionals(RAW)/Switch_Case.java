import java.util.Scanner;

public class Switch_Case {

	public static void main(String[] args) {
		
		/* ***** SWITCH-CASE *****
		 * switch(variable) {
		 * 	case [value]: code block; break;
		 * 	case [value]: code block; break;
		 * 	case [value]: code block; break;
		 * 	default: code;
		 * }
		 * */
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Giriş yapınız: 1) Toplama. 2) Çıkarma. 3) Çarpma. 4) Bölme");
		int option = scanner.nextInt();
		

		switch(option) {			
			case 1: System.out.println("Toplama"); break;
			case 2: System.out.println("Çıkarma"); break;
			case 3: System.out.println("Çarpma"); break;
			case 4: System.out.println("Bölme"); break;
			default: System.out.println("ÇIKIŞ YAPILDI.");
		}
		
		
		

		scanner.close();
	}
}
