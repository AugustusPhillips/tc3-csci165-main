import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.lang.Object;
import java.io.*;
import java.text.DecimalFormat;
import java.io.FileWriter;

public class FoodTruck{
    public static void main(String[] args) {
        //Create menu and price arrays
        String[] menu_array;
        double[] price_array;
        menu_array = new String[3];
        price_array = new double[3];
        //Scan the files, insert data from files into their respective arrays
        try{

            File menu_file = new File("menu.txt");
            File price_file = new File("prices.txt");
            Scanner menuScanner = new Scanner(menu_file);
            Scanner priceScanner = new Scanner(price_file);
            int index = 0;

            while(index < 3){

                menu_array[index] = menuScanner.nextLine();
                price_array[index] = priceScanner.nextDouble();
                index++;
            } 

            menuScanner.close();
            priceScanner.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println("ERROR: FILE NOT FOUND!");

        }

        
        System.out.printf("Welcome to the CS Food Truck.%n%n");

        Scanner name_input = new Scanner(System.in);                //User inputs their name
        System.out.printf("Please enter your name: ");
        String name = name_input.nextLine();
        
        Scanner order_input = new Scanner(System.in);               //Create new array to keep track of order quantity
        double[] order_array;
        order_array = new double[3];
        System.out.println();
        System.out.printf("Enter the quantity of each item:%n"+
        "=================================%n");
        for(int i = 0; i < menu_array.length; i++){                 //loop for ordering,

            System.out.printf("%s - $%.2f: ", menu_array[i], price_array[i]);
            order_array[i] = order_input.nextInt();
            System.out.println();

        }
        
        
        LocalDateTime timeLocal = LocalDateTime.now();              //Determining the local time
        String DatePattern = "MM/dd/yyyy";                          //Creating format patterns
        String TimePattern = "HH:mm:ss";
        String DTPattern = "ddMMHHmm";
        DateTimeFormatter DateFormatter = DateTimeFormatter.ofPattern(DatePattern); //Using format patterns to create variables 
        DateTimeFormatter TimeFormatter = DateTimeFormatter.ofPattern(TimePattern); //that will be used later in the program
        DateTimeFormatter DTFormatter = DateTimeFormatter.ofPattern(DTPattern);

        String date_time = DTFormatter.format(timeLocal);
        String date = DateFormatter.format(timeLocal);
        String time = TimeFormatter.format(timeLocal);
        
        
        name = name.toUpperCase();                                  //Grabbing the required initals from the name
        char f_init = name.charAt(0);
        int space = name.indexOf(" ");
        char l_init = name.charAt(space+1);
        char f_init2 = name.charAt(1);
        char l_init2 = name.charAt(space+2);

        int f_initial = (int)f_init;                                //Sum of the Initals, length of name
        int l_initial = (int)l_init;
        int sum = f_initial + l_initial;
        int length = name.length();
        sum = sum * length;

        String f = String.valueOf(f_init);                          //Converting back into strings
        String l = String.valueOf(l_init);
        String f2 = String.valueOf(f_init2);
        String l2 = String.valueOf(l_init2);

        DecimalFormat df = new DecimalFormat("#");                  //COnverting sum of the intials into string,
        String sum_S = df.format(sum);                              //Assembling the invoice 
        String combined = f + f2 + l + l2 + sum_S;
        String invoice = combined + date_time;
        
        
        double total;                                               //Initializing variables needed
        double sub_total = 0;
        double taxe = 0;
        double order_total = 0;     

        String fileName = invoice + ".txt";                         //Create the file to hold the output
        try{

            FileWriter fileWriter = new FileWriter(fileName);  
            String line1 = String.format(                           //String that holds the first "block" of receipt
                "Invoice Number: %20s\n"+
                "Date: %24s\n"+
                "Time: %22s\n"+
                "%s %23s %10s %6s %n"+
                "==============================================%n"
                ,invoice, date, time,"Item", "Quantity","Price", "Total");
            fileWriter.write(line1);                                //Writing to the receipt file
            System.out.print(line1);

            String line2;                                           //Second receipt block
            for (int i = 0; i < menu_array.length; i++){

                double order = (double)order_array[i];              //Determining order sub-total based off of order_array and prices_array
                total = order * price_array[i];
                sub_total += total;
                line2 = String.format(                              
                "%-10s %10.0f $%.2f $%.2f\n"+
                "==============================================%n",
                menu_array[i], order_array[i], price_array[i],total);

                fileWriter.write(line2);                            //Writing second block to receipt file
                
                System.out.print(line2);
            
            }
            taxe = (.0625 * sub_total);                             
            order_total = sub_total + taxe;
             
        
            String line3 = String.format(                           //Beginning third receipt block
                "%s %30s$%.2f\n"+
                "%s %25s$%.2f\n"+
                "%s %33s$%.2f\n"
                ,"Subtotal","", sub_total, "6.25%% sales tax","", taxe, "Total","", order_total);
            System.out.print(line3);
            fileWriter.write(line3);

            fileWriter.close();                                     

        } 
        catch (IOException e) {
            System.out.println("There was a problem writing to the file");
        }
    }   
} //Notes: I got very stuck and eventually gave up on trying to get the spacing of the receipt right using printf, I should probably have looked for 
  // different methods for formatting the output. Invoice assembly is messy but works, same with the time finding/storing/formatting.