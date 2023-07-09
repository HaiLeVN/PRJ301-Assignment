/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;
import utility.DataValidator;

/**
 *
 * @author lehai
 */
public class ItemDAO {

    public static ArrayList<Item> getAllItem() throws Exception {
        ArrayList<Item> itemList = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ItemId]\n"
                    + "      ,[ItemName]\n"
                    + "      ,[Price]\n"
                    + "      ,[CateId]\n"
                    + "  FROM [dbo].[Items]";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int itemid = rs.getInt("ItemId");
                    String itemName = rs.getString("ItemName");
                    int price = rs.getInt("Price");
                    int cateid = rs.getInt("CateId");
                    Item i = new Item(itemid, itemName, price, cateid);
                    itemList.add(i);
                }
            }
            cn.close();
        }
        return itemList;
    }

    public static Item getItembyID(int id) throws Exception {
        Item i = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ItemId]\n"
                    + "      ,[ItemName]\n"
                    + "      ,[Price]\n"
                    + "      ,[CateId]\n"
                    + "  FROM [dbo].[Items]"
                    + "  WHERE ItemId = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String itemName = rs.getString("ItemName");
                    int price = rs.getInt("Price");
                    int cateid = rs.getInt("CateId");
                    i = new Item(id, itemName, price, cateid);
                }
            }
            cn.close();
        }
        return i;
    }

    public static int updateItem(int id, String name, int price, int cateid) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "UPDATE [dbo].[Items]\n"
                    + "   SET [ItemName] = ?\n"
                    + "      ,[Price] = ?\n"
                    + "      ,[CateId] = ?\n"
                    + " WHERE [ItemId] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, price);
            pst.setInt(3, cateid);
            pst.setInt(4, id);

            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }

    public static int deleteItem(int id) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "DELETE FROM [dbo].[Items]\n"
                    + "      WHERE [ItemId] = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeUpdate();

            cn.close();
        }
        return rs;
    }

    public static int insertItem(int id, String name, int price, int cateid) throws Exception {
        int rs = 0;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "INSERT INTO [dbo].[Items]\n"
                    + "           ([ItemId]\n"
                    + "           ,[ItemName]\n"
                    + "           ,[Price]\n"
                    + "           ,[CateId])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, price);
            pst.setInt(4, cateid);

            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
