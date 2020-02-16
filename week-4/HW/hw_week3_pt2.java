import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;


public class hw_week3_pt2{
    final static int NUM_ROWS   = 50;                   // Creating final static vaeriables for the number
    final static int NUM_COLUMNS    = 20;               // of rows and columns in the array

    public static void main(String[] args){

        int[][] matrix = new int[50][20];               //Initalizing the array.
        fillArray(matrix);                              //Calling the fillArray method to fill the array

        Scanner input = new Scanner(System.in);

        System.out.printf("Please enter the row number you would like,(0-%d): ",NUM_ROWS);
        int row = input.nextInt();                      // Asking the user to input a row number
        System.out.printf("The maximum value in row #%d is: %d\n"+
                          "The minimum value in row #%d is: %d\n",
                          row, findMaxOfRow(matrix, row), row,findMinOfRow(matrix, row) );


        System.out.printf("Please enter the column number you would like,(0-%d): ",NUM_COLUMNS);
        int column = input.nextInt();                   // Asking the user to enter a column number
        System.out.printf("The maximum value in column #%d is: %d\n"+
                          "The minimum value in column #%d is: %d\n",
                          column, findMaxOfColumn(matrix, column), column,findMinOfColumn(matrix, column) );
    

    }                                                   // End of main method.

    public static void fillArray(int[][] matrix){
        // Standard process of filling an array from .txt file, in row major order
        try{
            FileReader fileReader = new FileReader("number_list.txt");
            Scanner scanner = new Scanner(fileReader);
           
            for(int i = 0; i < NUM_ROWS; i++){

                for(int j = 0; j < NUM_COLUMNS; ++j){
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

    }                                                   // End of fillArray method.

    public static int findMax(int[][] matrix){
        fillArray(matrix);                              // Calling the array.
        int max = 0;                                    // Creating variable to hold the max value.
        
        for(int i = 0; i < NUM_ROWS;i++){               // Nested for loops that run through the array in row major order.
            for(int j = 0;j < NUM_COLUMNS;j++){
                int num = matrix[i][j];
                if(num > max){                          // Testing the current value, if greater then max,
                    max = num;                          // then current value is max.
                }
            }
        }
        return max;                                     // Return the max.
    }                                                   // End of findMax method.

    public static int findMin(int[][] matrix){
        fillArray(matrix);                              // Call the array.
        int min = findMax(matrix);                      // Use the findMAx method to set the minimum value.
        for(int i = 0; i < NUM_ROWS;i++){               // nested for loops to run through the loop in
            for(int j = 0;j < NUM_COLUMNS;j++){         // row major order.
                int num = matrix[i][j];
                if(min > num){                          // If the current num is smaller then the minimum,
                    min = num;                          // then the current num is the minimum.
                }
            }
        }
        return min;                                     // Returning the minimum

    }                                                   // End of findMin method.

    public static int findMaxOfRow(int[][] matrix, int row){
        fillArray(matrix);                              // Calling the array.
        int rowMax = 0;                                 // Creating variable to hold max value.

        for(int j = 0;j < NUM_COLUMNS;j++){             // For loop to run through the columns, row is already 
            int num = matrix[row][j];                   // specified by user input.

            if(num > rowMax){                           // Standard process for finding max value.
                rowMax = num;
            }
        }  
        return rowMax;                                  // Returning the rowMax.
    }                                                   // End of findMaxOfRow method.
    
    public static int findMinOfRow(int[][] matrix, int row){
        fillArray(matrix);                              // Calling the array.
        int rowMin = findMaxOfRow(matrix, row);         //Repeating the process for finding the max, except for the minimum.

        for(int j = 0;j < NUM_COLUMNS;j++){
            int num = matrix[row][j];

            if(rowMin > num){
                rowMin = num;
            }
        }  
        return rowMin; 
        
    }                                                   // End of findMinOfRow method.

    public static int findMaxOfColumn(int[][] matrix, int column){
        fillArray(matrix);                              // Calling the array.
        int columnMax = 0;
        for(int i = 0;i < NUM_ROWS;i++){                // Similar to methods for finding row max, except finding max
            int num = matrix[i][column];                // of a user inputed column.

            if(num > columnMax){
                columnMax = num;
            }
        }  
        return columnMax;

    }                                                   // End of findMaxOfColumn method.

    public static int findMinOfColumn(int[][] matrix, int column){
        fillArray(matrix);                              // array the Calling.
        int columnMin = findMaxOfColumn(matrix, column);
        for(int i = 0;i < NUM_ROWS;i++){                // Repeating the process for finding the row minimum, except for 
            int num = matrix[i][column];                // user inputed column

            if(columnMin > num){
                columnMin = num;
            }
        }  
        
        return columnMin;
    }                                                   // End of findMaxOfColumn method.
}                                                       // End of public class.