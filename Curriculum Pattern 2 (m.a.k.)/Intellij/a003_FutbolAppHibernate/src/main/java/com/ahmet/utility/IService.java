package com.ahmet.utility;

import java.util.List;
import java.util.Optional;

public interface IService<T,ID> {
    /**
     * Musteri musteri = new Musteri("muhammet", "0555 666 7788")
     * save(musteri);
     * @param entity
     * @return
     * @param <S>
     */
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities); // save metodu hem save hem update yapar burda. Ayrıca 'update' metodu yazmaya gerek yoktur.
    void delete(T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    boolean existById(ID id);
    List<T> findAll();

    /**
     * Varlığın içinde bulunan herhangi bir alana göre kendisi
     * otomatik sorgulama yapar.
     * @param entity
     * @return
     */
    List<T> findByEntity(T entity);
    List<T> findAllByColumnNameAndValue(String columnName, String columnValue);
}
