package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Transactional // hoca movie sınıfındaki Lob (large object)'ten kaynaklanan bir hata aldı: "Auto-commit biçiminde large object kullanılamaz" hatası. Gidermek için burda Repository'ye @Transactional yazdı.
@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAllByRatingGreaterThan(double rate); // Rating'i belli bir değer üzerinde olan movie'leri getirin.

    List<Movie> findAllByPremiredBefore(LocalDate date); // Girilen tarihten önce çıkmış filmleri listeleyen bir metot yazın.
    List<Movie> findAllByPremiredBetween(LocalDate date,LocalDate nextDate);

    @Query("select rating,count(rating) from  Movie group by rating")
    Object [] searchbyRating(); // Object[] kullanıyoruz, çünkü farklı tipler içeriyor: rating->Double, count->int  |||  Her bir rating'den kaç tane olduğunu ve o rating'i beraber getiriniz (rating ve o rating'den kaç tane olduğu şeklinde 2'li sonuçlar) (Query yazılacak).
    @Query("select rating,count(rating) from  Movie group by rating having rating=?1")
    Object  searchbyRating(double rate); // Belli bir Rating'deki bir filmden kaç tane olduğunu ve o rating'i beraber getiriniz (Query yazılacak).

    List<Movie> findAllByRatingIn(List<Double> ratings); // Filmler içerisinde puanları 7,8,9 olan filmleri getiriniz.

    List<Movie> findAllByNameIn(String [] movieNames); // [film1, film2] ismine sahip filmleri getirin.

    int countAllByRating(double rating); // Belli bir Rating'deki bir filmden kaç tane olduğunu getiriniz (query'siz)

}
