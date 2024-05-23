package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * NOT: Embeddable sınıflara 'BaseEntity'i embed etmeyin!!! Yoksa
 * 2 kere yazılmış olur (duplicate), hata verir. Yani, bu embeddable
 * sınıf zaten başka bir sınıfa embed olacak, orda da baseEntity
 * var zaten.
 */
@Embeddable
@Builder // lombok'tan. Builder: Bir sınıftan nesne üretmek için özel anotasyon.
@Data // lombok'tan. Data: get & set metotlarını tanımlar.
@NoArgsConstructor// lombok'tan. Parametresiz constructor tanımlar.
@AllArgsConstructor // lombok'tan. Tüm parametrelerle constructor tanımlar.
@ToString // lombok'tan. toString metodunun tanımlar class'ımız için.
public class Iletisim {

    String telefon;
    String email;
    String web;
    String instagram;

}
