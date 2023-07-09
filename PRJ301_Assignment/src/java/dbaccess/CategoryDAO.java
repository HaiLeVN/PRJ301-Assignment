/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author lehai
 */
public class CategoryDAO {
    public static ArrayList<Category> getAllCategory() throws Exception {
        Connection cn = DBUtils.makeConnection();
        ArrayList<Category> cateList = new ArrayList<>();        
        if(cn != null) {
            String sql = "SELECT [CateId]\n"
                    + "      ,[CateName]\n"
                    + "      ,[Status]\n"
                    + "  FROM [dbo].[Categories]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while(rs.next()) {
                    int cateid = rs.getInt("CateId");
                    String catename = rs.getString("CateName");
                    boolean status = rs.getBoolean("status");
                    Category c = new Category(cateid, catename, status);
                    cateList.add(c);
                }
            }
            cn.close();
        }
        return cateList;
    }
}
