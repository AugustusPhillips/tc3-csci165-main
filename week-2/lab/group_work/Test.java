import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Test{
    public static void main(String args[]){
        try{
            File ticketList = new File("tickets.txt");
            Scanner fileScanner = new Scanner(ticketList);

            FileWriter vTickets = new FileWriter("ValidTickets.txt");

            int count = 0;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                  
                String  last = line.substring(line.length() - 1);                                                   
                int     last_digit = Integer.valueOf(last);
                String  reduced_ticket = line.substring(0, line.length() - 1);
                int     ticket_number = Integer.valueOf(reduced_ticket);
                int     remainder = ticket_number % 7; 
                boolean validity = remainder == last_digit; 

                  
                if (validity == true){
                    vTickets.write(line+"\n");
                    //count++;
                    //System.out.println(count);
                    //System.out.printf(ticket+"\n");
                }
            }
            vTickets.close();
            fileScanner.close();
        }

        catch(FileNotFoundException fnf){
            System.out.println("error: FNF");
        
        } catch(IOException fnw){
            System.out.println("Error: File Not Written.");
        }
    }
}
