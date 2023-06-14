package com.control;

import java.sql.SQLException;

import com.config.MyConfig;
import com.models.Produk;

public class ControlDatabase extends MyConfig {
    public static void getDatabase() {
        connection();
        try {
            query = "SELECT NAME, PRICE, STOCK FROM `table_produk` ORDER BY ID DESC ";
            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("NAME") + ": Rp." +
                                resultSet.getString("PRICE") + " (" +
                                resultSet.getString("STOCK") + ")");

            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static void readDB() {
        connection();
        try {
            query = "SELECT NAME, PRICE, STOCK FROM `table_produk` ORDER BY ID DESC ";
            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("NAME") + ": Rp." +
                                resultSet.getString("PRICE") + " (" +
                                resultSet.getString("STOCK") + ")");

            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static boolean insertDB(String product, Long harga, Integer stok) {
        connection();
        query = "INSERT INTO `table_produk` (NAME, PRICE, STOCK) VALUES (?, ?, ?)";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, product);
            preparedStatement.setLong(2, harga);
            preparedStatement.setInt(3, stok);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
    public static void updateNamaDB(int id, String name) {
        connection();
        query= "UPDATE `table_produk` SET NAMA=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateHargaDB(int id, Long harga) {
        connection();
        query= "UPDATE `table_produk` SET HARGA=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setLong(1, harga);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateStokDB(int id, Integer stok) {
        connection();
        query= "UPDATE `table_produk` SET JUMLAH=? WHERE ID=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setInt(1, stok);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean deletDB(String nama) {
        connection();
        query= "DELETE FROM `table_produk` WHERE NAMA=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, nama);
            int rowDelete = preparedStatement.executeUpdate();
            if (rowDelete>0) {
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Produk getProdukbyNama(String nama){
        Produk produk = null;
        connection();
        query = "SELECT * FROM `table_produk` WHERE NAMA=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, nama);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                produk = new Produk(resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getLong("PRICE"), resultSet.getInt("STOCK"));
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produk;
    }
}
