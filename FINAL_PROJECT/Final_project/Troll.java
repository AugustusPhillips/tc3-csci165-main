public class Troll extends Creature{
    private final int MAX_HEALTH = 300;
    
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

    public String toString(){
        return "Troll created at: (" +getPositionX() +", " +getPositionY() +
                ")\nHealth: " +getHealth() +
                "\nDamage: " +getDamage() +
                "\nArmor: " +getArmor() +
                "\nDectection Range: " +getRange();
    }
}