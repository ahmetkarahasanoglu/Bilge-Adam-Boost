package com.ahmet.dto.request;


import com.ahmet.repository.entity.SiparisDetay;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SiparisSaveRequestDto {

    @NotNull
    private Long musteriid;
    private Long kuryeid;
    private Double toplamKdvTutari;
    private Double genelToplamFiyat;
    private Long tarih;
    @OneToMany(mappedBy = "siparis", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SiparisDetay> siparisDetayList;

}
