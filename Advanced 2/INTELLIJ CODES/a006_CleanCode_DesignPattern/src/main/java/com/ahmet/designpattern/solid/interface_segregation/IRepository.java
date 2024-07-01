package com.ahmet.designpattern.solid.interface_segregation;

import java.util.List;

/**
 * Oluşturduğumuz bu genel interface, diğer interface'lerde bulunan
 * ortak metotları içeriyor. Diğer interface'ler bu interface'i
 * miras alacak (extend edecek)
 */
public interface IRepository {
    void save(Object entity);
    void update(Object entity);
    void delete(Object entity);
    List<Object> findAll();
}
