package com.ahmet.Java6MovieApp.service;

import com.ahmet.Java6MovieApp.repository.IMovieCommentRepository;
import com.ahmet.Java6MovieApp.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements IServiceCrud<MovieComment> {

    private final IMovieCommentRepository movieCommentRepository;


    @Override
    public MovieComment save(MovieComment movieComment) {
        return movieCommentRepository.save(movieComment);
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
        return movieCommentRepository.saveAll(t);
    }

    @Override
    public MovieComment update(MovieComment movieComment) {
        return null;
    }

    @Override
    public void delete(MovieComment movieComment) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<MovieComment> findAll() {
        return movieCommentRepository.findAll();
    }

    @Override
    public Optional<MovieComment> findById(Long id) {
        return movieCommentRepository.findById(id);
    }

    public List<MovieComment> findAllByMovieId(Long movieId) {
        return movieCommentRepository.findAllByMovieId(movieId);
    }

    public List<MovieComment> findAllByUserId(Long userId) {
        return movieCommentRepository.findAllByUserId(userId);
    }

    public List<MovieComment> findAllByMovieIdAndDateBetween(Long movieId, String firstDate, String secondDate) {
        LocalDate date1 = LocalDate.parse(firstDate);
        LocalDate date2 = LocalDate.parse(secondDate);
        return movieCommentRepository.findAllByMovieIdAndDateBetween(movieId, date1, date2);
    }

    public List<MovieComment> getAllByDateBetween(Long movieId, String firstDate, String secondDate) {
        LocalDate date1 = LocalDate.parse(firstDate);
        LocalDate date2 = LocalDate.parse(secondDate);
        return movieCommentRepository.getAllByDateBetween(movieId, date1, date2);
    }

    public List<MovieComment> findAllByUserIdAndDateBetween(Long userId, String firstDate, String secondDate) {
        LocalDate date1 = LocalDate.parse(firstDate);
        LocalDate date2 = LocalDate.parse(secondDate);
        return movieCommentRepository.findAllByUserIdAndDateBetween(userId, date1, date2);
    }

    public List<MovieComment> findAllByContentContaining(String searchTerm) {
        return movieCommentRepository.findAllByContentContaining(searchTerm);
    }

    public List<MovieComment> getAllByContentLengthGreaterThan(Integer commentLength) {
        return movieCommentRepository.getAllByContentLengthGreaterThan(commentLength);
    }

}