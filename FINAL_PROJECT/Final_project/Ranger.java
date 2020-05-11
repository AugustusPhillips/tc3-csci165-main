import java.awt.Color;
public class Ranger extends Creature{
    private final double MAX_HEALTH = 119;
    Blade rangersBlade = new Blade("Rangers Sword", 80, 9);

    public Ranger(int x, int y){
        super();
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setPositionX(x);
        setPosiitonY(y);
        setTitle("Ranger");
        addToInv(rangersBlade);
    }

    public void move(){
        System.out.println("move() method is unfinished but was called on " +getTitle());
    }
    public Creature replicate(){
        return new Ranger(getPositionX()+1,getPositionY());
    }
    public Color color(){
        double startHue = 180;
        double endHue = 315;
        double percentage = (getHealth()/getMaxHealth());
        double hue = ((percentage * (endHue - startHue)) + startHue) / 360;
        Color color = Color.getHSBColor((float)hue, (float).9, (float).9);
        return color;
    }
    public String toString(){
        return "Ranger created at: (" +getPositionX() +", " +getPositionY() +
                ")\nHealth: " +getHealth() +
                "\nDamage: " +getDamage() +
                "\nArmor: " +getArmor() +
                "\nDectection Range: " +getRange();
    }
}