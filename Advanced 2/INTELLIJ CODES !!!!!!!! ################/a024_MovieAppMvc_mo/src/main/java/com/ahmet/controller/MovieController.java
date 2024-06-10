package com.ahmet.controller;

import com.ahmet.repository.entity.Movie;
import com.ahmet.repository.entity.User;
import com.ahmet.service.GenreService;
import com.ahmet.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;

    @GetMapping("/findall")
    public ModelAndView getMoviePage(Long userId) {  // KODUN TAMAMLANMIŞ HALİ ÖĞRETMENİN KODUNDA: MovieAppMvc_TchrCode_mo
        User user = new User();
        List<Movie> movieList = movieService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("movies", movieList);
        modelAndView.addObject("genreservice", genreService); // genreService'i gönderiyoruz movies.html'e
        modelAndView.addObject("user", user);
        modelAndView.setViewName("movies"); // movies.html
        return modelAndView;
    }

}
