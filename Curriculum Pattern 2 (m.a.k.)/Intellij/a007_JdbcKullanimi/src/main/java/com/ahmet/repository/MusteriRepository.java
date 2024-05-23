package com.ahmet.repository;

import com.ahmet.repository.entity.Musteri;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


public class MusteriRepository implements ICrud<Musteri> {

    private String SQL = "";
    private ConnectionProvider provider; // 'ConnectionProvider' (bağlantı sağlayıcısı) sınıfımızdan bir referans tanımladık burda.

    // CONSTRUCTOR:
    public MusteriRepository() {
        this.provider = new ConnectionProvider(); // constructor'da new'ledik. Çünkü bu class oluşur oluşmaz bir connection provider'a ihtiyacımız var; amacımız veritabanına bağlanmak
    }

    // METHODS: ----
    @Override
    public void save(Musteri musteri) {  // in this method, we're inserting a row of data to a table in database.
        SQL = "insert into tblmusteri(ad, soyad, email, telefon, cinsiyet, yas) " +
                "values('"+musteri.getAd()+"','"+musteri.getSoyad()+"','"+musteri.getEmail()+"','"+musteri.getTelefon()+"','"+musteri.getCinsiyet()+"',"+musteri.getYas()+")"; // -> sondaki yaş sayısal bir değer olduğu için tek tırnak kullanmaya gerek yok orda.
        provider.executeQuery(SQL);
    }

    @Override
    public void update(Musteri musteri) {
        SQL = "update tblmusteri set ad='"+musteri.getAd()+"', " +
                "soyad='"+musteri.getSoyad()+"', " +
                "email='"+musteri.getEmail()+"', " +
                "telefon='"+musteri.getTelefon()+"', " +
                "cinsiyet='"+musteri.getCinsiyet()+"', " +
                "yas=" + musteri.getYas() +
                " where id=" + musteri.getId(); // where'in soluna bi tane boşluk karakteri koyduk, bitişik olmasın diye.
        provider.executeQuery(SQL);
    }

    @Override
    public void delete(Long id) {
        SQL = "delete from tblmusteri where id=" + id;
        provider.executeQuery(SQL);
    }

    @Override
    public List<Musteri> findAll() {
        SQL = "select * from tblmusteri";
        Optional<ResultSet> resultSet = provider.getAllData(SQL);
        if(resultSet.isEmpty()) {
            return new ArrayList<>(); // boş bir arraylist döneriz.
        }
        List<Musteri> musteriListesi = new ArrayList<>();
        try{
            while(resultSet.get().next()) { // gelen resultSet içindeki tabloyu satır satır okuyoruz.
                Long id = resultSet.get().getLong("id");
                String ad = resultSet.get().getString("ad");
                String soyad = resultSet.get().getString("soyad");
                String email = resultSet.get().getString("email");
                String telefon = resultSet.get().getString("telefon");
                String cinsiyet = resultSet.get().getString("cinsiyet");
                Integer yas = resultSet.get().getInt("yas");
                Long createdate = resultSet.get().getLong("createdate");
                Long updatedate = resultSet.get().getLong("updatedate");
                Integer state = resultSet.get().getInt("state");
                musteriListesi.add(new Musteri(id, ad, soyad, email, telefon, cinsiyet, yas, createdate, updatedate, state));
                // '--> Bir müşteri nesnesi oluşturup müşteriListesi'nin içine atacak her bir döngüde.
            }
            return musteriListesi;
        }catch(Exception exception) {

        }

        return new ArrayList<>();
    }

    @Override
    public Musteri findById(Long id) {
        SQL = "select * from tblmusteri where id=" +id;
        Optional<ResultSet> resultSet = provider.getAllData(SQL);
        if(resultSet.isEmpty()) {
            return new Musteri(); // boş bir Müşteri objesi döneriz.
        }
        try{
            while(resultSet.get().next()) { // burda gelen veri zaten 1 satır. Biz satır satır okuma yöntemiyle okuyoz.
                String ad = resultSet.get().getString("ad");
                String soyad = resultSet.get().getString("soyad");
                String email = resultSet.get().getString("email");
                String telefon = resultSet.get().getString("telefon");
                String cinsiyet = resultSet.get().getString("cinsiyet");
                Integer yas = resultSet.get().getInt("yas");
                Long createdate = resultSet.get().getLong("createdate");
                Long updatedate = resultSet.get().getLong("updatedate");
                Integer state = resultSet.get().getInt("state");
                return new Musteri(id, ad, soyad, email, telefon, cinsiyet, yas, createdate, updatedate, state);
            }
        }catch(Exception exception) {

        }
        return new Musteri(); // boş müşteri objesi döneriz (veritabanından veri alınamamışsa)
    }

    @Override
    public List<Musteri> findByAny(String findKey) {
        return null;
    }
}
