package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
public interface CustomerDAO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    boolean SaveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    void UpdateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean DeleteCustomer(String id) throws SQLException, ClassNotFoundException;

    ResultSet generateId() throws SQLException, ClassNotFoundException;

    CustomerDTO SearchCustomer(String newValue) throws SQLException, ClassNotFoundException;
}
