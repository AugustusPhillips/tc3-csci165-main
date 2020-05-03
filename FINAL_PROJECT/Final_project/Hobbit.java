
public class Hobbit extends Creature {
    private int replicationCounter = 3;
    private final int MAX_HEALTH = 100;


    public Hobbit(int x, int y){
        super();
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setPositionX(x);
        setPosiitonY(y);
        setTitle("Hobbit");
    }

    public Creature replicate(){
        return new Hobbit(getPositionX()+1, getPositionY());
    }
    public void move(){
        System.out.println(" move() method is unfinished but has been called on "+getTitle());
    }
    public String toString(){
        return "Hobbit created at: (" +getPositionX() +", " +getPositionY() +
        ")\nHealth: " +getHealth() +
        "\nDamage: " +getDamage() +
        "\nArmor: " +getArmor() +
        "\nDectection Range: " +getRange();
    }

}