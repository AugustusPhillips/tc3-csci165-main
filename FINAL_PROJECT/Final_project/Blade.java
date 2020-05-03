public class Blade extends MagicalItem{
    private int damageValue;
    public Blade(int dam) {
        setTitle("Normal Blade");
        this.damageValue = dam;
    }
    public Blade(int dam, int range){
        setTitle("Magical Blade");
        this.damageValue = dam;
        setRange(range);
    }

    public Blade(String title, int dam){
        setTitle(title);
        this.damageValue = dam;

    }
    public Blade(String title, int dam, int range){
        setTitle(title);
        this.damageValue = dam;
        setRange(range);
    }
    public void effectCreature(Creature c){
        c.setDamage(getDamageValue());
        setActive();
    }
    public int getDamageValue(){
        return this.damageValue;
    }

}