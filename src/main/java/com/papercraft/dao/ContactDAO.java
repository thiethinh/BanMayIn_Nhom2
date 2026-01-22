package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                SELECT SUM(rely) AS total_unreplied FROM contact WHERE rely =0;
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

    public List<Contact> getContactFilter(String userName, int replied) {
        List<Contact> contacts = new ArrayList<>();
        String sqlRaw = """
                SELECT c.id, c.user_fullname, u.email,c.contact_title c.content, c.rely
                FROM contact c
                JOIN users u ON u.id = c.user_id
                WHERE c.user_fullname = ?
                """;
        StringBuilder sqlBuilder = new StringBuilder(sqlRaw);
        if(replied!= -1){
            sqlBuilder.append(" AND rely = ?;");
        }else{
            sqlBuilder.append(";");
        }

        String sql = sqlBuilder.toString();
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,"%"+userName+"%");
            if (replied != -1) {
                ps.setInt(2, replied);
            }
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Integer id = rs.getInt("id");
                    String userFullname = rs.getString("user_fullname");
                    String email = rs.getString("email");
                    String contactTitle = rs.getString("contact_title");
                    String content = rs.getString("content");
                    Boolean rely = rs.getBoolean("rely");

                    Contact contact = new Contact();
                    contact.setId(id);
                    contact.setUserFullname(userFullname);
                    contact.setEmail(email);
                    contact.setContactTitle(contactTitle);
                    contact.setContent(content);
                    contact.setRely(rely);

                    contacts.add(contact);

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  contacts;

    }

    public boolean toggleStateContact(int idContact, int state) {
        state =state==1?0:1;
        String sql = """
                UPDATE review              
                SET rely =?
                WHERE id = ?;
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,idContact);
            ps.setInt(2,state);

            return  ps.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
}