package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDAO {

    public boolean insertContact(Contact c) {

        String sql = "INSERT INTO contact (user_id, user_fullname, email, contact_title, content, rely, created_at) VALUES (?, ?, ?, ?, ?, 0, NOW())";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Xử lý user_id -> Nếu null thì set Null trong SQL
            if (c.getUserId() != null) {
                ps.setInt(1, c.getUserId());
            } else {
                ps.setNull(1, java.sql.Types.INTEGER);
            }

            ps.setString(2, c.getUserFullname());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getContactTitle());
            ps.setString(5, c.getContent());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Integer totalUnrepliedContact(){
        String sql = """
                SELECT COUNT(*) AS total_unreplied FROM contact WHERE rely =0;
                """;
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return  rs.getInt("total_unreplied");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }
}