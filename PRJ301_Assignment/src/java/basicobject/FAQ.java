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
public class FAQ extends Item {
    private int id;
    private String custName;
    private String custContent;

    public FAQ() {
    }

    public FAQ(int id, String custName, String custContent, int itemId) {
        super(itemId);
        this.id = id;
        this.custName = custName;
        this.custContent = custContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustContent() {
        return custContent;
    }

    public void setCustContent(String custContent) {
        this.custContent = custContent;
    }
    
    
    
}
