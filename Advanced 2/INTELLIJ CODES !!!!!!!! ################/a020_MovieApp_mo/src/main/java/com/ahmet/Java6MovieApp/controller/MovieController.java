package com.ahmet.Java6MovieApp.controller;

import com.ahmet.Java6MovieApp.repository.entity.Movie;
import com.ahmet.Java6MovieApp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.ahmet.Java6MovieApp.constants.EndPoints.*;

@RestController
@RequestMapping(MOVIE)
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // Rating'i belli bir rating üzerinde olan movie'leri getirin.
    @GetMapping("/gtrating/{rate}")
    ResponseEntity<List<Movie>> findAllByRatingGreaterThan(@PathVariable Double rate) { // @PathVariable kullanılışı:  //localhost:9090/movie/gtrating/5 --> rating girişini 5 olarak yaptık mesela. Ve yukarı satırdaki URL'nin sonuna '/{rate}' yazdık. ||| @RequestParam kullansaydık: //localhost:9090/movie/gtrating?value=5
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(rate));
    }

    // Belirli bir kullanıcının ilgi alanlarını kapsayan filmleri getirin. ||| şu sorguyu yapan bir metot yazacaz:  select * from Movie where genres in(5,6,7)  gibi.
    @GetMapping("/findbyusersgenres/{userid}")
    public ResponseEntity<List<Movie>> findAllByUsersGenres(@PathVariable Long userid) {
        return ResponseEntity.ok(movieService.findAllByUsersGenres(userid));
    }

    // Girilen tarihten önce çıkmış filmleri listeleyen bir metot yazın.
    @GetMapping("/beforedate")
    public ResponseEntity<List<Movie>> findAllByPremieredBefore(@RequestParam(defaultValue = "2024-04-02") String date) {
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(date));
    }

    // Her bir rating'den kaç tane olduğunu ve o rating'i beraber getiriniz (rating ve o rating'den kaç tane olduğu şeklinde 2'li sonuçlar) (Query yazılacak).
    @GetMapping("/searchbyrating")
    public ResponseEntity<Object[]> searchbyRating() {
        return ResponseEntity.ok(movieService.searchbyRating());
    }

    // Belli bir Rating'deki bir filmden kaç tane olduğunu ve o rating'i beraber getiriniz (Query yazılacak).
    @GetMapping("/searchbyparticularrating")
    public ResponseEntity<Object> searchbyParticularRating(Double rating) {
        return ResponseEntity.ok(movieService.searchbyParticularRating(rating));
    }

    // 2.Yöntem - Belli bir Rating'deki bir filmden kaç tane olduğunu getiriniz (query'siz)
    @GetMapping("/searchbyparticularrating2")
    public int countAllByRating(@RequestParam double rating) {
        return movieService.countAllByRating(rating);
    }


    // Filmler içerisinde puanları 7,8,9 olan filmleri getiriniz.
    @GetMapping("/findallbyratingin")
    public List<Movie> findAllByRatingIn(Double[] ratings) {
        return movieService.findAllByRatingIn(ratings);
    }

    // [film1, film2] ismine sahip filmleri getirin.
    @GetMapping("/findbymovienames")
    public List<Movie> findAllByNameIn(@RequestParam List<String> names) {
        return movieService.findAllByNameIn(names);
    }

    // Her ülkede kaç film vardır (query yazınız).
    @GetMapping("/numberofmoviesbycountry")
    public ResponseEntity<Object[]> getNumberOfMoviesByEachCountry() {
        return ResponseEntity.ok(movieService.getNumberOfMoviesByEachCountry());
    }


}
