package com.bilgeadam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoController {


    @GetMapping("/getname") // ilk başta sayfanın yüklenmesi için @GetMapping kullanıyoz.
    public ModelAndView demo(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","mustafa");
        modelAndView.setViewName("demo"); // demo.html
        return modelAndView;
    }

}
