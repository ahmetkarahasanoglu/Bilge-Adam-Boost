package com.ahmet.Java6MovieApp.controller;

import com.ahmet.Java6MovieApp.repository.entity.MovieComment;
import com.ahmet.Java6MovieApp.service.MovieCommentService;
import com.ahmet.Java6MovieApp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import static com.ahmet.Java6MovieApp.constants.EndPoints.*;

@RestController
@RequestMapping(MOVIECOMMENT)
@RequiredArgsConstructor
public class MovieCommentController {

    private final MovieCommentService movieCommentService;

    // Bir filme ait yorumları listeleyen bir metot yazınız.
    @GetMapping("/findallbymovieid")
    public ResponseEntity<List<MovieComment>> findAllByMovieId(Long movieId) {
        return ResponseEntity.ok(movieCommentService.findAllByMovieId(movieId));
    }

    // Bir kullanıcıya ait yorumları listeleyen bir metot yazınız.
    @GetMapping("/findallbyuserid")
    public ResponseEntity<List<MovieComment>> findAllByUserId(Long userId) {
        return ResponseEntity.ok(movieCommentService.findAllByUserId(userId));
    }

    // Verilen tarih aralıklarında belirli bir filme yapılmış olan yorumları gösteren bir metot yazınız.
    @GetMapping("/findallbymovieidanddatebetween")
    public ResponseEntity<List<MovieComment>> findAllByMovieIdAndDateBetween(Long movieId, String firstDate, String secondDate) {
        return ResponseEntity.ok(movieCommentService.findAllByMovieIdAndDateBetween(movieId, firstDate, secondDate));
    }

    // (repository'de query kullanarak) Verilen tarih aralıklarında belirli bir filme yapılmış olan yorumları gösteren bir metot yazınız.
    @GetMapping("/getallbymovieidanddatebetween")
    public ResponseEntity<List<MovieComment>> getAllByDateBetween(Long movieId, String firstDate, String secondDate) {
        return ResponseEntity.ok(movieCommentService.getAllByDateBetween(movieId, firstDate, secondDate));
    }
    // Bir kullanıcının belli tarihler aralığında yapmış olduğu yorumları gösteren metot yazınız.
    @GetMapping("/findallbyuseridanddatebetween")
    public ResponseEntity<List<MovieComment>> findAllByUserIdAndDateBetween(Long userId, String firstDate, String secondDate) {
        return ResponseEntity.ok(movieCommentService.findAllByUserIdAndDateBetween(userId, firstDate, secondDate));
    }

    // Yorumun içerisinde "çok güzel" geçenleri getiriniz.
    @GetMapping("/findallbycontentcontaining")
    public ResponseEntity<List<MovieComment>> findAllByContentContaining(String searchTerm) {
        return ResponseEntity.ok(movieCommentService.findAllByContentContaining(searchTerm));
    }

    // Yorumun uzunluğu 20 karakterden büyük olanları getiriniz.
    @GetMapping("/findallbycontentlengthgreaterthan")
    public List<MovieComment> getAllByContentLengthGreaterThan(Integer commentLength) {
        return movieCommentService.getAllByContentLengthGreaterThan(commentLength);
    }

}
