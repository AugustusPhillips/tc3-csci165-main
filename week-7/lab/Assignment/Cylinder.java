


public class Cylinder extends Circle{

    private double height = 1.0;
    public Cylinder(){
        super();

    }   //End of Cylinder Constructor

    public Cylinder(double height){
        super();
        this.height = height;
    }   //End of Cylinder(h)

    public Cylinder(double radius, double height){
        super.setRadius(radius);
        this.height = height;

    }   //End of Cylinder(r, h) constructor 

    public Cylinder(double radius, double height, Point center){
        super.setRadius(radius);
        this.height = height;
        super.setCenter(center);

    }   //End of Cylinder(r, h, c) constructor 

    public void setHeight(double height){
        this.height = height;

    }   //End of setHeight method

    public double getHeight(){
        double copyHeight = this.height;
        return copyHeight;

    }   //End of getHeight method

    public String toString(){
        return "Cylinder[radius="+getRadius() +",center="+getCenter()+", height="+height+"]";
    }   //End of toString method

    public double getVolume(){
        return getArea() * height;
    }   //End of getVolume method
    @Override
    public boolean equals(Object otherCylinder){
        if (otherCylinder == this) return true;
        if (!(otherCylinder instanceof Cylinder)) return false;
        Cylinder c2 = (Cylinder) otherCylinder;

        return Double.compare(height, c2.height) == 0;
        

    }
}   //End of classs