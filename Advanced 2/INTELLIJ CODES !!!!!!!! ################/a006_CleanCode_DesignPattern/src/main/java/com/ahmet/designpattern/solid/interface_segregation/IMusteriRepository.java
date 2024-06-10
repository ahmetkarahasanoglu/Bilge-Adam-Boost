package com.ahmet.designpattern.solid.interface_segregation;

import java.util.List;

public interface IMusteriRepository extends IRepository{

    List<Object> findByMusteriNumber(Long mNumber); // Bu interface'de kullandığımız ek bir metot (ebeveyn interface'i miras alıyoruz, üzerine bu metodu ekliyoruz)
}
