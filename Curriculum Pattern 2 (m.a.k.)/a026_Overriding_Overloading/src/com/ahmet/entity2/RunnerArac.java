package com.ahmet.entity2;

public class RunnerArac {

	public static void main(String[] args) {
		
		Ucak ucak = new Ucak();
		Araba araba = new Araba();
		
		araba.hizlan();
		ucak.hizlan();
		System.out.println("Uçak hızı....: " + ucak.hiz);
		System.out.println("Araba hızı...: " + araba.hiz);

	}

}
