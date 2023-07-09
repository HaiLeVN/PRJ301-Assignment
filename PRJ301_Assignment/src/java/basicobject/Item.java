/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicobject;

/**
 *
 * @author lehai
 */
public class Item extends Category {
    private int itemId;
    private String itemName;
    private int price;

    public Item() {
    }

    //overloadding constructors for the columns ID not null
    public Item(int itemId) {
        this.itemId = itemId;
    }
   

    public Item(int itemId, String itemName, int price, int cateId) {
        super(cateId);
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
