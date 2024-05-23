package com.ahmet.entity;

public class De implements IDil {

	@Override
	public String getHello() {
		return "WILKOMMEN";
	}

	@Override
	public String getLogin1() {		
		return "Anmelden";
	}

	@Override
	public String getLogin2() {
		return "Eintragen";
	}

	@Override
	public String getLogin3() {
		return "Gast";
	}

	@Override
	public String getLogin4() {
		return "Einführung";
	}

	@Override
	public String getStop() {
		return "PROGRAM BEENDET";
	}
	
	

}
