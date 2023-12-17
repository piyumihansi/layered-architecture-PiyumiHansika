package com.example.layeredarchitecture.dao;
import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
public class ordersDAOimpl implements OrdersDAO {
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean isExists(Connection connection,String id,PreparedStatement stm) throws SQLException, ClassNotFoundException {
        stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, id);
        return stm.executeQuery().next();
    }

    @Override
    public int saveOrders(Connection connection, PreparedStatement stm, String id,Date date,String CusId) throws SQLException {
        stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1,id);
        stm.setDate(2, date);
        stm.setString(3, CusId);

        return stm.executeUpdate();
    }

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return DBConnection.getDbConnection().getConnection();
    }
}