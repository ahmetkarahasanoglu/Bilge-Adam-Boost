package com.ahmet.Monolitik.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriModel {

    String baslik;
    List<String> musterilistesi;
    String adres;
    List<String> menulistesi;

}
