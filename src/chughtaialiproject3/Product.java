/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chughtaialiproject3;

/**
 *
 * @author aachu
 */

    public abstract class Product implements Comparable<Product>
{
    private int productID;    
    private String title;
    private String authorArtist;
    private double price;
    private int numInStock;
            
/**
 * 
 * @param productID
 * @param title
 * @param authorArtist
 * @param numInStock
 * @param price 
 */
    public Product(int productID, String title, String authorArtist, int numInStock, double price) {
        this.productID = productID;
        this.title = title;
        this.authorArtist = authorArtist;
        this.price = price;
        this.numInStock = numInStock;
        
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorArtist() {
        return authorArtist;
    }

    public void setAuthorArtist(String authorArtist) {
        this.authorArtist = authorArtist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumInStock() {
        return numInStock;
    }

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }
    
    @Override
    public int compareTo(Product inv) {
        if(this.getPrice() > inv.getPrice())
        {
            return 1;
        }
        else if(this.getPrice() < inv.getPrice())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", title=" + title + ", authorArtist=" + authorArtist + ", price=" + price + ", numInStock=" + numInStock + '}';
    }
    public String toCSV() {
        return productID + "," + title + "," + authorArtist + "," + price + "," + numInStock;
    }
    
    
            
    
}

