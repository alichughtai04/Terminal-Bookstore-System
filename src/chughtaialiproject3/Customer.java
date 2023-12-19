/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chughtaialiproject3;

/**
 *
 * @author aachu
 */
public class Customer {
    
    private String customerName;
    private String customerEmail;
    private String paymentMethod;
    private boolean isRegularMember;
    private boolean isPremiumMember;
    private double amountSpent;
/**
 * default customer constructor
 * @param customerName
 * @param customerEmail
 * @param paymentMethod
 * @param isRegularMember
 * @param isPremiumMember
 * @param amountSpent 
 */
    public Customer(String customerName, String customerEmail, String paymentMethod, boolean isRegularMember, boolean isPremiumMember, double amountSpent) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.paymentMethod = paymentMethod;
        this.isRegularMember = isRegularMember;
        this.isPremiumMember = isPremiumMember;
        this.amountSpent = amountSpent;
    }
/**
 * 
 * @return customer name 
 */
       
    public String getCustomerName() {
        return customerName;
    }
/**
 * sets customer name
 * @param customerName 
 */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
/**
 * 
 * @return customer email
 */
    public String getCustomerEmail() {
        return customerEmail;
    }
/**
 * sets customer email
 * @param customerEmail 
 */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
/**
 * 
 * @return payment method
 */
    public String getPaymentMethod() {
        return paymentMethod;
    }
/**
 * sets payment method
 * @param paymentMethod 
 */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
/**
 * 
 * @return true if customer is a regular member
 */
    public boolean isRegularMember() {
        return isRegularMember;
    }
/**
 * sets isRegularMember to true or false
 * @param isRegularMember 
 */
    public void setRegularMember(boolean isRegularMember) {
        this.isRegularMember = isRegularMember;
    }

/**
 * 
 * @return true if customer is a premium member
 */
    public boolean isPremiumMember() {
        return isPremiumMember;
    }
/**
 * set isPremiumMember to true or false
 * @param isPremiumMember 
 */
    public void setPremiumMember(boolean isPremiumMember) {
        this.isPremiumMember = isPremiumMember;
    }
/**
 * 
 * @return amount spent
 */
    public double getAmountSpent() {
        return amountSpent;
    }
/**
 * sets amount spent 
 * @param spent 
 */
    public void setAmountSpent(double spent) {
        this.amountSpent += spent;
    }
    
/**
 * 
 * @return customer info to string
 */
    @Override
    public String toString() {
        return "Customer{" + "customer Name - " + customerName + ", customer Email - " + customerEmail + ", payment Method - " + paymentMethod + ", Regular Member - " + isRegularMember + ", Premium Member - " + isPremiumMember + ", amount Spent - $" + String.format("%.2f",amountSpent) + '}';
    }
  
}