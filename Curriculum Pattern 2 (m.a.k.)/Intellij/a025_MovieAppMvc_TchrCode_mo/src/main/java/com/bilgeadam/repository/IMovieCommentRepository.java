package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {


    List<MovieComment> findAllByMovieId(Long movieId); // Bir filme ait yorumları listeleyen bir metot yazınız:
    List<MovieComment> findAllByUserId(Long userId); // Bir kullanıcıya ait yorumları listeleyen bir metot yazınız.
    List<MovieComment> findAllByMovieIdAndDateBetween(Long movieId, LocalDate start,LocalDate end); // Verilen tarih aralıklarında belirli bir filme yapılmış olan yorumları gösteren bir metot yazınız.
    List<MovieComment> findAllByUserIdAndDateBetween(Long userId, LocalDate start,LocalDate end); // Bir kullanıcının belli tarihler aralığında yapmış olduğu yorumları gösteren metot yazınız.


}
