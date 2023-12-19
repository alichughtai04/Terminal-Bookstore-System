/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chughtaialiproject3;

/**
 *
 * @author aachu
 */
public class PremiumMember extends Customer
{
    private int monthlyPayment;
    private boolean isPayed;
/**
 * 
 * @param monthlyPayment
 * @param isPayed
 * @param customerName
 * @param customerEmail
 * @param paymentMethod
 * @param isRegularMember
 * @param isPremiumMember
 * @param amountSpent 
 */
    

    public PremiumMember(int monthlyPayment, boolean isPayed, String customerName, String customerEmail, String paymentMethod, boolean isRegularMember, boolean isPremiumMember, double amountSpent) {
        super(customerName, customerEmail, paymentMethod, isRegularMember, isPremiumMember, amountSpent);
        this.monthlyPayment = monthlyPayment;
        this.isPayed = isPayed;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }
  
}