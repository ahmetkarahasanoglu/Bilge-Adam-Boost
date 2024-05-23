package com.ahmet.Monolitik.controllermvc;

import com.ahmet.Monolitik.models.MusteriModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProjeMvcController {

    /**
     * http://localhost/musteri
     * @return
     */
    @GetMapping("/musteri")
    public ModelAndView musteriList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("musteri"); // 'musteri': template klasörünün altındaki 'musteri.html' dosyasının ismi.
//        modelAndView.addObject("baslik", "1. Yeni Müşteriler");
//        List<String> musteriler = Arrays.asList("Ahmet", "Canan", "Gülşen", "Emin", "Deniz");
//        modelAndView.addObject("liste", musteriler);
//        for(String item : musteriler) {
//            System.out.println(item);
//        }
//        return modelAndView;

        MusteriModel model = MusteriModel.builder()
                            .baslik("Müşteri İşlemleri")
                            .adres("Ankarada bir yer")
                            .menulistesi(Arrays.asList("Müşteri", "Urun", "Satış"))
                            .musterilistesi(Arrays.asList("Muhammet","Deniz","Hakan"))
                            .build();
        modelAndView.addObject("model", model);
        return modelAndView;
    }

}
