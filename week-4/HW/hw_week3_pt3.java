import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.lang.*;


public class hw_week3_pt3{
    // Create final static variables for the number of rows and columns in the array.
    final static int NUM_ROWS   = 50;
    final static int NUM_COLUMNS    = 20;

    public static void main(String[] args){
        int[][] matrix = new int[50][20];                   //Initalize the array.
        fillArray(matrix);                                  //Call the fillArray method to fill the array from the number list.
        
        //Scanner and inputs for row and num_cols, for the printRow method
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the row number you would like,(0-%d): ",NUM_ROWS);
        int row = input.nextInt();

        System.out.printf("Enter the number of columns you would like row %d to be printed in: ",row);
        int num_cols = input.nextInt();
        
        printRow(matrix, row, num_cols);                    //Calling the printRow method
                                                            //Printing the output of the smallestChange method
        System.out.printf("The row with the smallest change between values is row: %d\n",smallestChange(matrix));

    } //End of main method.

    public static void fillArray(int[][] matrix){
        //try and catch for filling the array
        try{    //Standard process for filling an array from a .txt file, column major.
            FileReader fileReader = new FileReader("number_list.txt");
            Scanner scanner = new Scanner(fileReader);
           
            for(int j = 0; j < NUM_COLUMNS; j++){

                for(int i = 0; i < NUM_ROWS; i++){
                    int num = scanner.nextInt();
                    matrix[i][j] = num;
                }
            }
            fileReader.close();
            scanner.close();
            
        }
        catch(IOException ioe){
            
            System.out.println("File issue");
        }
    } //End of fillArray method

    public static void printRow(int[][] matrix, int row, int num_cols){
        fillArray(matrix);                              // Calling the array.
        int counter = 0;                                // Initalizing a counter that will be used to count the 
        for(int z = 0;z < NUM_COLUMNS;z++){             // number of columns already printed.
            
            System.out.printf(" %d  ", matrix[row][z]); // Printing the row values for the inputed row #.
            counter++;                                  // Adding to the counter.
            if(counter == num_cols){                    // Once the counter equals the inputed num_cols,
                System.out.println();                   // a line break is printed
                counter = 0;                            // and the counter is reset to 0.
            }
        }
        System.out.println();
    } //End of printRow method

    public static int smallestChange(int[][] matrix){
        fillArray(matrix);                              // Calling the array.
        int smallestSum= 999999;                        // Creating a sum variable, hopefully the sum doesn't exceed this. 
        int rowIndex = 0;                               // Creating a variable to keep track of the row index.
        for(int i=  0; i < NUM_ROWS;i++){               // For loop to go through each row.
            int sum= 0;
            int result= 0;
            for(int j= 1;j < NUM_COLUMNS;j++){          // For loop to go through each coloumn for i row.
                result = matrix[i][j] - matrix[i][j-1]; // Getting the difference between the two adjacent values.
                sum += Math.abs(result);                // Ensuring that the result is postive, adding to the sum.
            }
            if(smallestSum > sum){                      // If the row sum is smaller than the smallestSum,
                smallestSum = sum;                      // smallestSum will now equal the sum.
                rowIndex = i;                           // The rowIndex will equal the current row in the top for loop.
            }

        }
        return rowIndex;                                // Returning the rowIndex
    } //End of smallestChange method

}     //End of class