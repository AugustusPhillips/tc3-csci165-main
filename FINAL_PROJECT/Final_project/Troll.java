import java.awt.Color;
public class Troll extends Creature{
    private final double MAX_HEALTH = 299;
    
    public Troll(int x, int y){
        setHealth(MAX_HEALTH);//He big boi
        setMaxHealth(MAX_HEALTH);
        setDamage(100);
        setArmor(100);
        setRange(2);
        setPositionX(x);
        setPosiitonY(y);
        setTitle("Troll");
    }
    public void move(){
        System.out.println("move() method is unfinished but was called on " +getTitle());
    }
    public Creature replicate(){
        return new Troll(getPositionX()+1, getPositionY());

    }
    public Color color(){
        double startHue = 100;
        double endHue = 200;
        double percentage = (getHealth()/getMaxHealth());
        double hue = ((percentage * (endHue - startHue)) + startHue) / 360;
        Color color = Color.getHSBColor((float)hue, (float).9, (float).9);
        return color;
    }
    public String toString(){
        return "Troll created at: (" +getPositionX() +", " +getPositionY() +
                ")\nHealth: " +getHealth() +
                "\nDamage: " +getDamage() +
                "\nArmor: " +getArmor() +
                "\nDectection Range: " +getRange();
    }
}