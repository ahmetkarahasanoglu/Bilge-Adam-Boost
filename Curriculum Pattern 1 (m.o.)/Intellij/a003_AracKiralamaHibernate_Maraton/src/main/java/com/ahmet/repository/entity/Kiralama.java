package com.ahmet.repository.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kiralama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "arac_id") // We're referencing the 'id' column of Arac. And the 'name' specifies the name of the foreign key column in the owning entity's table (Kiralama entity in this case). Here, it's set to "arac_id", which means the foreign key column in the Kiralama table will be named 'arac_id'. || Arac sınıfında Kiralama'yı tutmadığım için bağlantıyı burda JoinColumn ile sağlıyoruz.
    private Arac arac;
    @ManyToOne
    private Kisi kisi;



}
