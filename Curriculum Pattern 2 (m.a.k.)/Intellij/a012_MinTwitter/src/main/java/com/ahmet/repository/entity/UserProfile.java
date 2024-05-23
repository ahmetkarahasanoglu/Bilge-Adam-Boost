package com.ahmet.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "tbluserprofile")
@SuperBuilder // to be able to use '.build()' also for the fields of the super class when building a new object. Lombok generates a builder for the class annotated with @SuperBuilder as well as for all of its parent classes.
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "UserProfile.existByUsername",
                    query = "select count(u)>0 from UserProfile u where u.username = :username"), // returns true or false
        @NamedQuery(name = "UserProfile.doLogin",
                    query = "select count(u)>0 from UserProfile u where u.username = :username AND u.password = :password"), // is the profile available (if username and password match a profile in database) - returns true or false
        @NamedQuery(name = "UserProfile.findByUsername",
                    query = "select u from UserProfile u where u.username = :username")
})
public class UserProfile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String name;
    String surname;
    String website;
    String profileimg;
    String backgroundimg;
    Long memberdate;
    String memberdateview;
    boolean verifiedaccount;
}
