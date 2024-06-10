package com.ahmet.repository;

import java.sql.*;
import java.util.Optional;

public class ConnectionProvider {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String url = "jdbc:postgresql://localhost:5432/DbSatis";
    private final String username = "postgres";
    private final String password = "root";


    // METHODS: ----                   // (openConnection and closeConnection methods are private, can't be accessed from outside this class).
    private boolean openConnection() { // if connection is successful, method will return 'true'
        try {
            Driver.class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            return true;
        } catch (Exception exception) {
            return false; // if connection fails to establish (in that case an exception will occur), the method will return 'false'.
        }
    }

    private void closeConnection() {
        try{
            if(!connection.isClosed()) { // eğer bağlantı açık ise
                connection.close(); // Önemli!: bağlantı zaten kapalı ise hata verir, o yüzden böyle bir if'in içinde kullandık.
            }
        }catch(Exception exception) {

        }
    }

    public boolean executeQuery(String SQL) {
        if (openConnection()) { // -> bağlantı açmayı dene, açabilirsen 'true' dön, bu if'in içine gir.
            try {               // '--> Her sorguda bağlantının açılıp, sorgu bittikten sonra kapanması lazım, yani her sorgu için bağlantı açma ve kapama işlemi yapılması lazım. Bu şekildedir.
                preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.executeUpdate();
                closeConnection();
                return true; // her şey doğru giderse metot burda sonlanacak, alttaki kodlar çalışmayacak.
            } catch (Exception exception) {
                closeConnection();
            }
        }
        return false; // bir hata ile karşılaşıldığı zaman burası çalışacak, false dönecek.
    }

    /**
     * Bu tarz nesne dönen yapılarda her zaman NULL dönme ihtimali
     * vardır. Bu nedenle bu metotlarda Optional kullanmak daha
     * sağlıklıdır.
     * @param SQL
     * @return
     */
    public Optional<ResultSet> getAllData(String SQL) {
        if(openConnection()) {
            try{
                preparedStatement = connection.prepareStatement(SQL);
                resultSet = preparedStatement.executeQuery();
                closeConnection();
                return Optional.of(resultSet);
            }catch(Exception exception) {
                closeConnection();
            }
        }
        return Optional.empty(); // (benzetme: okul döneminin başında öğrenciye "sınavdan kaç aldın?" diye sorulduğunda öğrenci "sınava girmedim ki" der. İşte Optional bunu sağlıyor.
    }                            // '--> Returning an empty Optional allows the calling code to handle the absence of a result set gracefully without encountering a null value or throwing an exception.


}
