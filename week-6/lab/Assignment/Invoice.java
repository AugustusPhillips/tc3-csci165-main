import java.util.ArrayList;
import java.time.LocalDate;

public class Invoice{
    private String invoiceNumber;
    private Account account;
    private double amount = 0.0;
    private LocalDate orderDate;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Invoice(){}   //End of default Invoice constructor

    public Invoice(String inv_num, Account acct, double amount, LocalDate date){
        super();
        this.invoiceNumber = inv_num;
        this.account = acct;
        this.amount = amount;
        this.orderDate = date;
    }   //End of Invoice(S,A,d,L) constructor

    public Account getAccount(){
        return new Account(account);
    }   //End of getAccount method

    public double getAmount(){
        return amount;
    }   //End of getAmount method

    public LocalDate getDate(){
        return orderDate;
    }   //End of getDate method

    public void addProduct(Product prod){
        products.add(prod);
        this.amount += (prod.getPrice()) * (1.00 -this.account.getDiscount());
    }

    public void setDate(LocalDate date){
        this.orderDate = date; 
    }   //End of setDate method

    public Invoice(Invoice toClone){
        this.account = toClone.account;
        this.amount = toClone.amount;
        this.invoiceNumber = toClone.invoiceNumber;
        this.orderDate = toClone.orderDate;
        this.products = toClone.products;
    }   //End of toClone method
    @Override
    public String toString(){
        String string = "Invoice number: ";
        return
         string+invoiceNumber +"\n"+ account +
        "\nAmount due:  "+ amount +"\nOrder date: "+ orderDate +
        " \nProducts: "+ products+"\n"+
        "\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n" ;
    }   //End of toString merthod

    public int compareTo(Invoice otherInvoice){
        if(this.amount < otherInvoice.amount)  return -1;
        if(this.amount > otherInvoice.amount)  return  1;
        else return 0;
    }
}   //End of Invoice class