package com.ahmet;

import com.ahmet.repository.entity.*;
import com.ahmet.service.AddressService;
import com.ahmet.service.PersonelService;

import java.util.ArrayList;
import java.util.List;

public class PersonApplication {

    public static void main(String[] args) {

        List<Address> adresListesi = new ArrayList<>();
        adresListesi.add(Address.builder().city("Ankara").build());
        adresListesi.add(Address.builder().city("İstanbul").build());
        adresListesi.add(Address.builder().city("Bolu").build());
//        AddressService addressService = new AddressService();
//        addressService.saveAll(adresListesi);
        Car car = Car.builder().marka("Mercedes").build();
        Department department = Department.builder()
                .name("Muhasebe")
                .build();

        Person person = Person.builder()
                .age(56)
                .name("Muhammet")
                .gender(EGender.M)
                .addresses(adresListesi)
                .car(car)
                .department(department)
                .build();
        Person person2 = Person.builder()
                .age(56)
                .name("Ali")
                .gender(EGender.M)
                .department(department)
                .build();
        Person person3 = Person.builder()
                .age(56)
                .name("Deniz")
                .gender(EGender.F)
                .department(department)
                .build();
//        PersonelService personelService = new PersonelService();
//        personelService.save(person);
        // Yukarıdaki 2 satır, tek satır olarak da yazılabilir:
        new PersonelService().save(person);
        new PersonelService().save(person2);
        new PersonelService().save(person3);

        new PersonelService().findAll().forEach(System.out::println);

    }//MAIN ENDS HERE -----

}//CLASS ENDS HERE ----