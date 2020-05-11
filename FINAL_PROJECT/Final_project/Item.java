
public abstract class Item {
    private String title;
    private int positionX;
    private int positionY;
    private boolean active = false;

    public Item(){}

    public void setPosiiton(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }
    public abstract void effectCreature(Creature c);

    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public String getTitle(){
        return this.title;
    }
    public void setActive(){
        this.active = !this.active;
    }
    public boolean getActive(){
        return this.active;
    }
    public int getPositionX(){
        return this.positionX;
    }
    public int getPositionY(){
        return this.positionY;
    }

}//End of Item class