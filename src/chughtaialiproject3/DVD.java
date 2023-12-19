/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chughtaialiproject3;

/**
 *
 * @author aachu
 */
public class DVD extends Product
{
/**
 * 
 * @param productID
 * @param title
 * @param authorArtist
 * @param numInStock
 * @param price 
 */
    public DVD(int productID, String title, String authorArtist, int numInStock, double price) {
        super(productID, title, authorArtist, numInStock, price);
    }

     @Override
    public String toString() {
        return "DVD: " + "productID: " + getProductID() + ", title: " + getTitle() + ", Author/Artist: " + getAuthorArtist() + ", price: $" + getPrice() + ", Stock: " + getNumInStock() + '}';     
    }
    @Override
    public String toCSV() {
        return getProductID() + ",dvd," + getTitle() + "," + getAuthorArtist() + "," + "," + getNumInStock() + getPrice();
    }
}

    
