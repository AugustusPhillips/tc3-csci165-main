import java.util.ArrayList;

public class Nazgul extends Creature {
    private int replicationCounter = 8;
    private final int MAX_HEALTH = 150;
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
        /*
        if(!(replicationCounter == 0)){
            
            setPositionX(getPositionX()+2);
            setPosiitonY(getPositionY());
            replicationCounter -=1;
        }else{
            replicate();
            resetRepCount();
        }
        */
        System.out.println("move() method is unfinished but called on " +getTitle());
    }
    public void resetRepCount(){
        replicationCounter = 8;
    }
    public String toString(){
        return "Nazgul created at: (" +getPositionX() +", " +getPositionY() +
                ")\nHealth: " +getHealth() +
                "\nDamage: " +getDamage() +
                "\nArmor: " +getArmor() +
                "\nDectection Range: " +getRange();
    }
}