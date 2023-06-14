import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MyConfig.MyConfig;
import models.Produk;

public class ControlDatabase extends MyConfig {

    public static List<Produk> getDatabase() {
        List<Produk> produkList = new ArrayList<>();
        connection();
        try {
            // query = "SELECT nama, harga, stok FROM tb_mobil ORDER BY ID DESC";
            query = "SELECT ID, NAME, PRICE, STOCK FROM table_produk";

            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nama = resultSet.getString("NAME");
                int harga = resultSet.getInt("PRICE");
                int stock = resultSet.getInt("STOCK");

                Produk produk = new Produk(id, nama, harga, stock);
                produkList.add(produk);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produkList;
    }

    public static Produk getProdukByNama(String nama) {
        Produk produk = null;
        connection();
        query = "SELECT * FROM table_produk WHERE NAME=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                produk = new Produk(resultSet.getInt("id"), resultSet.getString("Brand"), resultSet.getLong("Harga"), resultSet.getInt("Stock"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produk;
    }

    public static boolean insertData(String nama, long harga, int jumlah) {
        connection();
        query = "INSERT INTO table_produk (NAME, PRICE, STOCK) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setLong(2, harga);
            preparedStatement.setInt(3, jumlah);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateNama(int id, String nama) {
        connection();
        query = "UPDATE table_produk SET NAME=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHarga(int id, long harga) {
        connection();
        query = "UPDATE table_produk SET PRICE=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, harga);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateJumlah(int id, int jumlah) {
        connection();
        query = "UPDATE table_produk SET STOCK=? WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, jumlah);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteData(int id) {
        connection();
        query = "DELETE FROM table_produk WHERE ID=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int affectedRowDelete = preparedStatement.executeUpdate();
            if (affectedRowDelete > 0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}