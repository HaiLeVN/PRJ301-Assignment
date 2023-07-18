/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.FAQ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author lehai
 */
public class FAQsDAO {

    public static ArrayList<FAQ> getFAQbyItemID(int itemId) throws Exception {
        ArrayList<FAQ> faqList = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select f.Id,f.CustName,f.CustContent\n"
                    + "from [dbo].[FAQ] f left join [dbo].[Items] i on f.ItemId = i.ItemId\n"
                    + "where i.ItemId = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, itemId);

            ResultSet rs = pst.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String name = rs.getString("CustName");
                    String content = rs.getString("CustContent");

                    FAQ faq = new FAQ(id, name, content, itemId);
                    faqList.add(faq);
                }
            }
            cn.close();
        }

        return faqList;
    }
    
    public static ArrayList<Integer> getFAQsIdfromItemId(int itemId) throws Exception {
        ArrayList<Integer> IDList = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select f.Id\n"
                    + "from [dbo].[FAQ] f left join [dbo].[Items] i on f.ItemId = i.ItemId\n"
                    + "where i.ItemId = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, itemId);

            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    IDList.add(id);
                }
            }
            cn.close();
        }
        return IDList;
    }
}
