import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
public abstract class Creature {
    Map map = new Map();
    private String title;
    private int positionX;
    private int positionY;
    private int rangeValue;
    private double health;
    private int damage;
    private int armor;
    private double MAX_HEALTH;
    private int replicationCounter;
    ArrayList<Item> inventory = new ArrayList<Item>();

    public Creature(){
        //Setting default values
        this.health     = 100;
        this.damage     = 50;
        this.armor      = 0;
        this.rangeValue = 4;
        
    }//End of Creature constructor

    public abstract void move();
    public abstract Creature replicate();
    public abstract Color color();
    
    public void attack(Creature c){
        if(c == this) return;
        c.takeDamage(damage);
        replicationCounter--;
        if((this.damage - c.getArmor()) < 0){
            System.out.println(getTitle()+" attacked " +c.getTitle() +" and dealt 0 damage.");
        }else{
            System.out.println(getTitle()+" attacked " +c.getTitle() +" and dealt " +(this.damage-c.getArmor()) +" damage.");
        }
    }//End of attack

    public void stay(){
        System.out.println("Stay was called on " +this.getTitle());
        if(!(this.health < 10)){
            this.health = this.health-10;
        }else{this.health = 0;}
        replicationCounter--;
        if(replicationCounter == 0 && (map.emptySpace(this)[0][0] == 1)) replicate();
    }
    public void chooseAction(Map map){
        if(map.emptySpace(this)[0][0] == 1){
            if(map.nearestCreature(this) <= 1.5 ){
                Random random = new Random();
                int number = random.nextInt(2);
                if(number == 0){
                    if(map.findEnemy(this) == this){
                        move();
                        return;
                    }
                    attack(map.findEnemy(this));
                    return;
                }else{
                    move();
                    return;}
            }else{ 
                move();
                return;}
        }else{
             stay();
            return;}
    }
    public void takeDamage(int dam){
        if(!(this.health-dam < 0)) {
            this.health = health + armor - dam;
        }else{this.health = 0;}
        System.out.println( getTitle() +" took " + dam +" damage");
    }//End of takeDamage
    public void addHealth(int healNum){
        if(!(this.health + healNum > this.MAX_HEALTH)){
            this.health = this.health+ healNum;
        }else{ 
            this.health = MAX_HEALTH;
        }
    }
    public void addToInv(Item item){
        inventory.add(item);
        useInventory();
    }
    public void useInventory(){
        for(Item item : inventory){
            if(item.getActive() == false){
                item.effectCreature(this);
                System.out.println(getTitle()+" added: " +item.getTitle() +" to its inventory");
            }
        }
    }
    public double getHealth(){
        return this.health;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getPositionX(){
        return this.positionX;
    }
    public int getPositionY(){
        return this.positionY;
    }
    public int getArmor(){
        return this.armor;
    }
    public int getRange(){
        return this.rangeValue;
    }
    public String getTitle(){
        return this.title;
    }
    public double getMaxHealth(){
        return this.MAX_HEALTH;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setHealth(double newHealth){
        this.health = newHealth;
    }
    public void setDamage(int newDam){
        this.damage = newDam;
    }
    public void setPositionX(int newX){
        this.positionX = newX;
    }
    public void setPosiitonY(int newY){
        this.positionY = newY;
    }
    public void setArmor(int newArmor){
        this.armor = newArmor;
    }
    public void setRange(int newRange){
        this.rangeValue = newRange;
    }
    public void setMaxHealth(double newMAX){
        this.MAX_HEALTH = newMAX;
    }
    public String toString(){
        return "Health: " +getHealth() +
        "\nDamage: " +getDamage() +
        "\nArmor: " +getArmor() +
        "\n Detection Range: " +getRange();
    }
}//End of class