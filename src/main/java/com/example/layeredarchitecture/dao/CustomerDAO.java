package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;


    void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;


     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean SaveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    ResultSet generateId() throws SQLException, ClassNotFoundException ;
}
