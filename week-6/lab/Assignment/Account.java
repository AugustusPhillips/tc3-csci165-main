import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Account{
    private String       accountID;
    private Customer     Customer;
    private LocalDate    dateCreated;
    private double       balance       = 0.0;
    private double       creditLimit   = 0.0;
    private double       discountLevel = 0.0;

    public Account(){}   //End of Account() constructor

    public Account(String id, Customer customer){
        super();
        this.accountID = id;
        this.Customer = customer;
    }   //End of Account(i, C) constructor

    public Account(String id, Customer customer, double balance, double creditLimit){
        this.Customer = customer;
        this.setBalance(balance);
        this.setCreditLimit(creditLimit);
        this.dateCreated = LocalDate.now();
        setID(customer);
        setDiscount();
    }
    public Account(String id, Customer customer, double balance, double creditLimit, LocalDate date){
        this.Customer = customer;
        this.setBalance(balance);
        this.setCreditLimit(creditLimit);
        setDate(date);
        setID(customer);
        setDiscount();
    }   //End of Account(i,C,d,d) constructor

    public void setID(Customer customer){
        String id = customer.getName();
        id = id.replaceAll("[AEIOUaeiou]","");
        id = id.toUpperCase();
        String date = this.dateCreated.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        int sum = 0;
        for(int i = 0; i < id.length();i++){
            int ascii = (int)id.charAt(i);
            sum += ascii;
        }
        String checkdigit = Integer.toString(sum % id.length());
        id = id + date + checkdigit;
        this.accountID = id;
    }
    public Customer getCustomer(){
        return new Customer(Customer);
    }   //End of getCustomer method

    public double getBalance(){
        return balance;
    }   //End of getBalance method

    public double getCreditLimit(){
        return creditLimit;
    }   //End of getCreditLimit

    public void setDate(LocalDate date){
        this.dateCreated = date;
        setDiscount();
    }   //End of setDate method

    public void setBalance(double b){
        if(b < 0) this.balance = 0;
        else this.balance = b;
        if(this.creditLimit >= b * 2) this.creditLimit = b*2;

    }   //End of setBalance method

    public void setCreditLimit(double cl){
        double maxCredit = this.balance * 2.0;
        if(maxCredit <= cl) this.creditLimit = maxCredit;
        else if(cl < 0) this.creditLimit = 0.0;
        else this.creditLimit = cl;
    }   //End of setCreditLimit method

    public void setDiscount(){
        LocalDate currentdate = LocalDate.now();
        double yearsCreated = 0.0;
        yearsCreated = currentdate.getYear() - this.dateCreated.getYear();
        this.discountLevel = yearsCreated *.02;
    }   //End of setDiscount method
    public double getDiscount(){
        return this.discountLevel;
    }

    public Account(Account toClone){
        this.Customer      = new Customer(toClone.Customer);
        this.accountID     = toClone.accountID;
        this.balance       = toClone.balance;
        this.creditLimit   = toClone.creditLimit;
        this.dateCreated   = toClone.dateCreated;
        this.discountLevel = toClone.discountLevel;
    }
    public String toString(){
        String string = "Account ID: ";
        return string+accountID +"\n"+ 
               Customer +"\nDate created: "+ dateCreated +"\nAccount balance: "+
                balance +"\nCredit Limit: "+ creditLimit +"\nDiscount Level: "+ discountLevel;
    }   //End of toString method
    
    public boolean equals(Account otherAccount){
        return this.accountID.equals(otherAccount.accountID)     &&
               this.Customer.equals(otherAccount.Customer)       &&
               this.dateCreated.equals(otherAccount.dateCreated) &&
               this.balance       == otherAccount.balance        &&
               this.creditLimit   == otherAccount.creditLimit    &&
               this.discountLevel == otherAccount.discountLevel;
    }   //End of equals method

    public int compareTo(Account otherAccount){
        return this.accountID.compareTo(otherAccount.accountID);
    }   //End of compareTo method

}   //End of Account classajp@ajp-HP-Laptop:~/tc3-csci165-main$ 

