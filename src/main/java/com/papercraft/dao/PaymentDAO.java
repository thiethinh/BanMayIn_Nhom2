package com.papercraft.dao;

import com.papercraft.db.DBConnect;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO {
    public double getTotalRevenue(){
        String sql = """
                SELECT SUM(payment_amount) as revenue from payment;
                """;
        try (
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    return rs.getDouble("revenue");
                }
            }

        }catch (SQLException e) {

            System.err.println("SQL Error : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0.0;
    }

}
