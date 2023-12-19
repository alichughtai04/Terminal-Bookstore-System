/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chughtaialiproject3;

/**
 *
 * @author aachu
 */
public class RegularMember extends Customer
{
/**
 * 
 * @param customerName
 * @param customerEmail
 * @param paymentMethod
 * @param isRegularMember
 * @param isPremiumMember
 * @param amountSpent 
 */
    public RegularMember(String customerName, String customerEmail, String paymentMethod, boolean isRegularMember, boolean isPremiumMember, double amountSpent) {
        super(customerName, customerEmail, paymentMethod, isRegularMember, isPremiumMember, amountSpent);
    }
    
}
