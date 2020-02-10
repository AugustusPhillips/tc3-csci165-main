import java.util.Scanner;



public class inputTranslater{
    public static void main(String[] args){
        
        String[] code;                              //Initialize new array
        code = new String[10];
        
        String encoded = "*BEA@FK%RM";              //Create string to hold the code that will be transferred into the array
        
        for (int i = 0;i < encoded.length();i++){   //Add the code to the array via for-loop
            code[i]= encoded.substring(i,i+1);
            
        }
        Scanner input = new Scanner(System.in);     //Create input for the number 
        System.out.println("Welcome to The KenSpeaker3000");
        System.out.println("Please enter a sequence of numbers: ");
        String num = input.nextLine();

        String translated = "";                     //Create variable to hold the translated number

        for (int i = 0; i < num.length();i++){      //Plug each individual number into the code index
            int x = Integer.valueOf(num.substring(i, i+1));
            translated += code[x];                  //Add the translated number to the final output

        }
        
        System.out.printf("The inputed number, %s translated to KenSpeakTM, is: %s\n", num, translated);
    }
}