package com.ahmet.Monolitik.repository.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VwSatis {

    Long satisid;
    Long musteriid;
    String musteriadi;
    Long urunid;
    String urunadi;
    int adet;
    Double birimfiyat;
    Double toplamfiyat;

}
