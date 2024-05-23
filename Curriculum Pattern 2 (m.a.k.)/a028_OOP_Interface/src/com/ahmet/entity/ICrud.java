package com.ahmet.entity;
// Interfaces are about how the methods must be written on an a
// pre-determined pattern.
public interface ICrud {  // --> means: Interface Crud. PAY ATT: 'interface' keyword.
/*
 * CRUD:
 * - Create
 * - Read
 * - Update
 * - Delete
 * 
 * Interface'de arayüzler nasıl tanımlanır:
 * 1- Erişim belirteci kullanmayız.
 * 2- Metodun gövdesi hariç diğer bileşenleri yazılabilir.
 */
	
	void save(Object o); // These are methods. They don't have bodies.
	void update(Object o); // 'Object' is the ancestor of all variables. All variables can be assigned to object. 
	void delete(Long id);
	Object findById(Long id);
	Object[] findAll();
	Object findByName(String name);
	
}
