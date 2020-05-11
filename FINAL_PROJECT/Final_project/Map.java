import java.util.ArrayList;


public class Map{
    private static final int MAP_SIZE = 30; //Size of the 'Map'
    private static final Object[][] worldArray;
    static{
        worldArray = new Object[MAP_SIZE][MAP_SIZE]; // 2-dim array acting as the "map"
    }
    private ArrayList<Item> itemList = new ArrayList<Item>(); //List containing all Items in the game
    private ArrayList<Creature> creatureList = new ArrayList<Creature>();//List containing all creatures in the game
    
    
    public Map(){}

    public ArrayList<Creature> neighborhood(Creature c){
        ArrayList<Creature> neighHood = new ArrayList<Creature>();
        int x        = c.getPositionX();
        int y        = c.getPositionY();
        int range    = c.getRange();
        int maximumX = x+range;
        int maximumY = y+range;
        int minimumX = x-range;
        int minimumY = y-range;
        int rows;
        int columns;

        if(x-range < 0)         minimumX    = 0;
        if(y-range < 0)         minimumY = 0; 
        if(x+range >= MAP_SIZE) maximumX = MAP_SIZE; 
        if(y+range >= MAP_SIZE) maximumY = MAP_SIZE; 

        for(rows = minimumX; rows < maximumX; rows++){
            for(columns = minimumY; columns < maximumY; columns++){
                if(worldArray[rows][columns] != null && worldArray[rows][columns] != c){
                    neighHood.add((Creature) worldArray[rows][columns]);
                }
            }
            columns = minimumY;
        }
        return neighHood;
    }

    public ArrayList<Creature> findCreature(Creature c, String type){
        ArrayList<Creature> creatList = new ArrayList<Creature>();
        int x        = c.getPositionX();
        int y        = c.getPositionY();
        int range    = c.getRange();
        int maximumX = x+range;
        int maximumY = y+range;
        int minimumX = x-range;
        int minimumY = y-range;
        int rows;
        int columns;
        if(x-range < 0)         minimumX    = 0;
        if(y-range < 0)         minimumY = 0; 
        if(x+range >= MAP_SIZE) maximumX = MAP_SIZE; 
        if(y+range >= MAP_SIZE) maximumY = MAP_SIZE; 

        for(rows = minimumX; rows < maximumX; rows++){
            for(columns = minimumY; columns < maximumY; columns++){
                if(worldArray[rows][columns] != null && worldArray[rows][columns] != c){
                    Creature currentC = (Creature) worldArray[rows][columns];
                    if(currentC.getTitle() == type){
                        creatList.add(currentC);
                    }
                }
            }
            columns = minimumY;
        }
        return creatList;
    }
    
    public double nearestCreature(Creature c, String type){
        ArrayList<Creature> creatureLis = findCreature(c, type);
        double distance;
        double closestDistance = c.getRange();
        for(Creature creature : creatureLis){
            int x2 = creature.getPositionX();
            int y2 = creature.getPositionY();
            int x1 = c.getPositionX();
            int y1 = c.getPositionY();
            distance = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
            if(distance < closestDistance) distance = closestDistance;
        }
        return closestDistance;
    }
    public double nearestCreature(Creature c){
        ArrayList<Creature> creatureList2 = neighborhood(c);
        double distance;
        double closestDistance = c.getRange();
        int x1 = c.getPositionX();
        int y1 = c.getPositionY();
        for(Creature creature : creatureList2){
            int x2 = creature.getPositionX();
            int y2 = creature.getPositionY();
            distance = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
            if(closestDistance > distance) closestDistance = distance;
        }
        return closestDistance;
    }
    
    public Creature findEnemy(Creature c){
        Creature closeCreature = c;
        int x        = c.getPositionX();
        int y        = c.getPositionY();
        int maximumX = x+1;
        int maximumY = y+1;
        int minimumX = x-1;
        int minimumY = y-1;
        int rows;
        int columns;

        if(x-1 < 0)         minimumX     = 0;
        if(y-1 < 0)         minimumY  = 0; 
        if(x+1 >= MAP_SIZE) maximumX = MAP_SIZE; 
        if(y+1 >= MAP_SIZE) maximumY = MAP_SIZE; 

        for(rows = minimumX; rows < maximumX; rows++){
            for(columns = minimumY; columns < maximumY; columns++){
                if(worldArray[rows][columns] != null && worldArray[rows][columns] != c){
                    Creature currentCreature = (Creature) worldArray[rows][columns];

                    if(c.getTitle() == "Hobbit" ){
                        if(currentCreature.getTitle() == "Nazgul"){
                            return currentCreature;}
                    }
                    if(c.getTitle() == "Ranger"){
                        if(currentCreature.getTitle() == "Nazgul" || currentCreature.getTitle() == "Troll"){
                            return currentCreature;}
                    }
                    if(c.getTitle() == "Nazgul"){
                        if(currentCreature.getTitle() == "Hobbit" || currentCreature.getTitle() == "Ranger"){
                            return currentCreature;}
                    }
                    if(c.getTitle() == "Troll"){
                        if(currentCreature.getTitle() != "Troll"){
                            return currentCreature;}
                    }
                }
            }
            columns = minimumY;
        }
        return closeCreature;
    }
    public int[][] emptySpace(Creature c){
        int[][] spacesList = new int[9][2];
        int x        = c.getPositionX();
        int y        = c.getPositionY();
        int counter  = 1;
        int maximumX = x+1;
        int maximumY = y+1;
        int minimumX = x-1;
        int minimumY = y-1;
        int rows;
        int columns;

        if(x-1 < 0)         minimumX     = 0;
        if(y-1 < 0)         minimumY  = 0; 
        if(x+1 >= MAP_SIZE) maximumX = MAP_SIZE; 
        if(y+1 >= MAP_SIZE) maximumY = MAP_SIZE; 

        for(rows  = minimumX; rows < maximumX; rows++){
            for(columns = minimumY; columns < maximumY; columns++){
                if(worldArray[rows][columns] == null){
                    if(spacesList[0][0] == 0){
                        spacesList[0][0] = 1;
                    }
                    spacesList[counter][0] = rows;
                    spacesList[counter][1] = columns;
                    counter++;
                }
            }
            columns = minimumY;
        }
        return spacesList;
    }
    
    public ArrayList<Item> getItemList(){
        return this.itemList;
    }
    public ArrayList<Creature> getCreatureList(){
        return this.creatureList;
    }
    public Object[][] getWorldArray(){
        return Map.worldArray;
    }
    public static int getMapSize(){
        return MAP_SIZE;
    }
    public void addItem(Item i){
        itemList.add(i);
    }
    public void removeItem(Item i){
        itemList.remove(i);
    }
    public void addCreature(Creature c){
        creatureList.add(c);
        addToMap(c);  
    }
    public void removeCreature(Creature c){
        //creatureList.remove(c);
        removeFromMap(c);
    }
    public void addToMap(Creature c){
        worldArray[c.getPositionX()][c.getPositionY()] = c;
    }
    public void addToMap(Item i){
        worldArray[i.getPositionX()][i.getPositionY()] = i;
    }
    public void removeFromMap(Creature c){
        worldArray[c.getPositionX()][c.getPositionY()] = null;
    }
    public void removeFromMap(Item i){
        worldArray[i.getPositionX()][i.getPositionY()] = null;
    }
}