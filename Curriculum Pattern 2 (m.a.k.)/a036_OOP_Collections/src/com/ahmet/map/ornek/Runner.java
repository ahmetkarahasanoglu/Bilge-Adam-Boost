package com.ahmet.map.ornek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		
		List<Departman> departmanListesi = new ArrayList<Departman>();
		departmanListesi.add(new Departman(1L, "Muhasebe"));
		departmanListesi.add(new Departman(2L, "İnsan Kaynakları"));
		departmanListesi.add(new Departman(3L, "Lojistik"));
		
		List<Personel> personelListesi = new ArrayList<Personel>();
		personelListesi.add(new Personel(200L, "Ahmet KUŞ", "0555 666 77 88", departmanListesi.get(2)));
		personelListesi.add(new Personel(201L, "Deniz BAŞ", "0555 666 77 88", departmanListesi.get(1)));
		personelListesi.add(new Personel(202L, "Taha VAR", "0555 666 77 88", departmanListesi.get(0)));
		personelListesi.add(new Personel(203L, "Kenan SEVEN", "0555 666 77 88", departmanListesi.get(0)));
		personelListesi.add(new Personel(204L, "Bahri TAŞ", "0555 666 77 88", departmanListesi.get(1)));
		personelListesi.add(new Personel(205L, "Tekin VARMAZ", "0555 666 77 88", departmanListesi.get(1)));
		personelListesi.add(new Personel(206L, "Duran PEK", "0555 666 77 88", departmanListesi.get(2)));
		personelListesi.add(new Personel(207L, "Hakkı BALA", "0555 666 77 88", departmanListesi.get(1)));
		personelListesi.add(new Personel(208L, "Emir SERÇE", "0555 666 77 88", departmanListesi.get(2)));
		personelListesi.add(new Personel(209L, "Fatih BAKAR", "0555 666 77 88", departmanListesi.get(0)));
		personelListesi.add(new Personel(210L, "Jale LEMAN", "0555 666 77 88", departmanListesi.get(2)));
				
		// Ben kişilerin listesini bir map içinde toplamak istiyorum.

		// --- Chat Gpt's Code: ---
//		Map<Departman, List<Personel>> gruplanmisListem = new HashMap<>();
//		for (int i = 0; i < personelListesi.size(); i++) {
//		    Personel personel = personelListesi.get(i);
//		    Departman departman = personel.getDepartman();
//
//		    // Check if the department is already in the map
//		    if (gruplanmisListem.containsKey(departman)) {
//		        // If yes, add the personel to the existing list
//		    	gruplanmisListem.get(departman).add(personel);
//		    } else {
//		        // If no, create a new list and put it in the map
//		        List<Personel> newPersonelList = new ArrayList<>();
//		        newPersonelList.add(personel);
//		        gruplanmisListem.put(departman, newPersonelList);
//		    }
//		}
//		gruplanmisListem.forEach((k, v) -> System.out.println(k + " --> " + v));

		
		Map<Departman, List<Personel>> gruplanmisListem = new HashMap<>();
		
		for(int i=0; i<departmanListesi.size(); i++) {
			/*
			 * Departman listesini döner; her bir i departman çekmek
			 * için kullanılır. 
			 * departmanListesi.get(0) -> 1. departmanı çeker. Muhasebe.
			 */			
			List<Personel> p = new ArrayList<Personel>();
			for(int j=0; j<personelListesi.size(); j++) {
				/*
				 * Mantık şu: personel listesi içinde hangi personelin
				 * muhasebe birimine ait olduğunu bulmak için ikinci 
				 * for'u kullanırız. 
				 * personelListesi.get(0)  -> 1. personeli verir.
				 */				
				if(personelListesi.get(j).getDepartman().equals(departmanListesi.get(i))) {
					/*
					 * Burada şunu sağlıyoruz: bir personelin bir departmanı
					 * içerdiği noktadayız. Burada ilgili departmanın map'in
					 * içinde olup olmadığına bakmamız gerekli.
					 */
					p.add(personelListesi.get(j));
				}
			}
			gruplanmisListem.put(departmanListesi.get(i), p);	
		}
		gruplanmisListem.forEach((k,v)-> System.out.println(k + " -> " + v));

		// *** Stream Api kullanarak listelerin dönüşümü sağlanabilir [Yukardakinin kısa yolu]:
		Map<Departman, List<Personel>> streamGrupListe;
		streamGrupListe = personelListesi.stream().collect(Collectors.groupingBy(Personel::getDepartman));
		System.out.println("- Stream Api İle Gruplanmış: ");
		streamGrupListe.forEach((k,v)->System.out.println(k + " -> " + v));
		
	}//MAIN ENDS HERE ------

}//CLASS ENDS HERE -----

