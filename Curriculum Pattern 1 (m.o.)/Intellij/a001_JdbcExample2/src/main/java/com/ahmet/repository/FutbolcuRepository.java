package com.ahmet.repository;

import com.ahmet.repository.entity.Futbolcu;
import com.ahmet.utility.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * - Icrud'ı oluşturalım.
 * - save metodu yazalım (burda)
 * - update -> id'sine göre futbolcuyu güncelleyelim.
 */
public class FutbolcuRepository implements ICrud<Futbolcu> {

    private String sql = "";
    private ConnectionProvider connectionProvider;

    // CONSTRUCTOR:
    public FutbolcuRepository() {
        this.connectionProvider = new ConnectionProvider();
    }

    // METHODS: ---
//    @Override
//    public void save(Futbolcu futbolcu) {   // Kullanmadık Bu Metodu, aşağıdaki 'save' metodunu kullandık. (sentax farklılığı var, aşağıdakinde soru işaretleri kullanılıyor).
//        sql = "insert into futbolcu(isim, mevki, forma_no, takim_id) " +
//                "values('"+futbolcu.getIsim()+"', '"+futbolcu.getMevki()+"', '"+futbolcu.getFormaNo()+"', '"+futbolcu.getTakimId()+"')";
//        connectionProvider.executeQuery(sql);
//    }

    @Override
    public void save(Futbolcu futbolcu) {
        sql="insert into futbolcu(isim,mevki,forma_no,takim_id) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql); // just to get the 'preparedStatement' here; to use it below.
            preparedStatement.setString(1, futbolcu.getIsim()); // '1' refers to first parameter of the 'values' in the sql string above. '?' in the sql string becomes this.
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setInt(3, futbolcu.getFormaNo());
            preparedStatement.setLong(4,futbolcu.getTakimId());
            preparedStatement.executeUpdate();
            connectionProvider.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Futbolcu futbolcu) {
        sql = "update futbolcu set isim=?, mevki=?, forma_no=?, deger=?, takim_id=? where id=?";
        try {
            PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
            preparedStatement.setString(1, futbolcu.getIsim());
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setInt(3, futbolcu.getFormaNo());
            preparedStatement.setLong(4, futbolcu.getDeger());
            preparedStatement.setLong(5,futbolcu.getTakimId());
            preparedStatement.setLong(6,futbolcu.getId());
            int etkilenenVeri = preparedStatement.executeUpdate(); // runs the 'executeUpdate()' method, then assigns the returning value to 'etkilenenVeri'
            if(etkilenenVeri>0) {
                System.out.println("Güncelleme başarılı.");
            }else {
                System.out.println("Güncelleme başarısız.");
            }
            connectionProvider.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
    sql = "delete from futbolcu where id=" + id; // eski yöntemi uyguladım ('?'li olmayan)
        try {
            PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
//            preparedStatement.setLong(1,id); // '?'li yöntem için bu. Bunu kullanmayacaz burda.
            int etkilenenVeri = preparedStatement.executeUpdate();
            if(etkilenenVeri > 0) {
                System.out.println("Başarıyla silindi.");
            }else {
                System.out.println("Silme başarısız.");
            }
            connectionProvider.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Futbolcu> findAll() {
        sql = "select * from futbolcu";
        List<Futbolcu> futbolcuList = new ArrayList<>();
        Futbolcu futbolcu;
        PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
        try {
            Optional<ResultSet> resultSet = connectionProvider.getData(sql, preparedStatement);
            while(resultSet.get().next()) {
                Long id = resultSet.get().getLong(1); // getting cell's data (1st column)
                String isim = resultSet.get().getString(2); // getting cell's data (2nd column)
                String mevki = resultSet.get().getString("mevki"); // getting cell's data ||| veya 3 yazabiliriz parametre olarak(columnIndex veririz)
                int formaNo = resultSet.get().getInt(("forma_no")); // veya 4
                long deger = resultSet.get().getLong("deger"); // veya 5
                long takimId = resultSet.get().getLong("takim_id"); // veya 6
                futbolcu = new Futbolcu(id, isim, mevki,formaNo,deger, takimId);
                futbolcuList.add(futbolcu);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return futbolcuList;
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {
//        sql = "select * from futbolcu where id =" + id;  // eski yöntem
        Futbolcu futbolcu = null;
        sql = "select * from futbolcu where id =?";
        PreparedStatement preparedStatement = connectionProvider.getPreparedStatement(sql);
        try {
            preparedStatement.setLong(1, id); // referring to the '?'
            Optional<ResultSet> resultSet = connectionProvider.getData(sql, preparedStatement);
            while(resultSet.get().next()) {
                String isim = resultSet.get().getString(2); // getting cell's data
                String mevki = resultSet.get().getString("mevki"); // getting cell's data |||veya 3 yazabiliriz parametre olarak(columnIndex veririz)
                int formaNo = resultSet.get().getInt(("forma_no")); // veya 4
                long deger = resultSet.get().getLong("deger"); // veya 5
                long takimId = resultSet.get().getLong("takim_id"); // veya 6
                futbolcu = new Futbolcu(id, isim, mevki,formaNo,deger, takimId);
                return Optional.of(futbolcu);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

}
