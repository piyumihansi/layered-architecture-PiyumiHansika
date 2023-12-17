package com.example.layeredarchitecture.dao;
import java.sql.*;
public interface OrdersDAO {
    String generateId() throws SQLException, ClassNotFoundException;

    boolean isExists(Connection connection, String id, PreparedStatement stm) throws SQLException, ClassNotFoundException;

    int saveOrders(Connection connection, PreparedStatement stm, String id,Date date,String CusId) throws SQLException ;

    Connection getConnection() throws SQLException, ClassNotFoundException;
}
