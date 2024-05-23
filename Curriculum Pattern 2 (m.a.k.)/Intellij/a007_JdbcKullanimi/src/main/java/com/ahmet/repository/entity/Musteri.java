package com.ahmet.repository.entity;

public class Musteri extends BaseEntity {
    private Long id;
    private String ad;
    private String soyad;
    private String email;
    private String telefon;
    private String cinsiyet;
    private Integer yas;

    // CONSTRUCTOR 1:
    public Musteri() {
    }

    // CONSTRUCTOR 2:
    public Musteri(Long id, String ad, String soyad, String email, String telefon, String cinsiyet, Integer yas, Long createdate, Long updatedate, int state) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.setCreatedate(createdate);
        this.setUpdatedate(updatedate);
        this.setState(state);
    }

    // GETTERS AND SETTERS:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    // METHODS: -----
    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", yas=" + yas +
                ", createdate=" + super.getCreatedate() +
                ", updatedate=" + super.getUpdatedate() +
                ", state=" + super.getState() +
                '}';
    }
}
