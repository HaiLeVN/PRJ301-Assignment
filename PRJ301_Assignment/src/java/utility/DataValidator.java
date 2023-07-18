/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import basicobject.Category;
import basicobject.Item;
import dbaccess.CategoryDAO;
import dbaccess.ItemDAO;
import java.util.ArrayList;

/**
 *
 * @author lehai
 */
public class DataValidator {

    public static boolean checkID(int itemid) {
        boolean flag = false;
        if (itemid > 0) {
            try {
                ArrayList<Item> itemList = ItemDAO.getAllItem();
                if (itemList != null && !itemList.isEmpty()) {
                    for (Item i : itemList) {
                        if (i.getItemId() == itemid) {
                            flag = true; // co trung
                            break;
                        } else {
                            flag = false;
                        }
                    }
                } else {
                    flag = false;

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean checkCategory(int cateid) {
        boolean flag = false;
        if (cateid > 0) {
            try {
                ArrayList<Category> cateList = CategoryDAO.getAllCategory();
                if (cateList != null && !cateList.isEmpty()) {
                    for (Category c : cateList) {
                        if (c.getCateId() == cateid) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                } else {
                    flag = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean checkPrice(int currentPrice) {
        boolean flag = false;
        if (currentPrice > 0) {
            flag = true;
        }
        return flag;
    }

    public static boolean checkNullString(String str) {
        boolean flag = false;
        if (str != null && !str.isEmpty()) {
            flag = true;
        }
        return flag;
    }
}
