//Ask the user to enter an integer and display the square, cube, and fourth power. Research the
//Math class and use the pow method for each calculation. Use a loop if you’d like.
import  java.util.Scanner;
import java.lang.Integer;
public class Primitives{
    public static void main(String[] args) {
        
        //Beginning of #1
        //creating variables
        byte thisAbyte = 12;
        short thisAshort = 21049;
        int thisAint = -759012;
        long thisAlong = 987654321;
        float thisAfloat = 1;
        double thisAdouble = 1.5314;
        boolean thisAboolean = true;
        char thisAchar = 'F';
        char thisAchar2 = 69;

        //Printing using printf
        System.out.format(" The value of the byte variable is %d%n" +
        "The value of the short variable is %d,%n" +
        "The value of the integer variable is %d%n" +
        "The value of the long variable is%d%n" +
        "The value of the float variable is %f%n" +
        "The value of the double variable is %f%n" +
        "The value of the boolean variable is %s%n" +
        "The value of the char variable is %c%n" +
        "The value of the second char variable is %c%n", thisAbyte, thisAshort, thisAint, thisAlong, thisAfloat, thisAdouble, thisAboolean, thisAchar, thisAchar2); 
        
        //Creating narrowing type cast
        byte narrowerer = (byte)thisAint;
        System.out.printf("%d was narrrowed to a byte: %d%n", thisAint, narrowerer);

        //Creating widening type cast
        long widened = (long)thisAshort;
        System.out.printf("%d was widened to a long: %d%n", thisAshort, widened);
        //
        //End of #1, Beginning of #2
        //
        //create stopping variable
        boolean cont = true;
        //loop for mutliple int- entries
        while(cont == true){
            //User inputs their int
            Scanner input = new Scanner(System.in);  
            System.out.println("Enter an integer:");
            int userInt = input.nextInt();
            
            //Loop to print out the int up to the fourth, could add a second user input for higher exponents and replace i
            for(int i = 2; i < 5; i++){
                //print the results
                int result = (int) Math.pow(userInt, i);
                System.out.printf("The integer %d, raised to the %d power is %d.%n", userInt, i, result);
                //System.out.println(result);
            }
            //ask user if they want to enter a new int
            Scanner input2 = new Scanner(System.in);  
            System.out.println("Enter a new integer? (true/false)");
            cont = input2.nextBoolean();
        }
        //
        //End of #2, beginning of #3
        //

        //
        int maxInt = 2147483647;
        int minInt = -2147463648;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int a = 10;
        int b = 20;
        int c = -10;

        int result1 = Integer.compare(a, b);
        int result2 = Integer.compare(b, c);
        int result3 = Integer.compare(a, a);

        System.out.printf("When %d is compared to %d, the result is %d, meaning that %d is less than %d.%n",a, b, result1, a, b);
        System.out.printf("When %d is compared to %d, the result is %d, meaning that %d is greater than %d.%n",b, c, result2, b, c);
        System.out.printf("When %d is compared to %d, the result is %d, meaning that %d is equal to %d.%n",a, a, result3, a, a);

        int z = 21;
        int y = 34;
        int x = -13;

        int resultz = Integer.compareUnsigned(z, y);
        int resulty = Integer.compareUnsigned(y, z);
        int resultx = Integer.compareUnsigned(x, z);

        System.out.printf("When %d is compared to %d, the result is %d, meaning that %d is less than %d.%n",z, y, resultz, z, y);
        System.out.printf("When %d is compared to %d, the result is %d, meaning that %d is greater than %d.%n",y, z, resulty, y, z);
        System.out.printf("When %d is compared to %d, the result is %d, meaning that %d is greater than %d.%n"+
        " This is due to -13 being compared as unsigned.%n",x, z, resultx, x, z);
        //compareUnsigned() treats all integers as positive, whereas compare() treats negatives normally
        //
        //End of #3, #4 told to skip, beginning of #5
        //
        Scanner divisor_input = new Scanner(System.in);  
        System.out.println("Enter a Divisor:");
        int userDivisor = divisor_input.nextInt();
        Scanner dividend_input = new Scanner(System.in);  
        System.out.println("Enter a Dividend:");
        int userDividend = dividend_input.nextInt();

        //Normal floor divison
        double d_d = userDividend / userDivisor;
        System.out.printf("Using floor divison, %d divided by %d is %f.%n", userDivisor, userDividend, d_d);

        //Normal modulus divison
        double dd_ = userDividend % userDivisor;
        System.out.printf("Using floor modulus, %d divided by %d is %f.%n", userDivisor, userDividend, dd_);

        //Floor divison using Math.floorDiv
        double floor_div = Math.floorDiv(userDividend, userDivisor);
        System.out.printf("Using floor divison, %d divided by %d is %f.%n", userDivisor, userDividend, floor_div);

        //Floor modulus divison using Math.floorMod
        double floor_mod = Math.floorMod(userDividend, userDivisor);
        System.out.printf("Using floor modulus, %d divided by %d is %f.%n", userDivisor, userDividend, floor_mod);
        
        
    }   
    
}
