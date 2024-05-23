package com.ahmet.service;

import com.ahmet.repository.IMovieRepository;
import com.ahmet.repository.entity.Movie;
import com.ahmet.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService implements IServiceCrud<Movie>{

    private final IMovieRepository movieRepository;
    private final UserService userService; // bir servis başka bir servisi kullanabilir.

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> t) {
        return movieRepository.saveAll(t);
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> findAllByRatingGreaterThan(Double rate) {
        return movieRepository.findAllByRatingGreaterThan(rate);
    }

    public List<Movie> findAllByUsersGenres(Long userid) {
        Optional<User> user = userService.findById(userid);
        if(user.isPresent()) {
            List<Long> genres = user.get().getFavGenres();
            List<Movie> movies = movieRepository.findAll().stream().filter(x -> x.getGenres().stream().anyMatch(genres::contains)).collect(Collectors.toList()); // (genre::contains) yerine bence şunu yazabilirim: (genre -> genres.contains(genre.getId()))
            System.out.println(movies.size());      // '--> Sql Sorgusu (bilgi amaçlı): select DISTINCT(movie-id), user_id from movie_genres INNER JOIN user_fav_genres ON movie_genres.genres = user_fav_genres.fav_genres where user_id=2
            return movies;
        }else {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
    }

    public List<Movie> findAllByPremieredBefore(String date) {
        return movieRepository.findAllByPremieredBefore(LocalDate.parse(date));
    }

    public Object[] searchbyRating() {
        return movieRepository.searchbyRating();
    }

    public Object searchbyParticularRating(Double rating) {
        return movieRepository.searchbyParticularRating(rating);
    }

    public List<Movie> findAllByRatingIn(Double[] ratings) {
        return movieRepository.findAllByRatingIn(Arrays.asList(ratings));
    }

    public List<Movie> findAllByNameIn(List<String> names) {
        return movieRepository.findAllByNameIn(names);
    }

    public Object[] getNumberOfMoviesByEachCountry() {
        return movieRepository.getNumberOfMoviesByEachCountry();
    }

    public int countAllByRating(double rating) {
        return movieRepository.countAllByRating(rating);
    }

}
