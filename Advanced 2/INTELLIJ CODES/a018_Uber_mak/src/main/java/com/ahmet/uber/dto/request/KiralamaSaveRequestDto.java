package com.ahmet.uber.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KiralamaSaveRequestDto {
    @NotNull // 'musteriid' boş geçilirse hata verir.
    Long musteriid;
    Long aracid;
    Long soforid;
    Long kiralamatarihi;
    Double startlat;
    Double startlon;
    String startkonum;

}
