package com.ahmet.controller;

import com.ahmet.dto.request.LoginRequestDto;
import com.ahmet.dto.request.RegisterRequestDto;
import com.ahmet.dto.response.LoginResponseDto;
import com.ahmet.dto.response.RegisterResponseDto;
import com.ahmet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage(String email)  { // parametre'deki email : register sayfasında girilen email'i; daha sonra login sayfasına yönlendirildiğinde url'de gösteriyo, o email'i url'den alıp login email input alanında otomatik görülmesini sağlamak için yazdık 'String email' parametre olarak.
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("email", email);
        modelAndView.setViewName("login"); // login.html'i getirecek. || Önce @GetMapping'le sayfayı getiriyoruz, ki sonra @PostMapping'le diğer işlemleri yapabilelim.
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(LoginRequestDto dto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            LoginResponseDto responseDto = userService.login(dto);
//            modelAndView.addObject("result", responseDto.getName() + " -- " + "Giriş Başarılı."); // Ahmet--Giriş Başarılı. ||| 'giriş başarılı' dememize gerek kalmadı; zaten içeri girip filmleri görcez.
            modelAndView.setViewName("redirect:/movie/findall"); // 'movies.html'e yönlendiriyo (giriş başarılı olduğunda) ||| Farklı bir controller'a gidildiği için ':'dan sonra '/' kullanmamız gerekiyor (redirect:/movie...)
        }catch(Exception e) {
            e.printStackTrace();
            modelAndView.addObject("result", e.getMessage());
            modelAndView.setViewName("login"); // (giriş başarısız olduğunda:) login.html
        }

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register"); // register.html'i getirecek. || Önce @GetMapping'le sayfayı getiriyoruz, ki sonra @PostMapping'le diğer işlemleri yapabilelim.
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(RegisterRequestDto dto) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.register(dto);
            modelAndView.addObject("email", dto.getEmail()); // url'nin sonuna email'in eklenmesini sağlıyor (aşağı satırda login'e redirect olduğunda) - http://localhost:9090/login?email=ahmet%40gmail.com
            modelAndView.setViewName("redirect:login"); // (giriş başarılı olduğunda) - Redirect her zaman GET ile çalışır (@GetMapping).
        }catch(Exception e) {
            modelAndView.addObject("error", e.getMessage());
            modelAndView.setViewName("register"); // (register başarısız olduğunda:)
        }
        return modelAndView;
    }
}
