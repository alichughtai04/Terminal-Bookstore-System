/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chughtaialiproject3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aachu
 */
public final class BookstoreOperator implements BookstoreSpecification {

    private String customerName;
    private String currentDate;
    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<CD> cdList = new ArrayList<CD>();
    private ArrayList<DVD> dvdList = new ArrayList<DVD>();
    private ArrayList<PremiumMember> pMemberList = new ArrayList<PremiumMember>();
    private ArrayList<RegularMember> rMemberList = new ArrayList<RegularMember>();
    public ArrayList<CD> cdPurchase = new ArrayList<>();
    public ArrayList<Book> bookPurchase = new ArrayList<>();
    public ArrayList<DVD> dvdPurchase = new ArrayList<>();   
/**
 * 
     * @throws java.io.FileNotFoundException
 */
    public BookstoreOperator() throws FileNotFoundException, IOException 
    {
        String path = "C:\\Users\\aachu\\Documents\\NetBeansProjects\\ChughtaiAliProject3\\src\\chughtaialiproject3\\ProductInventory.csv";    
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = " ";
        br.readLine();
        
        while((line = br.readLine()) != null)
        {
            String[] data = line.split(",");
            if (data[1].equals("book")) {
                int productID = Integer.parseInt(data[0]);
                String title = data[2];
                String authorArtist = data[3];
                int numInStock = Integer.parseInt(data[4]);
                double price = Double.parseDouble(data[5]);
                addBook(new Book(productID, title, authorArtist, numInStock, price));
            }
            if (data[1].equals("cd")) {
                int productID = Integer.parseInt(data[0]);
                String title = data[2];
                String authorArtist = data[3];
                int numInStock = Integer.parseInt(data[4]);
                double price = Double.parseDouble(data[5]);
                addCD(new CD(productID, title, authorArtist, numInStock, price));
            }
            if (data[1].equals("dvd")) {
                int productID = Integer.parseInt(data[0]);
                String title = data[2];
                String authorArtist = data[3];
                int numInStock = Integer.parseInt(data[4]);
                double price = Double.parseDouble(data[5]);
                addDvd(new DVD(productID, title, authorArtist, numInStock, price));
            }
            
        } // end while
           
    }
   
    public void displayBook() {
        for (int i = 0; i < bookList.size(); i++) {
                System.out.println(bookList.get(i));
        }
    }
    
    public void displayDvd() {
        for (int i = 0; i < dvdList.size(); i++) {
                System.out.println(dvdList.get(i));
        }
    }
    public void displayCd() {
        for (int i = 0; i < cdList.size(); i++) {
                System.out.println(cdList.get(i));
        }
    }
    
    public double getTotalOrderPrice(ArrayList<DVD> a, ArrayList<Book> b, ArrayList<CD> c) {
    double totalDvdPrice = 0;

    if (!a.isEmpty()) {
        for (int i = 0; i < a.size(); i++) {
            totalDvdPrice += a.get(i).getPrice();
        }
    }

    double totalBookPrice = 0;

    if (!b.isEmpty()) {
        for (int i = 0; i < b.size(); i++) {
            totalBookPrice += b.get(i).getPrice();
        }
    }

    double totalCdPrice = 0;

    if (!c.isEmpty()) {
        for (int i = 0; i < c.size(); i++) {
            totalCdPrice += c.get(i).getPrice();
        }
    }

    return totalDvdPrice + totalBookPrice + totalCdPrice;

        } // end method
    
/**
 * 
 * @return 
 */
    public String getCustomerName() {
        return customerName;
    }
/**
 * 
 * @param customerName 
 */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
/**
 * 
 * @return 
 */
    public String getCurrentDate() {
        return currentDate;
    }
/**
 * 
 * @param currentDate 
 */
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

/**
 * 
 * @param object 
 */    
    public void addBook(Book object)
    {
        bookList.add(object);
    }
/**
 * 
 * @param object 
 */
    public void addDvd(DVD object)
    {
        dvdList.add(object);
    }
/**
 * 
 * @param object 
 */
    public void addCD(CD object)
    {
        cdList.add(object);
    }
/**
 * 
 * @param bookNum
 * @param DvdNum
 * @param CdNum 
     * @return  
 */   
    /**
 * 
 * @return total price of pet inventory 
 */
    @Override
    public double inventoryValue() {
        double totalCost = 0.0;
        for (int i = 0; i < bookList.size(); i++){
            totalCost += bookList.get(i).getPrice();
        }
        for (int i = 0; i < dvdList.size(); i++){
            totalCost += dvdList.get(i).getPrice();
        }
        for (int i = 0; i < cdList.size(); i++){
            totalCost += cdList.get(i).getPrice();
        }
        return totalCost;
    }   
   
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<CD> getCdList() {
        return cdList;
    }

    public ArrayList<DVD> getDvdList() {
        return dvdList;
    }

}// end class
