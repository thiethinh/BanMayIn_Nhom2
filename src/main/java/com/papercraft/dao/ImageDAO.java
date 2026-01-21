package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO {
    public List<String> getSideImageByEntityID(int idEntity){
        List<String> imageNames = new ArrayList<>();
        String sql = """
                SELECT img_name
                FROM image
                WHERE entity_id =?;
                """;
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1,idEntity);
            try(ResultSet rs =ps.executeQuery()){
                while(rs.next()){
                    imageNames.add(rs.getString("img_name"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return imageNames;
    }

}
