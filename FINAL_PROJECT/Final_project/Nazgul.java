import java.util.ArrayList;
import java.awt.Color;
public class Nazgul extends Creature {
    private int replicationCounter = 8;
    private final double MAX_HEALTH = 150;
    //Base items that every Nazgul will have
    Blade morgalBlade = new Blade(55);
    //Armor wraithCloak = new Armor(15);
    
//Base Nazgul constructor
    public Nazgul(int x, int y){
        super();
        setPositionX(x);
        setPosiitonY(y);
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setTitle("Nazgul");
        addToInv(morgalBlade);
        //addToInv(wraithCloak);
    }
    public Creature replicate(){

        stay();
        return new Nazgul(getPositionX()+1, getPositionY());
    }
    public void move(){
        
        System.out.println("move() method is unfinished but called on " +getTitle());
    }
    public void resetRepCount(){
        replicationCounter = 8;
    }
    public Color color(){
        double input = getHealth();
        int color = (int) (input / MAX_HEALTH * 255);

        color = Math.abs(color - 255);

        Color colour = new Color(color, color, color);
        return colour;
        
    }
    public String toString(){
        return "Nazgul created at: (" +getPositionX() +", " +getPositionY() +
                ")\nHealth: " +getHealth() +
                "\nDamage: " +getDamage() +
                "\nArmor: " +getArmor() +
                "\nDectection Range: " +getRange();
    }
}