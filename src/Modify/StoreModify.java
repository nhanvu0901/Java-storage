package Modify;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Store;
import Database.DBConnection;
public class StoreModify {
    public static List<Store> findAll() { // lay du lieu tu database ve cho bang cua minh
        List<Store> storeList = new ArrayList<>(); // tạo một list để lưu trữ dữ liệu được truyền từ database

        Connection connection = (Connection) DBConnection.getConnection();
        Statement statement = null;
        try {

            //query
            String sql = "select * from store";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Store std = new Store(resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),resultSet.getString("food_kind"),
                        resultSet.getInt("food_number"), resultSet.getDouble("food_price"),
                        resultSet.getString("food_dateInput"), resultSet.getString("food_dayMade"),
                        resultSet.getString("food_expired"), resultSet.getString("food_origin"));
                storeList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return storeList;
    }


    public static void insert(Store store) {
        Connection connection = (Connection) DBConnection.getConnection();
        PreparedStatement statement = null;

        try {

            String sql = "insert into store(food_id, food_name , food_kind , food_number, food_price, food_dateInput,food_dayMade,food_expired,food_origin) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);

            statement.setInt(1, store.getFood_id());
            statement.setString(2, store.getFood_name());
            statement.setString(3, store.getFood_kind());
            statement.setInt(4,store.getFood_number());
            statement.setDouble(5, store.getFood_price());
            statement.setString(6, store.getFood_dateInput());
            statement.setString(7, store.getFood_dayMade());
            statement.setString(8, store.getFood_expired());
            statement.setString(9, store.getFood_origin());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    public static void delete(int id ) {
        Connection connection = (Connection) DBConnection.getConnection();
        PreparedStatement statement = null;

        try {

            String sql = "delete from store where food_id = ?";
            statement = connection.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
    public static List<Store> findByID(String id) {
        List<Store> storeList = new ArrayList<>();

        Connection connection = (Connection) DBConnection.getConnection();
        PreparedStatement statement = null;

        try {

            //query
            String sql = "select * from store where food_id like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+id+"%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Store std = new Store(resultSet.getInt("food_id"),
                        resultSet.getString("food_name"),resultSet.getString("food_kind"),
                        resultSet.getInt("food_number"), resultSet.getDouble("food_price"),
                        resultSet.getString("food_dateInput"), resultSet.getString("food_dayMade"),
                        resultSet.getString("food_expired"), resultSet.getString("food_origin"));
                storeList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.

        return storeList;
    }

    public static void update(Store store) {
        Connection connection = (Connection) DBConnection.getConnection();
        PreparedStatement statement = null;
        // update theo id cua san pham
        try {

            //query
            String sql = "update store set  food_name=? , food_kind=? , food_number=?, food_price=?, food_dateInput=?,food_dayMade=?,food_expired=?,food_origin=? where food_id =?";
            statement = connection.prepareCall(sql);

            statement.setInt(9, store.getFood_id());
            statement.setString(1, store.getFood_name());
            statement.setString(2, store.getFood_kind());
            statement.setInt(3,store.getFood_number());
            statement.setDouble(4, store.getFood_price());
            statement.setString(5, store.getFood_dateInput());
            statement.setString(6, store.getFood_dayMade());
            statement.setString(7, store.getFood_expired());
            statement.setString(8, store.getFood_origin());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
}
