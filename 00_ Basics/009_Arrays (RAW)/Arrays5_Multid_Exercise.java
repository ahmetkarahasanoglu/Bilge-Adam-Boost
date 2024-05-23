import java.util.Scanner;

public class Arrays5_Multid_Exercise {

	public static void main(String[] args) {
		
		// ÖĞRENCİ NOT GİRME - GÖRÜNTÜLEME PROGRAMI		
		
		Scanner sc = new Scanner(System.in);		
		int ogrenciSayisi = 0;
		int ozellikSayisi = 0;
		String[][] sinif = null;
		
		while(true) {  // I could also use:  int choice=0;  do{.....}while(secim!=0)
			System.out.println();
			System.out.println("**************************");
			System.out.println("*****  OKUL OTOMASYON  ***");
			System.out.println("**************************");
			System.out.println();
			System.out.println("--MENÜ-- Seçim Yapınız: ");
			System.out.println();
			System.out.println("1) Sınıf Tanımlama");
			System.out.println("2) Öğrenci Ekleme");
			System.out.println("3) Not Girme");
			System.out.println("4) Sınıf Listesi Görüntüleme");
			System.out.println("0) Ç I K I Ş");
			System.out.println();
			
			int choice = sc.nextInt();
			sc.nextLine(); // dummy input. to solve bug of java. 
			
			switch(choice) {
				case 1:					
					System.out.print("Kaç kişilik sınıf tanımlamak istediğinizi giriniz: ");
					ogrenciSayisi = sc.nextInt();					
					System.out.print("Kaç özellik tanımlamak istediğinizi giriniz: ");
					ozellikSayisi = sc.nextInt();
					sc.nextLine(); // dummy input. to solve bug of java. 
					sinif = new String[ogrenciSayisi][ozellikSayisi];
					System.out.println("--- " + ogrenciSayisi + " kişilik, " + ozellikSayisi + " özelliğe sahip sınıf oluşturuldu.");
					break;
				case 2:
					if(ogrenciSayisi==0 || ozellikSayisi==0) {
						System.out.println("Önce sınıf tanımlamasını yapınız.");
					}else {
						for(int i=0; i<ogrenciSayisi; i++) {						
							System.out.print("Öğrenci isim-soyisim girişi yapınız (" + (i+1) + " of " + ogrenciSayisi + "): ");
							String ogrenci = sc.nextLine();
							sinif[i][0] = ogrenci;						
						}
						System.out.println("---Girdiğiniz öğrenciler oluşturuldu.---");
						
					}	
					break;
				case 3:
					if(ogrenciSayisi==0 || ozellikSayisi==0) {
						System.out.println("Önce sınıf tanımlamasını yapınız.");
					}else {
						for(int i=0; i<ogrenciSayisi; i++) {				
							System.out.print("Matematik dersi not girişi yapınız; for " + sinif[i][0] + " (öğrenci " + (i+1) + " of " + ogrenciSayisi + "): ");
							String matNotu = sc.nextLine();
							sinif[i][1] = matNotu;			
							System.out.print("Türkçe dersi not girişi yapınız; for " + sinif[i][0] + " (öğrenci " + (i+1) + " of " + ogrenciSayisi + "): ");
							String turkceNotu = sc.nextLine();
							sinif[i][2] = turkceNotu;												
						}
						System.out.println("---Girdiğiniz notlar kaydedildi.---");
					}					
					break;
				case 4:
					if(ogrenciSayisi==0 || ozellikSayisi==0) {
						System.out.println("Önce sınıf tanımlamasını yapınız.");
					}else {
						System.out.println(" AD-SOYAD   |  MAT.NOTU  | TÜRKÇE NOTU ");
						for(int i=0; i<ogrenciSayisi; i++) {
							for(int j=0; j<ozellikSayisi; j++) {
								System.out.print(sinif[i][j] + "    ");					
							}
							System.out.println();
						}
					}					
					break;
				case 0:
					System.out.println("Çıkış yapılıyor.");
					return; // terminates the main() method.
//					System.exit(0); // or we could have also used this to terminate the whole Java Virtual Machine.
				default:
					System.out.println("Geçersiz seçim!");
					break;
			}	
		}		
		
		
		
		
	}
}
