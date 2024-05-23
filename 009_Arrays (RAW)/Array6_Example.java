import java.util.Scanner;

public class Array6_Example {

	public static void main(String[] args) {
		
	/* Soru: Elimizde bir günler dizi olsun. Bu diziyi kullanarak 
	 * kullanıcıdan hangi günde olduğumuz bilgisi ve kaç gün sonra hangi 
	 * güne denk gelir bilgisini aldığımızda sonuç üretecek kodlamamyı 
	 * yazınız.
	 */
		String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		Scanner sc = new Scanner(System.in);
		System.out.print("Hangi günde olduğmuzu giriniz: ");
		String currentDay = sc.nextLine();
		System.out.print("Kaç gün sonra hangi güne denk gelir sorusunu bulmak için kaç gün sonrasını bulmak istersiniz: ");
		int howManyDaysLater = sc.nextInt();
		
		int currentDaysIndex = -1000; // just to initialize
		for(int i=0; i<days.length; i++) {
			if(days[i].equals(currentDay)) {
				currentDaysIndex = i;
			}
		}

		int newDaysIndex = ( (currentDaysIndex) + howManyDaysLater ) % 7 ;
		System.out.println("Denk gelen gün: " + days[newDaysIndex]);
	}
}
