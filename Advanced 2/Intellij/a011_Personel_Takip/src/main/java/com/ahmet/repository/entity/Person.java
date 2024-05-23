package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblperson")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer age;
    EGender gender;
    /**
     * OneToMany -> Personel tablosunun adres tablosuna ilişkisini tanımlar.
     * Birden çoğa ilişki database'de ayrı bir bağlantı tablosu ile sağlanır.
     * Böylece yeni bir tablo yaratılır (burda tblperson_tbladdress tablosu
     * oluşur otomatik şekilde)
     */
    @OneToMany(cascade = CascadeType.ALL) // 'CascadeType.ALL' means that all of the operations (persist, merge, remove, refresh, detach) are cascaded from the parent entity (Person) to the related entity (Address). This prevents the 'IllegalStateException' caused by 'hibernate.TransientObjectException'. This exception occurs when you try to save an entity (Person) that references another entity (Address) which has not been saved yet.
    @JoinTable(name = "tbl_personel_adres_iliski",
               joinColumns = @JoinColumn(name = "personelid"), // alan adlarını değiştiriyoz.
               inverseJoinColumns = @JoinColumn(name = "aderesid"))
    List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL) // 1 to 1 relationship. Owning side is this class(Person).Yönetimi bu sınıfa (Person sınıfına) verdik - Person'un tablosunda gösterilecek 'car_id' şeklinde. [Her personelin 1 arabası olsun dedik]
    @JoinColumn(name = "arabanin_idsiii") // Person'un tablosunda gösterilen ilişki kolonu otomatik olarak 'car_id' şeklinde oluşuyor, biz ona 'arabanin_idsiii' diye özel bi isim verdik burda.
    Car car;

    @ManyToOne(cascade = CascadeType.ALL) // Many to One. Owning side of the relationship is this class (Person).
    Department department;
}
