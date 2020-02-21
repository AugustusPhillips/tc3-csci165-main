import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import java.lang.*;
import java.util.Random;

//a class for maintaining a 2D array of ints representing a topographic map
public class MapDataDrawer{
    //  Create variables that will be used throughout the class
    public static int rows        = 0;
    public static int columns     = 0;
    public static String fileName = "";
    private static int[][] data;
    private static int min        = 0;
    private static int max        = 0;
   //private static int indexLowestElev = 0;
    public static void main(String[] args){
        /// Read the user entered args into fileName variable
        if(args.length > 0){
            fileName = args[0];

            try{
                FileReader fr   = new FileReader(fileName);
                Scanner scanner = new Scanner(fr);
                scanner.close();
            }
            catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }

        }else System.out.println("No file name specified . . . aborting");
        // initialize array to hold njmber of rows and columns
        int[] sizeArray = new int[2];

        fileSize(fileName,sizeArray);       //Fill sizeArray via fileSize method
            rows    = sizeArray[1];         
            columns = sizeArray[0];

        data    = new int[rows][columns];   //Initialize main data array using sizes determined from filename
            MapDataDrawer(data, fileName, rows, columns);   //Fill array

        max     = findMax(data, rows, columns); //Assign max and min values
        min     = findMin(data, rows, columns);
        
        //indexOfLowestElevPath(g);

        Scanner input = new Scanner(System.in); //Input forindexOfMinRow method
        System.out.printf("Please enter the column number you would like,(0-%d): ",columns);
        int col = input.nextInt();                   // Asking the user to enter a column number
        System.out.printf("The minimum elevation of column %d is: %d\n",col,indexOfMinRow(col));
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                Drawer ex = new Drawer();
                ex.setVisible(true);
            }
        });
    }  //End of main method

    private static int[] fileSize(String fileName,int[]sizeArray){
                            //Splitting the string along "_" and removing the ".dat"
        String nums       = fileName.substring(fileName.indexOf("_")+1 , fileName.length()-4);
        String transfer[] = nums.split("x");    //Splitting the COLSxROWS by the "x" 

        String num1       = transfer[0];        //COLS and Rows are known as string, need to convert to int
        String num2       = transfer[1];

        int number1       = Integer.parseInt(num1);
        sizeArray[0]      = number1;

        int number2       = Integer.parseInt(num2);
        sizeArray[1]      = number2;
        return sizeArray;
    }   //End fileSize method

    public static void MapDataDrawer(int[][] data, String fileName, int rows, int columns){
        //read data from given file into a 2D array
        try{    
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner       = new Scanner(fileReader);
           
            for(int i = 0; i < rows; i++){

                for(int j = 0; j < columns; j++){
                    int num    = scanner.nextInt();
                    data[i][j] = num;
                }
            }
            fileReader.close();
            scanner.close();
            
        }
        catch(IOException ioe){
            
            System.out.println("File issue");
        }
        
    }   //End of MapDataDrawer method

    public static int findMin(int[][] data, int rows, int columns){
        //return the minimum value in the map
        
        int min = 99999;                                    // Creating variable to hold the max value.
        
        for(int i = 0; i < rows;i++){               // Nested for loops that run through the array in row major order.
            for(int j = 0;j < columns;j++){
                int num = data[i][j];
                if(min > num) min = num;                         // Testing the current value, if greater then max,                          // then current value is max.
            }
        }
        return min;                                     // Return the max.
    }   //End of findMin method

    public static int findMax(int[][] data, int rows, int columns){
        //return the max value in the map
        int max = 0;    //Max value variable

        for(int i = 0; i < rows; i++){          //Nested loops that test every number in the data array
            for(int j = 0; j < columns; j++){
                int num = data[i][j];
                if(num > max) max = num;        //If current value is larger than max, reassign max to current value
            }
        }
        return max; 
    }   // End of findMax method

    public static void drawMap(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        int color = 0;
        for(int i = 0; i < rows; i++){      // Nested loops to run through data in row major order
            for(int j = 0; j < columns; j++){
                int currentValue = data[i][j];
                color = (currentValue - min) / ((max - min)/255); //Using previous established min and max to set color range
                
                g2d.setColor(new Color(color, color, color));
                g2d.fillRect(j, i, 1, 1);   //Drawing the data
            }
        }
    }   //End of drawMap method

    public static int indexOfMinRow(int col){
        
        int columnMin = max;
        int rowIndex = 0;
        for(int i = 0;i < rows;i++){                // Repeating the process for finding the row minimum, except for 
            int value = data[i][col];                // user inputed column

            if(columnMin > value){
                columnMin = value;
                rowIndex = i;
            }
        }  
        
        return rowIndex;

    }   //End of indexOfMinRow method
/*
 Could not figure out how to call this method into the drawer class with the additional parameter,
 So no lowest elevation path drawn.
 Probably didn't need two seperate classes? idk
 
    public static int drawLowestElevPath(Graphics g,int indexLowestElev){
        //
        Graphics2D g2d   = (Graphics2D) g;
        int current      = 0;
        int nextAbove    = 0;
        int nextMiddle   = 0;
        int nextBelow    = 0;
        int changeTop    = 0;
        int changeMiddle = 0;
        int changeBottom = 0;
        int totalChange  = 0;
        Random random    = new Random();
        int yRow         = indexLowestElev;
        
        for(int x = 0;x < columns; x++){    //Loop through the columns for the indexLowestElev row
            current = data[yRow][x];

            //  Decision tree to determine pathing
            if(yRow > 0 && x != columns-1)       nextAbove  = data[yRow-1][x+1];
            if(x < columns-1)                    nextMiddle = data[yRow][x+1];
            if(yRow != rows-1 && x != columns-1) nextBelow  = data[yRow+1][x+1];

            // Finding the changes between cells
            if(nextAbove  > current){
                changeTop  = Math.abs(nextAbove  - current);
            }
            else{changeTop = Math.abs(current - nextAbove);
            }
            
            if(nextMiddle > current){
                changeMiddle  = Math.abs(nextMiddle - current);
            }
            else{changeMiddle = Math.abs(current - nextMiddle);
            }

            if(nextBelow  > current){
                changeBottom  = Math.abs(nextBelow  - current);
            }
            else{changeBottom = Math.abs(current - nextBelow);
            }
     
            //  Determining which change is smallest
            if(changeMiddle <= changeTop && changeMiddle <= changeBottom){
                totalChange += changeMiddle; // Adding the change to the total
                // since stepping forward, no need to add/substract a Yvalue(row)
            }
            else if(changeBottom < changeMiddle && changeBottom < changeTop){
                if(yRow > 0) yRow++; //Since stepping forward and down, need to add one to the yRow
                totalChange += changeBottom;
            } 
            
            else if(changeTop < changeMiddle && changeTop <  changeBottom){
                if(yRow < rows-1){ //   Stepping forward and up, need to subtract 1 from yRow
                    yRow--;
                }
                totalChange += changeTop;
            }
            
            else if(changeTop == changeBottom){
                if(random.nextInt(2) == 1){ //1 = picking the top path, subtracting 1
                    if(yRow > 0){
                        yRow--; 
                    }
                    totalChange += changeTop;
                }
                else{
                    if(yRow < rows-1){//Bottom path, adding 1
                        yRow++;
                    }     
                    totalChange += changeBottom;   
                }
            }
            
            g2d.setColor(Color.GREEN);  //Setting color
                g2d.fillRect(x, yRow, 1, 1);    //Creating the rectangle
        }
        
        return totalChange;
    }   //End of drawLowestElevPath method
*/
    public static int indexOfLowestElevPath(Graphics g){
        Graphics2D g2d      = (Graphics2D) g;
        int current         = 0;
        int nextAbove       = 0;
        int nextMiddle      = 0;
        int nextBelow       = 0;
        int changeTop       = 0;
        int changeMiddle    = 0;
        int changeBottom    = 0;
        int totalChange     = 0;
        int sumElev         = 99999;
        int indexLowestElev = 0;
        int yRow            = 0;
        Random random       = new Random();

        for(int y = 0;y < rows-1; y++){  //Since row is not predefined, need to loop through each row
            yRow = y;
            totalChange = 0;        //Need to reset total after each row is finished
            for(int x = 0;x < columns; x++){
                current = data[yRow][x];
                // Repeat of the drawLowestElevPath decision tree
                if(yRow > 0 && x != columns-1)       nextAbove  = data[yRow-1][x+1];
                if(x < columns-1)                    nextMiddle = data[yRow][x+1];
                if(yRow != rows-1 && x != columns-1) nextBelow  = data[yRow+1][x+1];

                if(nextAbove  > current){
                    changeTop  = Math.abs(nextAbove  - current);
                }
                else{changeTop = Math.abs(current - nextAbove);
                }
                
                if(nextMiddle > current){
                    changeMiddle  = Math.abs(nextMiddle - current);
                }
                else{changeMiddle = Math.abs(current - nextMiddle);
                }

                if(nextBelow  > current){
                    changeBottom  = Math.abs(nextBelow  - current);
                }
                else{changeBottom = Math.abs(current - nextBelow);
                }
         
                
                if(changeMiddle <= changeTop && changeMiddle <= changeBottom){
                    totalChange += changeMiddle;
                }
                else if(changeBottom < changeMiddle && changeBottom < changeTop){
                    if(yRow < rows-1) yRow++; //Since stepping forward and down, need to add one to the yRow
                    totalChange += changeBottom;
                } 
                
                else if(changeTop < changeMiddle && changeTop <  changeBottom){
                    if(yRow > 0){ //   Stepping forward and up, need to subtract 1 from yRow
                        yRow--;
                    }
                    totalChange += changeTop;
                }
                
                else if(changeTop == changeBottom){
                    if(random.nextInt(2) == 1){ //1 = picking the top path, subtracting 1
                        if(yRow > 0){
                            yRow--; 
                        }
                        totalChange += changeTop;
                    }
                    else{
                        if(yRow < rows-1){//Bottom path, adding 1
                            yRow++;
                        }     
                        totalChange += changeBottom;   
                    }
                }
                
                g2d.setColor(Color.RED);
                g2d.fillRect(x, yRow, 1, 1);
                
                
            }   //End of inner for loop
            if(sumElev > totalChange){  //Determining if current totalChange is smallest yet,
                sumElev = totalChange;  
                indexLowestElev = y;    //Keeping track of which row index held the smallest totalChange
            }
        }   // End of outer for loop

        return indexLowestElev;

    }   //ENd of indexOfLowestElevPath
}   //End of MapDataDrawer class


//Drawer class taken from drawer file
class Drawer extends JPanel {
    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public Drawer() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle(MapDataDrawer.fileName);
        window.setSize(MapDataDrawer.columns, MapDataDrawer.rows+30);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }


    public void doDrawing(Graphics g) {
        // Calling drawing methods
        MapDataDrawer.drawMap(g);
        MapDataDrawer.indexOfLowestElevPath(g);
        //MapDataDrawer.drawLowestElevPath(g);
    }
    

    public static void main(String[] args) {
    
        
    } // end main
} // end class