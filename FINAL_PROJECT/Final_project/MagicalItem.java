public class MagicalItem extends Item{
    private int increasedRange;
    /*
    public MagicalItem(int newRange){
        this.increasedRange = newRange;
    }
    */
    public void setRange(int newRange){
        this.increasedRange = newRange;
    }
    public void effectCreature(Creature c){
        c.setRange(getRangeValue());
    }
    public int getRangeValue(){
        return this.increasedRange;
    }
}
