package com.ahmet.Monolitik.controllermvc;

import com.ahmet.Monolitik.repository.entity.Musteri;
import com.ahmet.Monolitik.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginMvcController {

private final MusteriService musteriService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(String user, String password) {
        System.out.println("user....: " + user);
        System.out.println("passw...: " + password);
        if(musteriService.doLogin(user, password))
            return new ModelAndView("redirect:/musteri");
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(String name, String username, String password, String email, String confirm) {
            musteriService.save(Musteri.builder()
                .ad(name)
                .password(password)
                .email(email)
                .build());
        return new ModelAndView("login");
    }

}
