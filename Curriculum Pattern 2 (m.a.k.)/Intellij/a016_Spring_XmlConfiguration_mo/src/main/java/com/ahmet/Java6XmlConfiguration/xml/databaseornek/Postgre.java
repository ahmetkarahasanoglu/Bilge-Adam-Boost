package com.ahmet.Java6XmlConfiguration.xml.databaseornek;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Postgre implements IDatabase {

    String url;
    String username;

    @Override
    public void logToDatabase() {
        System.out.println("username --> " + username );
        System.out.println(url + " --> Postgre'ye loglandı.");
    }

}
