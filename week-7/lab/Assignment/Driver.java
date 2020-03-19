import java.util.Random;

public class Driver{
    public static void main(String[] args){

        Point[] pointArray = new Point[10];
        for(int i = 1;i<11; i++){
            Point pointHolder = new Point(i,i);
            pointArray[i-1] = pointHolder;
            System.out.print(pointArray[i-1].toString()+", ");
        }
        
        System.out.printf("\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");

        Circle[] circleArray = new Circle[10];
        for(int i = 1;i<11; i++){
            Random random = new Random();
            int randomRadius = random.nextInt(10)+1;
            Circle circleHolder = new Circle(pointArray[i-1],randomRadius);
            circleArray[i-1] = circleHolder;
            System.out.println(circleArray[i-1]);  
        }
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        Cylinder cyl1 = new Cylinder(12);
        Cylinder cyl2 = new Cylinder(5, 7);
        Cylinder cyl3 = new Cylinder(3, 2, new Point(3,4));
        Cylinder cyl4 = new Cylinder(3, 2, new Point(3,4));
        Cylinder cyl5 = new Cylinder(2, 6, new Point(-2,5));
        
        System.out.println(cyl1);
        System.out.println("Does cyl3 equal cyl4: "+cyl3.equals(cyl4));
        System.out.println("Center of cyl1: "+cyl1.getCenter());
        System.out.println("Circumference of cyl2: "+cyl2.getCircumference());
        System.out.println("Volume of cyl3: "+cyl3.getVolume());
        System.out.println("Distance between cyl1 and cyl3: "+cyl1.distance(cyl3));
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        
        Circle[] circleArray2 = new Circle[10];
        for(int i = 0; i < 5; i++){
            circleArray2[i] = circleArray[i];
        }

        circleArray2[5] = cyl1;
        circleArray2[6] = cyl2;
        circleArray2[7] = cyl5;
        circleArray2[8] = cyl3;
        circleArray2[9] = cyl4;
        for(int i = 0; i < 10; i++){
            System.out.println(circleArray2[i].toString());
        }
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        Point point1 = new Point(6,1);
        Point point2 = new Point(5,9);
        Point point3 = new Point(3,0);
        Circle circle1 = new Circle(2, 6, 3);
        Circle circle2 = new Circle(4, 5, 4);
        Circle circle3 = new Circle(1, 3, 1);
        Cylinder cylinder1 = new Cylinder(3, 6, new Point(2,6));
        Cylinder cylinder2 = new Cylinder(7, 5, new Point(5,1));
        Cylinder cylinder3 = new Cylinder(4, 8, new Point(6,1));
        Address address = new Address("Tompkins Cortland Community College","13053");
        Object[] objectArray = new Object[10];
        objectArray[0] = point1; objectArray[1] = point2; objectArray[2] = point3;
        objectArray[3] = circle1; objectArray[4] = circle2; objectArray[5] = circle3;
        objectArray[6] = cylinder1; objectArray[7] = cylinder2; objectArray[8] = cylinder3;
        objectArray[9] = address;
        for(int i = 0;i<10;i++){
            System.out.println(objectArray[i].toString());
        }

    }   //End of main
}   //End of class