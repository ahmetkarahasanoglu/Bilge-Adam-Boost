package com.ahmet.utility;

import java.sql.*;
import java.util.Optional;

public class ConnectionProvider {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet; // (1'den fazla satır tablo verisi geldiğinde database'den, resultSet kullanıyoruz).

    // METHODS: ----
    public boolean openConnection() { // if connection is successful, method will return 'true'
        try {
            Driver.class.forName("org.postgresql.Driver");
            connection = DatabaseConnection.getConnection();
            System.out.println(DatabaseConnection.dbName + " veritabanıyla bağlantı kuruldu.");
            return true;
        } catch (Exception e) {
            System.out.println("Başarısız! Veritabanına bağlanılamadı!");
            e.printStackTrace();
            return false; // if connection fails to establish (in that case an exception will occur), the method will return 'false'.
        }
    }

    public void closeConnection() {
        try{
            if(!connection.isClosed()) { // eğer bağlantı açık ise
                connection.close(); // Önemli!: bağlantı zaten kapalı ise hata verir, o yüzden böyle bir if'in içinde kullandık.
                System.out.println("Bağlantı kapatıldı.");
            }
        }catch(Exception e) {
            System.out.println("Bağlantı kapatma başarısız!!!");
            throw new RuntimeException();
        }
    }

        public boolean executeQuery(String sql) { // (Bu metot yerine aşağıdaki 'getPreparedStatement' metodunu kullandık; '?'li çözümü uygulamak için (FutbolcuRepository class'ında).
        if(openConnection()) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate(); // Create, Update ve Delete için 'executeUpdate()'. Veri almada(getData) 'executeQuery()' kullanılır.
                closeConnection();
                return true;
            }catch(Exception e) {
                closeConnection();
            }
        }
        return false;
    }

    public PreparedStatement getPreparedStatement(String sql){
        if (openConnection()){
            try {
                preparedStatement=DatabaseConnection.getConnection().prepareStatement(sql);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        return  preparedStatement;
    }

    public Optional<ResultSet> getData(String sql, PreparedStatement preparedStatement) {
        try {
            resultSet = preparedStatement.executeQuery(); // Veri almada (getData) 'executeQuery()' kullanılır.
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            closeConnection();
        }
        return Optional.ofNullable(resultSet);
    }

}
