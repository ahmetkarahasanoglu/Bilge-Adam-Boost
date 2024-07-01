package com.ahmet.repository.entity;

import com.ahmet.repository.enums.ERole;
import com.ahmet.repository.enums.EStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

/**
 * 1- Repository
 * 2- Service
 * 3- Controller
 * katmanlarını oluşturun.
 * - register metodu yazılacak ve buna bir endpoint yazılacak.
 * Kullanıcıdan belli kullanıcı verileri alınacak, database'e
 * kaydedilecek. Bu işlemler request dto ile yapılacak. Dönüş
 * tipi bir response dto olsun. @PostMapping ile olsun.
 */

@Entity
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auth extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) // username'in unique'liğinin geçerli olması için, AuthService application.yml'da -> ddl-auto: create'e çekilip 1 kez AuthServiceApplication run edilir, hemen tekrar -> ddl-auto: update'e çekilip run edilir (başlangıçta update'te olduğu varsayılarak). Böylelikle unique olması geçerli olur database'de.
    private String username;
    private String email;
    private String password;
    private String activationCode;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ERole role = ERole.USER;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.PENDING;

}
