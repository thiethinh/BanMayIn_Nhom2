package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Address;

import java.sql.*;

public class AddressDAO {

//   insertAddress
    public boolean insertAddress(Address address) {
        // ID auto increament
        String sql = "INSERT INTO address (user_id, fname, lname, nation, " +
                "city, " + "detail_address, postcode, email, phone, is_default) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //Lấy ID Sau khi thêm
        ) {
            // 1. Gán giá trị tham số cho PreparedStatement
            ps.setInt(1, address.getUserId());
            ps.setString(2, address.getFname());
            ps.setString(3, address.getLname());
            ps.setString(4, address.getNation());
            ps.setString(5, address.getCity());
            ps.setString(6, address.getDetailAddress());
            ps.setString(7, address.getPostcode());
            ps.setString(8, address.getEmail());
            ps.setString(9, address.getPhone());
            ps.setBoolean(10, address.getDefault());


            int rowsAffected = ps.executeUpdate();

            // ID tự tăng -> gán ngược lại cho đối tượng Address
            if (rowsAffected > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        address.setId(generatedId); // gán id mới cho đối tượng Address
                    }
                }
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println("SQL Error when inserting address: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Database error occurred while adding a new address.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
