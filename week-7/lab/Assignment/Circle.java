


public class Circle{
    private Point center = new Point(0,0);
    private double radius   = 1;


    public Circle(int x, int y, double radius){
        super();
        this.center.setX(x);
        center.setY(y);
        this.radius = radius;
    }   //End of Circle constructor

    public Circle(Point center, double radius){
        super();
        this.center = center;
        this.radius = radius;

    }   //End of Circle constructor

    public Circle(){
        this.center.setX(0);
        this.center.setY(0);
        this.radius = 1;
    }

    public double getRadius(){
        double copyOfRadius = this.radius;
        return copyOfRadius;

    }   //End of getRadius

    public void setRadius(double radius){
        this.radius = radius;

    }   //End of setRadius
    public Point getCenter(){
        Point copyOfCenterX = this.center;
        return copyOfCenterX;

    }   //End of getCenter

    public void setCenter(Point center){
        this.center = center;

    }   //End of setCenterX
    public int getCenterX(){
        int copyOfCenterX = center.getX();
        return copyOfCenterX;

    }   //End of getCenter

    public void setCenterX(int x){
        this.center.setX(x);

    }   //End of setCenterX

    public int getCenterY(){
        int copyofCenterY = center.getY();
        return copyofCenterY;

    }   //End of getCenterY

    public void setCenterY(int y){
        this.center.setY(y);
    }   //End of setCenterY

    public int[] getCenterXY(){
        int[] centerArray = new int[2];
        centerArray[0] = center.getX();
        centerArray[1] = center.getY();
        return centerArray;
    }   //End of getCenterXY

    public void setCenterXY(int x, int y){
        this.center.setX(x);
        this.center.setY(y);
    }   //End of setCenterXY
    
    public double getArea(){
        double area;
        double pi = Math.PI;
        area = pi *(radius * radius);
        return area;

    }   //End of getArea
    
    public double getCircumference(){
        double circumference;
        double pi = Math.PI;
        circumference = 2 * pi * radius;
        return circumference;

    }   //End of getCircumference

    public double distance(Circle anotherCircle){
        double distance = this.center.distance(anotherCircle.getCenter());
        return distance;

    }   //End of distance
    @Override
    public String toString(){
        return "Circle[radius="+radius +",center="+center+"]";

    }   //End of toString
    @Override
    public boolean equals(Object otherCircle){
        if (otherCircle == this) return true;
        if (!(otherCircle instanceof Circle)) return false;
        Circle c2 = (Circle) otherCircle;

        return Integer.compare(center.getX(), c2.center.getX()) == 0
        && Integer.compare(center.getY(), c2.center.getY()) == 0
        && Double.compare(radius, c2.radius) == 0; 
    }   //End of equals method
}   //End of Circle class