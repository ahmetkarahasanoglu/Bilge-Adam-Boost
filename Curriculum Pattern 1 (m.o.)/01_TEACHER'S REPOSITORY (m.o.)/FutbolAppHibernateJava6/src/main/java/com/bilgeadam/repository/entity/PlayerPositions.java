package com.bilgeadam.repository.entity;

import lombok.Getter;

@Getter
public enum PlayerPositions {
    CB("Defans"), RB("Defans"), LB("Defans"), RWB("Defans"), LWB("Defans"),
    CM("Orta Saha"), CDM("Orta Saha"), CAM("Orta Saha"), RM("Orta Saha"), LM("Orta Saha"),
    ST("Forvet"), CF("Forvet"), RW("Forvet"), LW("Forvet"), GK("Kaleci");

    String area;

    PlayerPositions(String area) {
        this.area = area;
    }


}
