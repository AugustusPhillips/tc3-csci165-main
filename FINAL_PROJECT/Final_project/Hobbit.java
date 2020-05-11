import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
public class Hobbit extends Creature {
    Map map = new Map();
    private int replicationCounter = 3;
    private final double MAX_HEALTH = 99;


    public Hobbit(int x, int y){
        super();
        setHealth(MAX_HEALTH);
        setMaxHealth(MAX_HEALTH);
        setPositionX(x);
        setPosiitonY(y);
        setTitle("Hobbit");
    }

    public Creature replicate(){
        replicationCounter = 3;
        int[][] spaces = map.emptySpace(this);
        Creature babyHob = null;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(7);
        list.add(8);
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(6);
        for(int num : list){
            if(spaces[num][0] != 0){
                int newX = spaces[num][0];
                int newY = spaces[num][1];
                babyHob = new Hobbit(newX, newY);
                map.addCreature(babyHob);
                System.out.println( getTitle()+" replicated");
                return babyHob;
            }
        }
        return babyHob;
    }
    public void move(){
        System.out.println("Move() called on Hobbit");
        Object[][] gameMap = map.getWorldArray();
        ArrayList<Creature> List = map.findCreature(this, "Nazgul");
        ArrayList<Creature> List0 = map.findCreature(this, "Troll");
        ArrayList<Creature> List1 = map.findCreature(this, "Ranger");
        ArrayList<Creature> List2 = map.findCreature(this,"Hobbit");
        ArrayList<Creature> List3 = map.neighborhood(this);
        List.addAll(List0);
        List.addAll(List1);
        int x1 = this.getPositionX();
        int y1 = this.getPositionY();
        int newX = 0;
        int newY = 0;
        if(!(List.isEmpty())){
            for( Creature c : List){
                int x2 = c.getPositionX();
                int y2 = c.getPositionY();
                if(x1 - x2 > 0) newX = 1;
                if(x1 - x2 < 0) newX = -1;
                if(y1 - y2 > 0) newY = 1;
                if(y1 - y2 < 0) newY = -1;
            }
        }else if(!(List2.isEmpty())){
            for( Creature c : List){
                int x2 = c.getPositionX();
                int y2 = c.getPositionY();
                if(x1 - x2 > 0) newX = -1;
                if(x1 - x2 < 0) newX = 1;
                if(y1 - y2 > 0) newY = -1;
                if(y1 - y2 < 0) newY = 1;
            }
        }else if(List3.isEmpty()){
            Random random = new Random();
            int randomX = random.nextInt(3);
            int randomY = random.nextInt(3);
            if(randomX == 0) newX = -1;
            if(randomX == 1) newX = 0;
            if(randomX == 2) newX = 1;
            if(randomY == 0) newY = -1;
            if(randomY == 1) newY = 0;
            if(randomY == 2) newY = 1;
        }
        int currentX = x1;
        int currentY = y1;
        int mapSize = map.getMapSize();
        int nextX = ((currentX+newX) + mapSize) % mapSize;
        int nextY = ((currentY+newY) + mapSize) % mapSize;
        if(gameMap[nextX][nextY] == null){
            this.setPositionX(nextX);
            this.setPosiitonY(nextY);
            replicationCounter--;
            System.out.println("Hobbit new posiiton: (" +nextX +", " +nextY +")");
            if(replicationCounter == 0 && (map.emptySpace(this)[0][0] == 1)) replicate();
            return;
        }
    }
    public Color color(){
        double startHue = 0;
        double endHue = 90;
        double percentage = (getHealth()/getMaxHealth());
        double hue = ((percentage * (endHue - startHue)) + startHue) / 360;
        Color color = Color.getHSBColor((float)hue, (float).9, (float).9);
        return color;
    }
    public String toString(){
        return "Hobbit at: (" +getPositionX() +", " +getPositionY() +
        ")\nHealth: " +getHealth() +
        "\nDamage: " +getDamage() +
        "\nArmor: " +getArmor() +
        "\nDectection Range: " +getRange();
    }

}