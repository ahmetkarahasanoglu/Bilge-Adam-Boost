package com.ahmet;

public class OopTekrar {

	public static void main(String[] args) {
		
		Profile myProfile = new Profile();
		myProfile.username = "Ahmet";
		myProfile.postOlustur();
		System.out.println(myProfile.username + "-" + myProfile.postSayisi);
		
		Profile myProfile2 = new Profile();
		myProfile2.username = "Mehmet";
		System.out.println(myProfile2.username + "-" + myProfile2.postSayisi);
		
	}//main ends here

}//class ends here
