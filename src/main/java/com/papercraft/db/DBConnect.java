package com.papercraft.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3307/papercraft_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Dang ket noi den Docker MySQL...");
        Connection c = getConnection();
        if (c != null) {
            System.out.println("KẾT NỐI THÀNH CÔNG! (Java đã thông với Docker)");
            
            try { c.close(); } catch (SQLException e) {}
        } else {
            System.out.println("KẾT NỐI THẤT BẠI.");
        }
    }
}