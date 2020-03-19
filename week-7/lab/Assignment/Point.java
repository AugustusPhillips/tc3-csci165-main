import java.lang.Math; 


public class Point{
    private int x = 0;
    private int y = 0;
    private int[] xy = new int[2];

    public Point(){
        super();}

    public Point(int x, int y){
        super();
        this.x = x;
        this.y = y;

    }   //End of MyPoint constructor

    public int getX(){
        return x; 
    }   //End of getX method

    public void setX(int x){
        this.x = x;

    }   //End of setX method

    public int getY(){
        return y;

    }   //End of getY

    public void setY(int y){
        this.y = y;

    }   //End of setY

    public int[] getXY(){
        xy[0] = x;
        xy[1] = y;
        return xy;

    }   //End of getXY

    public void setXY(int x,int y){
        xy[0] = this.x;
        xy[1] = this.x;

    }   //End of setXY
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }   //End of toString

    public double distance(int x, int y){
        double distance = 0.0;
        int x_change    = (x-this.x)*(x-this.x);
        int y_change    = (y-this.y)*(y-this.y);
        distance        = Math.sqrt(x_change+y_change);
        return distance;

    }   //End of distance

    public double distance(Point point){
        double distance = 0.0;
        int x_change    = (point.x-this.x)*(point.x-this.x);
        int y_change    = (point.y-this.y)*(point.y-this.y);
        distance        = Math.sqrt(x_change+y_change);
        return distance;

    }

    public double distance(){
        double distance = 0.0;
        int x_change    = (0-this.x)*(0-this.x);
        int y_change    = (0-this.y)*(0-this.y);
        distance        = Math.sqrt(x_change+y_change);
        return distance;
    }
    @Override
    public boolean equals(Object otherPoint){
        if(otherPoint == this) return true;
        if (!(otherPoint instanceof Point)) return false;
         Point p2 = (Point) otherPoint;

        return Integer.compare(x, p2.x) == 0
                && Integer.compare(y, p2.y) == 0; 
        
    }
}   //End of class