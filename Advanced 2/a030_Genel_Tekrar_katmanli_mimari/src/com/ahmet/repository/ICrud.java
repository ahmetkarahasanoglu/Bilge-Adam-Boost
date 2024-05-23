package com.ahmet.repository;

import java.util.List;

/*
 * GENERIC TYPES: Sağladığı şey: esnek sınıflar, esnek miras alınabilecek interface'ler
 * almamızı sağlıyor.
 */

public interface ICrud<T> { // T: tip'i sembolize etsin. [Generic Types]. Interface dışarıdan herhangi tip'te bir şey alacak, o tipteki şeyi kendi içinde kullanacak. Bu 'Müşteri' olabilir, 'Satış' olabilir.
	void save(T t); // Parantezin içinde 'Object object' yazıyor idi. 'T t' diye değiştirdik.
	void update(T t);
	void delete(Long id);
	List<T> findAll();
	T findById(Long id);
}
