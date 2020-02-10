import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;


public class fileTranslater{
    public static void main(String[] args){
        String[] code;                              //Initialize new array
        code = new String[10];
        
        String encoded = "*BEA@FK%RM";              //Create string to hold the code that will be transferred into the array
        
        for (int i = 0;i < encoded.length();i++){   //Add the code to the array via for-loop
            code[i]= encoded.substring(i,i+1);
            
        }

        
        try{
            FileReader fileReader = new FileReader("numbers.txt");
            Scanner input = new Scanner(fileReader);     //Create input for the nu

            File file = new File("translatedNumbers.txt"); //Create new file
            FileWriter fileWriter = new FileWriter(file); //Initiate fileWriter
            while(input.hasNext()){ //Loop that continues while there is another line in the number.txt file to read
                String num = input.nextLine();
                String translated = "";                     //Create variable to hold the translated number, must be reset after every number

                for (int i = 0; i < num.length();i++){      //Plug each individual number into the code index
                    int x = Integer.valueOf(num.substring(i, i+1));
                    translated += code[x];                  //Add the translated number to the final output
                    
                }
                //Write results to file
                
                fileWriter.write(translated);   //Write the translated njmber to the file
                fileWriter.write(System.lineSeparator());   //Begin the next write on a new line
                
            }
            fileWriter.close(); //close the writer
        
        }catch(IOException ioe){
            System.out.println("File issue");
        }


        
    }
}