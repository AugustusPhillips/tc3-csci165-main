import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;



public class hw_week3_pt1{

    public static void main(String[] args){

        int[] array = new int[1000];                    // Initalizing the array.
        fillArray(array);                               // Calling the fillArray method.
        System.out.printf("The maximum value in the array is: %d\n", findMax(array));// Printing max and
        System.out.printf("The minimum value in the array is: %d\n", findMin(array));// min values of the array.
        percentChange(array);                           // Calling the percentChange method.
      
    }//End of main method

    public static void fillArray(int[] array){
        // Creating try and catch for scanning file.
        try{
            FileReader fileReader = new FileReader("number_list.txt");
            Scanner input = new Scanner(fileReader);    // Scanner to file the file.
            int counter = 0;

            while(input.hasNextInt()){                  // Loop that add each Int from the file into the array.
                int num = input.nextInt();
                array[counter] = num;
                counter++;
            }
        }//End of try
        catch(IOException ioe){
            
            System.out.println("File issue");
        }

    }//End of fillArray Method

    public static int findMax(int[] array){

        fillArray(array);                               // Calling the array.
        int max = 0;                                    // Create max value variable.
        
        for(int i = 0; i < array.length;i++){           // For loop to scan each value of the array.
            int num = array[i];                         // Probably don't need to have this variable
            if(num > max){                              // If current value of array is larger then
                max = array[i];                         // the max, max will equal current.
            }
        }//End of max loop

        return max;                                     // Return the max
    }//End of findMAx method

    public static int findMin(int[] array){
        int min = findMax(array);                       // Not calling the array, using the findMax method to determine minimum
        for(int i = 0; i < array.length; i++){          // Looping through the array.
            if(min > array[i]){                         // If current value of array is smaller then
                min = array[i];                         // minimum, minimum will equal current.
            }


        }//End of min loop
        return min;                                     // Return the min. 
    }//End of findMin method

    public static int[] percentChange(int[] array){

        int[] per_change = new int[1000];               // Initalize array to hold the values.
        fillArray(array);                               // The array is called.

        for(int i = 1; i < array.length;i++){           // Loop through the main array.
            double current = array[i];
            double previous = array[i-1];
            double result = (((current - previous) / previous)*100);
            per_change[i-1] = (int)result;              // Result from the math is converted to an integer.
        }
        return per_change;                              // Return the array.

    }//End of percentChange method
} //End of hwWK3 class