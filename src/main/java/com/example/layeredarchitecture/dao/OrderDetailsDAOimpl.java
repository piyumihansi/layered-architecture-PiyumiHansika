package com.example.layeredarchitecture.dao;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class OrderDetailsDAOimpl implements OrderDetailsDAO {
    @Override
    public int saveOrderDetails(PreparedStatement stm, Connection connection, OrderDetailDTO detail,String orderId) throws SQLException {
        stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        stm.setString(1, orderId);
        stm.setString(2, detail.getItemCode());
        stm.setBigDecimal(3, detail.getUnitPrice());
        stm.setInt(4, detail.getQty());

        return stm.executeUpdate();
    }
}
