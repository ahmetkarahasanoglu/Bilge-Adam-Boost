
public class Arrays4_MultidimensionalArrays {

	public static void main(String[] args) {
		
		int[] numbersArray = new int[5]; // ex: {0,7,5,34,2}
		int[][] matrix = new int[3][2]; // ex: {{32,321,3}, {4,53,2}}
		String[][] sinifListesi = new String[13][3];
		
		// {"Ahmet", "Güçlü", "90"}
		// {"Ali", "Çevik", "85"}
		// {"Mehmet", "Sağlam", "75"}
		// {"Burak", "Tekin", "60"}
		// '--> String[4][3]
		
		// ------------------------------
		
		sinifListesi[0][0] = "Ahmet";
		sinifListesi[0][1] = "Güçlü";
		sinifListesi[0][2] = "90";
		
		sinifListesi[1][0] = "Ali";
		sinifListesi[1][1] = "Çevik";
		sinifListesi[1][2] = "85";		
		
		// -------------------------------
		
		System.out.println("AD    | SOYAD | NOT");
		for(int i=0; i<13; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(sinifListesi[i][j] + "\t");
			}
			System.out.println();
		}
		
		
	}
}
