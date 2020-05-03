import java.util.ArrayList;

public abstract class Creature {
    private String title;
    private int positionX;
    private int positionY;
    private int rangeValue;
    private int health;
    private int damage;
    private int armor;
    private int MAX_HEALTH;
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
    
    public void attack(Creature c){
        c.takeDamage(damage);
        if((this.damage - c.getArmor()) < 0){
            System.out.println(getTitle()+" attacked " +c.getTitle() +" and dealt 0 damage.");
        }else{
            System.out.println(getTitle()+" attacked " +c.getTitle() +" and dealt " +(this.damage-c.getArmor()) +" damage.");
        }
    }//End of attack

    public void stay(){
        if(!(this.health < 10)){
            this.health = this.health-10;
        }else{this.health = 0;}
    }
    //public void chooseAction(Map<Direction, Occupant> neighbors){
 
    //}
    public void chooseAction(){
        System.out.println("chooseAction method unfinished, called on: " +getTitle());
    }
    public void takeDamage(int dam){
        if(!(this.health-dam < 0)) {
            this.health = health + armor - dam;
        }else{this.health = 0;}
    }//End of takeDamage
    public int healthIndictation(){
        return health;
    }

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
        for(Item item: inventory){
            
            if(item.getActive() == false){
                item.effectCreature(this);
                System.out.println(getTitle()+" added: " +item.getTitle() +" to its inventory");
            }
        }
    }
    /*
    public int[] scan(){
        for(int row = rangeValue; row > 0; row--){
            for(int column = rangeValue; column > 0; column--){
                if
            }
        }
    }
    */
    public int getHealth(){
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
    public int getMaxHealth(){
        return this.MAX_HEALTH;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setHealth(int newHealth){
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
    public void setMaxHealth(int newMAX){
        this.MAX_HEALTH = newMAX;
    }
    public String toString(){
        return "Health: " +getHealth() +
        "\nDamage: " +getDamage() +
        "\nArmor: " +getArmor() +
        "\n Detection Range: " +getRange();
    }
}//End of class