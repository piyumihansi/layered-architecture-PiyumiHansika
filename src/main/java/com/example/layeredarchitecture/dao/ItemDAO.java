package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> GetAllItems() throws SQLException, ClassNotFoundException;
    void deleteItem(String code) throws SQLException, ClassNotFoundException;
    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    int updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean existItem (String code) throws SQLException, ClassNotFoundException;
    String generateCode() throws SQLException, ClassNotFoundException;
    ItemDTO findItem(String id) throws SQLException, ClassNotFoundException;

}