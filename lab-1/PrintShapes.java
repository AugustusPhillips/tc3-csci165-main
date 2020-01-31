public class PrintShapes{

    public static void main(String[] args){

        //Beginning string
        String x = "*****";

        //Loop for 5 print statments
        for (int i = 5; i > -1; i--){

            //Removing a * based up loop progress
           x = "*****".substring(0,i);
           System.out.println(x);
        }
        //2nd LoopyDoop
        for (int i = 4; i > 0; i--){

            //Beginning string
            x = "*";

            //Couldn't figure out how to combine the two If statements, so two it be
            if (i >= 4) {
                System.out.println(x+x+x+x+x);
            }
            if (i <= 1) {
                System.out.println(x+x+x+x+x);
            }
            else{
                System.out.println(x + "   " + x );
            }
        }
        System.out.println("");
        //I give on the last one. It's 2:30 ;-;
        System.out.println("*****");
        System.out.println("***");
        System.out.println("**");
        System.out.println("***");
        System.out.println("*****");
             
            
        
           
      
    }
}