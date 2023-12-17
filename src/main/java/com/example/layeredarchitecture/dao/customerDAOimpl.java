package com.example.layeredarchitecture.dao;

 import com.example.layeredarchitecture.db.DBConnection;
 import com.example.layeredarchitecture.model.CustomerDTO;

 import java.sql.*;
 import java.util.ArrayList;

 public class customerDAOimpl implements CustomerDAO {
     @Override
     public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
         Connection connection = DBConnection.getDbConnection().getConnection();
         Statement stm = connection.createStatement();
         ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

         ArrayList<CustomerDTO> AllCustomers = new ArrayList<>();
         while (rst.next()) {
             CustomerDTO Cdto = new CustomerDTO(
                     rst.getString("id"),
                     rst.getString("name"),
                     rst.getString("address")
             );
             AllCustomers.add(Cdto);
         }
         return AllCustomers;
     }

     @Override
     public boolean SaveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {


         Connection connection = DBConnection.getDbConnection().getConnection();
         PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
         pstm.setString(1, dto.getId());
         pstm.setString(2, dto.getName());
         pstm.setString(3, dto.getAddress());

         return pstm.executeUpdate() > 0;
     }

     @Override
     public void UpdateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {

         Connection connection = DBConnection.getDbConnection().getConnection();
         PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
         pstm.setString(1, dto.getName());
         pstm.setString(2, dto.getAddress());
         pstm.setString(3, dto.getId());
         pstm.executeUpdate();
     }

     @Override
     public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
         Connection connection = DBConnection.getDbConnection().getConnection();
         PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
         pstm.setString(1, id);

         return pstm.executeQuery().next();
     }

     @Override
     public boolean DeleteCustomer(String id) throws SQLException, ClassNotFoundException {
         Connection connection = DBConnection.getDbConnection().getConnection();
         PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
         pstm.setString(1, id);
         return pstm.executeUpdate() > 0;
     }

     @Override
     public ResultSet generateId() throws SQLException, ClassNotFoundException {
         Connection connection = DBConnection.getDbConnection().getConnection();
         ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
         return rst;
     }

     @Override
     public CustomerDTO SearchCustomer(String newValue) throws SQLException, ClassNotFoundException {
         Connection connection = DBConnection.getDbConnection().getConnection();
         PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
         pstm.setString(1, newValue + "");
         ResultSet rst = pstm.executeQuery();
         rst.next();
         CustomerDTO customerDTO = new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
         return customerDTO;
     }
 }
