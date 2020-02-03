import java.util.Scanner;


public class Initials {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name and last name:");
        String name = input.nextLine();

        char f_init = name.charAt(0);
        int space = name.indexOf(" ");
        char l_init = name.charAt(space+1);

        System.out.printf("The initial of the first name is %s.%n",f_init);
        System.out.printf("The initial of the last name is %s.%n",l_init);

        int f_initial = (int)f_init;
        int l_initial = (int)l_init;

        System.out.printf("The numeric value of the first name initial is %d.%n",f_initial);
        System.out.printf("The numeric value of the last name initial is %s.%n",l_initial);

        int sum = f_initial + l_initial;

        System.out.printf("The sum of the two initals numeric values is %d.%n",sum);
        String f = String.valueOf(f_init);
        String l = String.valueOf(l_init);
        String combined = f + l;

        System.out.printf("THe two initals concatenated together is %s.%n",combined);
    }
}