package com.ahmet.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunnerMapList {

	public static void main(String[] args) {
		/*
		 * MapList
		 * - Key = String
		 * - Values = List<String>
		 *   K=günler, V={pazartesi, salı, çarşamba}
		 */
		Map<String, List<String>> tarihler = new HashMap();
		List<String> gunler = Arrays.asList("Monday", "Tuesday",  // creating a list with elements in a short way. 
				"Wednesday", "Thursday", "Friday", "Saturday", 
				"Sunday");
		List<String> aylar = List.of("January", "February", 
				"March", "April", "May", "June", "July", 
				"August", "September", "October", "November", 
				"December");
		List<String> mevsimler = Arrays.asList("Winter", 
				"Spring", "Summer", "Autumn");
		
		tarihler.put("günler", gunler);
		tarihler.put("aylar", aylar);
		tarihler.put("mevsimler", mevsimler);
		
		System.out.println("5. gün.....: " + tarihler.get("günler").get(4) );
		
		
	}//main ends here

}//class ends here
