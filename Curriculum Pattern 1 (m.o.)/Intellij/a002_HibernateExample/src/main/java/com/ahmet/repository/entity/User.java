package com.ahmet.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * name
 * surname
 * username --> benzersiz olsun, null olmasın
 * password --> null olmasın, uzunlugu 32 olsun.
 *
 * Adresleri type'larına göre map'leyelim, database'le
 * ilişkilendirelim.
 */

@Entity
@Table(name = "tbl_user") // this line is optional.
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Name name;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false, length = 32)
    private String password;
    @Enumerated(EnumType.STRING) // enum'u veritabanında tabloda String olarak tutmamızı sağlar. Eğer bu satırı yazmazsak Enum index'ini tutar (0,1,2 gibi)
    private EGender gender;
    @ElementCollection
    private List<String> ilgi_alanlari;
    @ElementCollection // burada 'embedded' yazmamıza gerek yokmuş (ElementCollection olduğu içinmiş). -biz burda '@Embeddable' olan Address'i çekip kullanıyoruz
    @Enumerated(EnumType.STRING)
    private Map<AddressType, Address> adres;
    private int postcount;

}
