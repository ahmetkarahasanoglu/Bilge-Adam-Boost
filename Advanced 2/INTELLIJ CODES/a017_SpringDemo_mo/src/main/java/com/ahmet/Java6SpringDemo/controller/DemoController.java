package com.ahmet.Java6SpringDemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ahmet.Java6SpringDemo.constants.EndPoints.*;

/**
 * 1- Endpoint yazacağız; bir metot yazalım, bu metot bize bir
 * string değer dönsün. Biz de bunu browser'da görüntüleyelim.
 * 2- İsim listesi dönen bir metot yazalım; isim listesini metot
 * içinde oluşturalım.
 */
@RestController
@RequestMapping(DEMO)
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/getname")
    public String getName() {
        return "Mustafa";
    }

    @GetMapping("/getname2")
    public String getName2(@RequestParam("q")String name) {
        return name;
    }

    @GetMapping("/getname3")
    public String getName3(String name) { //browser'da şunu yazarak 'name' girdisi yapabiliriz:  http://localhost:9092/demo/getname3?name=ahmet
        return "<style> .name{background-color:yellow; color:red;} </style>" +
                "<div class='name'> Mustafa </div>";
    }

    // http://localhost:9092/demo/getdata
    @GetMapping("/getdata")
    public ResponseEntity<String> getdata() {
        return ResponseEntity.ok("This is the string data.");
    }

    // http://localhost:9092/demo/getnamelist
    @GetMapping("/getnamelist")
    public ResponseEntity<List<String>> getnamelist() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Mehmet");
        nameList.add("Refik");
        nameList.add("Süleyman");
        return ResponseEntity.ok(nameList);
    }

    @GetMapping("/getnamelist2")
    public String[] getnamelist2(String[] namelist) {
        return namelist;
    }

    // http://localhost:9092/demo/getnamelist3
    @GetMapping("/getnamelist3")                 // Kullanıcıdan input olarak isim listesi alalım, onu geri dönelim browser'da.
    public ResponseEntity<List<String>> getnamelist3(@RequestParam("namelist") String nameList) {
        List<String> names = Arrays.asList(nameList.split(","));
        return ResponseEntity.ok(names);
    }

}
