package com.ahmet.entity;

public class Tr implements IDil {

	@Override
	public String getHello() {
		return "HOŞ GELDİNİZ";
	}

	@Override
	public String getLogin1() {		
		return "Yeni Üye";
	}

	@Override
	public String getLogin2() {
		return "Üye Giriş";
	}

	@Override
	public String getLogin3() {
		return "Misafir";
	}

	@Override
	public String getLogin4() {
		return "Tanıtım";
	}

	@Override
	public String getStop() {
		return "PROGRAM SONLANDI";
	}
	
	

}
