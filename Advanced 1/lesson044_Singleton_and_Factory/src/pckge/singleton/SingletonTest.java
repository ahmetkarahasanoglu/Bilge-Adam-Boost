package pckge.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		
//		MyPostgreConnection myPostrgreConnection = new MyPostgreConnection() ;
//		MyPostgreConnection myPostrgreConnection2 = new MyPostgreConnection() ;
		// '--> *** constructor'ı public olduğu zaman istediğimiz kadar nesne üretebiliyoruz MyPostgreConnection sınıfından. Bu istemediğimiz bi şey. Singleton pattern kullanmamız lazım.
		
		System.out.println(MyPostgreConnection.getINSTANCE());
		System.out.println(MyPostgreConnection.getINSTANCE());
		
		// We can also use in this format:
		MyPostgreConnection myPostrgreConnection = MyPostgreConnection.getINSTANCE();
		System.out.println(myPostrgreConnection);
		
		
		
		
		
		
		
	}//MAIN ENDS HERE -----

}//CLASS ENDS HERE -----
