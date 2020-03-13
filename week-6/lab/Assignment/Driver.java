import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;



public class Driver {
  private static Customer[] customerList = new Customer[1000];
  private static Product[]  productList  = new Product[1000];
  private static Account[]  accountList  = new Account[1000];
  private static Invoice[]  invoiceList  = new Invoice[1000];
	public static void main(String[] args) {
    
      Address addy = new Address("123 This St","13803");
      Product prod = new Product("Cookie","Delicious",31.41,"110BELHHAL");
      Customer cust = new Customer("Bill","Nye","nyetheguy@aol.com",addy);
      Account acct = new Account("someididk",cust,93240.23,50000);
      LocalDate date = LocalDate.of(2018,12,19);
      acct.setDate(date);
      Invoice invc = new Invoice("001",acct,10,date);
      invc.addProduct(prod);
      Invoice invc2 = new Invoice("420",new Account("thisisid",new Customer("Danny","Devito","bigboidanny@gmail.edu",new Address("69 Who Ave","09696")),100,250),13,date);
      Product prod2 = new Product("Oreo","tasty",31.41,"001eowfijw");
      invc2.addProduct(prod2);
      System.out.println(invc);
      System.out.println(invc2);
      System.out.println(invc.compareTo(invc2));
    
    fillCustomerList();
    fillProductList();
    fillAccountList();
    fillInvoiceList();
    sortInvoiceList();
    printer();
    
    
    } //End of main
  
  private static void printer(){
    Scanner input = new Scanner(System.in);     
    System.out.println("Proceeding to print Invoice List sorted by least amount due."+
                        "\nEnter 1 to proceed to print next Invoice."+
                        "\nEnter '0' to stop.\n");
    try {
      Thread.sleep(500); 
   } catch (Exception e) {
      e.printStackTrace();
   }
    int i = 0;
    int keypress = 1;

    while(i<1000 && keypress == 1){
      System.out.print(invoiceList[i].toString());
      System.out.println("Enter 1 to proceed to print next Invoice."+
                       "\nEnter 0 to stop.\n");
      keypress = input.nextInt();
      System.out.print("\033[H\033[2J");

      i++;
    }
    input.close();
  }
  private static void fillCustomerList(){
    String[]       fileList    = new String[4];
    String[]       secondList = new String[4];
    String         file        = "customers.txt";
    String         street;
    String         line        = "";
    String         fileSplitBy = "\t";
    BufferedReader br          = null;
    try {
  
      br = new BufferedReader(new FileReader(file));
      for(int i = 0;i < 1000; i++){
        line          = br.readLine();
        fileList      = line.split(fileSplitBy, 4);
        secondList = fileList[3].split(fileSplitBy, 4);
        street = secondList[0] +" "+ secondList[1] +" "+ secondList[3];
        Address address = new Address(street, secondList[3]);
        Customer customer = new Customer(fileList[0], fileList[1], fileList[2], address);
        customerList[i] = customer;
      }//End of file reading loop
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }	//End of fillZipList method

  private static void fillProductList(){
    BufferedReader br          = null;
    String[]       fileList    = new String[4];
    String         file        = "products.txt";
    String         line        = "";
    String         fileSplitBy = "\t";
    String         prodName;                  //prod short for Product
    String         prodDesc;
    String         prodSku;
    double         prodPrice   = 0.0;
    
    try {
  
      br = new BufferedReader(new FileReader(file));
      for(int i = 0;i < 1000; i++){
        line          = br.readLine();
        fileList      = line.split(fileSplitBy, 4);
        prodName  = fileList[0];
        prodDesc  = fileList[1];
        prodSku   = fileList[3];
        prodPrice = Double.parseDouble(fileList[2]);
        Product product = new Product(prodName, prodDesc, prodPrice, prodSku);
        productList[i] = product;
      }//End of file reading loop
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  } //End of fillProductList method

  private static void fillAccountList(){
    DecimalFormat df = new DecimalFormat("###.##");
    LocalDate currentDate = LocalDate.now();
    int randomNumberDays;
    Random randomNum = new Random();
    double randomBal = 0.0;
    String id = ""; //Placeholder id
    for(int i = 0; i < 1000; i++){
      Customer customer = customerList[i];
      randomNumberDays = 15 * (randomNum.nextInt(365));
      LocalDate randomDate = currentDate.minusDays(randomNumberDays);
      randomBal = 10000 * (randomNum.nextDouble());
      randomBal = Double.parseDouble(df.format(randomBal));
      Account account = new Account(id, customer, randomBal, (Double.parseDouble(df.format(randomBal * .10))),randomDate);
      accountList[i] = account;
    }//End of forLoop

  } //ENd of fillAccountList method

  private static void fillInvoiceList(){
    LocalDate date    = LocalDate.now();
    Random randomNum  = new Random();
    
    for(int i = 0; i < 1000; i++){
      double amount = 0.0;
      String inv_num  = Integer.toString(i+1);
      int randAcct    = randomNum.nextInt(1000);
      Account account = accountList[randAcct];
      Invoice invoice = new Invoice(inv_num, account, amount, date);
      invoiceList[i] = invoice;

      int randProdNum = randomNum.nextInt(20)+1;
      for(int j = 0; j < randProdNum; j++){
        int randProd  = randomNum.nextInt(1000);
        Product product = productList[randProd];
        invoice.addProduct(product);
      }
    } //End of forLoop
  } //End of fillInvoiceList method

  private static void sortInvoiceList(){
    for(int i = 0; i < 1000; i++){
      int index = i;
      for(int j = i+1; j < 1000; j++){
        if(invoiceList[index].compareTo(invoiceList[j])== 1) index = j;
      }
      Invoice smallerInvoice = invoiceList[index];
      invoiceList[index] = invoiceList[i];
      invoiceList[i] = smallerInvoice;
    }
  } //End of sortInvoiceList
} //End of class