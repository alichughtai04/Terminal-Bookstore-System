/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chughtaialiproject3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author aachu
 */
public class BookstoreMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BookstoreOperator bookstore = new BookstoreOperator();
        Scanner user = new Scanner(System.in);
                
        ArrayList<DVD> dvdOrderList = new ArrayList<DVD>();
        ArrayList<Book> bookOrderList = new ArrayList<Book>();
        ArrayList<CD> cdOrderList = new ArrayList<CD>();
        ArrayList<Customer> members = new ArrayList<>();
        
        System.out.println("Welcome to Ali's Bookstore!");
        System.out.println();
        members.add(new Customer("Ali", "aachughtai2k4@gmail.com", "card", false, true, 0.0));
        int memberID = 0;
        boolean run = true;
        
        try {
            File file = new File("src/endOfDay.txt");
            FileWriter fwriter = new FileWriter(file);
            PrintWriter pwriter = new PrintWriter(fwriter);
            
            pwriter.println("*****************");
            pwriter.println("Days End Report");
            pwriter.println("*****************");
            pwriter.println();
        
            while(run == true){
            //initialize booleans to determine which type of membership the user chooses    
            boolean isPremiumMember = false;
            boolean isRegularMember = false;
            // create default customer
                   
            // display list of options to the user
            System.out.println("Please enter a number to begin: ");
            System.out.println("\t 1. Buy DVDs");
            System.out.println("\t 2. Buy CDs");
            System.out.println("\t 3. Buy Books");
            System.out.println("\t 4. Register new membership");
            System.out.println("\t 5. Check available items");
            System.out.println("\t 6. Check out");
            System.out.println("\t 7. Show account balance & actions");
        
            int number = user.nextInt();
            switch (number) {

                case 1:
                    // case 1 prompts the user to choose from the list of DVDs to buy, adds this selection to the order list, 
                    // and then removes the selection from the inventory list
                    bookstore.displayDvd();
                    System.out.println("Select the product ID to purchase: ");
                    int dvdNumber = user.nextInt();
                    for (int i = 0; i < bookstore.getDvdList().size(); i++) {
                        if (dvdNumber == bookstore.getDvdList().get(i).getProductID()) {
                            dvdOrderList.add(bookstore.getDvdList().get(i));
                            bookstore.getDvdList().get(i).setNumInStock(bookstore.getDvdList().get(i).getNumInStock() - 1);
                        }
                    }    
                        //bookstore.displayDvd();
                        System.out.println();
                        System.out.println("Your selection: ");
                        for (int j = 0; j < dvdOrderList.size(); j++) {
                            System.out.print(j+1 + ". ");
                            System.out.println(dvdOrderList.get(j));
                        }
                        
                    System.out.println();
                    break;
                case 2:
                    // case 2 prompts the user to choose from the list of CDs to buy, adds this selection to the order list,
                    // and then removes the selection from the inventory list
                    bookstore.displayCd();

                    System.out.println("Select the product ID to purchase: ");
                    int cdNumber = user.nextInt();
                    for (int i = 0; i < bookstore.getCdList().size(); i++) {
                        if (cdNumber == bookstore.getCdList().get(i).getProductID()) {
                            cdOrderList.add(bookstore.getCdList().get(i));
                            bookstore.getCdList().get(i).setNumInStock(bookstore.getCdList().get(i).getNumInStock() - 1);    
                        }
                    }
                        
                    
                    
                        System.out.println();
                        System.out.println("Your selection: ");
                        for (int j = 0; j < cdOrderList.size(); j++) {
                            System.out.print(j+1 + ". ");
                            System.out.println(cdOrderList.get(j));
                        }
                        

                    System.out.println();
                    break;
                case 3:
                    // case 2 prompts the user to choose from the list of Books to buy, adds this selection to the order list, 
                    // and then removes the selection from the inventory list
                    bookstore.displayBook();
                    System.out.println("Select the product ID to purchase: ");
                    int bookNumber = user.nextInt();
                    for (int i = 0; i < bookstore.getBookList().size(); i++) {
                        if (bookNumber == bookstore.getBookList().get(i).getProductID()) {
                            bookOrderList.add(bookstore.getBookList().get(i));
                            bookstore.getBookList().get(i).setNumInStock(bookstore.getBookList().get(i).getNumInStock() - 1);
                        }
                    }                       
                        System.out.println();
                        System.out.println("Your selection: ");
                        for (int j = 0; j < bookOrderList.size(); j++) {
                            System.out.print(j+1 + ". ");
                            System.out.println(bookOrderList.get(j));
                        }

                    System.out.println();
                    break;
                case 4: // case 4 registers a new member 
                    Scanner user5 = new Scanner(System.in);
                    System.out.println("Thank you for registering with us! ");
                    // prompts user for personal and contact information
                    System.out.println("Please enter your name: ");
                    String name = user5.nextLine();
                    System.out.println("Please enter your email: ");
                    String email = user5.nextLine();
                    System.out.println("Please enter your preffered payment method: ");
                    System.out.println("Press 1 for Card or 2 for Cash: ");
                    String paymentMethod = "";
                    // sets payment method to card or cash based on user input
                    int paymentSelector = user5.nextInt();
                    if (paymentSelector == 1) {
                        paymentMethod = "Card";
                    }
                    if (paymentSelector == 2) {
                        paymentMethod = "Cash";
                    }
                    System.out.println("Press 1 for Premium membership or press 2 for Regular membership");
                    int membershipSelector = user5.nextInt();
                    boolean premiumMemberStatus = false;
                    boolean regularMemberStatus = false;
                    // sets the type of membership to premium or regualar based on user input
                    if (membershipSelector == 1) {
                        premiumMemberStatus = true;
                    }
                    if (membershipSelector == 2) {
                        regularMemberStatus = true;
                    }

                    double totalAfterTax = 0;
                    // creates new customer based on the information provided from the user and increments the member ID
                    Customer customer1 = new Customer(name, email, paymentMethod, regularMemberStatus, premiumMemberStatus, totalAfterTax);
                    memberID++;
                    // add new customer to list of members 
                    members.add(customer1);
                    System.out.println(customer1);
                    System.out.println("Thank you " + customer1.getCustomerName()+ ", your registration was succesful! ");
                    System.out.println("Your member ID is: " + memberID);
                    pwriter.println("*****************");
                    pwriter.println("New member registered: ");
                    pwriter.println(customer1);
                    pwriter.println("*****************");                                                 
                    break;
                case 5:
                    // case 5 displays the stock currently available to purchase
                    System.out.println("The current items we have in stock are: ");
                    System.out.println("Press 1 to filter the price from low to high");
                    bookstore.displayDvd();
                    System.out.println();
                    bookstore.displayCd();
                    System.out.println();
                    bookstore.displayBook();
                    System.out.println();
                    System.out.println("The choice is yours!");
                    System.out.println();
                    
                    Scanner user6 = new Scanner(System.in);
                    int sort = user6.nextInt();
                    if (sort == 1) {
                        Collections.sort(bookstore.getBookList());
                        Collections.sort(bookstore.getDvdList());
                        Collections.sort(bookstore.getCdList());
                        bookstore.displayDvd();
                        System.out.println();
                        bookstore.displayCd();
                        System.out.println();
                        bookstore.displayBook();    
                    }
                    break;
                case 6:
                    // case 6 totals the selections made by the user and completes the transaction 
                    Scanner checkoutUser = new Scanner(System.in);
                    System.out.println("Your cart: ");

                    // displays dvd selections
                    for (int i = 0; i < dvdOrderList.size(); i++) {
                        System.out.print(i+1 + ". ");
                        System.out.println(dvdOrderList.get(i));
                        }
                    // displays cd selections
                    for (int i = 0; i < cdOrderList.size(); i++) {
                        System.out.print(i+1 + ". ");
                        System.out.println(cdOrderList.get(i ));
                        }
                    // displays book selections
                    for (int i = 0; i < bookOrderList.size(); i++) {
                        System.out.print(i+1 + ". ");
                        System.out.println(bookOrderList.get(i ));
                        }
                    // calls the getTotalOrderPrice() method to sum up the price of all the ArrayLists which contain
                    // the user selections and stores this in subtotal
                    double subtotal = bookstore.getTotalOrderPrice(dvdOrderList,bookOrderList, cdOrderList);
                    // computes the total after 4% tax rate 
                    totalAfterTax = subtotal * 1.04; 
                    double tax = totalAfterTax - subtotal;
                    // sets the amount spent by the customer to the totalAfterTax 
                    members.get(memberID).setAmountSpent(totalAfterTax);

                    // displays the amount charged 
                    System.out.println("subtotal: $" + String.format("%.2f",subtotal));
                    System.out.println("tax: $" + String.format("%.2f",tax));
                    System.out.println("total: $" + String.format("%.2f", totalAfterTax));

                    System.out.println("Press 1 to pay with card");
                    System.out.println("Press 2 to pay with cash");
                    int selectPayment = checkoutUser.nextInt();
                    String checkoutPaymentMethod = "";
                    // chooses payment method, card or cash based on user input 
                    if (selectPayment == 1) {
                        checkoutPaymentMethod = "Card";
                    }
                    if (selectPayment == 2) {
                        checkoutPaymentMethod = "Cash";
                    }
                    // finishes transaction and displays the purchase receipt
                    System.out.println("Please press 1 to complete transaction: ");
                    int completeTransaction = checkoutUser.nextInt();
                    if (completeTransaction == 1) {
                        System.out.println("Thank you for shopping with us! Have a nice day!");
                        System.out.println("Here is your receipt: ");
                        System.out.println();
                        System.out.println("**************");
                        System.out.println("**************");
                        System.out.println("Ali's Bookstore inc.");

                        for (int i = 0; i < dvdOrderList.size(); i++) {
                        System.out.print("* DVD| " + dvdOrderList.get(i).getTitle());
                        System.out.print(" - ");
                        System.out.println("$" + dvdOrderList.get(i).getPrice());
                        }
                        pwriter.println("DVDs sold: " + dvdOrderList.size());

                        for (int i = 0; i < cdOrderList.size(); i++) {
                        System.out.print("* CD| " + cdOrderList.get(i ).getTitle());
                        System.out.print(" - ");
                        System.out.println(cdOrderList.get(i).getPrice());
                        }
                        pwriter.println("CDs sold: " + cdOrderList.size());

                        for (int i = 0; i < bookOrderList.size(); i++) {
                        System.out.print("* Book| " + bookOrderList.get(i ).getTitle());
                        System.out.print(" - ");
                        System.out.println(bookOrderList.get(i).getPrice());
                        }
                        pwriter.println("Books sold: " + bookOrderList.size());

                        System.out.println("- subtotal: $" + String.format("%.2f",subtotal));
                        System.out.println("- tax: $" + String.format("%.2f",tax));
                        System.out.println("- total: $" + String.format("%.2f", totalAfterTax));
                        System.out.println("- Payed by: " + checkoutPaymentMethod );
                        System.out.println("- Come back soon! ");
                        System.out.println("**************");
                        System.out.println("**************");
                        System.out.println(); 
                        
                        pwriter.println("Total sale amount: $" + String.format("%.2f", totalAfterTax));
                        pwriter.println("*****************");
                        pwriter.close();
                        
                        FileOutputStream fs = new FileOutputStream("C:\\Users\\aachu\\Documents\\NetBeansProjects\\ChughtaiAliProject3\\src\\BookInventoryDay2.csv");
                        PrintWriter outFS = new PrintWriter(fs);
                        outFS.println("productID,type,title,author/artist,numInStock,price");
                        for (int i = 0; i < bookstore.getBookList().size(); i++) {
                            outFS.println(bookstore.getBookList().get(i).toCSV());
                        }
                        for (int i = 0; i < bookstore.getCdList().size(); i++) {
                            outFS.println(bookstore.getCdList().get(i).toCSV());
                        }
                        for (int i = 0; i < bookstore.getDvdList().size(); i++) {
                            outFS.println(bookstore.getDvdList().get(i).toCSV());
                        }
                        outFS.close();
                        
                    } // end if
                    break;
                case 7:
                    // tells user to register as a member to display their account information
                    // press 0 to display my default member information
                    System.out.println("You must register as a member to show account information! ");
                    System.out.println("Enter memberID: ");
                    int memberIDSelection = user.nextInt();
                    // based on the user's memberID, display the member information
                    if (memberIDSelection == memberID) {
                        System.out.println(members.get(memberID));
                    }
                    int accountBalance = 20;
                    // checks if the member at this memberID is a regular member and displays the account balance
                    if (members.get(memberID).isRegularMember() == true) {
                        System.out.println("Your current account balance is $0 ");
                    }
                    // checks if the member at this memberID is a premium member and displays the account balance
                    if (members.get(memberID).isPremiumMember() == true) {
                        System.out.println("Your monthly bill of $" + accountBalance + " is due: ");
                        System.out.println("Press 1 to pay your membership balance: ");
                        System.out.println("Press 2 to cancel your membership: ");
                        int selection = user.nextInt();
                        // if users selects 1, pay membership fee by setting accountBalance to 0;
                        if (selection == 1){
                            accountBalance = 0;
                            System.out.println("Your membership payment was succesful");
                            System.out.println("Account Balance: $" + accountBalance);
                        }
                        // if user selects 2, set premium member status to false
                        if (selection == 2) {
                            members.get(memberID).setPremiumMember(false);
                            System.out.println("Your membership has been cancelled! ");
                        }
                    }
                    //checks if user at memberID is regular member, shows account balance and prompts user to cancel membership
                    if (members.get(memberID).isRegularMember() == true) {
                        System.out.println("Regular Member: ");
                        System.out.println("You have $0 due!");
                        System.out.println("Press 1 to cancel your membership");
                        int selection = user.nextInt();
                        // set regualarMember to false if user selects 1
                        if (selection == 1) {
                            members.get(memberID).setRegularMember(false);
                            System.out.println("Your membership has been cancelled! ");
                        }
                    }                    
                    break;       
            } // end while     
            } // while (run == true)
                        
        } // end try
            catch(InputMismatchException e)
            {
                System.out.println("Incorrect value please restart the System. ");
            }
            catch(FileNotFoundException e)
            {
                System.out.println("The file cannot be found. Please check file name.");
            }
            catch(IOException e)
            {
                System.out.println("IOexception has been found please check your responses.");
            }
            catch(Exception e)
            {
                System.out.println("The System has caught an exeption.");
            }
            finally
            {
                System.out.println("Please restart the application.");
            }   
        } // end main method
    } // end class

