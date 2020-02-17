/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Mayank
 */
public class CustomerDirectory {
    private ArrayList<Customer> customerList;
    private Customer cust;
    private int count = 0;
    
   public CustomerDirectory(){
        this.customerList = new ArrayList<Customer>();
       
    }
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    
    public void addCustomer(Customer cust) {
        count++;
        cust.setCustomerId("Customer"+count);
        customerList.add(cust);
       
        
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
    
}
