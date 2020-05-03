public class Ranger extends Creature{
    private final int MAX_HEALTH = 120;
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
    public String toString(){
        return "Ranger created at: (" +getPositionX() +", " +getPositionY() +
                ")\nHealth: " +getHealth() +
                "\nDamage: " +getDamage() +
                "\nArmor: " +getArmor() +
                "\nDectection Range: " +getRange();
    }
}