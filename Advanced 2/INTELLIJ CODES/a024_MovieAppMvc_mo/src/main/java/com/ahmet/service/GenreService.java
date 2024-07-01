package com.ahmet.service;

import com.ahmet.repository.IGenreRepository;
import com.ahmet.repository.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService implements IServiceCrud<Genre> {

    private final IGenreRepository genreRepository;


    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Iterable<Genre> saveAll(Iterable<Genre> t) {
        return genreRepository.saveAll(t);
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    @Override
    public void delete(Genre genre) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    public List<Long> createGenresWithNames(List<String> genres) {
        List<Long> genreList = new ArrayList<>();
        for(String name : genres) {
            Optional<Genre> genre = genreRepository.findOptionalByName(name);
            if(genre.isPresent()) {
                genreList.add(genre.get().getId());
            }else {
                Genre myGenre = Genre.builder().name(name).build();
                save(myGenre);
                genreList.add(myGenre.getId());
            }
        }
        return genreList;
    }

    public String getGenreName(Long id) {  // genre'nin id'sini alıp ile genre'nin adını veren metot. (biz Movie sınıfında genre'lerin kendisini değil, sadece id'sini tutuyorduk. Bu metot vasıtasıyla adına ulaşıyoruz).
        return findById(id).get().getName();
    }

}
