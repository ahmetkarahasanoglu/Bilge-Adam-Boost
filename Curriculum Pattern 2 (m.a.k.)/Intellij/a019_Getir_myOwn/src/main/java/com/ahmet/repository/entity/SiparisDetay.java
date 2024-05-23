package com.ahmet.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tblsiparisdetay")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SiparisDetay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Long urunid;
    private Double birimFiyat;
    private Double adet;
    private Integer kdvYuzdesi;
    private Double kalemToplamFiyat;
    @ManyToOne
    @JoinColumn(name = "siparis_id")
    private Siparis siparis;

}
