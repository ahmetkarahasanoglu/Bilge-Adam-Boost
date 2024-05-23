package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tblsiparis")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Long musteriid;
    private Long kuryeid;
    private Double toplamKdvTutari;
    private Double genelToplamFiyat;
    private Long tarih;
    @OneToMany(mappedBy = "siparis", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SiparisDetay> siparisDetayList;

}
