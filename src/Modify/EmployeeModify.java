package Modify;

import Database.DBConnection;
import Model.Employee;
import Modify.StoreModify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeModify {
    public static List<Employee> findAll() { // lay du lieu tu database ve cho bang cua minh
        List<Employee> employeeList = new ArrayList<>(); // tạo một list để lưu trữ dữ liệu được truyền từ database

        Connection connection = (Connection) DBConnection.getConnection();
        Statement statement = null;
        try {

            //query
            String sql = "select * from tbl_employee";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee em = new Employee(resultSet.getInt("employee_id"),resultSet.getString("employee_name"),resultSet.getString("employee_gender"),
                        resultSet.getString("employee_gmail"),resultSet.getString("employee_password"),resultSet.getString("employee_job"),resultSet.getString("employee_shift"));
                employeeList.add(em);
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
        Collections.sort(employeeList);
        return employeeList;
    }
    public static void insert(Employee employee) {
        Connection connection = (Connection) DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            //lay tat ca danh sach employee
            //query
            String sql = "insert into tbl_employee( employee_name , employee_gender , employee_gmail,employee_password,employee_job,employee_id,employee_shift) values(?, ?, ?, ?, ?, ?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, employee.getEmployee_name());
            statement.setString(2, employee.getEmployee_gender());
            statement.setString(3, employee.getEmployee_gmail());
            statement.setString(4, employee.getEmployee_password());
            statement.setString(5,employee.getEmployee_job());
            statement.setInt(6,employee.getEmployee_id());
            statement.setString(7,employee.getEmployee_shift());
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
            //lay tat ca danh sach employee
            //query
            String sql = "delete from  tbl_employee where employee_id = ?";
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
    public static List<Employee> findByName(String name) {
        List<Employee> employeeList = new ArrayList<>();

        Connection connection = (Connection) DBConnection.getConnection();
        PreparedStatement statement = null;

        try {

            //query
            String sql = "select * from tbl_employee where employee_name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employee em = new Employee(resultSet.getInt("employee_id"),resultSet.getString("employee_name"),resultSet.getString("employee_gender"),
                        resultSet.getString("employee_gmail"),resultSet.getString("employee_password"),resultSet.getString("employee_job"),resultSet.getString("employee_shift"));
                employeeList.add(em);
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

        return employeeList;
    }
    public static void update(Employee employee) {
        Connection connection = (Connection) DBConnection.getConnection();
        PreparedStatement statement = null;

        try {

            String sql = "update tbl_employee set employee_name=? , employee_gender=? , employee_gmail=?,employee_password=? ,employee_job=?,employee_shift=? where  employee_id = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, employee.getEmployee_name());
            statement.setString(2, employee.getEmployee_gender());
            statement.setString(3, employee.getEmployee_gmail());
            statement.setString(4, employee.getEmployee_password());
            statement.setInt(7, employee.getEmployee_id());
            statement.setString(5,employee.getEmployee_job());
            statement.setString(6,employee.getEmployee_shift());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
    }
}
