package com.ahmet.repository;

import com.ahmet.repository.entity.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@Transactional  // hoca movie sınıfındaki Lob (large object)'ten kaynaklanan bir hata aldı: "Auto-commit biçiminde large object kullanılamaz" hatası. Gidermek için burda Repository'ye @Transactional yazdı.
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAllByRatingGreaterThan(Double rate); // Rating'i belli bir değer üzerinde olan movie'leri getirin.

    List<Movie> findAllByPremieredBefore(LocalDate date); // Girilen tarihten önce çıkmış filmleri listeleyen bir metot yazın.

    @Query("select rating, count(rating) from Movie group by rating order by rating desc")
    Object[] searchbyRating(); // Object[] kullanıyoruz, çünkü farklı tipler içeriyor: rating->Double, count->int  |||  Her bir rating'den kaç tane olduğunu ve o rating'i beraber getiriniz (rating ve o rating'den kaç tane olduğu şeklinde 2'li sonuçlar) (Query yazılacak).

    @Query("select rating, count(rating) from Movie group by rating having rating=:rating")
    Object searchbyParticularRating(@Param("rating") Double rating); // Belli bir Rating'deki bir filmden kaç tane olduğunu ve o rating'i beraber getiriniz (Query yazılacak).

    int countAllByRating(double rating); // 2.Yöntem - Belli bir Rating'deki bir filmden kaç tane olduğunu getiriniz (query'siz)

    List<Movie> findAllByRatingIn(List<Double> ratings); // Filmler içerisinde puanları 7,8,9 olan filmleri getiriniz.

    List<Movie> findAllByNameIn(List<String> names); // [film1, film2] ismine sahip filmleri getirin.

    @Query("select country, count(name) from Movie group by country")
    Object[] getNumberOfMoviesByEachCountry();// Her ülkede kaç film vardır (query).

}
