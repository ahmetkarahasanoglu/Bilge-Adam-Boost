package com.ahmet;

import java.util.Random;

/*
 * id değeri tutacağız.
 * Kirli olup olmadığını tutan bir değişken tutacağız.
 * Rastgele 10 tane tabak üreteceğiz. (tabak nesnesi oluşurken
 * kirli veya temiz olması rastgele olacak).
 * Daha sonra temizleri bir stack içine alalım,
 * kirlileri başka bir stack içine alalım.
 * Metot işlemlerini tabak sınıfında değil de manager 
 * sınıfında yapabiliriz. 
 */

public class Tabak {
	
	private int id;
	private static int idForNewTabak = 1;
	private boolean isDirty;
	
	// CONSTRUCTOR:
	public Tabak() {
		super();
		this.id = idForNewTabak++;
		Random random = new Random();
		this.isDirty = random.nextBoolean();
	}

	// GETTERS AND SETTERS:
	public boolean getIsDirty() {
		return isDirty;
	}

	public void setIsDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

	public int getId() {
		return id;
	}
	
	
	
}
