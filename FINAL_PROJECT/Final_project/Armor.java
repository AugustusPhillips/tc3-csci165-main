public class Armor extends MagicalItem{
    private int armorValue;
    public Armor(String title, int newArmor){
        setTitle(title);
        this.armorValue = newArmor;
    }
    
    public Armor(int reduct){
        this.armorValue = reduct;
        setTitle("Basic Armor");
    }
    public Armor(String title, int newArmor, int newRange){
        setTitle(title);
        this.armorValue = newArmor;
        setRange(newRange);
    }
    public Armor(int newArmor, int newRange){
        setTitle("Magical Chainmail");
        this.armorValue = newArmor;
        setRange(newRange);
    }
    public void effectCreature(Creature c){
        c.setArmor(getArmorValue());
    }
    public int getArmorValue(){
        return this.armorValue;
    }

}