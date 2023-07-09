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
public class Category {
    private int cateId;
    private String cateName;
    private boolean catestatus;

    public Category() {
    }

    
    public Category(int cateId, String cateName, boolean catestatus) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.catestatus = catestatus;
    }

    
    public Category(int cateId) {
        this.cateId = cateId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public boolean isCatestatus() {
        return catestatus;
    }

    public void setCatestatus(boolean catestatus) {
        this.catestatus = catestatus;
    }

}
