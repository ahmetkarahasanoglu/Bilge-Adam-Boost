package com.ahmet.repository;

import com.ahmet.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {

    List<MovieComment> findAllByMovieId(Long movieId); // Bir filme ait yorumları listeleyen bir metot yazınız.
    List<MovieComment> findAllByUserId(Long userId); // Bir kullanıcıya ait yorumları listeleyen bir metot yazınız.

    // Metodu yazınız: Verilen tarih aralıklarında belirli bir filme yapılmış olan yorumları gösteren bir metot yazınız.
    List<MovieComment> findAllByMovieIdAndDateBetween(Long movieId, LocalDate firstDate, LocalDate secondDate);
    // Yukarıdakini query ile yazdım:
    @Query("select m from MovieComment m where m.movieId=:movieId and (m.date between :firstDate and :secondDate)")
    List<MovieComment> getAllByDateBetween(@Param("movieId") Long movieId, @Param("firstDate") LocalDate firstDate, @Param("secondDate") LocalDate secondDate);

    // Bir kullanıcının belli tarihler aralığında yapmış olduğu yorumları gösteren metot yazınız.
    List<MovieComment> findAllByUserIdAndDateBetween(Long userId, LocalDate firstDate, LocalDate secondDate);

    // Yorumun içerisinde "çok güzel" geçenleri getiriniz.
    List<MovieComment> findAllByContentContaining(String searchTerm);

    // Yorumun uzunluğu 20 karakterden büyük olanları getiriniz.
    @Query("select m from MovieComment m where length(m.content)>:commentLength")
    List<MovieComment> getAllByContentLengthGreaterThan(@Param("commentLength") Integer commentLength);
}
