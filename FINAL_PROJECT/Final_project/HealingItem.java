public class HealingItem extends MagicalItem{
    private int healingEffect;

    public HealingItem(String title, int healing){
        setTitle(title);
        this.healingEffect = healing;
    }
    public HealingItem(int newHeal){
        setTitle("Random bit of food");
        this.healingEffect = newHeal;
    }
    public HealingItem(String title, int healing, int range){
        setTitle(title);
        this.healingEffect = healing;
        setRange(range);
    }
    public HealingItem(int healing, int range){
        setTitle("Magic Potion");
        this.healingEffect = healing;
        setRange(range);
    }


    public void effectCreature(Creature c){
        c.addHealth(getHealEffect());
        c.setRange(getRangeValue()+c.getRange());
    }
    public int getHealEffect(){
        return this.healingEffect;
    }
    
}